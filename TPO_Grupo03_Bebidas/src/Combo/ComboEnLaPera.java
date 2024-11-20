package Combo;

import Exception.ComboException;
import Producto.Producto;

public class ComboEnLaPera extends Combo{

    public ComboEnLaPera() {
        super();
        this.nombre = "ComboEnLaPera";
    }

    @Override
    public void agregarProducto(Producto unProducto, int cantidad) {
        Producto productoAgregar = unProducto.recrearProductoParaCombo(cantidad, unProducto.getNombre());

        if (productoAgregar.esAlcoholica()) {

            //Contamos solo las bebidas alcoholicas
            if (contarBebidasTipo(productoAgregar.esAlcoholica()) + productoAgregar.getCantidad() > 6) {
                throw new ComboException("El combo unicamente permite 6 productos");}

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
            throw new ComboException("El combo unicamente permite bebidas alcoholicas, esta bebida no se puede agregar al combo");
        }
    }

}