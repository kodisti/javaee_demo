package hu.ulyssys.java.course.maven.vehicle.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class DemoRequestScopedMBean {

    private int count;

    public void addToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
