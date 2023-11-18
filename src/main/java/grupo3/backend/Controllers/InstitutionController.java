package grupo3.backend.Controllers;

import grupo3.backend.Entities.EmergencyTaskEntity;
import grupo3.backend.Entities.InstitutionEntity;
import grupo3.backend.Services.EmergencyTaskService;
import grupo3.backend.Services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/institution")
public class InstitutionController {
    @Autowired
    InstitutionService institutionService;

    @GetMapping("/get")
    public List<InstitutionEntity> getAll(){
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/get/{id}")
    public List<InstitutionEntity> getById(@PathVariable long id) {
        return institutionService.getInstitutionById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<InstitutionEntity> save(@RequestBody InstitutionEntity institutionEntity){
        long idGenerado = institutionService.createInstitution(institutionEntity);
        institutionEntity.setId_institution(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody InstitutionEntity institutionEntity) {
        return institutionService.updateInstitution(institutionEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return institutionService.deleteInstitution(id);
    }
}
