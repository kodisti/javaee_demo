package hu.ulyssys.java.course.maven.vehicle.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Car.FIND_ALL, query = "select c from Car c order by c.id"),
        @NamedQuery(name = Car.FIND_ALL_BY_OWNER_ID, query = "select c from Car c where c.owner.id=:owner_id order by c.id"),
        @NamedQuery(name = Car.FIND_BY_ID, query = "select c from Car c where c.id=:id"),
})
@Entity
@Table
public class Car extends AbstractVehicle {

    public static final String FIND_ALL = "Car.findAll";
    public static final String FIND_ALL_BY_OWNER_ID = "Car.findAllByOwnerId";
    public static final String FIND_BY_ID = "Car.findById";

    @Column(name = "license_plate_number")
    private String licensePlateNumber;
    @Column(name = "door_numbers")
    private int doorNumbers;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(int doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }


}