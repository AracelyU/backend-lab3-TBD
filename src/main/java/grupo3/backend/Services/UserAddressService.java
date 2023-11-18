package grupo3.backend.Services;

import grupo3.backend.Entities.UserAddressEntity;
import grupo3.backend.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
@Service
public class UserAddressService implements UserAddressRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<UserAddressEntity> getAllUserAddress() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM user_address")
                    .executeAndFetch(UserAddressEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserAddressEntity> getUserAddressById(long id_user_address) {
        try (Connection conn = sql2o.open()) {
            // String sql = "SELECT * FROM taskStatus where idStatus=:id";
            return conn.createQuery("SELECT * FROM user_address WHERE id_address_u = :id_user_address ")
                    .addParameter("id_address_u", id_user_address)
                    .executeAndFetch(UserAddressEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public long createUserAddress(UserAddressEntity userAddressEntity) {
        try(Connection conn = sql2o.open()) {
            // Verificar si el id_state existe en la tabla de estados
            String sql = "INSERT INTO user_address (address, latitude, longitude, " +
                    "geom) " +
                    "VALUES (:address, :latitude, :longitude, :geom)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("address", userAddressEntity.getAddress())
                    .addParameter("latitude", userAddressEntity.getLatitude())
                    .addParameter("longitude", userAddressEntity.getLongitude())
                    .addParameter("geom", userAddressEntity.getGeom());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    @Override
    public String updateUserAddress(UserAddressEntity user_address, long id_user) {
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE user_address SET address= :address, " +
                    "latitude = :latitude, longitude = :longitude, geom = :geom";
            conn.createQuery(updateSql)
                    .addParameter("address", user_address.getAddress())
                    .addParameter("latitude", user_address.getLatitude())
                    .addParameter("longitude", user_address.getLongitude())
                    .addParameter("geom", user_address.getGeom())
                    .executeUpdate();
            return "actualizacion realizada con exito";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al realizar actualizacion";
        }
    }

    @Override
    public String deleteUserAddress(long id_user_address) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from user_address where id_address_u = :id_user_address ")
                    .addParameter("id_address_u",id_user_address)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }
}
