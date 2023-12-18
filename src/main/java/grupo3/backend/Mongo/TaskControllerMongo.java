package grupo3.backend.Mongo;


import grupo3.backend.EntitiesMongo.TaskMongo;
import grupo3.backend.repositoriesMongo.TaskMongoRepositoryImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/taskMongo")
public class TaskControllerMongo {


    @Autowired
    TaskMongoRepositoryImg taskMongoRepositoryImg;

    @GetMapping("/tareasActivas/{id_emergencia}")
    public List<TaskMongo> obtenerTareasActivas(@PathVariable long id_emergencia){
        System.out.println("esta en el controlador");
        List<TaskMongo> tareas = taskMongoRepositoryImg.getActiveTasksForEmergency(id_emergencia);
        if(tareas == null){
            return null;
        }else{
            return tareas;
        }

    }




}
