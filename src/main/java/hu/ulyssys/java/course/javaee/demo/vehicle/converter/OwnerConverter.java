package hu.ulyssys.java.course.javaee.demo.vehicle.converter;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@ApplicationScoped
public class OwnerConverter implements Converter {

    @Inject
    private OwnerService ownerService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        String[] params = s.split(" ");
        if (params.length != 3) {
            return null;
        }
        Optional<Owner> optionalOwner = ownerService.getAll().stream().filter(owner -> owner.getId().equals(Long.parseLong(params[2]))
        ).findFirst();
        return optionalOwner.get();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Owner) {
            return ((Owner) o).getFirstName() + " " + ((Owner) o).getLastName() + " " + ((Owner) o).getId() + "";
        }
        if(o instanceof String){
            return o.toString();
        }
        return null;
    }
}
