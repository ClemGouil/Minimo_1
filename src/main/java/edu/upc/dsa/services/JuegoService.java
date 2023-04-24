package edu.upc.dsa.services;


import edu.upc.dsa.JuegoManager;

import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.models.Objecto;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/juego", description = "Endpoint to Track Service")
@Path("/juego")
public class JuegoService {

    private JuegoManager jm;

    public JuegoService() {
        this.jm = JuegoManagerImpl.getInstance();
        jm.addUsuario("id","Clement","gouilloud");
    }


    @POST
    @ApiOperation(value = "add a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Usuario usuario) {

        if (usuario.getNombre()==null || usuario.getId()==null || usuario.getApellido()==null)  return Response.status(500).entity(usuario).build();
        this.jm.addUsuario(usuario.getId(),usuario.getNombre(),usuario.getApellido());
        return Response.status(201).entity(usuario).build();
    }

    @POST
    @ApiOperation(value = "add a new Object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Objecto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/objecto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjecto(Objecto objecto) {

        if (objecto.getDesc()==null || objecto.getId()==null || objecto.getPrecio()==null)  return Response.status(500).entity(objecto).build();
        this.jm.addOjectoEnTienda(objecto.getId(),objecto.getDesc(),objecto.getPrecio());
        return Response.status(201).entity(objecto).build();
    }

    @GET
    @ApiOperation(value = "get the game state", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = String.class),
            @ApiResponse(code = 404, message = "juego not found")
    })
    @Path("/GameState")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameState() {
        String estadoJuego = jm.getEstadoJuego();
        if (estadoJuego == null) return Response.status(404).build();
        else  return Response.status(201).entity(estadoJuego).build();
    }

    @GET
    @ApiOperation(value = "get the life point of an user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Integer.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLife(@PathParam("id") String id) {
        Integer i = this.jm.getVidaUsuario(id);
        if (i == null) return Response.status(404).build();
        else  return Response.status(201).entity(i).build();
    }

}