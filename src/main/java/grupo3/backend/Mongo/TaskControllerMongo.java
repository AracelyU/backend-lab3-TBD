package grupo3.backend.Mongo;


import grupo3.backend.EntitiesMongo.TaskMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/taskMongo")
public class TaskControllerMongo {
    @Autowired
    TaskServiceMongo taskServiceMongo;
    @GetMapping("/tareasActivas/{id_emergencia}")
    public List<TaskMongo> obtenerTareasActivas(@PathVariable long id_emergencia){
        return taskServiceMongo.tareasActivas(id_emergencia);
    }
}






