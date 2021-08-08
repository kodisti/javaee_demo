package hu.ulyssys.java.course.javaee.demo.ejb;

import javax.ejb.Stateless;

@Stateless
public class DemoServiceImpl implements DemoService{

    @Override
    public void doSomethingCool() {
        System.out.println("super demo");
    }
}
