package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.OwnerModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;
import hu.ulyssys.java.course.maven.vehicle.entity.*;
import hu.ulyssys.java.course.maven.vehicle.service.*;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/owner")
public class OwnerRestService {

    @Inject
    private CarRestService carRestService;

    @Inject
    private PlaneRestService planeRestService;

    @Inject
    private ShipRestService shipRestService;

    @Inject
    private OwnerService service;

    @Inject
    private CarService carService;

    @Inject
    private PlaneService planeService;

    @Inject
    private ShipService shipService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @GET
    @Path("/data/{owner_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllOwnersVehicles(@PathParam("owner_id") Long owner_id){
        Owner entity = service.findById(owner_id);
        if (entity == null){
            Response.status(Response.Status.NOT_FOUND).build();
        }
        OwnerModel owner = createModelFromEntity(entity);
        List<CarModel> carModels = new ArrayList<>();
        List<PlaneModel> planeModels = new ArrayList<>();
        List<ShipModel> shipModels = new ArrayList<>();
        for (Car car : carService.getAllByOwnerId(owner_id)) {
            carModels.add(carRestService.createModelFromEntity(car));
        }
        for (Plane plane : planeService.getAllByOwnerId(owner_id)) {
            planeModels.add(planeRestService.createModelFromEntity(plane));
        }
        for (Ship ship : shipService.getAllByOwnerId(owner_id)) {
            shipModels.add(shipRestService.createModelFromEntity(ship));
        }
        owner.setCarList(carModels);
        owner.setPlaneList(planeModels);
        owner.setShipList(shipModels);
        return Response.ok(owner).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid OwnerModel model) {
        Owner entity = initNewEntity();
        entity.setId(model.getId());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        service.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid OwnerModel model) {
        Owner entity = service.findById(model.getId());
        if (entity==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        service.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Owner entity = service.findById(id);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(entity);
        return Response.ok().build();
    }

    protected OwnerModel createModelFromEntity(Owner entity) {
        OwnerModel model = initNewModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        return model;
    }

    protected OwnerModel initNewModel() {
        return new OwnerModel();
    }

    protected Owner initNewEntity() {
        return new Owner();
    }
}
