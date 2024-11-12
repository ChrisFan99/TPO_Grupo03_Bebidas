package org.example.Combo;

import org.example.Producto.Producto;

import java.util.Arrays;

public class ComboCompleto extends Combo{

    private int cantVasos;

    private float pesoHielo;

    public ComboCompleto(Combo combo) {
        if (combo.cantidadBebidas() == 2){
            this.nombre = "ComboCompleto1x1";
            this.cantVasos = 4;
            this.pesoHielo = 0.5f;
        }
        else if (combo.cantidadBebidas() > 6 && combo.cantidadBebidas() < 10) {
            this.nombre = "ComboCompletoEnLaPera";
            this.cantVasos = combo.cantidadBebidas() * 2;
            this.pesoHielo = combo.cantidadBebidas() * 0.25f;
        }
        else{
            throw new RuntimeException("Error al cargar un combo, revisar el codigo");
        }
    }

    @Override
    protected boolean agregarCombo(Producto... productos) {
        if (productos.length == 2){
            Producto produ1 = productos[0];
            Producto produ2 = productos[1];
            this.combos.add(produ1);
            this.combos.add(produ2);
            return true;
        }
        else {
            this.combos.addAll(Arrays.asList(productos));
            return true;
            }
    }
}
