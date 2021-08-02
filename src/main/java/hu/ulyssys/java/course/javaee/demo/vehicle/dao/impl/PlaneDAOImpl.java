package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.PlaneDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PlaneDAOImpl implements PlaneDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @Override
    public List<Plane> findAll() {
        return entityManager.createQuery("select p from Plane p order by p.id", Plane.class).getResultList();
    }

    @Override
    public Plane findById(Long id) {
        return entityManager.find(Plane.class, id);
    }

    @Override
    public Plane persist(Plane plane) {
        entityManager.persist(plane);
        return plane;
    }

    @Override
    public Plane update(Plane plane) {
        return entityManager.merge(plane);
    }

    @Override
    public void delete(Plane plane) {
        entityManager.remove(findById(plane.getId()));
    }
}
