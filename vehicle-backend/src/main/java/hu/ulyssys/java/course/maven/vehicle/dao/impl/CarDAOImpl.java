package hu.ulyssys.java.course.maven.vehicle.dao.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.CarDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CarDAOImpl implements CarDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Car> findAll() {
        return entityManager.createNamedQuery(Car.FIND_ALL, Car.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Car> findAllByOwnerId(Long owner_id){
        return entityManager.createNamedQuery(Car.FIND_ALL_BY_OWNER_ID, Car.class).setParameter("owner_id", owner_id).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Car findById(Long id) {
        try {
            return entityManager.createNamedQuery(Car.FIND_BY_ID, Car.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Car persist(Car car) {
        entityManager.persist(car);
        return car;
    }

    //TODO nem mindig kell merge;
    @Override
    public Car update(Car car) {
        return entityManager.merge(car);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}