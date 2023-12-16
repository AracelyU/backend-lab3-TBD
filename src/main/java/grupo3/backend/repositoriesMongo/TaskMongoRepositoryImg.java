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


    /*
    La función getActiveTasksForEmergency del repositorio TaskMongoRepositoryImg en el código que proporcionaste se utiliza para obtener una lista de tareas activas asociadas a una emergencia específica en una base de datos MongoDB. He aquí un desglose de lo que hace:

1. Dependencias:

Importa las clases necesarias para conectarse a la base de datos MongoDB, trabajar con documentos y colecciones, y mapear entidades a clases POJO.
Inyecta la base de datos MongoDB database usando @Autowired.
2. Método getActiveTasksForEmergency:

Toma la emergencyId como parámetro.
Obtiene las colecciones task y emergencyTask de la base de datos.
Crea una lista de documentos pipeline para definir la agregación:
Etapa de match: Filtra los documentos de emergencyTask por id_emergency igual al emergencyId proporcionado.
Etapa de lookup: Realiza una unión entre las colecciones emergencyTask y task en base a los campos id_task (campo común). El resultado es un array de documentos de la colección task dentro de cada documento de emergencyTask.
Etapa de unwind: Desestructura el array de documentos de task creado por la etapa anterior, generando un documento por cada tarea dentro de cada documento de emergencyTask.
Etapa de match: Filtra los documentos de task restantes por id_state igual a 2 (suponiendo que 2 representa el estado "activo").
Ejecuta la agregación en la colección emergencyTask utilizando la lista pipeline y asigna el resultado a una variable result.
Convierte el resultado de la agregación a una lista de objetos TaskMongo y la devuelve.
En resumen, esta función realiza una consulta compleja en MongoDB para recuperar una lista de tareas activas para una emergencia específica, utilizando etapas de agregación para filtrar, unir y procesar los datos de las colecciones involucradas.
     */


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