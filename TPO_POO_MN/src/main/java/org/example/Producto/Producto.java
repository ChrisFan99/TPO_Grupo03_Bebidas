package org.example.Producto;

import org.example.Exception.ProductoExistenteException;

public class Producto {

    protected String nombre;

    protected int cantidad;

    protected float litros;

    protected boolean esAlcoholica;
    protected float venta;

    protected float costo;

    public Producto(String nombre, float litros, boolean esAlcoholica, float venta, float costo, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.litros = litros;
        this.esAlcoholica = esAlcoholica;
        this.venta = venta;
        this.costo = costo;
    }

    public Producto recrearProductoParaCombo(int cantidad){
        if (cantidad == 0){
            throw new ProductoExistenteException("No se puede producir el combo si el producto no tiene stock");
        }
        this.cantidad -= cantidad;
        return new Producto(this.nombre, this.litros, this.esAlcoholica, this.venta, this.costo, cantidad);
    }

    public boolean esAlcoholica() {
        return esAlcoholica;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getLitros() {
        return litros;
    }

    public float getVenta() {
        return venta;
    }

    public float getCosto() {
        return costo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setVenta(float venta) {
        this.venta = venta;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
