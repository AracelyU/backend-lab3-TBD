package grupo3.backend.repositoriesMongo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import grupo3.backend.EntitiesMongo.EmergencyMongo;
import grupo3.backend.EntitiesMongo.EmergencyTaskMongo;
import grupo3.backend.EntitiesMongo.TaskMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskMongoRepositoryImg implements TaskMongoRepository {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<TaskMongo> getActiveTasksForEmergency(long idEmergency) {

        // Verificar que el id_emergency tenga un id_state igual a 2 en EmergencyMongo
        EmergencyMongo emergency = mongoTemplate.findOne(
                Query.query(Criteria.where("id_emergency").is(idEmergency).and("id_state").is(2)),
                EmergencyMongo.class
        );

        // Si no se encuentra una EmergencyMongo válida, retornar una lista vacía
        if (emergency == null) {
            return null;
        }

        // Continuar con la búsqueda de tareas

        // Definir la operación de lookup
        LookupOperation lookup = LookupOperation.newLookup()
                .from("task")
                .localField("id_task")
                .foreignField("id_task")
                .as("tasks");

        // Agregar la etapa de match para filtrar por id_emergency
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("id_emergency").is(idEmergency)),
                lookup
        );

        // Ejecutar la agregación y obtener el resultado
        List<EmergencyTaskMongo> emergencyTasks = mongoTemplate.aggregate(aggregation, "emergency_task", EmergencyTaskMongo.class).getMappedResults();

        // Obtener la lista de id_task asociados al emergencyID
        List<Long> taskIds = emergencyTasks.stream()
                .map(EmergencyTaskMongo::getId_task)
                .collect(Collectors.toList());

        // Filtrar las tareas de TaskMongo por los id_task obtenidos y por id_state en TaskMongo
        List<TaskMongo> result = mongoTemplate.find(
                Query.query(Criteria.where("id_task").in(taskIds).and("id_state").is(2)),
                TaskMongo.class
        );

        return result;
    }
}


