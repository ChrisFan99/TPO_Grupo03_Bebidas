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
        System.out.println("El producto se agrego correctamente");
    }

    public void removerProducto(Producto produ){
        bebidas.remove(produ);
        System.out.println("El producto se removio correctamente");
    }

    public String verInformacionDeBebidas(String nombreProducto){
        for (Producto produ : bebidas){
            if (produ.getNombre().equals(nombreProducto)){
                return "1." + produ.getNombre() + "-" +produ.getLitros() + "-" + produ.getCantidad() + "-" + produ.esAlcoholica() + "-" + produ.getVenta() + "-" + produ.getCosto();
            }
        }
        return "No se a encontrado una bebida con ese nombre";
    }

    public String verListadoBebidas(){
        String productoIndividual;
        String listado = "";
        for (Producto produ : bebidas){
            productoIndividual = "1." + produ.getNombre() + "-" +produ.getLitros() + "-" + produ.getCantidad() + "-" + produ.esAlcoholica()+"\n";
            listado = listado + productoIndividual;
        }
        return listado;
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
