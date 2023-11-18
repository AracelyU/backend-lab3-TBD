package grupo3.backend.repositories;

import grupo3.backend.Entities.EmergencyAbilityEntity;
import org.springframework.stereotype.Repository;

public interface EmergencyAbilityRepository {
        // GET
        // para obtener todas las combinaciones emergencia-habilidad
        Iterable<EmergencyAbilityEntity> getAllEmergencyAbility();

        // para obtener una combinación emergencia-habilidad por id
        Iterable<EmergencyAbilityEntity> getEmergencyAbility(long id_emergency_ability);

        // POST
        // para crear una nueva combinación emergencia-habilidad
        long createEmergencyAbility(EmergencyAbilityEntity emergencyAbilityEntity);

        // PUT
        // para actualizar una combinación emergencia-habilidad
        String updateEmergencyAbility(EmergencyAbilityEntity emergencyAbilityEntity, long id_emergency_ability);

        // DELETE
        // para borrar una combinación emergencia-habilidad (por id)
        String deleteEmergencyAbility(long id_emergency_ability);
}
