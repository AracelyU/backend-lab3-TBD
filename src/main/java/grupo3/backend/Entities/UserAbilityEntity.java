package grupo3.backend.Entities;


public class UserAbilityEntity {
    long id_user_ability;
    long id_user;
    long id_ability;

    public long getId_user_ability() {
        return id_user_ability;
    }

    public void setId_user_ability(long id_user_ability) {
        this.id_user_ability = id_user_ability;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_ability() {
        return id_ability;
    }

    public void setId_ability(long id_ability) {
        this.id_ability = id_ability;
    }
}
