package grupo3.backend.Controllers;

import grupo3.backend.Entities.StateEntity;
import grupo3.backend.Services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/state")
public class StateController {
    @Autowired
    StateService stateService;

    @GetMapping("/get")
    public List<StateEntity> getAll(){
        return stateService.getAllStateTask();
    }

    @GetMapping("/get/{id}")
    public List<StateEntity> getById(@PathVariable long id) {
        return stateService.getStateTaskById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<StateEntity> save(@RequestBody StateEntity stateEntity){
        long idGenerado = stateService.createTaskState(stateEntity);
        stateEntity.setId_state(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(stateEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody StateEntity stateEntity) {
        return stateService.updateTaskStatus(stateEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return stateService.deleteTaskStatus(id);
    }
}
