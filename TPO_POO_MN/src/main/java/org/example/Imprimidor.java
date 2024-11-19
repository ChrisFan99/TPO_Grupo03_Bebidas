package org.example;

import org.example.Combo.Combo;
import org.example.Producto.Producto;

public class Imprimidor {

    public void imprimirInformacionBebidas(int contador,Producto producto){
        String nombre = producto.getNombre();
        int cantidad = producto.getCantidad();
        boolean esAlcoholica = producto.esAlcoholica();
        float litros = producto.getLitros();
        float venta = producto.getVenta();
        float costo = producto.getCosto();

        System.out.println(contador+"- Nombre: "+nombre+ " _ Cantidad: "+cantidad+ " _ litros: "+litros+ " _ Alcoholica: "+esAlcoholica+ " _ PrecioVenta: $"+venta+ " _ PrecioCosto: $"+costo);
    }

    public void imprimidorInformacionCombo(int contador, Combo combo){
        for (Producto productoIteracion : combo.getProductos()){
            imprimirInformacionBebidas(contador, productoIteracion);
        }
    }

}
