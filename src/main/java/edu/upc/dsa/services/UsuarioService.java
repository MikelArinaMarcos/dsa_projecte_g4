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
        if (jm.sizeUsers() == 0) {
            List<Objeto> objetos = new ArrayList<>();
            this.jm.addUsuario("jordi", "jordi@gmail.com", "Jordi", "Figueras", "1234", 500, objetos);
            this.jm.addUsuario("aran", "aran@gmail.com", "Arán", "Huarte", "1234", 500, objetos);
            this.jm.addUsuario("bryan", "bryan@gmail.com", "Bryan", "García", "1234", 500, objetos);
            this.jm.addUsuario("mikel", "mikel@gmail.com", "Mikel", "Arina", "1234", 500, objetos);
            this.jm.addUsuario("pedro", "pedro@gmail.com", "Pedro", "Jordán", "1234", 500, objetos);
            this.jm.addUsuario("a", "a@gmail.com", "A", "B", "1234", 500, objetos);
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

    @POST
    @ApiOperation(value = "Log in", notes = "ole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfull", response=Usuario.class),
            @ApiResponse(code = 301, message = "Usuario o contraseña incorrectos"),
    })
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(VOCredenciales credenciales){
        Usuario u = this.jm.login(credenciales);
        if (u==null) return Response.status(301).build();
        return Response.status(201).entity(u).build();
    }
    @POST
    @ApiOperation(value = "Registrar", notes = "ole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfull", response=Usuario.class),
            @ApiResponse(code = 301, message = "Mail en uso"),
            @ApiResponse(code = 302, message = "Usuario en uso"),
    })
    @Path("/registrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RegistrarUsuario(Usuario u){
        int n = this.jm.registrarUsuario(u);
        if (n==1) return Response.status(301).build();
        if (n==2) return Response.status(302).build();
        if (n==3) return Response.status(303).build();
        if (n==0) return Response.status(201).build();

        //En caso de un valor inesperado, devolver código de Internal Server Error
        return Response.status(500).build();
    }
    @DELETE
    @ApiOperation(value = "delete user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 301, message = "Contra incorrecta")
    })
    @Path("/deleteUser/{mail}&{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("mail") String mail, @PathParam("password") String password) {
        VOCredenciales voc = new VOCredenciales(mail, password);
        if (jm.getUser(mail) == null) return Response.status(404).build();
        /*if(this.jm.deleteUsuario(voc) == -1)
            return Response.status(301).build();*/
        if(this.jm.deleteUsuario(voc) == 1)
            return Response.status(201).build();
        //En caso de un valor inesperado, devolver código de Internal Server Error
        return Response.status(500).build();
    }

    @PUT
    @ApiOperation(value = "Actualizar usuario", notes = "Actualiza la información del usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Actualización exitosa"),
            @ApiResponse(code = 404, message = "Usuario no encontrado"),
            @ApiResponse(code = 301, message = "Contraseña incorrecta"),
            @ApiResponse(code = 5, message = "Correo electrónico ya en uso")
    })
    @Path("/actualizarUsuario/{mail}/{newPassword}/{newUsername}/{newName}/{newLastName}/{newMail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(
            @PathParam("mail") String mail,
            @PathParam("newPassword") String newPassword,
            @PathParam("newUsername") String newUsername,
            @PathParam("newName") String newName,
            @PathParam("newLastName") String newLastName,
            @PathParam("newMail") String newMail) {

        int result = this.jm.actualizarUsuario(mail, newUsername, newName, newLastName, newPassword, newMail);

        switch (result) {
            case 1:
                return Response.status(201).build(); // Actualización exitosa
            case 404:
                return Response.status(404).build(); // Usuario no encontrado
            case 301:
                return Response.status(301).build(); // Contraseña incorrecta
            case 5:
                return Response.status(5).build(); // Correo electrónico ya en uso
            default:
                return Response.status(500).build(); // Error interno del servidor
        }
    }


}

