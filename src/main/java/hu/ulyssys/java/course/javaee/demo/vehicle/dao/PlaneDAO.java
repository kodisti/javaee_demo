package hu.ulyssys.java.course.javaee.demo.vehicle.dao;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;

import java.util.List;

public interface PlaneDAO {

    List<Plane> findAll();

    Plane findById(Long id);

    Plane persist(Plane plane);

    Plane update(Plane plane);

    void delete(Plane plane);
}
