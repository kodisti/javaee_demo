package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.OwnerDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class OwnerServiceImpl implements OwnerService {
    @Inject
    private OwnerDAO dao;

    @Override
    public List<Owner> getAll() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public void add(Owner entity) {
        dao.persist(entity);
    }

    @Transactional
    @Override
    public void remove(Owner entity) {
        dao.delete(entity);
    }

    @Transactional
    @Override
    public void update(Owner entity) {
        dao.update(entity);
    }

    @Override
    public Owner findById(Long id) {
        return dao.findById(id);
    }
}
