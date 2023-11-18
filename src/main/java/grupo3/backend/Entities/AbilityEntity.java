package grupo3.backend.Entities;

public class AbilityEntity {
    //Atributos
    private long id_ability;
    private String ability_name;
    private String ability_description;

    // Getters y Setters
    public long getId_ability() {return id_ability;}
    public void setId_ability(long id_ability) {this.id_ability = id_ability;}

    public String getAbility_name() {return ability_name;}
    public void setAbility_name(String ability_name) {this.ability_name = ability_name;}

    public String getAbility_description() {return ability_description;}
    public void setAbility_description(String ability_description) {this.ability_description = ability_description;}
}
