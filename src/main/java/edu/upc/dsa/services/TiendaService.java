package edu.upc.dsa.services;

import edu.upc.dsa.TiendaManager;
import edu.upc.dsa.TiendaManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Personaje;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/tienda", description = "Endpoint to tienda Service")
@Path("/tienda")
public class TiendaService {
    private TiendaManager tm;
    final static Logger logger = Logger.getLogger(TiendaManagerImpl.class);

    public TiendaService() {
        this.tm = TiendaManagerImpl.getInstance();
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

    @GET
    @ApiOperation(value = "Get objetos tienda", notes = "Devuelve un listado de objetos de la tienda en orden ascendiente de precio")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer = "List"),
    })
    @Path("/objetosTienda")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductosTienda() {
        int nivel = 9;
        List<Objeto> objetos = this.tm.getProductosTienda(nivel);
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {
        };
        return Response.status(201).entity(entity).build();
    }

}
