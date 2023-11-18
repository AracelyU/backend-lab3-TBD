package grupo3.backend.repositories;


import grupo3.backend.Entities.UserAddressEntity;

import java.util.List;

public interface UserAddressRepository {
    List<UserAddressEntity> getAllUserAddress();

    List<UserAddressEntity> getUserAddressById(long id_user_address);

    long createUserAddress(UserAddressEntity userAddressEntity);

    public String updateUserAddress(UserAddressEntity user, long id_user);

    public String deleteUserAddress(long id_user);
}
