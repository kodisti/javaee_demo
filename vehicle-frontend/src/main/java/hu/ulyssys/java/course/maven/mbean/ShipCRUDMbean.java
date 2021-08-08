package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.maven.vehicle.entity.Owner;
import hu.ulyssys.java.course.maven.vehicle.entity.Ship;
import hu.ulyssys.java.course.maven.vehicle.entity.service.OwnerService;
import hu.ulyssys.java.course.maven.vehicle.entity.service.ShipService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ShipCRUDMbean implements Serializable {

    private List<Ship> list;
    private Ship selectedShip;
    private boolean inFunction;
    private List<Owner> ownerList;

    @Inject
    private ShipService shipService;
    @Inject
    private OwnerService ownerService;

    @PostConstruct
    private void init() {
        list = shipService.getAll();
        ownerList = ownerService.getAll();
        //Reflection
        selectedShip = new Ship();
    }

    public void initSave() {
        selectedShip = new Ship();
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public void save() {
        if (selectedShip.getId() == null) {
            shipService.add(selectedShip);
            list = shipService.getAll();
            selectedShip = new Ship();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));

        } else {
            shipService.update(selectedShip);
            list = shipService.getAll();
            selectedShip = new Ship();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
        PrimeFaces.current().executeScript("PF('shipDialog').hide()");
    }

    public void remove() {
        shipService.remove(selectedShip);
        list = shipService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedShip = new Ship();
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public List<Ship> getList() {
        return list;
    }

    public void setList(List<Ship> list) {
        this.list = list;
    }

    public Ship getSelectedShip() {
        return selectedShip;
    }

    public void setSelectedShip(Ship selectedShip) {
        this.selectedShip = selectedShip;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
