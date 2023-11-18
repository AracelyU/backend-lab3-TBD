package grupo3.backend.repositories;

import grupo3.backend.Entities.TaskEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TaskRepository {
    List<TaskEntity> getAllTasks();

    //List<Object> getTasks_2();

    //List<Map<String, Object>> getTasks_nameState();

    List<TaskEntity> getTaskById(long id_task);
    long createTask(TaskEntity taskModel);
    String updateTask(TaskEntity taskModel, long id_task);
    public String deleteTask(long id_task);
    public List<TaskEntity> getTaskByName(String task_name);

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Para obtener el listado de emergencias ordenadas por estado y nombre (5)
    List<Map<String, Object>> getTasks_emergency(long id_emergency);

    // - -- - - - - - - -- -- -  -- - - - -
    String updateTaskName(long id_task, String newTaskName);

    String updateTaskDescription(long id_task, String newTaskDescription);

    String updateVolunteersRequired(long id_task, Integer newVolunteersRequired);

    String updateStateTask(long id_task, String state_name);

}
