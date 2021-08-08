package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.service.PlaneService;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/plane")
public class PlaneRestService extends CoreRestService<Plane, PlaneModel>{

    @Inject
    private OwnerService ownerService;

    @Inject
    private PlaneService service;

    @Override
    public Response findAll(){
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @Override
    public Response findOneById(Long id) {
        Plane entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response findAllByOwnerId(Long owner_id) {
        List<PlaneModel> planeModels = service.getAllByOwnerId(owner_id).stream().map(this::createModelFromEntity).collect(Collectors.toList());
        if (planeModels.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(planeModels).build();
    }

    @Override
    public Response save(PlaneModel model) {
        Plane entity = initNewEntity();
        populateEntityFromModel(entity,model);
        service.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response update(PlaneModel model) {
        Plane entity = service.findById(model.getId());
        if (entity==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity,model);
        service.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response delete(Long id) {
        Plane entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(entity);
        return Response.ok().build();
    }

    @Override
    protected void populateEntityFromModel(Plane entity, PlaneModel model) {
        if (model.getOwnerID() != null){
            entity.setOwner(ownerService.findById(model.getOwnerID()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
        entity.setPassengerNumber(model.getPassengerNumber());
    }

    @Override
    protected PlaneModel createModelFromEntity(Plane entity) {
        PlaneModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setPassengerNumber(entity.getPassengerNumber());
        if (entity.getOwner() != null){
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }

    @Override
    protected PlaneModel initNewModel() {
        return new PlaneModel();
    }

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }
}
