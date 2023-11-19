package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyAddressEntity;
import grupo3.backend.Services.EmergencyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/emergencyAddress")
public class EmergencyAddressController {
    @Autowired
    EmergencyAddressService emergencyAddressService;

    @GetMapping("/get")
    public List<Map<String, Object>> getAll(){
        return emergencyAddressService.getAllEmergencyAddress();
    }

    @GetMapping("/get/{id}")
    public List<Map<String, Object>> getById(@PathVariable long id) {
        return emergencyAddressService.getEmergencyAddressById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<EmergencyAddressEntity> save(@RequestBody EmergencyAddressEntity emergencyAddressEntity){
        long idGenerado = emergencyAddressService.createEmergencyAddress(emergencyAddressEntity);
        emergencyAddressEntity.setId_address_e(idGenerado);
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
