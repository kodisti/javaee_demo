package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.*;

@Entity
@Table
public class Ship extends AbstractVehicle {

    @Column(name = "license_plate_number")
    private String licensePlateNumber;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.SHIP;
    }


}
