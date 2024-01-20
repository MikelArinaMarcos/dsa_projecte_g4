package edu.upc.dsa.services;

import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.exceptions.NotInInventoryException;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.sql.SQLException;

@Api(value = "/usuario", description = "Endpoint to usuario Service")
@Path("/usuario")
public class UsuarioService {
    private JuegoManager jm;

    public UsuarioService() {
        this.jm = JuegoManagerImpl.getInstance();
        if (jm.sizeUsers() == 0) {
            List<Objeto> objetos = new ArrayList<>();
            this.jm.addUsuario("jordi", "jordi@gmail.com", "Jordi", "Figueras", "1234");
            this.jm.addUsuario("aran", "aran@gmail.com", "Arán", "Huarte", "1234");
            this.jm.addUsuario("bryan", "bryan@gmail.com", "Bryan", "García", "1234");
            this.jm.addUsuario("mikel", "mikel@gmail.com", "Mikel", "Arina", "1234");
            this.jm.addUsuario("pedro", "pedro@gmail.com", "Pedro", "Jordán", "1234");
            this.jm.addUsuario("a", "a@gmail.com", "A", "B", "1234");
            List<Insignia> i = new LinkedList<Insignia>();
            Insignia ins;
            i.add(ins = new Insignia("Master del universo", "https://media.gq.com.mx/photos/5dec0db85b7e8300097bca15/1:1/w_600,h_600,c_limit/thanos-bebe-marvel.jpg"));
            i.add(ins = new Insignia("Rey de Catalunya", "https://imagenes.muyinteresante.es/files/composte_image/uploads/2023/08/10/64d49b847013d.jpeg"));
            i.add(ins = new Insignia("El estudiante", "https://img.freepik.com/vector-premium/lindo-nino-estudiante-levantando-mano-respondiendo-pregunta-sentado-su-escritorio-aula_535862-690.jpg?w=2000"));
            i.add(ins = new Insignia("Badass badge", "https://www.mundodeportivo.com/alfabeta/hero/2020/10/levi-ackerman-abj.jpg?width=768&aspect_ratio=16:9&format=nowebp"));

            jm.addInsignias(i, "jordi");

            List<Insignia> o = new LinkedList<Insignia>();
            o.add(ins = new Insignia("Dragon slayer", "https://c4.wallpaperflare.com/wallpaper/705/734/459/dark-dovahkiin-dragon-dragonborn-wallpaper-preview.jpg"));
            o.add(ins = new Insignia("El estudiante", "https://img.freepik.com/vector-premium/lindo-nino-estudiante-levantando-mano-respondiendo-pregunta-sentado-su-escritorio-aula_535862-690.jpg?w=2000"));
            jm.addInsignias(o, "pedro");

            List<Insignia> h = new LinkedList<Insignia>();
            h.add(ins = new Insignia("Cazador furtivo", "https://i.pinimg.com/originals/ef/90/0d/ef900dd70802cd2c5fce596f92f89549.jpg"));
            h.add(ins = new Insignia("BBDD expert", "https://www.aceinfoway.com/blog/wp-content/uploads/2020/03/best-database-to-work-with-in-2020.jpg"));
            jm.addInsignias(h, "bryan");

            List<Insignia> k = new LinkedList<Insignia>();
            k.add(ins = new Insignia("Badass badge", "https://www.mundodeportivo.com/alfabeta/hero/2020/10/levi-ackerman-abj.jpg?width=768&aspect_ratio=16:9&format=nowebp"));
            k.add(ins = new Insignia("Unity master", "https://cink.es/wp-content/uploads/2022/03/unity-3d-como-hacer-juegos.jpg"));
            jm.addInsignias(k, "aran");

            List<Mensaje> mensajesPredeterminados = new LinkedList<>();
            mensajesPredeterminados.add(new Mensaje("Bienvenido a Pollopeta"));
            mensajesPredeterminados.add(new Mensaje("Espero que le guste el juego, que se divierta!"));
            jm.addMensajesGenerales(mensajesPredeterminados);
        }
    }
    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
            @ApiResponse(code = 501, message = "Error al intentar coger todos los usuarios"),
    })
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<Usuario> Users = this.jm.getallusers();
        if (Users == null){
            return Response.status(501).build();
        }
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(Users) {};
        return Response.status(201).entity(entity).build();

    }

    @POST
    @ApiOperation(value = "Log in", notes = "ole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfull", response=Usuario.class),
            @ApiResponse(code = 301, message = "Contraseña incorrecta"),
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
            @ApiResponse(code = 302, message = "Nombre de Usuario en uso"),
    })
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RegistrarUsuario(Usuario u){
        int n = this.jm.registrarUsuario(u);
        if (n==1) return Response.status(301).build();
        if (n==2) return Response.status(302).build();
        if (n==0) return Response.status(201).build();

        //En caso de un valor inesperado, devolver código de Internal Server Error
        return Response.status(500).build();
    }
    @DELETE
    @ApiOperation(value = "delete user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "User not found"),
            @ApiResponse(code = 301, message = "Contra incorrecta")
    })
    @Path("/deleteUser/{mail}&{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("mail") String mail, @PathParam("password") String password) {
        VOCredenciales voc = new VOCredenciales(mail, password);
        int res = this.jm.deleteUsuario(voc);
        if(res == 2)
            return Response.status(301).build();
        if(res == 0)
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

        Usuario usuarioActualizado = this.jm.actualizarUsuario(mail, newUsername, newName, newLastName, newPassword, newMail);

        if (usuarioActualizado != null) {
            return Response.status(201).entity(usuarioActualizado).build(); // Retornar código 201 para indicar actualización exitosa
        } else {
            return Response.status(404).build(); // Retornar código 404 para indicar que el usuario no fue encontrado
        }
    }
    @GET
    @ApiOperation(value = "insignias", notes = "View Badges")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 401, message = "The user has no badges"),
            @ApiResponse(code = 500, message = "SQL Exception")
    })
    @Path("/listar_insignias_usuario/insignias/{username}")  // Cambié {mail} a {username}
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsignias(@PathParam("username") String username) throws NotInInventoryException {
        try {
            List<Insignia> insignias = this.jm.getInsignias(username);
            GenericEntity<List<Insignia>> entity = new GenericEntity<List<Insignia>>(insignias) {};
            return Response.status(201).entity(entity).build();
        } catch (NotInInventoryException e) {
            return Response.status(401).build();
        }
    }

    /* @GET
    @ApiOperation(value = "View the user's badges", notes = "View Badges")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 401, message = "The user has no badges"),
            @ApiResponse(code = 500, message = "SQL Exception")
    })
    @Path("/listar_insignias_usuario/insignias/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsignias(@PathParam("username") String mail) throws NotInInventoryException {
            List<Insignia> insignias = this.jm.getInsignias(mail);
            GenericEntity<List<Insignia>> entity = new GenericEntity<List<Insignia>>(insignias) {};
            return Response.status(201).entity(entity).build();


    }

    @GET
    @ApiOperation(value = "get all Insignias", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Insignia.class, responseContainer="List"),
    })
    @Path("/listar_insignias_usuario/insignias/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsignias(@PathParam("username") String user) {

        List<Insignia> insignias = jm.getInsignias(user);
        GenericEntity<List<Insignia>> entity = new GenericEntity<List<Insignia>>(insignias) {};
        return Response.status(201).entity(entity).build();

    }*/
    @GET
    @ApiOperation(value = "get all system messages", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Mensaje.class, responseContainer="List"),
    })
    //en el swagger se ve la ruta /usuario/posts get all system messages porque está en el UsuarioService

    @Path("/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMensajesGenerales() {
        List<Mensaje> mensajes = this.jm.getMensajesGenerales();

        GenericEntity<List<Mensaje>> entity = new GenericEntity<List<Mensaje>>(mensajes) {};
        return Response.status(201).entity(entity).build();
    }
    @GET
    @ApiOperation(value = "get mapa", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Mapas.class),
    })
    @Path("/mapas/{idMapa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMapas(@PathParam("idMapa") String idMapa) {
        Mapas mapa = this.jm.getMap(Integer.parseInt(idMapa));
        return Response.status(201).entity(mapa).build();

    }
    @GET
    @ApiOperation(value = "get backpack", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/backpack/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMyBackpack(@PathParam("mail") String mail) {
        List<Objeto> objeto = this.jm.getMyBackpack(mail);
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objeto) {};
        return Response.status(201).entity(entity).build();

    }
}

