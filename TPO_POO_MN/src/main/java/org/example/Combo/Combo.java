package org.example.Combo;

import org.example.Producto.Producto;

import java.util.ArrayList;

public abstract class Combo implements InterfaceCombo{

    protected String nombre;

    protected int cantidad;

    protected ArrayList<Producto> combos;

    public Combo(){
        this.combos = new ArrayList<>();
    }

    protected abstract boolean agregarCombo(Producto... productos);

    protected boolean tieneBebidas(){
        if (combos.isEmpty()){
            return true;
        }
        return false;
    }

    protected int cantidadBebidas(){
        if (combos.isEmpty()){
            return 0;
        }
        return combos.toArray().length;
    }


}
