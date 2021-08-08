package hu.ulyssys.java.course.maven.vehicle.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Ship.FIND_ALL, query = "select c from Ship c order by c.id"),
        @NamedQuery(name = Ship.FIND_ALL_BY_OWNER_ID, query = "select c from Ship c where c.owner.id=:owner_id order by c.id"),
        @NamedQuery(name = Ship.FIND_BY_ID, query = "select c from Ship c where c.id=:id"),
})
@Entity
@Table
public class Ship extends AbstractVehicle {

    public static final String FIND_ALL = "Ship.findAll";
    public static final String FIND_ALL_BY_OWNER_ID = "Ship.findAllByOwnerId";
    public static final String FIND_BY_ID = "Ship.findById";

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.SHIP;
    }


}
