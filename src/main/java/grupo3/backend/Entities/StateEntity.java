package grupo3.backend.Entities;

public class StateEntity {
    private long id_state;
    private String state_name;
    private String state_description;

    public long getId_state() {
        return id_state ;
    }

    public void setId_state(long id_state) {
        this.id_state  = id_state ;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_description() {
        return state_description;
    }

    public void setState_description(String state_description) {
        this.state_description = state_description;
    }
}
