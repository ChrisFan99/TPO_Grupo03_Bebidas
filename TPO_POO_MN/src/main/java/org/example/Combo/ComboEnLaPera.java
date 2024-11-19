package org.example.Combo;

import org.example.Exception.ComboLimiteAlcanzadoException;
import org.example.Exception.ProductoExistenteException;
import org.example.Producto.Producto;

public class ComboEnLaPera extends Combo{

    public ComboEnLaPera() {
        super();
        this.nombre = "ComboEnLaPera";
    }

    @Override
    public void agregarProducto(Producto unProducto, int cantidad) {
        Producto productoAgregar = unProducto.recrearProductoParaCombo(cantidad);

        if (productoAgregar.esAlcoholica()) {

            //Contamos solo las bebidas alcoholicas
            if (contarBebidasTipo(productoAgregar.esAlcoholica()) + productoAgregar.getCantidad() > 6) {
                throw new ComboLimiteAlcanzadoException("El combo unicamente permite 6 productos");}

            boolean productoExiste = false;
            for (Producto productoIteracion : productos){
                if (productoIteracion.getNombre().equals(productoAgregar.getNombre())){
                    productoIteracion.setCantidad(productoIteracion.getCantidad() + productoAgregar.getCantidad());
                    productoExiste = true;
                    break;
                }
            }

            if (!productoExiste) {
                productos.add(productoAgregar);}

        } else {
            throw new ProductoExistenteException("El combo unicamente permite bebidas alcoholicas, esta bebida no se puede agregar al combo");
        }
    }

}
