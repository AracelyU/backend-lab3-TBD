package grupo3.backend.ServicesMongo;


import grupo3.backend.EntitiesMongo.TaskMongo;
import grupo3.backend.repositoriesMongo.TaskMongoRepositoryImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerMongo {

    @Autowired
    TaskMongoRepositoryImg taskMongoRepositoryImg;

    @GetMapping("/tareasActivas/{id_emergencia}")
    public List<TaskMongo> getDogs(@PathVariable("id_emergencia") long id_emergency){
        return taskMongoRepositoryImg.getActiveTasksForEmergency(id_emergency);
    }




}
