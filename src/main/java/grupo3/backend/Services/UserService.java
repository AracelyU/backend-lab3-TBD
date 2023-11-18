package grupo3.backend.Services;

import grupo3.backend.Entities.UserEntity;
import grupo3.backend.Entities.UserRequestEntity;
import grupo3.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<UserEntity> findByUsername(String username) {
        try(Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM public.user WHERE username= :username";
            return conn.createQuery(sql, true)
                    .addParameter("username", username)
                    .executeAndFetch(UserEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Integer save(UserEntity user) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.user (username, password, id_role, id_profile, id_institution, id_address_u)" +
                    " VALUES (:username, :password, :id_role, :id_profile, :id_institution, :id_address_u)";
            return (Integer) conn.createQuery(sql, true)
                    .addParameter("username", user.getUsername())
                    .addParameter("password", user.getPassword())
                    .addParameter("id_role", user.getId_role())
                    .addParameter("id_profile", user.getId_profile())
                    .addParameter("id_institution", user.getId_institution())
                    .addParameter("id_address_u", user.getId_address_u())
                    .executeUpdate()
                    .getKey();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<UserEntity> getUsersById(long id_user){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM \"user\" WHERE id_user= :id_user")
                    .addParameter("id_user", id_user)
                    .executeAndFetch(UserEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserEntity> get_All_Users() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM \"user\"")
                    .executeAndFetch(UserEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateUsers_byId(UserEntity user, long id_user){
        try(Connection conn = sql2o.open()){
            String sql = "UPDATE public.user SET username = :username, password = :password, " +
                    "id_role = :id_role, id_profile =: id_profile, id_institution =: id_institution, id_address_u = :id_addres_u" +
                    "WHERE id_user =: id_user";
            conn.createQuery(sql, true)
                    .addParameter("username", user.getUsername())
                    .addParameter("password", user.getPassword())
                    .addParameter("id_role", user.getId_role())
                    .addParameter("id_profile", user.getId_profile())
                    .addParameter("id_institution", user.getId_institution())
                    .addParameter("id_user", id_user)
                    .addParameter("id_address_u", user.getId_address_u())
                    .executeUpdate();
            return "actualizacion realizada con exito";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al realizar actualizacion";
        }
    }

    @Override
    public String delete_User(long id_user){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from \"user\" where id_user = :id_user ")
                    .addParameter("id_user",id_user)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }

    // - - -  - - -  - - - - - --  - - - - - - - -  - - - - - - - - - - -- - - - -
    // Para obtener la cantidad de tareas en las que participa un voluntario
    public int getParticipation(long id_user, long id_task) {
        try ( Connection conn = sql2o.open()) {
            String sql = "SELECT COUNT(*) AS participation " +
                    "FROM \"user\" u, ranking r " +
                    "WHERE u.id_user = :id_user AND r.id_task = :id_task AND u.id_user = r.id_user";
            Integer count = conn.createQuery(sql)
                    .addParameter("id_user", id_user)
                    .addParameter("id_task", id_task)
                    .executeScalar(Integer.class);
            return count != null ? count : 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Map<String, Object>> userParticipation(long id_user, long id_task){
        try (Connection conn = sql2o.open()) {
            int participation = getParticipation(id_user, id_task);
            if(participation > 0){
                participation = 1;
            }
            else{
                participation = 0;
            }
            String sql = "SELECT u.id_user, p.rut, p.first_name, p.first_lastname, :participation as participation " +
                    "FROM \"user\" u, profile p " +
                    "WHERE u.id_user = :id_user AND u.id_profile = p.id_profile ";
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .addParameter("id_user", id_user)
                    .addParameter("participation", participation)
                    .executeAndFetchTable()
                    .asList();
            return results;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> usersParticipation(long id_task){
        List<Map<String, Object>> us_p = new ArrayList<>(); // Inicializo la lista aquí
        List<UserEntity> users = get_All_Users();
        for(UserEntity u1 : users){
            if(u1.getId_role() == 3){
                List<Map<String, Object>> o = userParticipation(u1.getId_user(), id_task);
                if(!o.isEmpty()){
                    us_p.add(o.get(0));
                }
            }
        }
        return us_p;
    }

    @Override
    public List<Map<String, Object>> getParticipationByTask(long id_task){
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT s.id_user, s.participation, pro.first_name, pro.first_lastname, pro.rut " +
                    "FROM( " +
                    "    SELECT u.id_user, COALESCE(COUNT(r.id_user), 0) AS participation, u.id_profile " +
                    "    FROM profile pro, \"user\" u " +
                    "    LEFT JOIN ranking r ON u.id_user = r.id_user AND r.id_task = :id_task " +
                    "    WHERE pro.id_profile = u.id_profile AND u.id_role = 3  " +
                    "    GROUP BY u.id_user, u.id_profile  " +
                    "    ORDER BY u.id_user " +
                    ") AS s, profile AS pro " +
                    "WHERE s.id_profile = pro.id_profile " +
                    "ORDER BY s.participation DESC, first_name";
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .addParameter("id_task", id_task)
                    .executeAndFetchTable()
                    .asList();
            return results;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
