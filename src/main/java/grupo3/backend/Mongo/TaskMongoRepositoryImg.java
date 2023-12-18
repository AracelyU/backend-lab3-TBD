package grupo3.backend.Mongo;

import grupo3.backend.EntitiesMongo.EmergencyMongo;
import grupo3.backend.EntitiesMongo.EmergencyTaskMongo;
import grupo3.backend.EntitiesMongo.TaskMongo;
import grupo3.backend.Mongo.TaskMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskMongoRepositoryImg implements TaskMongoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<TaskMongo> getActiveTasksForEmergency(long idEmergency) {

        // verificar que id_emergency tenga un id_state igual a 2 en EmergencyMongo
        EmergencyMongo emergency = mongoTemplate.findOne(
                Query.query(Criteria.where("id_emergency").is(idEmergency).and("id_state").is(2)),
                EmergencyMongo.class
        );

        // Si no se encuentra esa emergencia en proceso
        if (emergency == null) {
            return null;
        }

        // definir la operación de lookup
        LookupOperation lookup = LookupOperation.newLookup()
                .from("task")
                .localField("id_task")
                .foreignField("id_task")
                .as("tasks");

        // agregar la etapa de match para filtrar por id_emergency
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("id_emergency").is(idEmergency)),
                lookup
        );

        // ejecutar la agregación y obtener el resultado
        List<EmergencyTaskMongo> emergencyTasks = mongoTemplate.aggregate(aggregation, "emergency_task", EmergencyTaskMongo.class).getMappedResults();

        // obtener la lista de id_task asociados al id ingresado
        List<Long> taskIds = emergencyTasks.stream()
                .map(EmergencyTaskMongo::getId_task)
                .collect(Collectors.toList());

        // filtrar las tareas de TaskMongo por los id_task obtenidos y por id_state 2 (tareas activas)
        List<TaskMongo> result = mongoTemplate.find(
                Query.query(Criteria.where("id_task").in(taskIds).and("id_state").is(2)),
                TaskMongo.class
        );
        return result;
    }
}


