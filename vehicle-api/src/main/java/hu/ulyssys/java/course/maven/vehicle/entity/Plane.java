package hu.ulyssys.java.course.maven.vehicle.entity;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = Plane.FIND_ALL, query = "select c from Plane c order by c.id"),
        @NamedQuery(name = Plane.FIND_ALL_BY_OWNER_ID, query = "select c from Plane c where c.owner.id=:owner_id order by c.id"),
        @NamedQuery(name = Plane.FIND_BY_ID, query = "select c from Plane c where c.id=:id"),
})
@Entity
@Table
public class Plane extends AbstractVehicle {

    public static final String FIND_ALL = "Plane.findAll";
    public static final String FIND_ALL_BY_OWNER_ID = "Plane.findAllByOwnerId";
    public static final String FIND_BY_ID = "Plane.findById";

    @Column(name = "passenger_number")
    private int passengerNumber;

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.PLANE;
    }
}
