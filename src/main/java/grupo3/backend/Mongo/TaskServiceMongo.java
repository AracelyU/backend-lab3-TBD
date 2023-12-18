package grupo3.backend.Mongo;

import grupo3.backend.EntitiesMongo.TaskMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceMongo {
    @Autowired
    TaskMongoRepositoryImg taskMongoRepositoryImg;
    public List<TaskMongo> tareasActivas(long id_emergency){
        return taskMongoRepositoryImg.getActiveTasksForEmergency(id_emergency);
    }
}




