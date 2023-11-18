package grupo3.backend.repositories;

import grupo3.backend.Entities.UserAbilityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAbilityRepository {

    // GET
    List<UserAbilityEntity> getAllUserAbility();

    List<UserAbilityEntity> getUserAbility(long id_user_ability);

    // POST
    long createUserAbility(UserAbilityEntity userAbilityEntity);

    // PUT
    String updateUserRequest(UserAbilityEntity userAbilityEntity, long id_user_ability);

    // DELETE
    String deleteUserRequest(long id_user_ability);
}
