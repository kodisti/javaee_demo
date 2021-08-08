package hu.ulyssys.java.course.maven.vehicle.jsf;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DemoViewScopedMBean implements Serializable {

    private int count;

    public void addToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
