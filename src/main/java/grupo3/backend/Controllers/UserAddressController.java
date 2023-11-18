package grupo3.backend.Controllers;

import grupo3.backend.Entities.UserAddressEntity;
import grupo3.backend.Services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userAddress")
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;

    @GetMapping("/get")
    public List<UserAddressEntity> getAll(){
        return userAddressService.getAllUserAddress();
    }

    @GetMapping("/get/{id}")
    public List<UserAddressEntity> getById(@PathVariable long id) {
        return userAddressService.getUserAddressById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<UserAddressEntity> save(@RequestBody UserAddressEntity userAddressEntity){
        long idGenerado = userAddressService.createUserAddress(userAddressEntity);
        userAddressEntity.setId_user_a(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAddressEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody UserAddressEntity userAddressEntity) {
        return userAddressService.updateUserAddress(userAddressEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return userAddressService.deleteUserAddress(id);
    }
}
