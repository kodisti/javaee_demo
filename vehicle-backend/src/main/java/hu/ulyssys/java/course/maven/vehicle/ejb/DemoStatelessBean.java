package hu.ulyssys.java.course.maven.vehicle.ejb;

import javax.ejb.Stateless;

@Stateless
public class DemoStatelessBean {
    public void doSomething(){
        System.out.println("Lefutott a bean");
    }
}
