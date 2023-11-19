package grupo3.backend.repositories;

import grupo3.backend.Entities.EmergencyAddressEntity;

import java.util.List;
import java.util.Map;

public interface EmergencyAddressRepository {
    List<Map<String, Object>> getAllEmergencyAddress();

    List<Map<String, Object>> getEmergencyAddressById(long id_emergency_address);

    long createEmergencyAddress(EmergencyAddressEntity emergencyAddressEntity);

    void setGeom_emergency();

    public String updateEmergencyAddress(EmergencyAddressEntity emergency, long id_emergency);

    public String deleteEmergencyAddress(long id_emergency);
}
