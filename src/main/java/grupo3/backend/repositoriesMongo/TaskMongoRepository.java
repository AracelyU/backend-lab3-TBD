package grupo3.backend.repositoriesMongo;

import grupo3.backend.EntitiesMongo.TaskMongo;

import java.util.List;

public interface TaskMongoRepository {

    public List<TaskMongo> getActiveTasksForEmergency(long emergencyId);


}
