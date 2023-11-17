package edu.upc.dsa;
import edu.upc.dsa.models.Objeto;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class TiendaManagerImpl implements TiendaManager{
    private static TiendaManager instance;
    protected List<Objeto> Objetos;
    final static Logger logger = Logger.getLogger(TiendaManagerImpl.class);

    public TiendaManagerImpl() {
        this.Objetos = new LinkedList<Objeto>();
    }
    public  static TiendaManager getInstance(){
        if (instance==null) instance = new TiendaManagerImpl();
        return instance;
    }
    public List<Objeto> getProductosTienda(){

        Objetos.sort((Objeto o1, Objeto o2) -> Integer.compare(o1.getPrecio(),(o2.getPrecio())));
        for(Objeto obj : Objetos){
            logger.info("Producto: " + obj.getNombre() + " - Precio: " + obj.getPrecio());
        }
        return Objetos;
    }
    public void addProducto(String nombre, int precio, int dmg){
        logger.info("Inicializando objeto " + nombre);
        Objeto o = new Objeto(nombre, precio, dmg);
        Objetos.add(o);
    }
    public int productoSize(){
        logger.info("Size productos " + Objetos.size());
        return Objetos.size();
    }
}
