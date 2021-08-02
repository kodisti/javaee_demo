package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CarService;

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
    private Car selectedCar;

    private boolean inFunction;

    private CarService carService;

    @Inject
    public CarCRUDMbean(CarService carService) {
        this.carService = carService;
        list = carService.getAll();
        selectedCar = new Car();
    }

    public void initSave() {
        selectedCar = new Car();
        inFunction = true;
    }

    public void initEdit(Car car) {
        selectedCar = car;
        inFunction = true;
    }

    public void save() {
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
