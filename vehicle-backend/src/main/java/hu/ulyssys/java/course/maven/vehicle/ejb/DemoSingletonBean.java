package hu.ulyssys.java.course.maven.vehicle.ejb;

import javax.ejb.Singleton;

@Singleton
public class DemoSingletonBean {

    private int count;
    public int getCount() {
        return count;
    }

    public void init() {
        count++;
    }
}
