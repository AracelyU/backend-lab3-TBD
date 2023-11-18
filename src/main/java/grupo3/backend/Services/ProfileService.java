package grupo3.backend.Services;


import grupo3.backend.Entities.AbilityEntity;
import grupo3.backend.Entities.ProfileEntity;
import grupo3.backend.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class ProfileService implements ProfileRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer save(ProfileEntity profile) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.profile (rut, photo, first_name, second_name, first_lastname, second_lastname, description, gender, birthday) " +
                    "VALUES (:rut, :photo, :first_name, :second_name, :first_lastname, :second_lastname, :description, :gender, :birthday)";
            return (Integer) conn.createQuery(sql, true)
                    .addParameter("rut", profile.getRut())
                    .addParameter("photo", profile.getPhoto())
                    .addParameter("first_name", profile.getFirst_name())
                    .addParameter("second_name", profile.getSecond_name())
                    .addParameter("first_lastname", profile.getFirst_lastname())
                    .addParameter("second_lastname", profile.getSecond_lastname())
                    .addParameter("description", profile.getDescription())
                    .addParameter("gender", profile.getGender())
                    .addParameter("birthday", profile.getBirthday())
                    .executeUpdate()
                    .getKey();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<ProfileEntity> getAllProfile() {
        try (Connection conn = sql2o.open()) {
            // selecciono toda la informacion de la tabla
            return conn.createQuery("SELECT * FROM profile")
                    .executeAndFetch(ProfileEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProfileEntity> getProfileById(long id_profile) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM profile WHERE id_profile = :id_profile")
                    .addParameter("id_profile", id_profile)
                    .executeAndFetch(ProfileEntity.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int createProfile(ProfileEntity profile) {
        return 0;
    }

    @Override
    public long create_Profile(ProfileEntity profile) {
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO profile (photo, rut, first_name, second_name, " +
                    "first_lastname, second_lastname, description, gender, birthday) " +
                    "VALUES (:photo, :rut, :first_name, :second_name, :first_lastname, " +
                    ":second_lastname, :description, :gender, :birthday)";
            Query query = conn.createQuery(sql, true)
                    .addParameter("photo", profile.getPhoto())
                    .addParameter("rut", profile.getRut())
                    .addParameter("first_name", profile.getFirst_name())
                    .addParameter("second_name", profile.getSecond_name())
                    .addParameter("first_lastname", profile.getFirst_lastname())
                    .addParameter("second_lastname", profile.getSecond_lastname())
                    .addParameter("description", profile.getDescription())
                    .addParameter("gender", profile.getGender())
                    .addParameter("birthday", profile.getBirthday());
            int idGenerado = (int) query.executeUpdate().getKey();
            return idGenerado; // retorno el id del perfil generado
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }

    @Override
    public String updateProfile(ProfileEntity profile, Long id_profile) {
        try(Connection conn = sql2o.open()){

            String sql = "UPDATE profile SET photo = :photo, rut = :rut, first_name = :first_name, " +
                    "second_name = :second_name, first_lastname = :first_lastname, " +
                    "second_lastname = :second_lastname, description = :description," +
                    "gender =: gender, birthday = :birthday " +
                    "WHERE id_profile = :id_profile";
            conn.createQuery(sql)
                    .addParameter("photo", profile.getPhoto())
                    .addParameter("rut", profile.getRut())
                    .addParameter("first_name", profile.getFirst_name())
                    .addParameter("second_name", profile.getSecond_name())
                    .addParameter("first_lastname", profile.getFirst_lastname())
                    .addParameter("second_lastname", profile.getSecond_lastname())
                    .addParameter("description", profile.getDescription())
                    .addParameter("gender", profile.getGender())
                    .addParameter("birthday", profile.getBirthday())
                    .addParameter("id_profile", id_profile)
                    .executeUpdate();
            return "Perfil actualizado";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteProfile(long id_profile) {
        try(Connection conn = sql2o.open()){
            String deleteSql = "DELETE FROM profile WHERE id_profile = :id_profile";
            conn.createQuery(deleteSql)
                    .addParameter("id_profile", id_profile)
                    .executeUpdate();
            return "Perfil eliminado";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
