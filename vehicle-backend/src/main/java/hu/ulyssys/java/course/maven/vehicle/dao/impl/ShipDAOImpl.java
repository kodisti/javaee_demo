package hu.ulyssys.java.course.maven.vehicle.dao.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.ShipDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.entity.Ship;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ShipDAOImpl implements ShipDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Ship> findAll() {
        return entityManager.createNamedQuery(Ship.FIND_ALL, Ship.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Ship> findAllByOwnerId(Long owner_id) {
        return entityManager.createNamedQuery(Ship.FIND_ALL_BY_OWNER_ID, Ship.class).setParameter("owner_id", owner_id).getResultList();

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Ship findById(Long id) {
        try {
            return entityManager.createNamedQuery(Ship.FIND_BY_ID, Ship.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e){
            return null;
        }    }

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
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
