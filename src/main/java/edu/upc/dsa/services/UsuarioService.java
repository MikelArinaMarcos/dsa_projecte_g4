package edu.upc.dsa.services;

import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.models.Objeto;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/usuario", description = "Endpoint to usuario Service")
@Path("/usuario")
public class UsuarioService {
    private JuegoManager jm;

    public UsuarioService() {
        this.jm = JuegoManagerImpl.getInstance();
        if (jm.sizeusers() == 0) {
            LinkedList<Objeto> objetos = new LinkedList<Objeto>();
            this.jm.addUsuario("j","jordi@gmail.com", "jordi", "l","1234", 500, objetos);
            this.jm.addUsuario("a","aran@gmail.com", "aran", "a","1234", 500, objetos);
            this.jm.addUsuario("p","pedro@gmail.com", "pedro","s", "1234", 500, objetos);
            this.jm.addUsuario("b","bryan@gmail.com", "bryan", "t","1234", 500, objetos);
            this.jm.addUsuario("m","mikel@gmail.com", "mikel", "n","1234", 500, objetos);
        }
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<Usuario> Users = this.jm.getallusers();

        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(Users) {};
        return Response.status(201).entity(entity).build();

    }
//    @GET
//    @ApiOperation(value = "get a User", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
//            @ApiResponse(code = 404, message = "User not found")
//    })
//    @Path("/usuario")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUser(VOCredenciales credenciales) {
//        Usuario U = this.jm.getUser(credenciales);
//        if (U == null) return Response.status(404).build();
//        else  return Response.status(201).entity(U).build();
//    }
    @POST
    @ApiOperation(value = "Log in", notes = "ole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfull", response=Usuario.class),
            @ApiResponse(code = 501, message = "Usuario o contraseña incorrectos"),
    })
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(VOCredenciales credenciales){
        Usuario u = this.jm.LogIn(credenciales);
        if (u==null) return Response.status(501).build();
        return Response.status(201).entity(u).build();
    }
    @POST
    @ApiOperation(value = "Registrar", notes = "ole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfull", response=Usuario.class),
            @ApiResponse(code = 501, message = "Mail en uso"),
            @ApiResponse(code = 502, message = "Usuario en uso"),
    })
    @Path("/registrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RegistrarUsuario(Usuario u){
        int n = this.jm.registrarUsuario(u);
        if (n==1) return Response.status(501).build();
        if (n==2) return Response.status(502).build();
        return Response.status(201).build();
    }
    @DELETE
    @ApiOperation(value = "delete user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/deleteUser/{mail}/{password}")
    public Response deleteUser(@PathParam("mail") String mail, @PathParam("password") String password) {
        VOCredenciales voc = new VOCredenciales(mail, password);
        if (jm.getUser(voc) == null) return Response.status(404).build();
        else this.jm.deleteUsuario(voc);
        return Response.status(201).build();
    }
}

