package edu.upc.dsa;

import edu.upc.dsa.models.Peticiones;

import java.util.List;

public interface PeticionesManager {
    public int addPeticiones(String date, String title, String message, String sender);
    public int addPeticiones(Peticiones p);
    public List<Peticiones> getAllPeticiones();
    public int sizeP();

}
