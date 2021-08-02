package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Car.FIND_ALL, query = "select c from Car c order by c.id"),
        @NamedQuery(name = Car.FIND_BY_ID, query = "select c from Car c where c.id=:id"),
})
@Entity
@Table
public class Car extends AbstractVehicle {

    public static final String FIND_ALL = "Car.findAll";
    public static final String FIND_BY_ID = "Car.findById";

    @Column(name = "license_plate_number")
    private String licensePlateNumber;
    @Column(name = "door_numbers")
    private int doorNumbers;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    //erre csak akkor van szükség, ha van olyan konsttuktor, aminek van bemenő paramétere. Ez az üres konstruktor
    public Car() {
    }

    public Car(Long id, String licensePlateNumber, String manufacturer, String type, int doorNumbers) {
        super(id, manufacturer, type);
        this.licensePlateNumber = licensePlateNumber;
        this.doorNumbers = doorNumbers;
    }

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }


}
