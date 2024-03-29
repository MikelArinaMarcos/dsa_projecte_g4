package edu.upc.dsa;
import edu.upc.dsa.bbdd.Sesion;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.DAO.BackpackDAO;
import edu.upc.dsa.DAO.BackpackDAOImpl;
import edu.upc.dsa.models.*;
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
        ObjetosDAO objetosDAO = new ObjetosDAOImpl();
        List<Objeto> lObjetos = objetosDAO.getObjetos();
        if (lObjetos != null) {
            logger.info("Va la lista lokete");
        }
        /*List<Objeto> lObjetos = new LinkedList<Objeto>(Objetos.values());
        lObjetos.sort((Objeto o1, Objeto o2) -> Integer.compare(o1.getPrecio(),(o2.getPrecio())));
        for(Objeto obj : lObjetos){
            logger.info("Producto: " + obj.getNombre() + " - Precio: " + obj.getPrecio());
        }*/
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
    public int comprobarObjetoBackpack(Objeto o, Usuario u){
        logger.info("comprobando objeto único");
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        List<Backpack> backpack = usuarioDAO.getObjetosBackpack(u.getMail());

        for (Backpack mochila : backpack) {
            // Supongamos que getIdItems devuelve el ID del objeto en la mochila
            int idItem = mochila.getIdItems();
            if (idItem == o.getId()) {
                logger.info("Tienes este objeto");
                return 1;
            }
        }
        return 0;
    }
    public Objeto comprarObjeto(Objeto o, Usuario u){
        BackpackDAO backpackDAO = new BackpackDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        if (o.getPrecio() > u.getBolivares()){
            logger.info("Estás pobre");
            return null;
        }
        /*if (u.tieneObjeto(o)) {
            logger.info("Ya tienes el objeto " + o.getNombre());
            return null;
        }*/
        int res = backpackDAO.addItem(u.getMail(),o.getId());
        if (res == 0){
            logger.info("Objeto añadido a la mochila");
        }
        logger.info("Comprando objeto " + o.getNombre());
        u.setBolivares(u.getBolivares() - o.getPrecio());
        Usuario uActualizado= usuarioDAO.updateUsuario(u, u.getMail());
        //u.addObjeto(o);
        return o;
    }
}

