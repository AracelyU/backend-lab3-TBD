package grupo3.backend.Services;

import grupo3.backend.Entities.*;
import grupo3.backend.repositories.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class UserRequestService implements UserRequestRepository {
    @Autowired
    private Sql2o sql2o;

    //@Autowired
    //UserService userService; (no esta implementado)

    @Autowired
    grupo3.backend.Services.RequestService requestService;

    // GET
    @Override
    public List<UserRequestEntity> getAllUserRequest() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM user_request")
                    .executeAndFetch(UserRequestEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserRequestEntity> getUserRequest(long id_user_request){
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM user_request WHERE " +
                    "id_user_request = :id_user_request";
            return conn.createQuery(sql)
                    .addParameter("id_user_request", id_user_request)
                    .executeAndFetch(UserRequestEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // POST
    @Override
    public long createUserRequest(UserRequestEntity userRequestEntity) {
        Long id_user = userRequestEntity.getId_user();
        Long id_request = userRequestEntity.getId_request();
        try(Connection conn = sql2o.open()) {
            Long insertedId = conn.createQuery("INSERT INTO user_request(id_user, id_request) " +
                    "values (:id_user, :id_request)", true)
                    .addParameter("id_user", id_user)
                    .addParameter("id_request", id_request)
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
    public String updateUserRequest(UserRequestEntity userRequestEntity, long id_user_request) {
        Long id_user = userRequestEntity.getId_user();
        Long id_request = userRequestEntity.getId_request();
        try(Connection conn = sql2o.open()) {
            String updateSql = "UPDATE user_request SET " +
                    "id_user = :id_user, " +
                    "id_request = :id_request " +
                    "WHERE id_user_request = :id_user_request";
            conn.createQuery(updateSql)
                    .addParameter("id_user", id_user)
                    .addParameter("id_request", id_request)
                    .addParameter("id_user_request", id_user_request)
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
    public String deleteUserRequest(long id_user_request) {
        try(Connection conn = sql2o.open()) {
            String deleteSql = "DELETE FROM user_request WHERE id_user_request = :id_user_request";
            conn.createQuery(deleteSql)
                    .addParameter("id_user_request", id_user_request)
                    .executeUpdate();
            return "Solicitud de usuario eliminada";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al eliminar solicitud de usuario";
        }
    }
}
