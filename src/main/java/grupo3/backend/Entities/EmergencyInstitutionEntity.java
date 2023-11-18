package grupo3.backend.Entities;

public class EmergencyInstitutionEntity {
    private long id_emergency_institution;
    private long id_emergency;
    private long id_institution;

    public long getId_emergency_institution() {
        return id_emergency_institution;
    }

    public void setId_emergency_institution(long id_emergency_institution) {
        this.id_emergency_institution = id_emergency_institution;
    }

    public long getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(long id_emergency) {
        this.id_emergency = id_emergency;
    }

    public long getId_institution() {
        return id_institution;
    }

    public void setId_institution(long id_institution) {
        this.id_institution = id_institution;
    }
}
