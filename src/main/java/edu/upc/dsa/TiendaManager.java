package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface TiendaManager {
    public List<Objeto> listaObjetos();
    public List<Objeto> getProductosTienda(int nivel);
    public void addProducto(int id, int rareza, String nombre, int precio, int dmg, String url);
    public Objeto getObjeto(String nombre);
    public int productoSize();
    public Objeto comprarObjeto(Objeto o, Usuario u);
}
