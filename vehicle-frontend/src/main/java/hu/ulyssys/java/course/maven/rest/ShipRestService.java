package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;
import hu.ulyssys.java.course.maven.vehicle.entity.Car;
import hu.ulyssys.java.course.maven.vehicle.entity.Plane;
import hu.ulyssys.java.course.maven.vehicle.entity.Ship;
import hu.ulyssys.java.course.maven.vehicle.service.ShipService;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/ship")
public class ShipRestService extends CoreRestService<Ship, ShipModel>{

    @Inject
    private OwnerService ownerService;

    @Inject
    private ShipService service;

    @Override
    public Response findAll(){
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @Override
    public Response findOneById(Long id) {
        Ship entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response findAllByOwnerId(Long owner_id) {
        List<ShipModel> shipModels = service.getAllByOwnerId(owner_id).stream().map(this::createModelFromEntity).collect(Collectors.toList());
        if (shipModels.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(shipModels).build();
    }

    @Override
    public Response save(ShipModel model) {
        Ship entity = initNewEntity();
        populateEntityFromModel(entity,model);
        service.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response update(ShipModel model) {
        Ship entity = service.findById(model.getId());
        if (entity==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity,model);
        service.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @Override
    public Response delete(Long id) {
        Ship entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(entity);
        return Response.ok().build();
    }

    @Override
    protected void populateEntityFromModel(Ship entity, ShipModel model) {
        if (model.getOwnerID() != null){
            entity.setOwner(ownerService.findById(model.getOwnerID()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    protected ShipModel createModelFromEntity(Ship entity) {
        ShipModel model = initNewModel();
        model.setId(entity.getId());
        model.setManufacturer(entity.getManufacturer());
        model.setType(entity.getType());
        model.setLicensePlateNumber(entity.getLicensePlateNumber());
        if (entity.getOwner() != null){
            model.setOwnerID(entity.getOwner().getId());
        }
        return model;
    }

    @Override
    protected ShipModel initNewModel() {
        return new ShipModel();
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }
}
