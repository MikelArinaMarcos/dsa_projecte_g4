package edu.upc.dsa;
import edu.upc.dsa.models.Objeto;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
    public List<Objeto> listaObjetos(){
        Objetos.sort((Objeto o1, Objeto o2) -> Integer.compare(o1.getPrecio(),(o2.getPrecio())));
        for(Objeto obj : Objetos){
            logger.info("Producto: " + obj.getNombre() + " - Precio: " + obj.getPrecio());
        }
        return Objetos;
    }
    public List<Objeto> getProductosTienda(int nivel){
        List<Objeto> oTienda = new LinkedList<Objeto>();
        for (int i = 0 ; i < 5 ; i++){
            Random rand = new Random();
            int n = rand.nextInt(50);
            n = n + nivel*5;
            if(n<=35){
                oTienda.add(Objetos.get(0));
            } else if(35<n && n<=60) {
                oTienda.add(Objetos.get(3));
            }else if(60<n && n<=90){
                oTienda.add(Objetos.get(4));
            }else
                oTienda.add(Objetos.get(6));
        }
        oTienda.sort((Objeto o1, Objeto o2) -> Integer.compare(o1.getPrecio(),(o2.getPrecio())));
        for(Objeto obj : oTienda){
            logger.info("Producto: " + obj.getNombre() + " - Precio: " + obj.getPrecio());
        }
        return oTienda;
    }
    public void addProducto(int id, int rareza, String nombre, int precio, int dmg){
        logger.info("Inicializando objeto " + nombre);
        Objeto o = new Objeto(id, rareza, nombre, precio, dmg);
        Objetos.add(o);
    }
    public int productoSize(){
        logger.info("Size productos " + Objetos.size());
        return Objetos.size();
    }

    @Override
    public List<Objeto> getAllObjects() {
        return this.Objetos;
    }
}
