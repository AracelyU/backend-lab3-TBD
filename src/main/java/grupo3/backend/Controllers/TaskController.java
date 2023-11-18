package grupo3.backend.Controllers;

import grupo3.backend.Entities.TaskEntity;
import grupo3.backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/get")
    public List<TaskEntity> getAll(){
        return taskService.getAllTasks();
    }

    @GetMapping("/get_s/{id}")
    public List<Map<String, Object>> getNameState(@PathVariable long id){
        return taskService.getTasks_emergency(id);
    }


    @GetMapping("/get/{id}")
    public List<TaskEntity> getById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity taskEntity){
        long idGenerado = taskService.createTask(taskEntity);
        taskEntity.setId_task(idGenerado);
        System.out.println("id: " + idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody TaskEntity taskEntity) {
        return taskService.updateTask(taskEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return taskService.deleteTask(id);
    }

    @PutMapping("/updateTaskName/{id}/{newTaskName}")
    @ResponseBody
    public String updateTaskName(@PathVariable long id, @PathVariable String newTaskName) {
        return taskService.updateTaskName(id, newTaskName);
    }

    @PutMapping("/updateDescription/{id}/{description}")
    @ResponseBody
    public String updateDescription(@PathVariable long id, @PathVariable String description) {
        return taskService.updateTaskDescription(id, description);
    }

    @PutMapping("/updateVolunteers/{id}/{volunteers}")
    @ResponseBody
    public String updateVolunteers(@PathVariable long id, @PathVariable Integer volunteers) {
        return taskService.updateVolunteersRequired(id, volunteers);
    }

    @PutMapping("/updateState/{id}/{state_name}")
    @ResponseBody
    public String updateState(@PathVariable long id, @PathVariable String state_name) {
        return taskService.updateStateTask(id, state_name);
    }


}
