package grupo3.backend.Entities;

public class RequestEntity {
    //Atributos
    long id_request;
    String request_name;
    String request_description;

    // Getters y Setters
    public long getId_request() {return id_request;}
    public void setId_request(long id_request) {this.id_request = id_request;}

    public String getRequest_name() {return request_name;}
    public void setRequest_name(String request_name) {this.request_name = request_name;}

    public String getRequest_description() {return request_description;}
    public void setRequest_description(String request_description) {this.request_description = request_description;}
}
