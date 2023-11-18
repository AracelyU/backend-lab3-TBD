package grupo3.backend.Entities;

public class EmergencyTaskEntity {
    private long id_emergency_task;
    private long id_emergency;
    private long id_task;

    public long getId_emergency_task() {
        return id_emergency_task;
    }

    public void setId_emergency_task(long id_emergency_task) {
        this.id_emergency_task = id_emergency_task;
    }

    public long getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(long id_emergency) {
        this.id_emergency = id_emergency;
    }

    public long getId_task() {
        return id_task;
    }

    public void setId_task(long id_task) {
        this.id_task = id_task;
    }
}
