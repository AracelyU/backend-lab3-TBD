package grupo3.backend.repositories;

import grupo3.backend.Entities.EmergencyTaskEntity;
import grupo3.backend.Entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmergencyTaskRepository {

    List<EmergencyTaskEntity> getAllEmergencyTask();

    // Para buscar una combinación emergencia-tarea por id
    List<EmergencyTaskEntity> getEmergencyTask(long id_emergency_task);

    // Para crear una nueva combinación emergencia-tarea
    long createEmergencyTask(EmergencyTaskEntity emergencyTaskEntity);

    // Para actualizar la información de una tarea
    String updateEmergencyTask(EmergencyTaskEntity emergencyTaskEntity, long id_emergency_task);

    // Para borrar una emergencia (por id)
    String deleteEmergencyTask(long id_emergency_task);

    long special_creation_task(Map<String, Object> jsonData);
}
