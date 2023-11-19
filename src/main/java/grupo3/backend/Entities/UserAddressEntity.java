package grupo3.backend.Entities;

import lombok.Builder;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

@Builder
public class UserAddressEntity {
    private long id_address_u;
    private String address;
    private float latitude;
    private float longitude;
    private Geometry geom;

    public long getId_address_u() {
        return id_address_u;
    }

    public void setId_address_u(long id_address_u) {
        this.id_address_u = id_address_u;
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

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Point geom) {
        this.geom = geom;
    }
}
