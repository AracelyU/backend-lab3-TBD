package grupo3.backend.Services;

import grupo3.backend.Entities.*;
import grupo3.backend.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RankingService implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;


    // para obtener todos los ranking
    @Override
    public List<RankingEntity> getAllRankings() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla ranking
            return conn.createQuery("SELECT * FROM ranking")
                    .executeAndFetch(RankingEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    // Para buscar una combinación emergencia-tarea por id
    public List<RankingEntity> getRankingById(long id_ranking){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM ranking WHERE id_ranking = :id_ranking")
                    .addParameter("id_ranking", id_ranking)
                    .executeAndFetch(RankingEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Para crear un nuevo ranking
    @Override
    public long createRanking(RankingEntity rankingEntity) {
        Long id_task = rankingEntity.getId_task();
        Long id_user = rankingEntity.getId_user();
        try(Connection conn = sql2o.open()) {
            // Verificar si id_task e id_user existen en la base de datos
            // List<UserEntity> userList = userService.getUserById(id_emergency);
            List<TaskEntity> taskList = taskService.getTaskById(id_task);
            // if (userList != null && !emergencyList.isEmpty() && taskList != null && !taskList.isEmpty()) {
            if (taskList != null && !taskList.isEmpty()) {
                // en caso que exista el id_task e id_emergency asociado
                String sql = "INSERT INTO ranking (ranking_position, id_user, id_task) " +
                        "VALUES (:ranking_position, :id_user, :id_task)";
                Query query = conn.createQuery(sql, true)
                        .addParameter("ranking_position", rankingEntity.getRanking_position())
                        .addParameter("id_user", rankingEntity.getId_user())
                        .addParameter("id_task", rankingEntity.getId_task());
                int idGenerado = (int) query.executeUpdate().getKey();
                return idGenerado; // retorno el id del ranking creado
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

    // Para actualizar la información de un ranking
    @Override
    public String updateRanking(RankingEntity rankingEntity, long id_ranking) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE ranking SET ranking_position = :ranking_position, " +
                    "id_user = :id_user, id_task = :id_task " +
                    "WHERE id_ranking = :id_ranking";
            conn.createQuery(updateSql)
                    .addParameter("ranking_position", rankingEntity.getRanking_position())
                    .addParameter("id_user", rankingEntity.getId_user())
                    .addParameter("id_task", rankingEntity.getId_task())
                    .addParameter("id_ranking", id_ranking)
                    .executeUpdate();
            return "actualización realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al realizar actualización";
        }
    }
    // Para borrar un ranking (por id)
    @Override
    public String deleteRanking(long id_ranking){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM ranking WHERE id_ranking = :id_ranking ")
                    .addParameter("id_ranking", id_ranking)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //

    // Para obtener los voluntarios designados de una tarea
    /*
    public int getVolunteersCountByTask(long taskId) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT COUNT(*) AS num FROM ranking WHERE id_task = :taskId";
            Integer count = conn.createQuery(sql)
                    .addParameter("taskId", taskId)
                    .executeScalar(Integer.class);
            return count != null ? count : 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

        @Override
    public List<Map<String, Object>> getTaskInformation(long id_task) {
        try (Connection conn = sql2o.open()) {
            int volunteersCount = getVolunteersCountByTask(id_task);
            String sql = "SELECT ta.*, et.id_emergency, e.emergency_name, e.emergency_type, " +
                    ":volunteersCount as volunteers_count " +
                    "FROM task ta, emergency_task et, emergency e " +
                    "WHERE ta.id_task = :id_task AND ta.id_task = et.id_task " +
                    "AND et.id_emergency = e.id_emergency ";
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .addParameter("id_task", id_task)
                    .addParameter("volunteersCount", volunteersCount)
                    .executeAndFetchTable()
                    .asList();
            if(results.isEmpty()){

            }
            return results;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    }*/


    // Para obtener la información de una tarea (1)
    @Override
    public Map<String, Object> getTaskInformation(long id_task) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT ta.*, e.emergency_type, s.state_name " +
                    "FROM task ta, emergency_task et, emergency e, state s " +
                    "WHERE ta.id_task = :id_task AND ta.id_task = et.id_task " +
                    "AND et.id_emergency = e.id_emergency AND ta.id_state = s.id_state";
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .addParameter("id_task", id_task)
                    .executeAndFetchTable()
                    .asList();
            if(!results.isEmpty()){
                Map<String, Object> m = results.get(0);
                return m;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*
    @Override
    public List<Map<String, Object>> getTaskInformation(long id_task) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT ta.*, et.id_emergency, e.emergency_name, e.emergency_type " +
                    "FROM task ta, emergency_task et, emergency e " +
                    "WHERE ta.id_task = :id_task AND ta.id_task = et.id_task " +
                    "AND et.id_emergency = e.id_emergency ";
            List<Map<String, Object>> results = conn.createQuery(sql)
                    .addParameter("id_task", id_task)
                    .executeAndFetchTable()
                    .asList();
            if(!results.isEmpty()){
            }
            return results;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<List<Map<String, Object>>> getInformationByTasks() {
        List<List<Map<String, Object>>> l = new ArrayList<>(); // Inicializo la lista aquí
        List<TaskEntity> taskEntities = taskService.getAllTasks();
        for (TaskEntity t : taskEntities) {
            List<Map<String, Object>> o = getTaskInformation(t.getId_task());
            if(!o.isEmpty()){
                l.add(o);
            }
        }
        return l;
    }

    */

    @Override
    public List<Map<String, Object>> getInformationByTasks() {
        List<Map<String, Object>> l = new ArrayList<>(); // Inicializo la lista aquí
        List<TaskEntity> taskEntities = taskService.getAllTasks();
        for (TaskEntity t : taskEntities) {
            Map<String, Object> o = getTaskInformation(t.getId_task());
            if(o != null && !o.isEmpty()){
                l.add(o);
            }
        }
        return l;
    }



}
