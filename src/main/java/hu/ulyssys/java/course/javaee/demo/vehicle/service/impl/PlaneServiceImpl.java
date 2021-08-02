package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.PlaneDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.PlaneService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlaneServiceImpl implements PlaneService {

    @Inject
    private PlaneDAO dao;

    @Override
    public List<Plane> getAll() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public void add(Plane vehicle) {
        dao.persist(vehicle);
    }

    @Transactional
    @Override
    public void remove(Plane vehicle) {
        dao.delete(vehicle);
    }

    @Transactional
    @Override
    public void update(Plane vehicle) {
        dao.update(vehicle);
    }
}
