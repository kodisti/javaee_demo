package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.vehicle.entity.Owner;
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
public class OwnerCRUDMbean implements Serializable {

    private List<Owner> list;
    private Owner selectedOwner;

    private boolean inFunction;

    private OwnerService ownerService;

    @Inject
    public OwnerCRUDMbean(OwnerService ownerService) {
        this.ownerService = ownerService;
        list = ownerService.getAll();
        selectedOwner = new Owner();
    }

    public void initSave() {
        selectedOwner = new Owner();
        inFunction = true;
    }

    public void initEdit(Owner owner) {
        selectedOwner = owner;
        inFunction = true;
    }

    public void save() {
        if (selectedOwner.getId() == null) {
            ownerService.add(selectedOwner);
            list = ownerService.getAll();
            selectedOwner = new Owner();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            ownerService.update(selectedOwner);
            list = ownerService.getAll();
            selectedOwner = new Owner();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
        inFunction = false;
    }

    public void remove(Owner owner) {
        ownerService.remove(owner);
        list = ownerService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));

    }

    public List<Owner> getList() {
        return list;
    }

    public void setList(List<Owner> list) {
        this.list = list;
    }

    public Owner getSelectedOwner() {
        return selectedOwner;
    }

    public void setSelectedOwner(Owner selectedOwner) {
        this.selectedOwner = selectedOwner;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
