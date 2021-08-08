package hu.ulyssys.java.course.maven.vehicle.service.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.PlaneDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.service.PlaneService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class PlaneServiceImpl implements PlaneService {

    @Inject
    private PlaneDAO dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Plane> getAll() {
        return dao.findAll();
    }

    @Override
    public List<Plane> getAllByOwnerId(Long owner_id) {
        return dao.findAllByOwnerId(owner_id);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Plane findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void add(Plane vehicle) {
        dao.persist(vehicle);
    }

    @Override
    public void remove(Plane vehicle) {
        dao.delete(vehicle.getId());
    }

    @Override
    public void update(Plane vehicle) {
        dao.update(vehicle);
    }
}
