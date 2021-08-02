package hu.ulyssys.java.course.javaee.demo.vehicle.service;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;

import java.util.List;

public interface AbstractService<T extends AbstractVehicle> {
    List<T> getAll();

    void add(T object);

    void remove(T object);

    void update(T object);
}
