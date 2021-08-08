package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.rest.model.CoreModel;
import hu.ulyssys.java.course.maven.vehicle.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.vehicle.service.CoreService;
import hu.ulyssys.java.course.maven.vehicle.service.OwnerService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

public abstract class CoreRestService<T extends AbstractVehicle, M extends CoreModel> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public abstract Response findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public abstract Response findOneById(@PathParam("id") Long id);

    @GET
    @Path("/owner_id/{owner_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public abstract Response findAllByOwnerId(@PathParam("owner_id") Long owner_id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public abstract Response save(@Valid M model);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public abstract Response update(@Valid M model);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public abstract Response delete(@PathParam("id") Long id);

    protected abstract void populateEntityFromModel(T entity, M model);

    protected abstract M createModelFromEntity(T entity);

    protected abstract M initNewModel();

    protected abstract T initNewEntity();
}
