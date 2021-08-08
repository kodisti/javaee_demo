package hu.ulyssys.java.course.maven.vehicle.jsf;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class DemoSessionScopedMBean implements Serializable {

    private int count;

    public void addToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
