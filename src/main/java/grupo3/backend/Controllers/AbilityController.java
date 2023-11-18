package grupo3.backend.Controllers;

import grupo3.backend.Entities.AbilityEntity;
import grupo3.backend.Services.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping ("/ability")
public class AbilityController {

    @Autowired
    AbilityService abilityService;

    // GET
    @GetMapping("/get")
    public List<AbilityEntity> getAll(){
        return abilityService.getAllAbility();
    }

    @GetMapping("/get/{id}")
    public List<AbilityEntity> getById(@PathVariable long id) {
        return abilityService.getAbilityById(id);
    }

    // POST
    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<AbilityEntity> save(@RequestBody AbilityEntity abilityEntity) {
        long idGenerado = abilityService.createAbility(abilityEntity);
        abilityEntity.setId_ability(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(abilityEntity);
    }

    // PUT
    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody AbilityEntity abilityEntity) {
        return abilityService.updateAbility(abilityEntity, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return abilityService.deleteAbility(id);
    }
}
