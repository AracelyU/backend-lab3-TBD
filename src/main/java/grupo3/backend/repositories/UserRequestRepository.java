package grupo3.backend.repositories;

import grupo3.backend.Entities.UserRequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRequestRepository {

    // GET
    List<UserRequestEntity> getAllUserRequest();
    List<UserRequestEntity> getUserRequest(long id_user_request);

    // POST
    long createUserRequest(UserRequestEntity userRequestEntity);

    // PUT
    String updateUserRequest(UserRequestEntity userRequestEntity, long id_user_request);

    // DELETE
    String deleteUserRequest(long id_user_request);
}
