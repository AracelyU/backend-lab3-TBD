package grupo3.backend.Services;

import grupo3.backend.Entities.*;
import grupo3.backend.repositories.EmergencyInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class EmergencyInstitutionService implements EmergencyInstitutionRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    EmergencyService emergencyService;

    @Autowired
    InstitutionService institutionService;


    // para obtener todas las combinaciones emergencia-institución
    @Override
    public List<EmergencyInstitutionEntity> getAllEmergencyInstitution() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM emergency_institution")
                    .executeAndFetch(EmergencyInstitutionEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Para buscar una combinación emergencia-institución por id
    @Override
    public List<EmergencyInstitutionEntity> getEmergencyInstitution(long id_emergency_institution){
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM emergency_institution WHERE " +
                    "id_emergency_institution = :id_emergency_institution";
            return conn.createQuery(sql)
                    .addParameter("id_emergency_institution", id_emergency_institution)
                    .executeAndFetch(EmergencyInstitutionEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Para crear una nueva combinación emergencia-institución
    @Override
    public long createEmergencyInstitution(EmergencyInstitutionEntity emergencyInstitutionEntity) {
        Long id_institution = emergencyInstitutionEntity.getId_institution();
        Long id_emergency = emergencyInstitutionEntity.getId_emergency();
        try(Connection conn = sql2o.open()) {
            // Verificar si id_task e id_emergency existen en la base de datos
            List<EmergencyEntity> emergencyList = emergencyService.getEmergencyById(id_emergency);
            List<InstitutionEntity> institutionList = institutionService.getInstitutionById(id_institution);
            if (emergencyList != null && !emergencyList.isEmpty() &&
                    institutionList != null && !institutionList.isEmpty()) {
                // en caso que exista el id_task e id_emergency asociado
                String sql = "INSERT INTO emergency_institution (id_institution, id_emergency) " +
                        "VALUES (:id_institution, :id_emergency)";
                Query query = conn.createQuery(sql, true)
                        .addParameter("id_institution", emergencyInstitutionEntity.getId_institution())
                        .addParameter("id_emergency", emergencyInstitutionEntity.getId_emergency());
                int idGenerado = (int) query.executeUpdate().getKey();
                return idGenerado; // retorno el id de la combinación emergencia tarea generada
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

    // Para actualizar una combinación Institución y Emergencia
    @Override
    public String updateEmergencyInstitution(EmergencyInstitutionEntity emergencyInstitutionEntity,
                                             long id_emergency_institution) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE emergency_institution SET id_emergency = :id_emergency, " +
                    "id_institution = :id_institution " +
                    "WHERE id_emergency_institution = :id_emergency_institution";
            conn.createQuery(updateSql)
                    .addParameter("id_emergency", emergencyInstitutionEntity.getId_emergency())
                    .addParameter("id_institution", emergencyInstitutionEntity.getId_institution())
                    .addParameter("id_emergency_institution", id_emergency_institution)
                    .executeUpdate();
            return "actualización realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al realizar actualización";
        }
    }

    // Para borrar una combinación emergencia e institución (por id)
    @Override
    public String deleteEmergencyInstitution(long id_emergency_institution){
        try(Connection conn = sql2o.open()){
            String deletesql = "DELETE FROM emergency_institution WHERE " +
                    "id_emergency_institution = :id_emergency_institution";
            conn.createQuery(deletesql)
                    .addParameter("id_emergency_institution", id_emergency_institution)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }
}
