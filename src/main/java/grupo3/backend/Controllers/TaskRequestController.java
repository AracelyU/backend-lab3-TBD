package grupo3.backend.Controllers;

import grupo3.backend.Entities.TaskEntity;
import grupo3.backend.Entities.RequestEntity;
import grupo3.backend.Entities.TaskRequestEntity;
import grupo3.backend.Services.TaskRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task_request")
public class TaskRequestController {
    @Autowired
    TaskRequestService taskRequestService;

    // GET
    @GetMapping("/get")
    public List<TaskRequestEntity> getAll(){
        return taskRequestService.getAllTaskRequest();
    }

    @GetMapping("/get/{id}")
    public List<TaskRequestEntity> getById(@PathVariable long id) {
        return taskRequestService.getTaskRequest(id);
    }


    // POST
    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<TaskRequestEntity> save(@RequestBody TaskRequestEntity taskRequestEntity){
        long idGenerado = taskRequestService.createTaskRequest(taskRequestEntity);
        taskRequestEntity.setId_task_request(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRequestEntity);
    }

    // PUT
    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody TaskRequestEntity taskRequestEntity) {
        return taskRequestService.updateTaskRequest(taskRequestEntity, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return taskRequestService.deleteTaskRequest(id);
    }
}
