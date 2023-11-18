package grupo3.backend.Entities;

import org.locationtech.jts.geom.Point;
import java.util.Date;

public class EmergencyEntity {

    /*CREATE TABLE IF NOT EXISTS public.emergency(
    id_emergency SERIAL PRIMARY KEY,
    emergency_name TEXT COLLATE pg_catalog."default",
    emergency_location TEXT COLLATE pg_catalog."default",
    statement_date DATE,   <- lo coloque como LocalDate
    id_state INTEGER);

     */

    private long id_emergency;

    private String emergency_name;

    private Integer emergency_type;

    private Date statement_date;

    private long id_state;
    private long id_address_e;

    public void setId_emergency(long id_emergency){
        this.id_emergency = id_emergency;
    }

    public long getId_emergency(){
        return id_emergency;
    }

    public void setEmergency_name(String emergency_name){
        this.emergency_name = emergency_name;
    }

    public String getEmergency_name(){
        return emergency_name;
    }

    public Integer getEmergency_type() {
        return emergency_type;
    }

    public void setEmergency_type(Integer emergency_type) {
        this.emergency_type = emergency_type;
    }

    public void setStatement_date(Date d){
        this.statement_date = d;
    }

    public Date getStatement_date(){
        return statement_date;
    }

    public void setId_state(long id_state){
        this.id_state = id_state;
    }

    public long getId_state(){
        return id_state;
    }

    public long getId_emergency_address() {
        return id_address_e;
    }

    public void setId_emergency_address(long id_emergency_address) {
        this.id_address_e = id_emergency_address;
    }
}
