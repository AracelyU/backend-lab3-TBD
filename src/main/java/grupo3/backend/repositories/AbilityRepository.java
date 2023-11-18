package grupo3.backend.repositories;

import grupo3.backend.Entities.AbilityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbilityRepository {

    // GET
    List<AbilityEntity> getAllAbility();
    List<AbilityEntity> getAbilityById(Long id_ability);

    // POST
    long createAbility(AbilityEntity ability);

    // PUT
    String updateAbility(AbilityEntity ability, Long id_ability);

    // DELETE
    String deleteAbility(Long id_ability);
}
