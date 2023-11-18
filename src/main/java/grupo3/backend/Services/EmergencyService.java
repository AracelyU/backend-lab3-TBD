package grupo3.backend.Services;

import grupo3.backend.Entities.EmergencyEntity;
import grupo3.backend.Entities.StateEntity;
import grupo3.backend.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EmergencyService implements EmergencyRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    StateService stateService;

    // Para obtener todos los estados de las tareas
    @Override
    public List<EmergencyEntity> getAllEmergency() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM emergency")
                    .executeAndFetch(EmergencyEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergencyEntity> getEmergencyById(long id_emergency){
        try(Connection conn = sql2o.open()) {
            // String sql = "SELECT * FROM taskStatus where idStatus=:id";
            return conn.createQuery("SELECT * FROM emergency WHERE id_emergency = :id_emergency ")
                    .addParameter("id_emergency", id_emergency)
                    .executeAndFetch(EmergencyEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public long createEmergency(EmergencyEntity emergencyEntity) {
        long id_state = emergencyEntity.getId_state();
        try(Connection conn = sql2o.open()) {
            // Verificar si el id_state existe en la tabla de estados
            List<StateEntity> stateList = stateService.getStateTaskById(id_state);
            if (stateList != null && !stateList.isEmpty()) {
                Date currentDate = new Date();
                String sql = "INSERT INTO emergency (emergency_name, emergency_type, " +
                        "statement_date, id_state, id_address_e) " +
                        "VALUES (:emergency_name, :emergency_type, :statement_date, :id_state, :id_address_e)";
                Query query = conn.createQuery(sql, true)
                        .addParameter("emergency_name", emergencyEntity.getEmergency_name())
                        .addParameter("emergency_type", emergencyEntity.getEmergency_type())
                        .addParameter("statement_date", currentDate)
                        .addParameter("id_state", emergencyEntity.getId_state())
                        .addParameter("id_address_e", emergencyEntity.getId_emergency_address());
                int idGenerado = (int) query.executeUpdate().getKey();
                return idGenerado; // retorno el id de la emergencia generada
            }
            else{
                return -1L;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    @Override
    public String updateEmergency(EmergencyEntity emergencyEntity, long id_emergency){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE emergency SET emergency_name= :emergency_name, " +
                    "statement_date = :statement_date, id_address_e = :id_address_e" +
                    "emergency_type = :emergency_type, id_state = :id_state WHERE id_emergency = :id_emergency";
            conn.createQuery(updateSql)
                    .addParameter("emergency_name", emergencyEntity.getEmergency_name())
                    .addParameter("statement_date", new Date())
                    .addParameter("emergency_type", emergencyEntity.getEmergency_type())
                    .addParameter("id_state", emergencyEntity.getId_state())
                    .addParameter("id_emergency", id_emergency)
                    .addParameter("id_address_e", emergencyEntity.getId_emergency_address())
                    .executeUpdate();
            return "actualizacion realizada con exito";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al realizar actualizacion";
        }
    }

    @Override
    public String deleteEmergency(long id_emergency){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from emergency where id_emergency = :id_emergency ")
                    .addParameter("id_emergency",id_emergency)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Para obtener los nombres de las emergencias (2. Listado de Emergencias)
    @Override
    public List<EmergencyEntity> getEmergenciesName() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT id_emergency, emergency_name FROM emergency")
                    .executeAndFetch(EmergencyEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    // Para obtener el listado de emergencias ordenadas por estado y nombre (4)
    @Override
    public List<Map<String, Object>> getEmergencies_nameState() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT e.id_emergency, e.emergency_name, e.emergency_type, s.state_name " +
                            "FROM emergency e, state s " +
                            "WHERE e.id_state = s.id_state " +
                            "ORDER BY s.id_state, e.emergency_name")
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
