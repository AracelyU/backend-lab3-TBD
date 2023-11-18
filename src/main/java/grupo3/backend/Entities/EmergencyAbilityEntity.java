package grupo3.backend.Entities;

public class EmergencyAbilityEntity {
    // Atributos
    private long id_emergency_ability;
    private long id_emergency;
    private long id_ability;

    // Getters y Setters
    public long getId_emergency_ability() {return id_emergency_ability;}
    public void setId_emergency_ability(long id_emergency_ability) {this.id_emergency_ability = id_emergency_ability;}

    public long getId_emergency() {return id_emergency;}
    public void setId_emergency(long id_emergency) {this.id_emergency = id_emergency;}

    public long getId_ability() {return id_ability;}
    public void setId_ability(long id_ability) {this.id_ability = id_ability;}
}
