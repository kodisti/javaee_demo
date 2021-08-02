package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.OwnerDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class OwnerDAOImpl implements OwnerDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("select o from Owner o order by o.id", Owner.class).getResultList();
    }

    @Override
    public Owner findById(Long id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public Owner persist(Owner owner) {
        entityManager.persist(owner);
        return owner;
    }

    @Override
    public Owner update(Owner owner) {
        return entityManager.merge(owner);
    }

    @Override
    public void delete(Owner owner) {
        entityManager.remove(findById(owner.getId()));
    }
}
