package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.service.CarService;
import hu.ulyssys.java.course.maven.vehicle.service.CoreService;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/car")
public class CarRestService extends CoreRestService<Car, CarModel>{

    @Inject
    private OwnerService ownerService;

    @Inject
    private CarService service;

    @Override
    public Response findAll(){
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @Override
    public Response findOneById(Long id){
        Car entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response findAllByOwnerId(Long owner_id){
        List<CarModel> carModels = service.getAllByOwnerId(owner_id).stream().map(this::createModelFromEntity).collect(Collectors.toList());
        if (carModels.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(carModels).build();
    }

    @Override
    public Response save(CarModel model) {
        Car entity = initNewEntity();
        populateEntityFromModel(entity,model);
        service.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response update(CarModel model) {
        Car entity = service.findById(model.getId());
        if (entity==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity,model);
        service.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response delete(Long id) {
        Car entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(entity);
        return Response.ok().build();
    }

    @Override
    protected void populateEntityFromModel(Car entity, CarModel model) {
        if (model.getOwnerID() != null){
            entity.setOwner(ownerService.findById(model.getOwnerID()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
        entity.setDoorNumbers(model.getDoorNumbers());
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    protected CarModel createModelFromEntity(Car entity) {
        CarModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setDoorNumbers(entity.getDoorNumbers());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        if (entity.getOwner() != null){
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }

    @Override
    protected CarModel initNewModel() {
        return new CarModel();
    }

    @Override
    protected Car initNewEntity() {
        return new Car();
    }
}
