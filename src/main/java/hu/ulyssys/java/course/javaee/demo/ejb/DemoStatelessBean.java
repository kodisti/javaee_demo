package hu.ulyssys.java.course.javaee.demo.ejb;

import javax.ejb.Stateless;

//Nem szabad értéket tárolni benne, nem lehet be bitzonyítani, hogy mindig ugyan azt a példányt kapjuk vissza
@Stateless
public class DemoStatelessBean {

    public void doSomething() {
        System.out.println("Lefutott a bean");
    }

}
