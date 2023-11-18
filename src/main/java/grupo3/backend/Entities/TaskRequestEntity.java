package grupo3.backend.Entities;

public class TaskRequestEntity {
    /*
    CREATE TABLE IF NOT EXISTS public.task_request(
        id_task_request SERIAL PRIMARY KEY,
        id_task INTEGER,
        id_request INTEGER);
     */

    // Attributes
    private long id_task_request;
    private long id_task;
    private long id_request;

    // Getters & Setters
    public long getId_task_request() {return id_task_request;}
    public void setId_task_request(long id_task_request) {this.id_task_request = id_task_request;}

    public long getId_task() {return id_task;}
    public void setId_task(long id_task) {this.id_task = id_task;}

    public long getId_request() {return id_request;}
    public void setId_request(long id_request) {this.id_request = id_request;}
}
