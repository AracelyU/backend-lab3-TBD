package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyEntity;
import grupo3.backend.Entities.TaskEntity;
import grupo3.backend.Services.EmergencyService;
import grupo3.backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/emergency")
public class EmergencyController {
    @Autowired
    EmergencyService emergencyService;

    @GetMapping("/get")
    public List<EmergencyEntity> getAll(){
        return emergencyService.getAllEmergency();
    }

    @GetMapping("/get/{id}")
    public List<EmergencyEntity> getById(@PathVariable long id) {
        return emergencyService.getEmergencyById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<EmergencyEntity> save(@RequestBody EmergencyEntity emergencyEntity){
        long idGenerado = emergencyService.createEmergency(emergencyEntity);
        emergencyEntity.setId_emergency(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(emergencyEntity);
    }


    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody EmergencyEntity emergencyEntity) {
        return emergencyService.updateEmergency(emergencyEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return emergencyService.deleteEmergency(id);
    }

    @GetMapping("/get_names")
    public List<EmergencyEntity> getEmergenciesName(){
        return emergencyService.getEmergenciesName();
    }

    @GetMapping("/get_state_names")
    public List<Map<String, Object>> getStateNames(){
        return emergencyService.getEmergencies_nameState();
    }
}
