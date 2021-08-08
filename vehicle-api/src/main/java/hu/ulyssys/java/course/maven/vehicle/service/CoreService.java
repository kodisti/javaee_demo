package hu.ulyssys.java.course.maven.vehicle.service;

import hu.ulyssys.java.course.maven.vehicle.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.vehicle.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;

import java.util.List;

public interface CoreService<T extends AbstractEntity> {
    List<T> getAll();

    List<T> getAllByOwnerId(Long owner_id);

    T findById(Long id);

    void add(T vehicle);

    void remove(T vehicle);

    void update(T vehicle);
}
