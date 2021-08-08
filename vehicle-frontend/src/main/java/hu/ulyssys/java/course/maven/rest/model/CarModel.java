package hu.ulyssys.java.course.maven.rest.model;

import javax.persistence.Column;

public class CarModel extends CoreModel{
    private String licensePlateNumber;
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
}
