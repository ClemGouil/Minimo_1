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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/juego", description = "Endpoint to Track Service")
@Path("/juego")
public class JuegoService {

    private JuegoManager jm;

    public JuegoService() {
        this.jm = JuegoManagerImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "add a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Usuario usuario) {

        if (usuario.getNombre()==null || usuario.getId()==null || usuario.getApellido()==null)  return Response.status(500).entity(usuario).build();
        this.jm.addUsuario(usuario.getId(),usuario.getNombre(),usuario.getApellido());
        return Response.status(201).entity(usuario).build();
    }

}