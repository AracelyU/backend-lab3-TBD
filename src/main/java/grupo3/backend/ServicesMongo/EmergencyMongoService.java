package grupo3.backend.ServicesMongo;

import com.mongodb.client.MongoDatabase;
import grupo3.backend.repositoriesMongo.EmergencyMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmergencyMongoService implements EmergencyMongoRepository {

    @Autowired
    MongoDatabase database;







}
