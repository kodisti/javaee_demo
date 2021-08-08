package hu.ulyssys.java.course.maven.vehicle.dao;

import hu.ulyssys.java.course.maven.vehicle.entity.Owner;

import java.util.List;

public interface OwnerDAO {
    List<Owner> findAll();

    Owner findById(Long id);

    Owner persist(Owner vehicle);

    Owner update(Owner vehicle);

    void delete(Long id);
}
