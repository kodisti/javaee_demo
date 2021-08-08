package hu.ulyssys.java.course.javaee.demo.jsf;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

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
