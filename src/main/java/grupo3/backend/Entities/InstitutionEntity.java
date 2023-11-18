package grupo3.backend.Entities;

public class InstitutionEntity {

    private Long id_institution;
    private String institution_name;
    private String institution_description;


    public void setId_institution(Long id){
        this.id_institution = id;
    }
    public Long getId_institution() {
        return id_institution;
    }
    public void setInstitution_name(String name){
        this.institution_name = name;
    }
    public String getInstitution_name(){
        return institution_name;
    }
    public void setInstitution_description(String description){
        this.institution_description = description;
    }
    public String getInstitution_description(){
        return institution_description;
    }




}
