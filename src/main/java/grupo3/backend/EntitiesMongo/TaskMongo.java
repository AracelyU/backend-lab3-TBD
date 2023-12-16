package grupo3.backend.EntitiesMongo;

import jakarta.persistence.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class TaskMongo {

    @BsonId
    ObjectId _id;

    private long id_task;
    private String task_name;
    private String task_description;
    private Integer volunteers_required;
    private long id_state;


}
