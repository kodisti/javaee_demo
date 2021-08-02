package hu.ulyssys.java.course.javaee.demo.vehicle.service;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAll();

    void add(Owner entity);

    void remove(Owner entity);

    void update(Owner entity);

    Owner findById(Long id);
}
