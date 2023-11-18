package grupo3.backend.repositories;


import org.springframework.stereotype.Repository;

@Repository
public interface TriggerRepository {

    String updateUserInLoginIdentification(long user_id);
}
