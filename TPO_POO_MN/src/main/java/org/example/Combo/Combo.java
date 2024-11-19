package org.example.Combo;

import org.example.Exception.ComboLimiteAlcanzadoException;
import org.example.Producto.Producto;

import java.util.ArrayList;

public abstract class Combo implements InterfaceCombo{

    protected String nombre;

    protected ArrayList<Producto> productos;

    public Combo(){
        this.productos = new ArrayList<>();
    }

    public abstract void agregarProducto(Producto unProducto, int cantidad);

    protected void validarCantidadDeProductos(int limite) {
        int cantidadProductos = 0;
        for (Producto productoInteraccion : productos){
            cantidadProductos += productoInteraccion.getCantidad();

            if (cantidadProductos >= limite) {
                throw new ComboLimiteAlcanzadoException("El combo ha alcanzado el límite de productos. Unicamente admite "+limite + " productos");
            }
        }
        System.out.println("Es posible seguir agregando productos, puede agregar "+(limite - cantidadProductos)+ " productos");
    }

    protected int contarBebidasTipo(boolean esAlcoholica){
        int contador = 0;
        for (Producto productoIteraccion : productos){
            if (productoIteraccion.esAlcoholica() == esAlcoholica) {
                contador += productoIteraccion.getCantidad();
            }
        }
        return contador;
    }

    public int cantidadBebidasCombo(){
        int contador = 0;
        for (Producto productoInteracion : productos){
            contador += productoInteracion.getCantidad();
        }
        return contador;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }
}
