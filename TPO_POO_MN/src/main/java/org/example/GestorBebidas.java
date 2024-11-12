package org.example;
import org.example.Producto.Producto;

import java.util.ArrayList;

public class GestorBebidas {

    private ArrayList<Producto> bebidas;



    public GestorBebidas() {
        this.bebidas = new ArrayList<>();
    }

    public void agregarProducto(Producto produ){
        bebidas.add(produ);
    }


    public void clear(){
        bebidas.clear();
        System.out.println("Collecion eliminada correctamente");
    }

    /*public boolean estaContenido(String nombre){
        for (Producto p : bebidas){
            if (p.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    */

}
