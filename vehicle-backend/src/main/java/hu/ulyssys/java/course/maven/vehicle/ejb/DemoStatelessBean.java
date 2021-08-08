package hu.ulyssys.java.course.javaee.demo.ejb;

import javax.ejb.Stateless;

@Stateless
public class DemoStatelessBean {
    public void doSomething(){
        System.out.println("Lefutott a bean");
    }
}
