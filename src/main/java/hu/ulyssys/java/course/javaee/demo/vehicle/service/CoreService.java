package hu.ulyssys.java.course.javaee.demo.vehicle.service;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;

import java.util.List;

public interface CoreService<T extends AbstractVehicle> {
    List<T> getAll();

    void add(T vehicle);

    void remove(T vehicle);

    void update(T vehicle);
}
