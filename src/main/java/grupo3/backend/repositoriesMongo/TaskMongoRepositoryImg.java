package grupo3.backend.repositoriesMongo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
        MongoCollection<TaskMongo> collection = database.getCollection("task", TaskMongo.class);

        List<Document> pipeline = new ArrayList<>();
        pipeline.add(new Document("$match", new Document("id_state", 2))); // Assuming 2 is the active state

        AggregateIterable<TaskMongo> result = collection.aggregate(pipeline, TaskMongo.class);

        return result.into(new ArrayList<>());
    }





}
