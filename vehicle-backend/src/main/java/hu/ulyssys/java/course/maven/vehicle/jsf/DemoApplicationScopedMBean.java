package hu.ulyssys.java.course.maven.vehicle.jsf;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class DemoApplicationScopedMBean {

    private int count;

    public void addToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
