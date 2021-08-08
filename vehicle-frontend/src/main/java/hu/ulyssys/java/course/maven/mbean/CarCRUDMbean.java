package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Owner;
import hu.ulyssys.java.course.maven.vehicle.service.CarService;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CarCRUDMbean implements Serializable {

    private List<Car> list;
    private List<Owner> ownerList;

    private Car selectedCar;
    private Long selectedCarOwnerId;
    private boolean inFunction;

    private CarService carService;
    private OwnerService ownerService;

    @Inject
    public CarCRUDMbean(CarService carService, OwnerService ownerService) {
        this.carService = carService;
        this.ownerService = ownerService;
        list = carService.getAll();
        ownerList = ownerService.getAll();
        selectedCar = new Car();
    }

    public void initSave() {
        selectedCar = new Car();
        inFunction = true;
        selectedCarOwnerId = null;
    }

    public void initEdit(Car car) {
        selectedCar = car;
        if (car.getOwner() != null) {
            selectedCarOwnerId = car.getOwner().getId();
        } else {
            selectedCarOwnerId = null;
        }
        inFunction = true;
    }

    public void save() {

        if (selectedCarOwnerId != null) {
            selectedCar.setOwner(ownerService.findById(selectedCarOwnerId));
        }
        if (selectedCar.getId() == null) {
            carService.add(selectedCar);
            list = carService.getAll();
            selectedCar = new Car();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {

            carService.update(selectedCar);
            list = carService.getAll();
            selectedCar = new Car();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
        inFunction = false;
    }

    public void remove(Car car) {
        carService.remove(car);
        list = carService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public Long getSelectedCarOwnerId() {
        return selectedCarOwnerId;
    }

    public void setSelectedCarOwnerId(Long selectedCarOwnerId) {
        this.selectedCarOwnerId = selectedCarOwnerId;
    }

    public List<Car> getList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}