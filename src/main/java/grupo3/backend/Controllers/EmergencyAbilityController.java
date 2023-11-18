package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyAbilityEntity;
import grupo3.backend.Services.EmergencyAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("/emergency_ability")
public class EmergencyAbilityController {

    @Autowired
    EmergencyAbilityService emergencyAbilityService;

    // GET
    @GetMapping("/get")
    public List<EmergencyAbilityEntity> getAll(){
        return emergencyAbilityService.getAllEmergencyAbility();
    }

    @GetMapping("/get/{id}")
    public List<EmergencyAbilityEntity> getById(@PathVariable long id) {
        return emergencyAbilityService.getEmergencyAbility(id);
    }

    // POST
    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<EmergencyAbilityEntity> save(@RequestBody EmergencyAbilityEntity emergencyAbility){
        long idGenerado = emergencyAbilityService.createEmergencyAbility(emergencyAbility);
        emergencyAbility.setId_emergency_ability(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(emergencyAbility);
    }

    // PUT
    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody EmergencyAbilityEntity emergencyAbility) {
        return emergencyAbilityService.updateEmergencyAbility(emergencyAbility, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return emergencyAbilityService.deleteEmergencyAbility(id);
    }
}
