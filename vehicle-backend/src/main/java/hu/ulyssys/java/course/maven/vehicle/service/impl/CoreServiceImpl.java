package hu.ulyssys.java.course.maven.vehicle.service.impl;

import hu.ulyssys.java.course.maven.vehicle.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.vehicle.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.vehicle.service.CoreService;

import java.util.ArrayList;
import java.util.List;

//Ezt nevezik generikus megoldásnak
public abstract class CoreServiceImpl<T extends AbstractEntity> implements CoreService<T> {
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
