package grupo3.backend.repositories;

import grupo3.backend.Entities.ProfileEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProfileRepository {

    Integer save(ProfileEntity profile);

    List<ProfileEntity> getAllProfile();

    List<ProfileEntity> getProfileById(long id_profile);

    public int createProfile(ProfileEntity profile);

    long create_Profile(ProfileEntity profile);

    public String updateProfile(ProfileEntity profile, Long id_profile);

    public String deleteProfile(long id_profile);


}
