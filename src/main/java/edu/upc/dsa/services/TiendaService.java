package edu.upc.dsa.services;

import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import edu.upc.dsa.models.Objeto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/tienda", description = "Endpoint to tienda Service")
@Path("/tienda")
public class TiendaService {
    private JuegoManager tm;
    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    public TiendaService(){
        this.tm = JuegoManagerImpl.getInstance();
        if(tm.productoSize() == 0){
            this.tm.addProducto("Baguette", 1, 1);
            logger.info("Creado objeto Baguette");
            this.tm.addProducto("Espada rota", 4, 1);
            logger.info("Creado objeto Espada rota");
            this.tm.addProducto("Machete", 17, 1);
            logger.info("Creado objeto Machete");
            this.tm.addProducto("Palo", 2, 1);
            logger.info("Creado objeto Palo");
            this.tm.addProducto("Mjolnir", 999, 1);
            logger.info("Creado objeto Mjolnir");
        }
    }

    @GET
    @ApiOperation(value = "Get objetos tienda", notes = "Devuelve un listado de objetos de la tienda en orden ascendiente de precio")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/productos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductos() {
        List<Objeto> objetos = this.tm.getProductosTienda();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build()  ;
    }
}
