package hu.ulyssys.java.course.javaee.demo.vehicle.dao;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;

import java.util.List;

public interface ShipDAO {

    List<Ship> findAll();

    Ship findById(Long id);

    Ship persist(Ship ship);

    Ship update(Ship ship);

    void delete(Ship ship);
}
