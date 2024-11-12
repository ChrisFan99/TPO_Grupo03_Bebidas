package org.example.Producto;

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

    public boolean isEsAlcoholica() {
        return esAlcoholica;
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
}
