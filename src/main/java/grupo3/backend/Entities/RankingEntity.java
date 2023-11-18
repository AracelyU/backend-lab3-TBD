package grupo3.backend.Entities;

public class RankingEntity {
    private long id_ranking;
    private Integer ranking_position;
    private long id_user;
    private long id_task;

    public long getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public Integer getRanking_position() {
        return ranking_position;
    }

    public void setRanking_position(Integer ranking_position) {
        this.ranking_position = ranking_position;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_task() {
        return id_task;
    }

    public void setId_task(long id_task) {
        this.id_task = id_task;
    }
}
