package grupo3.backend.Services;

import grupo3.backend.Entities.*;
import grupo3.backend.repositories.EmergencyAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class EmergencyAbilityService {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    EmergencyService emergencyService;

    @Autowired
    AbilityService abilityService;

    // GET
    // para obtener todas las combinaciones emergencia-habilidad
    public List<EmergencyAbilityEntity> getAllEmergencyAbility() {
        try(Connection conn = sql2o.open()) {
            //selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM emergency_ability")
                    .executeAndFetch(EmergencyAbilityEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // para obtener una combinación emergencia-habilidad por id
    public List<EmergencyAbilityEntity> getEmergencyAbility(long id_emergency_ability){
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM emergency_ability WHERE " +
                    "id_emergency_ability = :id_emergency_ability";
            return conn.createQuery(sql)
                    .addParameter("id_emergency_ability", id_emergency_ability)
                    .executeAndFetch(EmergencyAbilityEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // POST
    // para crear una nueva combinación emergencia-habilidad
    public long createEmergencyAbility(EmergencyAbilityEntity emergencyAbilityEntity) {
        Long id_ability = emergencyAbilityEntity.getId_ability();
        Long id_emergency = emergencyAbilityEntity.getId_emergency();
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO emergency_ability(id_ability, id_emergency) " +
                    "values(:id_ability, :id_emergency)";
            Query query = conn.createQuery(sql);
            query.addParameter("id_ability", id_ability);
            query.addParameter("id_emergency", id_emergency);
            int id = (int) query.executeUpdate().getKey();
            return id;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    // PUT
    // para actualizar una combinación emergencia-habilidad
    public String updateEmergencyAbility(EmergencyAbilityEntity emergencyAbilityEntity, long id_emergency_ability) {
        Long id_ability = emergencyAbilityEntity.getId_ability();
        Long id_emergency = emergencyAbilityEntity.getId_emergency();
        try(Connection conn = sql2o.open()) {
            String sql = "UPDATE emergency_ability SET id_ability = :id_ability, id_emergency = :id_emergency " +
                    "WHERE id_emergency_ability = :id_emergency_ability";
            Query query = conn.createQuery(sql);
            query.addParameter("id_ability", id_ability);
            query.addParameter("id_emergency", id_emergency);
            query.addParameter("id_emergency_ability", id_emergency_ability);
            query.executeUpdate();
            return "Se ha actualizado la combinación emergencia-habilidad con id " + id_emergency_ability;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Ha ocurrido un error al actualizar la combinación emergencia-habilidad con id " + id_emergency_ability;
        }
    }

    // DELETE
    // para eliminar una combinación emergencia-habilidad
    public String deleteEmergencyAbility(long id_emergency_ability) {
        try(Connection conn = sql2o.open()) {
            String sql = "DELETE FROM emergency_ability WHERE id_emergency_ability = :id_emergency_ability";
            Query query = conn.createQuery(sql);
            query.addParameter("id_emergency_ability", id_emergency_ability);
            query.executeUpdate();
            return "Se ha eliminado la combinación emergencia-habilidad con id " + id_emergency_ability;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Ha ocurrido un error al eliminar la combinación emergencia-habilidad con id " + id_emergency_ability;
        }
    }
}
