package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyAddressEntity;
import grupo3.backend.Services.EmergencyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/emergencyAddress")
public class EmergencyAddressController {
    @Autowired
    EmergencyAddressService emergencyAddressService;

    @GetMapping("/get")
    public List<EmergencyAddressEntity> getAll(){
        return emergencyAddressService.getAllEmergencyAddress();
    }

    @GetMapping("/get/{id}")
    public List<EmergencyAddressEntity> getById(@PathVariable long id) {
        return emergencyAddressService.getEmergencyAddressById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<EmergencyAddressEntity> save(@RequestBody EmergencyAddressEntity emergencyAddressEntity){
        long idGenerado = emergencyAddressService.createEmergencyAddress(emergencyAddressEntity);
        emergencyAddressEntity.setId_emergency_address(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(emergencyAddressEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody EmergencyAddressEntity emergencyAddressEntity) {
        return emergencyAddressService.updateEmergencyAddress(emergencyAddressEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return emergencyAddressService.deleteEmergencyAddress(id);
    }
}
