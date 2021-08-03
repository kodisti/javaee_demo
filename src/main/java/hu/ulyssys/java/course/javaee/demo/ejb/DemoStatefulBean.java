package hu.ulyssys.java.course.javaee.demo.ejb;

import javax.ejb.Stateful;

//Nem szoktunk Stateful beaneket hsználni
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
