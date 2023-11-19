package grupo3.backend.Services;

import grupo3.backend.Entities.EmergencyAddressEntity;
import grupo3.backend.repositories.EmergencyAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmergencyAddressService implements EmergencyAddressRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Map<String, Object>> getAllEmergencyAddress() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla emergency_address
            return conn.createQuery("SELECT * FROM emergency_address")
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Map<String, Object>> getEmergencyAddressById(long id_address_e) {
        List<Map<String, Object>> r = new ArrayList<>();
        List<Map<String, Object>> e_address = getAllEmergencyAddress();
        for(Map<String, Object> o : e_address){
            Integer op = (Integer) o.get("id_address_e");
            if(op == id_address_e){
                r.add(o);
                return r;
            }
        }
        return r;
    }

    @Override
    public void setGeom_emergency(){
        try(Connection conn = sql2o.open()){
            String geom_set = "UPDATE emergency_address SET geom = ST_SetSRID(ST_MakePoint(latitude, longitude), 4326); ";
            conn.createQuery(geom_set).executeUpdate();
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
            setGeom_emergency(); // Para modificar a un geom relacionado a las coordenadas
            return idGenerado;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    @Override
    public String updateEmergencyAddress(EmergencyAddressEntity emergency_address, long id_address_e) {
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE emergency_address SET address= :address, " +
                    "latitude = :latitude, longitude = :longitude, geom = :geom " +
                    "WHERE id_address_e = :id_address_e";
            conn.createQuery(updateSql)
                    .addParameter("address", emergency_address.getAddress())
                    .addParameter("latitude", emergency_address.getLatitude())
                    .addParameter("longitude", emergency_address.getLongitude())
                    .addParameter("geom", emergency_address.getGeom())
                    .addParameter("id_address_e", id_address_e)
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
