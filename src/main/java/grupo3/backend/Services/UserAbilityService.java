package grupo3.backend.Services;

import grupo3.backend.Entities.UserAbilityEntity;
import grupo3.backend.repositories.UserAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class UserAbilityService implements UserAbilityRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    grupo3.backend.Services.RequestService requestService;

    // GET
    @Override
    public List<UserAbilityEntity> getAllUserAbility() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM user_ability")
                    .executeAndFetch(UserAbilityEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public List<UserAbilityEntity> getUserAbility(long id_user_ability){
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM user_ability WHERE " +
                    "id_user_ability = :id_user_ability";
            return conn.createQuery(sql)
                    .addParameter("id_user_ability", id_user_ability)
                    .executeAndFetch(UserAbilityEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // POST
    @Override
    public long createUserAbility(UserAbilityEntity userAbilityEntity) {
        Long id_user = userAbilityEntity.getId_user_ability();
        Long id_ability = userAbilityEntity.getId_user_ability();
        try(Connection conn = sql2o.open()) {
            Long insertedId = conn.createQuery("INSERT INTO user_ability (id_user, id_ability) " +
                            "values (:id_user, :id_request)", true)
                    .addParameter("id_user", id_user)
                    .addParameter("id_ability", id_ability)
                    .executeUpdate().getKey(Long.class);
            return insertedId;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    // PUT
    @Override
    public String updateUserRequest(UserAbilityEntity userAbilityEntity, long id_user_ability) {
        Long id_user = userAbilityEntity.getId_user();
        Long id_ability = userAbilityEntity.getId_ability();
        try(Connection conn = sql2o.open()) {
            String updateSql = "UPDATE user_ability SET " +
                    "id_user = :id_user, " +
                    "id_ability = :id_ability " +
                    "WHERE id_user_ability = :id_user_ability";
            conn.createQuery(updateSql)
                    .addParameter("id_user", id_user)
                    .addParameter("id_ability", id_ability)
                    .addParameter("id_user_ability", id_user_ability)
                    .executeUpdate();
            return "Solicitud de usuario actualizada";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al actualizar solicitud de usuario";
        }
    }

    // DELETE
    @Override
    public String deleteUserRequest(long id_user_ability) {
        try(Connection conn = sql2o.open()) {
            String deleteSql = "DELETE FROM user_ability WHERE id_user_ability = :id_user_ability";
            conn.createQuery(deleteSql)
                    .addParameter("id_user_ability", id_user_ability)
                    .executeUpdate();
            return "Solicitud de usuario eliminada";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al eliminar solicitud de usuario";
        }
    }
}
