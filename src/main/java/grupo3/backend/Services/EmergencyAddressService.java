package grupo3.backend.Services;

import grupo3.backend.Entities.EmergencyAddressEntity;
import grupo3.backend.repositories.EmergencyAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class EmergencyAddressService implements EmergencyAddressRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<EmergencyAddressEntity> getAllEmergencyAddress() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM emergency_address")
                    .executeAndFetch(EmergencyAddressEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergencyAddressEntity> getEmergencyAddressById(long id_address_e) {
        try (Connection conn = sql2o.open()) {
            // String sql = "SELECT * FROM taskStatus where idStatus=:id";
            return conn.createQuery("SELECT * FROM emergency_address WHERE id_address_e = :id_address_e ")
                    .addParameter("id_address_e", id_address_e)
                    .executeAndFetch(EmergencyAddressEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public long createEmergencyAddress(EmergencyAddressEntity emergencyAddressEntity) {
        try(Connection conn = sql2o.open()) {
            // Verificar si el id_state existe en la tabla de estados
            String sql = "INSERT INTO emergency_address (address, latitude, longitude, " +
                    "geom) " +
                    "VALUES (:address, :latitude, :longitude, :geom)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("address", emergencyAddressEntity.getAddress())
                    .addParameter("latitude", emergencyAddressEntity.getLatitude())
                    .addParameter("longitude", emergencyAddressEntity.getLongitude())
                    .addParameter("geom", emergencyAddressEntity.getGeom());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    @Override
    public String updateEmergencyAddress(EmergencyAddressEntity emergency_address, long id_emergency_address) {
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE emergency_address SET address= :address, " +
                    "latitude = :latitude, longitude = :longitude, geom = :geom";
            conn.createQuery(updateSql)
                    .addParameter("address", emergency_address.getAddress())
                    .addParameter("latitude", emergency_address.getLatitude())
                    .addParameter("longitude", emergency_address.getLongitude())
                    .addParameter("geom", emergency_address.getGeom())
                    .executeUpdate();
            return "actualizacion realizada con exito";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al realizar actualizacion";
        }
    }

    @Override
    public String deleteEmergencyAddress(long id_address_e) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from emergency_address where id_address_e = :id_address_e ")
                    .addParameter("id_address_e",id_address_e)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }
}
