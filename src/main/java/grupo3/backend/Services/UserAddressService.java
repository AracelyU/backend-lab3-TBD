package grupo3.backend.Services;

import grupo3.backend.Entities.UserAddressEntity;
import grupo3.backend.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserAddressService implements UserAddressRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Map<String, Object>> getAllUserAddress() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla user_address
            return conn.createQuery("SELECT * FROM user_address")
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public void setGeom_user(){
        try(Connection conn = sql2o.open()){
            String geom_set = "UPDATE user_address SET geom = ST_SetSRID(ST_MakePoint(latitude, longitude), 4326); ";
            conn.createQuery(geom_set).executeUpdate();
        }
    }

    @Override
    public List<Map<String, Object>> getUserAddressById(long id_user_address) {
        List<Map<String, Object>> r = new ArrayList<>();
        List<Map<String, Object>> us_address = getAllUserAddress();
        for(Map<String, Object> o : us_address){
            Integer op = (Integer) o.get("id_address_u");
            if(op == id_user_address){
                r.add(o);
                return r;
            }
        }
        return r;
    }

    @Override
    public long createUserAddress(UserAddressEntity userAddressEntity) {
        // Para crear un usuario no es necesario ingresar geom, ya que se actualizará
        try(Connection conn = sql2o.open()) {
            // Verificar si el id_state existe en la tabla de estados
            String sql = "INSERT INTO user_address (address, latitude, longitude) " +
                    "VALUES (:address, :latitude, :longitude)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("address", userAddressEntity.getAddress())
                    .addParameter("latitude", userAddressEntity.getLatitude())
                    .addParameter("longitude", userAddressEntity.getLongitude());
            int idGenerado = (int) query.executeUpdate().getKey();
            setGeom_user(); // Para modificar a un geom relacionado a las coordenadas
            return idGenerado;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    @Override
    public String updateUserAddress(UserAddressEntity user_address, long id_address_u) {
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE user_address SET address= :address, " +
                    "latitude = :latitude, longitude = :longitude, geom = :geom " +
                    "WHERE id_address_u = :id_address_u";
            conn.createQuery(updateSql)
                    .addParameter("address", user_address.getAddress())
                    .addParameter("latitude", user_address.getLatitude())
                    .addParameter("longitude", user_address.getLongitude())
                    .addParameter("geom", user_address.getGeom())
                    .addParameter("id_address_u", id_address_u)
                    .executeUpdate();
            setGeom_user();
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
