package edu.upc.dsa.services;
/*
import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/users", description = "Endpoint to User Service")
@Path("/users")

public class UserService {
    private JuegoManager jm;

    public UserService() {
        this.jm = JuegoManagerImpl.getInstance();
        if (jm.size() == 0) {
            this.jm.addUser("jordi@gmail.com", "jordi", "1234");
            this.jm.addUser("aran@gmail.com", "aran", "1234");
            this.jm.addUser("pedro@gmail.com", "pedro", "1234");
            this.jm.addUser("bryan@gmail.com", "bryan", "1234");
            this.jm.addUser("mikel@gmail.com", "mikel", "1234");
        }
    }

    @GET
    @ApiOperation(value = "Conseguir todos los usuarios", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<Usuario> users = this.jm.findAll();

        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(users) {
        };
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "Conseguir un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        Usuario u = this.jm.getUser(id);

        if (u == null) {
            return Response.status(404).build();
        } else {
            return Response.status(201).entity(u).build();
        }
    }

    @GET
    @ApiOperation(value = "Autenticar usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{mail}&{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authentificate(@PathParam("mail") String mail, @PathParam("password") String password) {

        Usuario user = this.jm.authentification(mail, password);

        if (user == null) {
            return Response.status(404).build();
        } else {
            return Response.status(201).entity(user).build();
        }
    }

    @POST
    @ApiOperation(value = "LOGIN", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/Login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authentificate(VOCredenciales credenciales) {

        Usuario user = this.jm.authentification(credenciales.getUsername(), credenciales.getPassword());

        if (user == null) {
            return Response.status(404).build();
        } else {
            return Response.status(201).entity(user).build();
        }
    }

    @DELETE
    @ApiOperation(value = "Elimina a un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        Usuario t = this.jm.deleteUser(id);

        if (t == null) {
            return Response.status(404).build();
        } else {
            return Response.status(201).build();
        }
    }


    @PUT
    @ApiOperation(value = "Actualiza un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/")
    public Response updateTrack(Usuario u) {

        Usuario user = this.jm.updateUser(u);

        if (user == null) {
            return Response.status(404).build();
        } else {
            return Response.status(201).build();
        }
    }

    @POST
    @ApiOperation(value = "Crea un nuevo usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 400, message = "User already exist for this mail")

    })

    @Path("/Register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Usuario u) {
        Usuario t = this.jm.addUser(u);

        if (t == null) {
            return Response.status(400).build();
        } else {
            return Response.status(201).entity(u).build();
        }
    }
}*/