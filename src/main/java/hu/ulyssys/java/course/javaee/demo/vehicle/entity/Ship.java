package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Ship extends AbstractVehicle {

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
