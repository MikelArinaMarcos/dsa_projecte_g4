package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;

import java.util.List;

public interface TiendaManager {
    public List<Objeto> listaObjetos();
    public List<Objeto> getProductosTienda(int nivel);
    public void addProducto(int id, int rareza, String nombre, int precio, int dmg);
    public int productoSize();
}
