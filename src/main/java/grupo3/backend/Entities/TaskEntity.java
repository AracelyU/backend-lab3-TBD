package grupo3.backend.Entities;

import jakarta.persistence.*;

public class TaskEntity {
    /*
    CREATE TABLE IF NOT EXISTS public.task(
    id_task SERIAL PRIMARY KEY,
    task_name TEXT COLLATE pg_catalog."default",
    task_description TEXT COLLATE pg_catalog."default",
    volunteers_required INTEGER,
    id_state INTEGER);
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    @SequenceGenerator(name = "task_id_sequence", sequenceName = "task_id_sequence", allocationSize = 1)
    @Column(name = "id_task")
    private long id_task;
    private String task_name;
    private String task_description;
    private Integer volunteers_required;
    private long id_state;

    public long getId_task() {
        return id_task;
    }

    public void setId_task(long id_task) {
        this.id_task = id_task;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public Integer getVolunteers_required() {
        return volunteers_required;
    }

    public void setVolunteers_required(Integer volunteers_required) {
        this.volunteers_required = volunteers_required;
    }

    public long getId_state() {
        return id_state;
    }

    public void setId_state(long id_state) {
        this.id_state = id_state;
    }
}
