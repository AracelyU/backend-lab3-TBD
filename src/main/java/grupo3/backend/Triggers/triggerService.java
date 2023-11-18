package grupo3.backend.Triggers;


import grupo3.backend.repositories.TriggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Service
public class triggerService implements TriggerRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public String updateUserInLoginIdentification(long user_id) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE login_identification SET user_id = :user_id WHERE id_login_identification = 1";
            conn.createQuery(updateSql)
                    .addParameter("user_id", user_id)
                    .executeUpdate();
            return "Valor de user_id actualizado en login_identification";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al actualizar el valor de user_id";
        }
    }


}
