package org.example.Combo;

import org.example.Producto.Producto;

public class Combo1x1 extends Combo{

    public Combo1x1() {
        super();
        this.nombre = "Combo1x1";
    }

    @Override
    protected boolean agregarCombo(Producto... productos) {
        if (productos.length != 2){
            System.out.println("Solo puedes agregar 2 productos (1 bebida con alcohol, 1 bebida con gas)");
        }
        Producto produ1 = productos[0];
        Producto produ2 = productos[1];

        if ((produ1.esAlcoholica() && !produ2.esAlcoholica()) || (!produ1.esAlcoholica() && produ2.esAlcoholica())){
            this.combos.add(produ1);
            this.combos.add(produ2);
            return true;
        }
        else{
            return false;
        }
    }
}
