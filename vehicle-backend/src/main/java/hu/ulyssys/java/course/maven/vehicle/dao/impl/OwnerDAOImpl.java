package hu.ulyssys.java.course.maven.vehicle.dao.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Owner;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OwnerDAOImpl implements OwnerDAO {

    @PersistenceContext(unitName = "TestPersistence")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Owner> findAll() {
        return entityManager.createNamedQuery(Owner.FIND_ALL, Owner.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Owner findById(Long id) {
        try {
            return entityManager.createNamedQuery(Owner.FIND_BY_ID, Owner.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
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
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

}
