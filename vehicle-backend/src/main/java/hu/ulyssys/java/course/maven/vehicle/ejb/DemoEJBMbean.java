package hu.ulyssys.java.course.maven.vehicle.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
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

    @PostConstruct
    private void init(){
        statelessBean.doSomething();
        name = "Hello World!";
    }

    public int getCount(){
        return statefulBean.getCount();
    }
    public void initCount(){
        statefulBean.init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoStatelessBean getStatelessBean() {
        return statelessBean;
    }

    public void setStatelessBean(DemoStatelessBean statelessBean) {
        this.statelessBean = statelessBean;
    }


}
