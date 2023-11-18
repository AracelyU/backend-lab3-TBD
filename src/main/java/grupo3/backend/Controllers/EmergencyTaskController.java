package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyEntity;
import grupo3.backend.Entities.EmergencyTaskEntity;
import grupo3.backend.Entities.TaskEntity;
import grupo3.backend.Services.EmergencyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/emergency_task")
public class EmergencyTaskController {
    @Autowired
    EmergencyTaskService emergencyTaskService;

    @GetMapping("/get")
    public List<EmergencyTaskEntity> getAll(){
        return emergencyTaskService.getAllEmergencyTask();
    }

    @GetMapping("/get/{id}")
    public List<EmergencyTaskEntity> getById(@PathVariable long id) {
        return emergencyTaskService.getEmergencyTask(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<EmergencyTaskEntity> save(@RequestBody EmergencyTaskEntity emergencyTaskEntity){
        long idGenerado = emergencyTaskService.createEmergencyTask(emergencyTaskEntity);
        emergencyTaskEntity.setId_emergency_task(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(emergencyTaskEntity);
    }


    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody EmergencyTaskEntity emergencyTaskEntity) {
        return emergencyTaskService.updateEmergencyTask(emergencyTaskEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return emergencyTaskService.deleteEmergencyTask(id);
    }

    @PostMapping("/specialPost")
    @ResponseBody
    public long createSpecialTask(@RequestBody Map<String, Object> json){
        return emergencyTaskService.special_creation_task(json);
    }

}
