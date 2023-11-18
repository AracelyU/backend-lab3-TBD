package grupo3.backend.Entities;

import org.locationtech.jts.geom.Point;

public class EmergencyAddressEntity {
    private long id_address_e;
    private String address;
    private float latitude;
    private float longitude;
    private Point geom;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId_emergency_address() {
        return id_address_e;
    }

    public void setId_emergency_address(long id_emergency_address) {
        this.id_address_e = id_emergency_address;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Point getGeom() {
        return geom;
    }

    public void setGeom(Point geom) {
        this.geom = geom;
    }
}
