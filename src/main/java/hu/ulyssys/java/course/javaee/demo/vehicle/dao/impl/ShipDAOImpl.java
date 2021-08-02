package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.ShipDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ShipDAOImpl implements ShipDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @Override
    public List<Ship> findAll() {
        return entityManager.createQuery("select s from Ship s order by s.id", Ship.class).getResultList();
    }

    @Override
    public Ship findById(Long id) {
        return entityManager.find(Ship.class, id);
    }

    @Override
    public Ship persist(Ship ship) {
        entityManager.persist(ship);
        return ship;
    }

    @Override
    public Ship update(Ship ship) {
        return entityManager.merge(ship);
    }

    @Override
    public void delete(Ship ship) {
        entityManager.remove(findById(ship.getId()));
    }
}
