package grupo3.backend.repositoriesMongo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import grupo3.backend.EntitiesMongo.EmergencyTaskMongo;
import grupo3.backend.EntitiesMongo.TaskMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TaskMongoRepositoryImg implements TaskMongoRepository {

    @Autowired
    MongoDatabase database;

    @Override
    public List<TaskMongo> getActiveTasksForEmergency(long emergencyId) {
        MongoCollection<TaskMongo> taskCollection = database.getCollection("task", TaskMongo.class);
        MongoCollection<EmergencyTaskMongo> emergencyTaskCollection = database.getCollection("emergencyTask", EmergencyTaskMongo.class);

        List<Document> pipeline = new ArrayList<>();

        // Match stage to filter EmergencyTaskMongo by id_emergency
        Document matchEmergencyTaskStage = new Document("$match", new Document("id_emergency", emergencyId));
        pipeline.add(matchEmergencyTaskStage);

        // Lookup stage to join EmergencyTaskMongo with TaskMongo
        Document lookupStage = new Document("$lookup", new Document()
                .append("from", "task")
                .append("localField", "id_task")
                .append("foreignField", "id_task")
                .append("as", "tasks"));
        pipeline.add(lookupStage);

        // Unwind stage to destructure the array created by $lookup
        Document unwindStage = new Document("$unwind", "$tasks");
        pipeline.add(unwindStage);

        // Match stage to filter tasks with id_state: 2 (assuming 2 is the active state)
        Document matchActiveTaskStage = new Document("$match", new Document("tasks.id_state", 2));
        pipeline.add(matchActiveTaskStage);

        AggregateIterable<TaskMongo> result = emergencyTaskCollection.aggregate(pipeline, TaskMongo.class);

        return result.into(new ArrayList<>());
    }
}