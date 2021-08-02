package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.PlaneService;

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
public class PlaneCRUDMbean implements Serializable {
    private List<Owner> ownerList;
    private List<Plane> list;
    private Plane selectedPlane;
    private boolean inFunction;

    @Inject
    private PlaneService planeService;
    @Inject
    private OwnerService ownerService;

    @PostConstruct
    private void init() {
        list = planeService.getAll();
        selectedPlane = new Plane();
        ownerList = ownerService.getAll();
    }

    public void initSave() {
        selectedPlane = new Plane();
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public void save() {
        if (selectedPlane.getId() == null) {
            planeService.add(selectedPlane);
            list = planeService.getAll();
            selectedPlane = new Plane();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));

        } else {
            planeService.update(selectedPlane);
            list = planeService.getAll();
            selectedPlane = new Plane();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
    }

    public void remove() {
        planeService.remove(selectedPlane);
        list = planeService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedPlane = new Plane();
    }

    public List<Plane> getList() {
        return list;
    }

    public void setList(List<Plane> list) {
        this.list = list;
    }

    public Plane getSelectedPlane() {
        return selectedPlane;
    }

    public void setSelectedPlane(Plane selectedPlane) {
        this.selectedPlane = selectedPlane;
    }

    public boolean isInFunction() {
        return inFunction;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }
}
