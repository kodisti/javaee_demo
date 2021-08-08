package hu.ulyssys.java.course.maven.vehicle.service.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Owner;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class OwnerServiceImpl implements OwnerService {
    @Inject
    private OwnerDAO dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Owner> getAll() {
        return dao.findAll();
    }

    @Override
    public void add(Owner entity) {
        dao.persist(entity);
    }

    @Override
    public void remove(Owner entity) {
        dao.delete(entity.getId());
    }

    @Override
    public void update(Owner entity) {
        dao.update(entity);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Owner findById(Long id) {
        return dao.findById(id);
    }

}
