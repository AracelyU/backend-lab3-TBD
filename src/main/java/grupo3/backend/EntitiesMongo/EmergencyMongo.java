package grupo3.backend.EntitiesMongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "emergency")
public class EmergencyMongo {

    @BsonId
    ObjectId _id;

    private long id_emergency;

    private String emergency_name;

    private Integer emergency_type;

    private String statement_date;

    private long id_state;


    public long getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(long id_emergency) {
        this.id_emergency = id_emergency;
    }

    public String getEmergency_name() {
        return emergency_name;
    }

    public void setEmergency_name(String emergency_name) {
        this.emergency_name = emergency_name;
    }

    public Integer getEmergency_type() {
        return emergency_type;
    }

    public void setEmergency_type(Integer emergency_type) {
        this.emergency_type = emergency_type;
    }

    public String getStatement_date() {
        return statement_date;
    }

    public void setStatement_date(String statement_date) {
        this.statement_date = statement_date;
    }

    public long getId_state() {
        return id_state;
    }

    public void setId_state(long id_state) {
        this.id_state = id_state;
    }

}
