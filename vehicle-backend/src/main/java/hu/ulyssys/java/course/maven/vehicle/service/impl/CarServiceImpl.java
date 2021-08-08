package hu.ulyssys.java.course.maven.vehicle.service.impl;

import hu.ulyssys.java.course.maven.vehicle.dao.CarDAO;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.service.CarService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CarServiceImpl extends CoreServiceImpl<Car> implements CarService {

    @Inject
    private CarDAO carDAO;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Car> getAll() {
        return carDAO.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Car> getAllByOwnerId(Long owner_id){
        return carDAO.findAllByOwnerId(owner_id);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Car findById(Long id) {
        return carDAO.findById(id);
    }


    @Override
    public void add(Car vehicle) {
        carDAO.persist(vehicle);

    }

    @Override
    public void remove(Car vehicle) {
        carDAO.delete(vehicle.getId());
    }

    @Override
    public void update(Car vehicle) {
        carDAO.update(vehicle);
    }
}
