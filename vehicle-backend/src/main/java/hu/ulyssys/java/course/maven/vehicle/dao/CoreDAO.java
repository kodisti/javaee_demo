package hu.ulyssys.java.course.maven.vehicle.dao;

import hu.ulyssys.java.course.maven.vehicle.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;

import java.util.List;

public interface CoreDAO<T extends AbstractEntity> {
    List<T> findAll();

    List<T> findAllByOwnerId(Long owner_id);

    T findById(Long id);

    T persist(T vehicle);

    T update(T vehicle);

    void delete(Long id);
}
