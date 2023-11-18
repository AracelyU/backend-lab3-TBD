package grupo3.backend.repositories;

import grupo3.backend.Entities.UserEntity;
import grupo3.backend.Entities.UserRequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository {
    List<UserEntity> findByUsername(String username);

    Integer save(UserEntity user);

    // GET
    List<UserEntity> getUsersById(long id_user);

    String updateUsers_byId(UserEntity user, long id_user);

    String delete_User(long id_user);

    // DELETE
    List<Map<String, Object>> userParticipation(long id_user, long id_task);

    List<UserEntity> get_All_Users();

    List<Map<String, Object>> usersParticipation(long id_task);

    List<Map<String, Object>> getParticipationByTask(long id_task);
}
