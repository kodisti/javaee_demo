package hu.ulyssys.java.course.javaee.demo.ejb;

import javax.ejb.Singleton;
import javax.ejb.Stateful;

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
