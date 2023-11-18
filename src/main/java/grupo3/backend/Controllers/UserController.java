package grupo3.backend.Controllers;

import grupo3.backend.Entities.UserAbilityEntity;
import grupo3.backend.Entities.UserEntity;
import grupo3.backend.Services.UserService;
import grupo3.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
        user.setId_user(userRepository.save(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    public ResponseEntity<UserEntity> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByUsername(username).stream().findFirst().orElseThrow());
    }

    @GetMapping("/userparticipation/{id_user}/{id_task}")
    @ResponseBody
    public Map<String, Object> getParcipation(@PathVariable long id_user, @PathVariable long id_task){
        if(userService.userParticipation(id_user, id_task).isEmpty()){
            return null;
        }
        return userService.userParticipation(id_user, id_task).get(0);
    }

    @GetMapping("/users_participation/{id}")
    @ResponseBody
    public List<Map<String, Object>> getParticipations(@PathVariable long id){
        return userService.usersParticipation(id);
    }

    @GetMapping("/users_task_participation/{id}")
    @ResponseBody
    public List<Map<String, Object>> getParticipationsByTask(@PathVariable long id){
        return userService.getParticipationByTask(id);
    }

    @GetMapping("/get")
    public List<UserEntity> getAll(){
        return userService.get_All_Users();
    }

    @GetMapping("/get/{id}")
    public List<UserEntity> getById(@PathVariable long id) {
        return userService.getUsersById(id);
    }

    // PUT
    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody UserEntity userEntity) {
        return userService.updateUsers_byId(userEntity, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return userService.delete_User(id);
    }

    @GetMapping("/getVolunteers/{id_emergency}")
    public List<Map<String, Object>> getVolunteersByEmergency(@PathVariable Integer id_emergency) { return userService.getVolunteersByEmergency(id_emergency); }

}
