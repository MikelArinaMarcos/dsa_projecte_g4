//package edu.upc.dsa.services;
//
//import edu.upc.dsa.JuegoManager;
//import edu.upc.dsa.JuegoManagerImpl;
//import edu.upc.dsa.models.*;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.GenericEntity;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//@Api(value = "/usuario", description = "Endpoint to usuario Service")
//@Path("/usuario")
//public class UsuarioService {
//    private JuegoManager jm;
//    public UsuarioService() {
//        this.jm = JuegoManagerImpl.getInstance();
//    }
//    @GET
//    @ApiOperation(value = "get all Users", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
//    })
//    @Path("/getUsers")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUsuarios() {
//
//        HashMap<VOCredenciales,Usuario> Users = this.jm.getallusers();
//
//        GenericEntity<HashMap<VOCredenciales,Usuario>> entity = new GenericEntity<HashMap<VOCredenciales,Usuario>>(Users) {};
//        return Response.status(201).entity(entity).build()  ;
//
//    }
//    @GET
//    @ApiOperation(value = "get a User", notes = "asdasd")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
//            @ApiResponse(code = 404, message = "Track not found")
//    })
//    @Path("/{Username}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUser(@PathParam("id") String id) {
//        Track t = this.tm.getTrack(id);
//        if (t == null) return Response.status(404).build();
//        else  return Response.status(201).entity(t).build();
//    }
//
//
//}
