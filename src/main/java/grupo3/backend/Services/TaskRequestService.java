package grupo3.backend.Services;

import grupo3.backend.Entities.TaskEntity;
import grupo3.backend.Entities.TaskRequestEntity;
import grupo3.backend.Entities.RequestEntity;
import grupo3.backend.repositories.TaskRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class TaskRequestService implements TaskRequestRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    TaskService taskService;

    @Autowired
    RequestService requestService;

    // GET
    public List<TaskRequestEntity> getAllTaskRequest() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskRequest
            return conn.createQuery("SELECT * FROM task_request")
                    .executeAndFetch(TaskRequestEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<TaskRequestEntity> getTaskRequest(long id_task_request){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM task_request WHERE id_task_request= :id_task_request")
                    .addParameter("id_task_request", id_task_request)
                    .executeAndFetch(TaskRequestEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // POST
    public long createTaskRequest(TaskRequestEntity taskRequestEntity) {
        Long id_task = taskRequestEntity.getId_task();
        Long id_request = taskRequestEntity.getId_request();
        // verifico que existan los id_task y id_request
        List<TaskEntity> task = taskService.getTaskById(id_task);
        List<RequestEntity> request = requestService.getRequestById(id_request);
        if (task == null || request == null) {
            return -1;
        }
        try(Connection conn = sql2o.open()) {
            Long id_task_request = conn.createQuery("SELECT MAX(id_task_request) " +
                    "FROM task_request").executeScalar(Long.class);
            if (id_task_request == null) {
                id_task_request = 0L;
            }
            else {
                id_task_request++;
            }
            conn.createQuery("INSERT INTO task_request(id_task_request, id_task, id_request) " +
                            "VALUES (:id_task_request, :id_task, :id_request)")
                    .addParameter("id_task_request", id_task_request)
                    .addParameter("id_task", id_task)
                    .addParameter("id_request", id_request)
                    .executeUpdate();

            return id_task_request;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    // PUT
    public String updateTaskRequest(TaskRequestEntity taskRequestEntity, long id_task_request) {
        Long id_task = taskRequestEntity.getId_task();
        Long id_request = taskRequestEntity.getId_request();

        try(Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE task_request SET id_task = :id_task, id_request = :id_request WHERE id_task_request = :id_task_request")
                    .addParameter("id_task_request", id_task_request)
                    .addParameter("id_task", id_task)
                    .addParameter("id_request", id_request)
                    .executeUpdate();

            return "task_request updated";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: task_request not updated";
        }
    }

    // DELETE
    public String deleteTaskRequest(long id_task_request) {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM task_request WHERE id_task_request = :id_task_request")
                    .addParameter("id_task_request", id_task_request)
                    .executeUpdate();

            return "task_request deleted";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error: task_request not deleted";
        }
    }
}
