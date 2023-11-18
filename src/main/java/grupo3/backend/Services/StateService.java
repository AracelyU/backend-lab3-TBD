package grupo3.backend.Services;

import grupo3.backend.Entities.StateEntity;
import grupo3.backend.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class StateService implements StateRepository {
    @Autowired
    private Sql2o sql2o;

    // Para obtener todos los estados de las tareas
    @Override
    public List<StateEntity> getAllStateTask() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM state")
                    .executeAndFetch(StateEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<StateEntity> getStateTaskById(long id_state){
        try(Connection conn = sql2o.open()) {
            System.out.print("id recibido: "+ id_state);
            // String sql = "SELECT * FROM taskStatus where idStatus=:id";
            return conn.createQuery("SELECT * FROM state WHERE id_state = :id_state ")
                    .addParameter("id_state", id_state )
                    .executeAndFetch(StateEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public long createTaskState(StateEntity taskStatus) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO state (state_name, state_description)" +
                    "VALUES (:state_name, :state_description)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("state_name", taskStatus.getState_name())
                    .addParameter("state_description", taskStatus.getState_description());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado; // retorno el id del estado tarea generado
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public String updateTaskStatus(StateEntity taskStatus, long id_state){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE state SET state_name= :state_name, " +
                    "state_description = :state_description " +
                    "WHERE id_state = :id_state";
            conn.createQuery(updateSql)
                    .addParameter("state_name", taskStatus.getState_name())
                    .addParameter("state_description", taskStatus.getState_description())
                    .addParameter("id_state", id_state)
                    .executeUpdate();
            return "actualizacion realizada con exito";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "fallo al realizar actualizacion";
        }
    }

    @Override
    public String deleteTaskStatus(long id_state){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from state where id_state = :id_state ")
                    .addParameter("id_state",id_state)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }

    // - - - - - - - - - -  - - - - - - -
    @Override
    public StateEntity getStateByName(String stateName) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM state WHERE state_name = :stateName";
            return conn.createQuery(sql)
                    .addParameter("stateName", stateName)
                    .executeAndFetchFirst(StateEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
