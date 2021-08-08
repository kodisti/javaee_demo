package hu.ulyssys.java.course.maven.converter;

import hu.ulyssys.java.course.maven.vehicle.entity.Owner;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AppOwnerConverter implements Converter {

    @Inject
    private OwnerService ownerService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        return ownerService.getAll().stream().filter(owner -> owner.getFirstName().equals(s)
        ).findFirst().orElse(null);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Owner) {
            return ((Owner) o).getFirstName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
