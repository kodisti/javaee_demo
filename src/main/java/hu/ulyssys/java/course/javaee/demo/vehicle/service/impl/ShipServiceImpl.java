package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.ShipDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.ShipService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ShipServiceImpl implements ShipService {

    @Inject
    private ShipDAO dao;

    @Override
    public List<Ship> getAll() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public void add(Ship vehicle) {
        dao.persist(vehicle);
    }

    @Transactional
    @Override
    public void remove(Ship vehicle) {
        dao.delete(vehicle);
    }

    @Transactional
    @Override
    public void update(Ship vehicle) {
        dao.update(vehicle);
    }
}
