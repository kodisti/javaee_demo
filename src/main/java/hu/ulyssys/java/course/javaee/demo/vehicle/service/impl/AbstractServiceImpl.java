package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;

import java.util.ArrayList;
import java.util.List;

//Ezt nevezik generikus megoldásnak
public abstract class AbstractServiceImpl<T extends AbstractVehicle> {
    private List<T> list = new ArrayList<>();

    public List<T> getAll() {
        return list;
    }

    public void add(T vehicle) {
        list.add(vehicle);
    }

    public void remove(T vehicle) {
        list.remove(vehicle);
    }

}
