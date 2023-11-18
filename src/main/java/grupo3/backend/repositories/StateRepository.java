package grupo3.backend.repositories;

import grupo3.backend.Entities.StateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository {
    List<StateEntity> getAllStateTask();
    List<StateEntity> getStateTaskById(long id_state);
    long createTaskState(StateEntity taskStatus);
    String updateTaskStatus(StateEntity taskStatus, long id_state);
    String deleteTaskStatus(long id_state);

    // - - - - - - - - - -  - - - - - - -
    StateEntity getStateByName(String stateName);
}
