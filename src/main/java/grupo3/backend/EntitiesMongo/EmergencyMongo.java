package grupo3.backend.EntitiesMongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;

public class EmergencyMongo {

    @BsonId
    ObjectId _id;

    private long id_emergency;

    private String emergency_name;

    private Integer emergency_type;

    private Date statement_date;

    private long id_state;

}
