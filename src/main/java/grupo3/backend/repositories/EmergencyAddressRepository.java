package grupo3.backend.repositories;

import grupo3.backend.Entities.EmergencyAddressEntity;

import java.util.List;

public interface EmergencyAddressRepository {
    List<EmergencyAddressEntity> getAllEmergencyAddress();

    List<EmergencyAddressEntity> getEmergencyAddressById(long id_emergency_address);

    long createEmergencyAddress(EmergencyAddressEntity emergencyAddressEntity);

    public String updateEmergencyAddress(EmergencyAddressEntity emergency, long id_emergency);

    public String deleteEmergencyAddress(long id_emergency);
}
