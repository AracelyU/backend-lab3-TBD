package grupo3.backend.Entities;

import lombok.Builder;
import org.locationtech.jts.geom.Point;

@Builder
public class UserAddressEntity {
    private long id_user_a;
    private String address;
    private float latitude;
    private float longitude;
    private Point geom;

    public long getId_user_a() {
        return id_user_a;
    }

    public void setId_user_a(long id_user_a) {
        this.id_user_a = id_user_a;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
