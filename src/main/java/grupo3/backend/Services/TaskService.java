package grupo3.backend.Services;

import grupo3.backend.Entities.*;
import grupo3.backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Service
public class TaskService implements TaskRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    StateService stateService;

    TaskRequestService taskRequestService;

    // Para obtener todas las tareas   promedio :
    @Override
    public List<TaskEntity> getAllTasks() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM task")
                    .executeAndFetch(TaskEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /*
    @Override
    public List<Map<String, Object>> getTasks_nameState() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT t.*, s.state_name " +
                            "FROM task AS t, state AS s " +
                            "WHERE t.id_state = s.id_state")
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }*/

    // Para buscar una tarea por id
    @Override
    public List<TaskEntity> getTaskById(long id_task){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM task WHERE id_task= :id_task")
                    .addParameter("id_task", id_task)
                    .executeAndFetch(TaskEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Para crear una nueva tarea
    @Override
    public long createTask(TaskEntity taskModel) {
        long id_state = taskModel.getId_state();
        System.out.println("id del estado" + id_state);
        try(Connection conn = sql2o.open()) {
            // Verificar si el id_state existe en la tabla de estados
            List<StateEntity> stateList = stateService.getStateTaskById(id_state);
            if (stateList != null && !stateList.isEmpty()) {
                // en caso que no exista el id_state asociado
                String sql = "INSERT INTO task (task_name, task_description, volunteers_required, id_state) " +
                        "VALUES (:task_name, :task_description, :volunteers_required, :id_state)";
                Query query = conn.createQuery(sql, true)
                        .addParameter("task_name", taskModel.getTask_name())
                        .addParameter("task_description", taskModel.getTask_description())
                        .addParameter("volunteers_required", taskModel.getVolunteers_required())
                        .addParameter("id_state", taskModel.getId_state());
                int idGenerado = (int) query.executeUpdate().getKey();
                System.out.println("ID GENERADO: "+  idGenerado);
                return idGenerado; // retorno el id de la tarea generada
            }
            else{
                System.out.println("Id no encontrado en la base de datos\n");
                return -1L;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    // Para actualizar la información de una tarea
    @Override
    public String updateTask(TaskEntity taskModel, long id_task) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE task SET task_name = :task_name, task_description = :task_description, " +
                    "volunteers_required = :volunteers_required, id_state = :id_state " +
                    "WHERE id_task = :id_task";
            conn.createQuery(updateSql)
                    .addParameter("task_name", taskModel.getTask_name())
                    .addParameter("task_description", taskModel.getTask_description())
                    .addParameter("volunteers_required", taskModel.getVolunteers_required())
                    .addParameter("id_state", taskModel.getId_state())
                    .addParameter("id_task", id_task)
                    .executeUpdate();
            return "actualización realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al realizar actualización";
        }
    }
    // Para borrar una emergencia (por id)
    @Override
    public String deleteTask(long id_task){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM task WHERE id_task = :id_task ")
                    .addParameter("id_task", id_task)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Para obtener tarea por nombre
    @Override
    public List<TaskEntity> getTaskByName(String task_name){
        try(Connection conn = sql2o.open()) {
            String getTaskByNamesql = "SELECT * " +
                    "FROM task " +
                    "WHERE \"task_name\" = :task_name ";
            return conn.createQuery(getTaskByNamesql)
                    .addParameter("task_name", task_name)
                    .executeAndFetch(TaskEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Para obtener el listado de emergencias ordenadas por estado y nombre (5)
    @Override
    public List<Map<String, Object>> getTasks_emergency(long id_emergency) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT ta.id_task, ta.task_name, " +
                            "ta.volunteers_required, s.state_name, e.emergency_type " +
                            "FROM task ta, state s, emergency_task et, emergency e " +
                            "WHERE ta.id_state = s.id_state AND ta.id_task = et.id_task " +
                            "AND et.id_emergency = e.id_emergency AND et.id_emergency = :id_emergency " +
                            "ORDER BY s.id_state, ta.task_name")
                    .addParameter("id_emergency", id_emergency)
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*
    @Override
    public List<Map<String, Object>> getTasks_nameState() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT ta.id_task, ta.task_name, " +
                            "ta.volunteers_required, s.state_name, e.emergency_type " +
                            "FROM task ta, state s, emergency_task et, emergency e " +
                            "WHERE ta.id_state = s.id_state AND ta.id_task = et.id_task " +
                            "AND et.id_emergency = e.id_emergency " +
                            "ORDER BY s.id_state, ta.task_name")
                    .executeAndFetchTable()
                    .asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
     */

    // - -- - - - - - - -- -- -  -- - - - -
    @Override
    public String updateTaskName(long id_task, String newTaskName) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE task SET task_name = :newTaskName WHERE id_task = :id_task";
            conn.createQuery(updateSql)
                    .addParameter("newTaskName", newTaskName)
                    .addParameter("id_task", id_task)
                    .executeUpdate();
            return "actualización del nombre de la tarea realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al realizar actualización del nombre de la tarea";
        }
    }

    @Override
    public String updateTaskDescription(long id_task, String newTaskDescription) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE task SET task_description = :newTaskDescription WHERE id_task = :id_task";
            conn.createQuery(updateSql)
                    .addParameter("newTaskDescription", newTaskDescription)
                    .addParameter("id_task", id_task)
                    .executeUpdate();
            return "Actualización de la descripción de la tarea realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al realizar la actualización de la descripción de la tarea";
        }
    }

    @Override
    public String updateVolunteersRequired(long id_task, Integer newVolunteersRequired) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE task SET volunteers_required = :newVolunteersRequired WHERE id_task = :id_task";
            conn.createQuery(updateSql)
                    .addParameter("newVolunteersRequired", newVolunteersRequired)
                    .addParameter("id_task", id_task)
                    .executeUpdate();
            return "Actualización de la cantidad de voluntarios requeridos realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al realizar la actualización de la cantidad de voluntarios requeridos";
        }
    }

    @Override
    public String updateStateTask(long id_task, String state_name) {
        StateEntity s = stateService.getStateByName(state_name);
        long id_state = s.getId_state();
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE task SET id_state = :id_state WHERE id_task = :id_task";
            conn.createQuery(updateSql)
                    .addParameter("id_state", id_state)
                    .addParameter("id_task", id_task)
                    .executeUpdate();
            return "Actualización del estado de la tarea realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al realizar la actualización del estado";
        }
    }










}
