package hu.ulyssys.java.course.maven.vehicle.ejb;

import javax.ejb.Stateful;

@Stateful
public class DemoStatefulBean {

    private int count;

    public int getCount() {
        return count;
    }

    public void init() {
        count++;
    }
}
