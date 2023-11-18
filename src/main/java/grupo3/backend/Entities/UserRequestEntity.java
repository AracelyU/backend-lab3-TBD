package grupo3.backend.Entities;

public class UserRequestEntity {
    // Attributos
    private long id_user_request;
    private long id_user;
    private long id_request;

    // Getters y Setters
    public long getId_user_request() {return id_user_request;}
    public void setId_user_request(long id_user_request) {this.id_user_request = id_user_request;}

    public long getId_user() {return id_user;}
    public void setId_user(long id_user) {this.id_user = id_user;}

    public long getId_request() {return id_request;}
    public void setId_request(long id_request) {this.id_request = id_request;}
}
