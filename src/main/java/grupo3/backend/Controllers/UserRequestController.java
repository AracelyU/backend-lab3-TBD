package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyInstitutionEntity;
import grupo3.backend.Services.EmergencyInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user_request")
public class UserRequestController {
    @Autowired
    EmergencyInstitutionService emergencyInstitutionService;

    // GET
    @GetMapping("/get")
    public List<EmergencyInstitutionEntity> getAll(){
        return emergencyInstitutionService.getAllEmergencyInstitution();
    }

    @GetMapping("/get/{id}")
    public List<EmergencyInstitutionEntity> getById(@PathVariable long id) {
        return emergencyInstitutionService.getEmergencyInstitution(id);
    }

    // POST
    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<EmergencyInstitutionEntity> save(@RequestBody EmergencyInstitutionEntity emergencyInstitution){
        long idGenerado = emergencyInstitutionService.createEmergencyInstitution(emergencyInstitution);
        emergencyInstitution.setId_emergency_institution(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(emergencyInstitution);
    }

    // PUT
    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody EmergencyInstitutionEntity emergencyInstitution) {
        return emergencyInstitutionService.updateEmergencyInstitution(emergencyInstitution, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return emergencyInstitutionService.deleteEmergencyInstitution(id);
    }
}
