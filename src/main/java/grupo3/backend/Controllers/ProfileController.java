package grupo3.backend.Controllers;

import grupo3.backend.Entities.InstitutionEntity;
import grupo3.backend.Entities.ProfileEntity;
import grupo3.backend.Services.InstitutionService;
import grupo3.backend.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/get")
    public List<ProfileEntity> getAll(){
        return profileService.getAllProfile();
    }

    @GetMapping("/get/{id}")
    public List<ProfileEntity> getById(@PathVariable long id) {
        return profileService.getProfileById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<ProfileEntity> save(@RequestBody ProfileEntity profileEntity){
        long idGenerado = profileService.create_Profile(profileEntity);
        profileEntity.setId_profile(idGenerado);
        return ResponseEntity.status(HttpStatus.CREATED).body(profileEntity);
    }

    @PutMapping("/put/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody ProfileEntity profileEntity) {
        return profileService.updateProfile(profileEntity, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return profileService.deleteProfile(id);
    }
}
