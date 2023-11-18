package grupo3.backend.Services;

import grupo3.backend.Entities.RequestEntity;
import grupo3.backend.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Service
public class RequestService implements RequestRepository{
    @Autowired
    private Sql2o sql2o;

    //Get
    @Override
    public List<RequestEntity> getAllRequest() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla
            return conn.createQuery("SELECT * FROM request")
                    .executeAndFetch(RequestEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RequestEntity> getRequestById(long id_request) {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla
            return conn.createQuery("SELECT * FROM request WHERE id_request = :id_request")
                    .addParameter("id_request", id_request)
                    .executeAndFetch(RequestEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Post
    @Override
    public long createRequest(RequestEntity request) {
        try (Connection conn = sql2o.open()) {
            // inserto la información en la tabla
            Query query = conn.createQuery("INSERT INTO request (request_name, request_description) " +
                    "values (:request_name, :request_description)");
            query.addParameter("request_name", request.getRequest_name());
            query.addParameter("request_description", request.getRequest_description());
            int idGenerado = query.executeUpdate().getKey(Integer.class);
            return idGenerado; // retorno el id de la solicitud generada
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L; // Manejo de errores
        }
    }

    // Put
    @Override
    public String updateRequest(RequestEntity request, long id_request) {
        try (Connection conn = sql2o.open()) {
            // actualizo la informacion de la tabla
            Query query = conn.createQuery("UPDATE request SET id_request = :id_request, request_name = :request_name, request_description = :request_description " +
                    "WHERE id_request = :id_request");
            query.addParameter("id_request", request.getId_request());
            query.addParameter("request_name", request.getRequest_name());
            query.addParameter("request_description", request.getRequest_description());
            query.addParameter("id_request", id_request);
            query.executeUpdate();
            return "Request actualizado";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Delete
    @Override
    public String deleteRequest(long id_request) {
        try (Connection conn = sql2o.open()) {
            // elimino la informacion de la tabla
            Query query = conn.createQuery("DELETE FROM request WHERE id_request = :id_request");
            query.addParameter("id_request", id_request);
            query.executeUpdate();
            return "Request eliminado";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    // - -- - - - - - -- - - - - - - - - -  - -- - - - - - -  - - -- -  - - - -- - //
    @Override
    public List<Map<String, Object>> get_request_names(){
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT id_request, request_name " +
                            "FROM request " +
                            "ORDER BY id_request")
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
