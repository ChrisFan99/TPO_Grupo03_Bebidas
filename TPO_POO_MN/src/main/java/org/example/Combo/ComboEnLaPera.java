package org.example.Combo;

import org.example.Producto.Producto;

public class ComboEnLaPera extends Combo{

    public ComboEnLaPera() {
        super();
        this.nombre = "ComboEnLaPera";
    }

    @Override
    protected boolean agregarCombo(Producto... productos) {
        if (productos.length <6 || productos.length > 10 ){
            System.out.println("Porfavor ingresar entre 6 y 10 bebidas alcoholicas");
            return false;
        }
        for (Producto producto : productos){
            if (!producto.esAlcoholica()){
                System.out.println("Este combo unicamente admite bebidas alcoholicas");
                return false;
            }
            this.combos.add(producto);
        }
        return true;
    }
}
