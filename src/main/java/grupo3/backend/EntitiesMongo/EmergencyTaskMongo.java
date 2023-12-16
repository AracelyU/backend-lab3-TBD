package grupo3.backend.EntitiesMongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class EmergencyTaskMongo {

    @BsonId
    ObjectId _id;
    private long id_emergency_task;
    private long id_emergency;
    private long id_task;
}
