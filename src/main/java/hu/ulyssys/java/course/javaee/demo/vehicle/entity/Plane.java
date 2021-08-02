package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.*;

@Entity
@Table
public class Plane extends AbstractVehicle {
    @Column(name = "passenger_number")
    private int passengerNumber;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.PLANE;
    }
}
