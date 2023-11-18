package grupo3.backend.repositories;

import grupo3.backend.Entities.EmergencyInstitutionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyInstitutionRepository {

    // para obtener todas las combinaciones emergencia-institución
    List<EmergencyInstitutionEntity> getAllEmergencyInstitution();

    // Para buscar una combinación emergencia-institución por id
    List<EmergencyInstitutionEntity> getEmergencyInstitution(long id_emergency_institution);

    // Para crear una nueva combinación emergencia-institución
    long createEmergencyInstitution(EmergencyInstitutionEntity emergencyInstitutionEntity);

    // Para actualizar una combinación Institución y Emergencia
    String updateEmergencyInstitution(EmergencyInstitutionEntity emergencyInstitutionEntity,
                                      long id_emergency_institution);

    // Para borrar una combinación emergencia e institución (por id)
    String deleteEmergencyInstitution(long id_emergency_institution);
}
