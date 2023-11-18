package grupo3.backend.repositories;


import grupo3.backend.Entities.EmergencyEntity;
import grupo3.backend.Entities.ProfileEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmergencyRepository {

    List<EmergencyEntity> getAllEmergency();

    List<Map<String, Object>> getEmergenciesAddresses();

    List<EmergencyEntity> getEmergencyById(long id_emergency);

    long createEmergency(EmergencyEntity emergency);

    public String updateEmergency(EmergencyEntity emergency, long id_emergency);

    public String deleteEmergency(long id_emergency);


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Para obtener los nombres de las emergencias
    List<EmergencyEntity> getEmergenciesName();

    // Para obtener el listado de emergencias ordenadas por estado y nombre
    List<Map<String, Object>> getEmergencies_nameState();
}
