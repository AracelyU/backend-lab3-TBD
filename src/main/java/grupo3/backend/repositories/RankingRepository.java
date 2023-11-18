package grupo3.backend.repositories;

import grupo3.backend.Entities.RankingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RankingRepository {
    // para obtener todos los ranking
    List<RankingEntity> getAllRankings();

    // Para buscar una combinación emergencia-tarea por id
    List<RankingEntity> getRankingById(long id_ranking);

    // Para crear un nuevo ranking
    long createRanking(RankingEntity rankingEntity);

    // Para actualizar la información de un ranking
    String updateRanking(RankingEntity rankingEntity, long id_ranking);

    // Para borrar un ranking (por id)
    String deleteRanking(long id_ranking);

    Map<String, Object> getTaskInformation(long id_task);

    List<Map<String, Object>> getInformationByTasks();
}
