package grupo3.backend.repositories;

import grupo3.backend.Entities.TaskRequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRequestRepository {
    // GET
    List<TaskRequestEntity> getAllTaskRequest();
    List<TaskRequestEntity> getTaskRequest(long id_task_request);

    // POST
    long createTaskRequest(TaskRequestEntity taskRequestEntity);

    // PUT
    String updateTaskRequest(TaskRequestEntity taskRequestEntity, long id_task_request);

    // DELETE
    String deleteTaskRequest(long id_task_request);
}
