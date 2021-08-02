package hu.ulyssys.java.course.javaee.demo.vehicle.dao;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;

import java.util.List;

public interface OwnerDAO {

    List<Owner> findAll();

    Owner findById(Long id);

    Owner persist(Owner owner);

    Owner update(Owner owner);

    void delete(Owner owner);
}
