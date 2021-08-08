package hu.ulyssys.java.course.maven.vehicle.service.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.ShipDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.entity.Ship;
import hu.ulyssys.java.course.maven.vehicle.service.ShipService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ShipServiceImpl implements ShipService {

    @Inject
    private ShipDAO dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Ship> getAll() {
        return dao.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Ship> getAllByOwnerId(Long owner_id) {
        return dao.findAllByOwnerId(owner_id);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Ship findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void add(Ship vehicle) {
        dao.persist(vehicle);
    }

    @Override
    public void remove(Ship vehicle) {
        dao.delete(vehicle.getId());
    }

    @Override
    public void update(Ship vehicle) {
        dao.update(vehicle);
    }
}
