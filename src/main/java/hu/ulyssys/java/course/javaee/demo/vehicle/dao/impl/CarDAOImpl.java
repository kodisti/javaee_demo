package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.CarDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class CarDAOImpl implements CarDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @Override
    public List<Car> findAll() {
        return entityManager.createNamedQuery(Car.FIND_ALL, Car.class).getResultList();
    }

    @Override
    public Car findById(Long id) {
        TypedQuery<Car> carTypedQuery = entityManager.createNamedQuery(Car.FIND_BY_ID, Car.class);
        carTypedQuery.setParameter("id", id);
        return carTypedQuery.getSingleResult();
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
    public void delete(Car car) {
        entityManager.remove(findById(car.getId()));
    }
}
