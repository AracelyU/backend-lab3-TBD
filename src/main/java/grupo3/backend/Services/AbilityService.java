package grupo3.backend.Services;

import grupo3.backend.Entities.AbilityEntity;
import grupo3.backend.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class AbilityService implements AbilityRepository{

    @Autowired
    private Sql2o sql2o;

    // GET
    @Override
    public List<AbilityEntity> getAllAbility() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla
            return conn.createQuery("SELECT * FROM ability")
                    .executeAndFetch(AbilityEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<AbilityEntity> getAbilityById(Long id_ability){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM ability WHERE id_ability = :id_ability")
                    .addParameter("id_ability", id_ability)
                    .executeAndFetch(AbilityEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // POST
    @Override
    public long createAbility(AbilityEntity ability) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO ability (ability_name, ability_description) " +
                    "VALUES (:ability_name, :ability_description)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("ability_name", ability.getAbility_name())
                    .addParameter("ability_description", ability.getAbility_description());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado; // retorno el id de la habilidad generada
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    // PUT
    @Override
    public String updateAbility(AbilityEntity ability, Long id_ability){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE ability SET ability_name= :ability_name, " +
                    "ability_description = :ability_description " +
                    "WHERE id_ability = :id_ability";
            conn.createQuery(updateSql)
                    .addParameter("ability_name", ability.getAbility_name())
                    .addParameter("ability_description", ability.getAbility_description())
                    .addParameter("id_ability", id_ability)
                    .executeUpdate();
            return "Habilidad actualizada";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // DELETE
    @Override
    public String deleteAbility(Long id_ability){
        try(Connection conn = sql2o.open()){
            String deleteSql = "DELETE FROM ability WHERE id_ability = :id_ability";
            conn.createQuery(deleteSql)
                    .addParameter("id_ability", id_ability)
                    .executeUpdate();
            return "Habilidad eliminada";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
