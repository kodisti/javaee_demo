package hu.ulyssys.java.course.javaee.demo.vehicle.dao;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;

import java.util.List;

public interface CarDAO {

    List<Car> findAll();

    Car findById(Long id);

    Car persist(Car car);

    Car update(Car car);

    void delete(Car car);
}
