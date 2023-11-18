package grupo3.backend.Entities;

import lombok.Builder;

import java.util.Date;

@Builder
public class ProfileEntity {

    /*
    CREATE TABLE IF NOT EXISTS public.profile(
    id_profile SERIAL PRIMARY KEY,
    photo varchar(200),
    first_name TEXT COLLATE pg_catalog."default",
    second_name TEXT COLLATE pg_catalog."default",
    first_lastname TEXT COLLATE pg_catalog."default",
    second_lastname TEXT COLLATE pg_catalog."default",
    description TEXT COLLATE pg_catalog."default",
    gender TEXT COLLATE pg_catalog."default",
    birthday DATE);
     */

    private Long id_profile;

    private String rut;

    private String photo;

    private String first_name;

    private String second_name;

    private String first_lastname;

    private String second_lastname;

    private String description;

    private String gender;

    private Date birthday;


    public void setId_profile(Long id){
        this.id_profile = id;
    }

    public Long getId_profile(){
        return id_profile;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }

    public String getPhoto(){
        return photo;
    }

    public void setFirst_name(String fname){
        this.first_name = fname;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setSecond_name(String sname){
        this.second_name = sname;
    }

    public String getSecond_name(){
        return second_name;
    }

    public void setFirst_lastname(String flname){
        this.first_lastname = flname;
    }

    public String getFirst_lastname(){
        return first_lastname;
    }

    public void setSecond_lastname(String slname){
        this.second_lastname = slname;
    }

    public String getSecond_lastname(){
        return second_lastname;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setBirthday(Date date_birthday){
        this.birthday = date_birthday;
    }

    public Date getBirthday(){
        return birthday;
    }


}
