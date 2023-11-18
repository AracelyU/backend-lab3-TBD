package grupo3.backend.Services;


import grupo3.backend.Entities.InstitutionEntity;
import grupo3.backend.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class InstitutionService implements InstitutionRepository {
    @Autowired
    private Sql2o sql2o;

    // Para obtener todas las instituciones
    @Override
    public List<InstitutionEntity> getAllInstitutions() {
        try(Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla taskStatus
            return conn.createQuery("SELECT * FROM institution")
                    .executeAndFetch(InstitutionEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Para buscar una institución por id
    @Override
    public List<InstitutionEntity> getInstitutionById(long id_institution){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM institution WHERE id_institution= :id_institution")
                    .addParameter("id_institution", id_institution)
                    .executeAndFetch(InstitutionEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Para crear una nueva institución
    @Override
    public long createInstitution(InstitutionEntity institutionEntity) {
        try(Connection conn = sql2o.open()) {
            // en caso que no exista el id_state asociado
            String sql = "INSERT INTO institution (institution_name, institution_description) " +
                    "VALUES (:institution_name, :institution_description)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("institution_name", institutionEntity.getInstitution_name())
                    .addParameter("institution_description", institutionEntity.getInstitution_description());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado; // retorno el id de la tarea generada
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    // Para actualizar la información de una institucion
    @Override
    public String updateInstitution(InstitutionEntity institutionEntity, long id_institution) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE institution SET institution_name = :institution_name, " +
                    "institution_description = :institution_description " +
                    "WHERE id_institution = :id_institution";
            conn.createQuery(updateSql)
                    .addParameter("institution_name", institutionEntity.getInstitution_name())
                    .addParameter("institution_description", institutionEntity.getInstitution_description())
                    .addParameter("id_institution", id_institution)
                    .executeUpdate();
            return "actualización realizada con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al realizar actualización";
        }
    }
    // Para borrar una institucion (por id)
    @Override
    public String deleteInstitution(long id_institution){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM institution WHERE id_institution = :id_institution ")
                    .addParameter("id_institution", id_institution)
                    .executeUpdate();
            return "eliminacion por id realizada con exito";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "fallo al eliminar por id (el id proporcionado no existe)";
        }
    }

}
