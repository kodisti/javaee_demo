package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.CarDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CarService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CarServiceImpl implements CarService {

    @Inject
    private CarDAO carDAO;

    @Override
    public List<Car> getAll() {
        return carDAO.findAll();
    }

    @Transactional
    @Override
    public void add(Car vehicle) {
        carDAO.persist(vehicle);

    }

    @Transactional
    @Override
    public void remove(Car vehicle) {
        carDAO.delete(vehicle);
    }

    @Transactional
    @Override
    public void update(Car vehicle) {
        carDAO.update(vehicle);
    }
}
