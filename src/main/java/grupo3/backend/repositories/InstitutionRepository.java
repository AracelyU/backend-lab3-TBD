package grupo3.backend.repositories;

import grupo3.backend.Entities.InstitutionEntity;

import java.util.List;

public interface InstitutionRepository {
    // Para obtener todas las instituciones
    List<InstitutionEntity> getAllInstitutions();

    // Para buscar una institución por id
    List<InstitutionEntity> getInstitutionById(long id_institution);

    // Para crear una nueva institución
    long createInstitution(InstitutionEntity institutionEntity);

    // Para actualizar la información de una institucion
    String updateInstitution(InstitutionEntity institutionEntity, long id_institution);

    // Para borrar una institucion (por id)
    String deleteInstitution(long id_institution);
}
