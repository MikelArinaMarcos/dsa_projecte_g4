
package edu.upc.dsa;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.*;

public class TiendaManagerImpl implements TiendaManager{
    private static TiendaManager instance;
    protected Map<String, Objeto> Objetos;
    final static Logger logger = Logger.getLogger(TiendaManagerImpl.class);

    public TiendaManagerImpl() {
        this.Objetos = new HashMap<String, Objeto>();
    }
    public  static TiendaManager getInstance(){
        if (instance==null) instance = new TiendaManagerImpl();
        return instance;
    }
    public List<Objeto> listaObjetos(){
        List<Objeto> lObjetos = new LinkedList<Objeto>(Objetos.values());
        lObjetos.sort((Objeto o1, Objeto o2) -> Integer.compare(o1.getPrecio(),(o2.getPrecio())));
        for(Objeto obj : lObjetos){
            logger.info("Producto: " + obj.getNombre() + " - Precio: " + obj.getPrecio());
        }
        return lObjetos;
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
    public void addProducto(int id, int rareza, String nombre, int precio, int dmg, String url){
        logger.info("Inicializando objeto " + nombre);
        Objeto o = new Objeto(id, rareza, nombre, precio, dmg, url);
        Objetos.put(nombre, o);
    }

    public Objeto getObjeto(String nombre){
        if (Objetos.containsKey(nombre)){
            logger.info(nombre + "found");
            Objeto o = Objetos.get(nombre);
            return o;
        }
        logger.warn(nombre + " not found");
        return null;
    }

    public int productoSize(){
        logger.info("Size productos " + Objetos.size());
        return Objetos.size();
    }

    public Objeto comprarObjeto(Objeto o, Usuario u){
        if (o.getPrecio() > u.getBolivares()){
            logger.info("Estás pobre");
            return null;
        }
/*
        if (u.tieneObjeto(o)) {
            logger.info("Ya tienes el objeto " + o.getNombre());
            return null;
        }*/

        logger.info("Comprando objeto " + o.getNombre());
        u.setBolivares(u.getBolivares() - o.getPrecio());
        //u.addObjeto(o);
        return o;
    }

}
