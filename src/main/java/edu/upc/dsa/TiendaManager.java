package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;

import java.util.List;

public interface TiendaManager {
    public List<Objeto> getProductosTienda();
    public void addProducto(String nombre, int precio, int dmg);
    public int productoSize();
}
