package grupo3.backend.repositories;


import grupo3.backend.Entities.UserAddressEntity;

import java.util.List;
import java.util.Map;

public interface UserAddressRepository {
    List<Map<String, Object>> getAllUserAddress();

    List<Map<String, Object>> getUserAddressById(long id_user_address);

    void setGeom_user();

    long createUserAddress(UserAddressEntity userAddressEntity);

    public String updateUserAddress(UserAddressEntity user, long id_user);

    public String deleteUserAddress(long id_user);
}
