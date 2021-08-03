package hu.ulyssys.java.course.javaee.demo.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class DemoEJBMbean implements Serializable {

    private String name;
    @EJB
    private DemoStatelessBean statelessBean;
    @EJB
    private DemoStatefulBean statefulBean;
    @EJB
    private DemoSingletonBean singletonBean;
    @Inject
    private DemoService demoService;

    @PostConstruct
    private void init() {
        statelessBean.doSomething();
        demoService.doSomethingCool();
        name = "Hello world";
    }

    public int getCount() {
        //nem biztos, hogy mindig ugyan azt az objektum vissza.
        return singletonBean.getCount();
    }

    public void initCount() {
        singletonBean.init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
