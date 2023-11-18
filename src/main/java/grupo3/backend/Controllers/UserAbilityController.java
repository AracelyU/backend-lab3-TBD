package grupo3.backend.Controllers;

import grupo3.backend.Entities.TaskRequestEntity;
import grupo3.backend.Entities.UserAbilityEntity;
import grupo3.backend.Services.TaskRequestService;
import grupo3.backend.Services.UserAbilityService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user_ability")
public class UserAbilityController {
    @Autowired
    UserAbilityService userAbilityService;

    // GET
    @GetMapping("/get")
    public List<UserAbilityEntity> getAll(){
        return userAbilityService.getAllUserAbility();
    }

    @GetMapping("/get/{id}")
    public List<UserAbilityEntity> getById(@PathVariable long id) {
        return userAbilityService.getUserAbility(id);
    }

    // PUT
    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody UserAbilityEntity userAbilityEntity) {
        return userAbilityService.updateUserRequest(userAbilityEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return userAbilityService.deleteUserRequest(id);
    }

}
