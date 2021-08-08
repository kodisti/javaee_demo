package hu.ulyssys.java.course.maven.rest.model;

import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.entity.Ship;

import java.util.List;

public class OwnerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private List<CarModel> carList;
    private List<PlaneModel> planeList;
    private List<ShipModel> shipList;

    public OwnerModel(){

    }

    public OwnerModel(Long id, String firstName, String lastName, List<CarModel> carList, List<PlaneModel> planeList, List<ShipModel> shipList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.carList = carList;
        this.planeList = planeList;
        this.shipList = shipList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CarModel> getCarList() {
        return carList;
    }

    public void setCarList(List<CarModel> carList) {
        this.carList = carList;
    }

    public List<PlaneModel> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<PlaneModel> planeList) {
        this.planeList = planeList;
    }

    public List<ShipModel> getShipList() {
        return shipList;
    }

    public void setShipList(List<ShipModel> shipList) {
        this.shipList = shipList;
    }
}
