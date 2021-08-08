package hu.ulyssys.java.course.maven.vehicle.dao.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.PlaneDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlaneDAOImpl implements PlaneDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Plane> findAll() {
        return entityManager.createNamedQuery(Plane.FIND_ALL, Plane.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Plane> findAllByOwnerId(Long owner_id) {
        return entityManager.createNamedQuery(Plane.FIND_ALL_BY_OWNER_ID, Plane.class).setParameter("owner_id", owner_id).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Plane findById(Long id) {
        try {
            return entityManager.createNamedQuery(Plane.FIND_BY_ID, Plane.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
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
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
