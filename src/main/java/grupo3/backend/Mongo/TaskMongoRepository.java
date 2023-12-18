package grupo3.backend.Mongo;

import grupo3.backend.EntitiesMongo.TaskMongo;

import java.util.List;

public interface TaskMongoRepository {

    List<TaskMongo> getActiveTasksForEmergency(long emergencyId);


}
