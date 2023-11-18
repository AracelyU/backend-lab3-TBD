package grupo3.backend.Services;

import grupo3.backend.Entities.EmergencyEntity;
import grupo3.backend.Entities.EmergencyTaskEntity;
import grupo3.backend.Entities.TaskEntity;
import grupo3.backend.Entities.TaskRequestEntity;
import grupo3.backend.repositories.EmergencyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Service
public class EmergencyTaskService implements EmergencyTaskRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    EmergencyService emergencyService;

    @Autowired
    TaskRequestService taskRequestService;

    @Autowired
    TaskService taskService;


    // para obtener todas las combinaciones emergencia-tarea
    @Override
    public List<EmergencyTaskEntity> getAllEmergencyTask() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM emergency_task")
                    .executeAndFetch(EmergencyTaskEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    // Para buscar una combinación emergencia-tarea por id
    public List<EmergencyTaskEntity> getEmergencyTask(long id_emergency_task){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM emergency_task WHERE id_emergency_task= :id_emergency_task")
                    .addParameter("id_emergency_task", id_emergency_task)
                    .executeAndFetch(EmergencyTaskEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    // Para crear una nueva combinación emergencia-tarea
    @Override
    public long createEmergencyTask(EmergencyTaskEntity emergencyTaskEntity) {
        Long id_task = emergencyTaskEntity.getId_task();
        Long id_emergency = emergencyTaskEntity.getId_emergency();
        try(Connection conn = sql2o.open()) {
            // Verificar si id_task e id_emergency existen en la base de datos
            List<EmergencyEntity> emergencyList = emergencyService.getEmergencyById(id_emergency);
            List<TaskEntity> taskList = taskService.getTaskById(id_task);
            if (emergencyList != null && !emergencyList.isEmpty() && taskList != null && !taskList.isEmpty()) {
                // en caso que exista el id_task e id_emergency asociado
                String sql = "INSERT INTO emergency_task (id_task, id_emergency) " +
                        "VALUES (:id_task, :id_emergency)";
                Query query = conn.createQuery(sql, true)
                        .addParameter("id_task", emergencyTaskEntity.getId_task())
                        .addParameter("id_emergency", emergencyTaskEntity.getId_emergency());
                int idGenerado = (int) query.executeUpdate().getKey();
                return idGenerado; // retorno el id de la combinación emergencia tarea generada
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

    // Para actualizar la información de una tarea
    @Override
    public String updateEmergencyTask(EmergencyTaskEntity emergencyTaskEntity, long id_emergency_task) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE emergency_task SET id_emergency = :id_emergency, " +
                    "id_task  = :id_task " +
                    "WHERE id_emergency_task = :id_emergency_task";
            conn.createQuery(updateSql)
                    .addParameter("id_emergency", emergencyTaskEntity.getId_emergency())
                    .addParameter("id_task", emergencyTaskEntity.getId_task())
                    .addParameter("id_emergency_task", id_emergency_task)
                    .executeUpdate();
            return "actualización realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al realizar actualización";
        }
    }
    // Para borrar una emergencia (por id)
    @Override
    public String deleteEmergencyTask(long id_emergency_task){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM emergency_task WHERE id_emergency_task = :id_emergency_task ")
                    .addParameter("id_emergency_task", id_emergency_task)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }

    @Override
    public long special_creation_task(Map<String, Object> jsonData){
        String task_name = (String) jsonData.get("task_name");
        int emergency_id = (int) jsonData.get("emergency_id");
        List<Integer> requirements = (List<Integer>) jsonData.get("requirements");
        Object volunteersRequiredObj = jsonData.get("volunteers_required");
        Long volunteersRequired = null;
        if (volunteersRequiredObj instanceof Long) {
            volunteersRequired = (Long) volunteersRequiredObj;
        } else if (volunteersRequiredObj instanceof Integer) {
            volunteersRequired = ((Integer) volunteersRequiredObj).longValue();
        }
        String description = (String) jsonData.get("description");
        TaskEntity task = new TaskEntity();
        task.setTask_name(task_name); task.setTask_description(description);
        task.setVolunteers_required(Math.toIntExact(volunteersRequired));
        task.setId_state(1);
        long l = taskService.createTask(task);  // creo la nueva tarea
        // creo la nueva relacion emergencia tarea
        EmergencyTaskEntity emergencyTask = new EmergencyTaskEntity();
        emergencyTask.setId_emergency(emergency_id); emergencyTask.setId_task(l);
        createEmergencyTask(emergencyTask);
        // Para vincular la tarea con los requerimientos
        TaskRequestEntity taskRequest;
        for(Integer id_request : requirements){
            taskRequest = new TaskRequestEntity();
            taskRequest.setId_request(id_request); taskRequest.setId_task(l);
            taskRequestService.createTaskRequest(taskRequest);
        }
        return l;
    }

}
