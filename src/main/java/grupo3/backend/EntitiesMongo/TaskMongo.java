package grupo3.backend.EntitiesMongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class TaskMongo {

    @BsonId
    private ObjectId _id;

    private long id_task;
    private String task_name;
    private String task_description;
    private Integer volunteers_required;
    private long id_state;

    // Constructores, getters y setters

    public TaskMongo() {
        // Constructor sin argumentos
    }

    public long getId_task() {
        return id_task;
    }

    public void setId_task(long id_task) {
        this.id_task = id_task;
    }

    //---------------------

    public void setTask_name(String name) {
        this.task_name = name;
    }

    public String getTask_name() {
        return task_name;
    }

    //_-------------------------

    public void setTask_description(String name) {
        this.task_description = name;
    }

    public String getTask_description() {
        return task_description;
    }

    //_--------------------------

    public long getVolunteers_required() {
        return volunteers_required;
    }

    public void setVolunteers_required(int volunteers_required) {
        this.volunteers_required = volunteers_required;
    }

    //-------------------
    public long getId_state() {
        return id_state;
    }

    public void setId_state(long id_state) {
        this.id_state = id_state;
    }


}
