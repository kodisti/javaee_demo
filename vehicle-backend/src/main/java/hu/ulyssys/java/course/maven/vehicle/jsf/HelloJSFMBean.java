package hu.ulyssys.java.course.maven.vehicle.jsf;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

//ViewScope vagy Session scope alapú beam-ünk van Serializable interface implementálni
@Named
@ViewScoped
public class HelloJSFMBean implements Serializable {

    private String value = "Hello world";

    public String getValue() {
        return value;
    }
}
