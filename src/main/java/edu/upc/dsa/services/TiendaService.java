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
            this.tm.addProducto(1, 1, "DMG+", 1, 1);
            this.tm.addProducto(2, 1, "Life+", 4, 1);
            this.tm.addProducto(3, 2, "Crit+", 17, 1);
            this.tm.addProducto(4, 2, "Stamina+", 2, 1);
            this.tm.addProducto(5, 3, "Xp+", 999, 1);
            this.tm.addProducto(6, 4, "Fire dmg+", 999, 1);
            this.tm.addProducto(7, 4, "Freeze shot", 999, 1);
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
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 501, message = "Estas pobre")
    })
    @Path("/comprarObjeto/{Mail}/{Objeto}")
    public Response comprarObjeto(@PathParam("Mail") String mail, @PathParam("Objeto") String objeto) {
        Usuario u = jm.getUser(mail);
        Objeto o = tm.getObjeto(objeto);
        int res = tm.comprarObjeto(o,u);
        if(res != 0){
            return Response.status(501).build();
        }
        return Response.status(201).build();
    }
}
