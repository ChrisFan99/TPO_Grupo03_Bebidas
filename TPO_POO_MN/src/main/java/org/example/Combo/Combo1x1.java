package org.example.Combo;

import org.example.Exception.ComboLimiteAlcanzadoException;
import org.example.Exception.ProductoExistenteException;
import org.example.Producto.Producto;

public class Combo1x1 extends Combo{

    public Combo1x1() {
        super();
        this.nombre = "Combo1x1";
    }

    @Override
    public void agregarProducto(Producto unProducto, int cantidad) throws ProductoExistenteException {
        validarCantidadDeProductos(2);

        if (cantidad >= 2){
            throw new ComboLimiteAlcanzadoException("Este combo unicamnete admite 1 bebida de cada tipo");}

        else if (this.productos.isEmpty()) {
            this.productos.add(unProducto.recrearProductoParaCombo(cantidad));}

        // Verifica si el producto complementario cumple con la regla de alcohol.
        else if (esProductoComplementario(unProducto)) {
            this.productos.add(unProducto.recrearProductoParaCombo(cantidad));}

        else {
            throw new ProductoExistenteException("Se necesita agregar una bebida complementaria");}
    }

    //Metodo chris
    private boolean esProductoComplementario(Producto unProducto) {
        return this.productos.getFirst().esAlcoholica() != unProducto.esAlcoholica();
    }

}
