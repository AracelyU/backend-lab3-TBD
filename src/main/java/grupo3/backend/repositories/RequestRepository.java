package grupo3.backend.repositories;

import grupo3.backend.Entities.RequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RequestRepository {

    // GET
    List<RequestEntity> getAllRequest();
    List<RequestEntity> getRequestById(long id_request);

    // POST
    public long createRequest(RequestEntity request);

    // PUT
    public String updateRequest(RequestEntity request, long id_request);

    // DELETE
    public String deleteRequest(long id_request);

    List<Map<String, Object>> get_request_names();
}
