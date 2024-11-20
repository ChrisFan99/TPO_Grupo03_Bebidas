package Combo;

import Exception.ComboException;
import Producto.Producto;

public class ComboCompleto extends ComboEnLaPera{

    public ComboCompleto() {
        super();
        this.nombre = "Combo Completo";
    }

    @Override
    public void agregarProducto(Producto unProducto, int cantidad) {
        Producto productoAgregar = unProducto.recrearProductoParaCombo(cantidad, unProducto.getNombre());
        validarCantidadDeProductos(18);

        if (productoAgregar.esAlcoholica() && contarBebidasTipo(productoAgregar.esAlcoholica()) + productoAgregar.getCantidad() <= 6) {
            this.productos.add(productoAgregar);}

        else if (!productoAgregar.esAlcoholica()){
            if (contarBebidasTipo(false) + productoAgregar.getCantidad() <= 12){
                if (productos.contains(productoAgregar)){
                    boolean productoExiste = false;
                    for (Producto productoIteracion : productos){
                        if (productoIteracion.getNombre().equals(productoAgregar.getNombre())) {
                            productoIteracion.setCantidad(productoIteracion.getCantidad() + productoAgregar.getCantidad());
                            productoExiste = true;
                            break;}

                    }
                }
                else{
                    productos.add(productoAgregar); //Si no existe, lo agregamos
                }
            }
            else {
                throw new ComboException("Este combo unicamente acepta 12 bebidas sin alcohol");}
        }

        else{
            throw new ComboException("Este combo unicamente qcepta 6 bebidas alcoholicas");}

    }
}


