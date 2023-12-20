package edu.upc.dsa.services;

import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.TiendaManager;
import edu.upc.dsa.TiendaManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.VOCredenciales;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/tienda", description = "Endpoint to tienda Service")
@Path("/tienda")
public class TiendaService {
    private TiendaManager tm;
    private JuegoManager jm;
    final static Logger logger = Logger.getLogger(TiendaManagerImpl.class);

    public TiendaService() {
        this.tm = TiendaManagerImpl.getInstance();
        this.jm = JuegoManagerImpl.getInstance();
        if (tm.productoSize() == 0) {
            this.tm.addProducto(1, 1, "DMG+", 1, 1,"https://media.istockphoto.com/id/1434218035/es/foto/antena-suburbana-de-austin.jpg?s=612x612&w=0&k=20&c=a2rxyTry_BZR3OwlbxhpCYWGzb4nlHFmCSBhWuSMOAs=");
            this.tm.addProducto(2, 1, "Life+", 4, 1,"https://media.istockphoto.com/id/1295384747/es/vector/hermoso-paisaje-de-monta%C3%B1a-verde-de-agua-de-marea.jpg?s=612x612&w=0&k=20&c=1ZB6dVPl1Phs4VN97SaPcbrrTJvHVh0FvW-alucpzDI=");
            this.tm.addProducto(3, 2, "Crit+", 17, 1,"https://media.istockphoto.com/id/1316663402/es/foto/pareja-de-pie-en-la-playa-y-disfrutando-de-la-puesta-de-sol-de-arriba-hacia-abajo-vista-a%C3%A9rea.jpg?s=612x612&w=0&k=20&c=7VRKBN0oYkNPeaYaVsgGPGVjRIahvpfpjXyWwN17FFM=");
            this.tm.addProducto(4, 2, "Stamina+", 2, 1,"https://media.istockphoto.com/id/1311458015/es/foto/pasillos-oscuros-con-escaleras-iluminadas-subiendo.jpg?s=612x612&w=0&k=20&c=rA-897aCxA9r53TOoSnYGn3o-s5ArTl4FNLj6K7a01Y=");
            this.tm.addProducto(5, 3, "Xp+", 999, 1,"https://media.istockphoto.com/id/1491157294/es/foto/escritorio-a-la-luz-de-una-l%C3%A1mpara-a-altas-horas-de-la-noche.jpg?s=612x612&w=0&k=20&c=GDt8CgB4lgoMH2ym0idl5Po--_MoDHp9-mnP2sdcHto=");
            this.tm.addProducto(6, 4, "Fire dmg+", 999, 1,"https://media.istockphoto.com/id/1346029435/es/foto/vista-de-drones-de-estacionamientos-al-aire-libre.jpg?s=612x612&w=0&k=20&c=Shey0U4oPqHRYLLjV3YhBUrI4ANkKtyBQWvAT3mT80Q=");
            this.tm.addProducto(7, 4, "Freeze shot", 999, 1,"https://media.istockphoto.com/id/1365849981/es/foto/vista-de-alto-%C3%A1ngulo-de-las-dunas-texturizadas-del-desierto-al-amanecer.jpg?s=612x612&w=0&k=20&c=Deel0ejewe1okVHFOw371EmUlrNyMBRHRSuBL1r5KDk=");
        }
    }

    @GET
    @ApiOperation(value = "Get objetos", notes = "Devuelve el listado de todos los objetos por precio")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer = "List"),
    })
    @Path("/objetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaProductos() {
        List<Objeto> objetos = this.tm.listaObjetos();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {
        };
        return Response.status(201).entity(entity).build();
    }

    @PUT
    @ApiOperation(value = "Comprar objeto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objeto.class),
            @ApiResponse(code = 501, message = "Estas pobre")
    })
    @Path("/comprarObjeto/{mail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(Objeto o, @PathParam("mail") String mail) {
        Usuario u = jm.getUser(mail);
        Objeto object = tm.comprarObjeto(o, u);
        if (object == null) {return Response.status(404).build();}
        else {return Response.status(201).entity(o).build();}
    }
}
