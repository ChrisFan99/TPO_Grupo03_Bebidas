package org.example;
import org.example.Combo.Combo;
import org.example.Exception.ComboLimiteAlcanzadoException;
import org.example.Exception.ProductoExistenteException;
import org.example.Producto.Producto;

import java.util.ArrayList;
import java.util.HashSet;

public class GestorBebidas {

    private HashSet<Producto> bebidas;

    private ArrayList<Combo> combos;

    private Imprimidor imprimidorinfo;

    public GestorBebidas() {
        this.bebidas = new HashSet<>();
        this.combos = new ArrayList<>();
        this.imprimidorinfo = new Imprimidor();
    }

    //Verifica si hay un producto con ese nombre
    public boolean estaElProducto(String nombre){
        for (Producto productoInteracion : bebidas){
            if (productoInteracion.getNombre().equals(nombre))
                return true;
        }
        return false;
    }

    //Busca el producto en la coleccion comparando con el nombre pasado de parametro
    public Producto buscarProducto(String nombreProducto){
        if (!estaElProducto(nombreProducto)){
            throw new ProductoExistenteException("No se a encontrado un producto con ese nombre");
        }
        for (Producto elProducto : bebidas){
            if (elProducto.getNombre().equals(nombreProducto)){
                return elProducto;
            }
        }
        throw new ProductoExistenteException("Error desconocido, revisar el codigo");
    }

    //Agrega un producto a la coleccion, en casp de ya encontrarlo tira excepcion
    public void agregarProducto(Producto unProducto){
        if (estaElProducto(unProducto.getNombre())){
            throw new ProductoExistenteException("El producto ya se encuentra en Stock, en caso de modificar algun parametro ingresar a la opcion 3");
        }
        bebidas.add(unProducto);
        System.out.println("El producto se agrego correctamente =)");
    }

    //Remueve un producto de la coleccion, en caso de no encontrarlo
    public void removerProducto(String nombreProducto){
        if (!estaElProducto(nombreProducto)){
            throw new ProductoExistenteException("No se a encontrado un producto con ese nombre");
        }
        Producto productoAEliminar = buscarProducto(nombreProducto);
        bebidas.remove(productoAEliminar);
        System.out.println("El producto se removio correctamente");
    }

    //Muestra (a traves del imprimidor) la informaciion de la bebida solicitada, usando el nombre pasado como parametro para comparar
    public void verInformacionDeBebidas(String nombreProducto){
        int contador = 1;
        boolean bandera = true;
        for (Producto elProducto : bebidas){
            if (elProducto.getNombre().equals(nombreProducto)){
                imprimidorinfo.imprimirInformacionBebidas(contador, elProducto);
                bandera = false;
                break;
            }
        }
        if (bandera) {
            throw new ProductoExistenteException("No se a encontrado ningun producto con ese nombre");
        }
    }

    //Muestra (a traves del imprimidor) todas las bebidas en la coleccion
    public void verListadoBebidas(){
        int contador = 1;
        for (Producto produ : bebidas){
            imprimidorinfo.imprimirInformacionBebidas(contador, produ);
            contador ++;
            }
    }

    public void agregarCombo(Combo comboParaAgregar){
        combos.add(comboParaAgregar);
    }

    public void verListadoCombos(){
        int contador = 1;
        for (Combo comboInteracion : combos){
            imprimidorinfo.imprimidorInformacionCombo(contador, comboInteracion);
            contador ++;
        }
    }

    public float verTotalInvertido(){
        float total = 0;

        for (Producto productoIteracion : bebidas){
            total += (productoIteracion.getCosto()*productoIteracion.getCantidad());
        }

        for (Combo comboIteracion : combos){
            for (Producto productoEnCombo : comboIteracion.getProductos()) {
                total += (productoEnCombo.getCosto()*productoEnCombo.getCantidad());
            }
        }
        return total;
    }

    public void removerCombo(int posicion){
        if (posicion < 1 || posicion > combos.size()){
            throw new ComboLimiteAlcanzadoException("Selecciono una opcion fuera del rango, vuelva a ingresar el combo a eliminar");
        }
        combos.remove(posicion-1);
        System.out.println("Se elimino correctamente el combo");
    }

    public void descontarProductos(Combo combo){
        for (Producto productoCombo : combo.getProductos()){
            for (Producto productoStock : bebidas){
                if (productoStock.getNombre().equals(productoCombo.getNombre())){
                    productoStock.setCantidad(productoStock.getCantidad() - productoCombo.getCantidad());
                }
            }
        }
    }

    public void modificarCombo(int posicion, Producto producto){
        if (posicion < 1 || posicion > combos.size()){
            throw new ComboLimiteAlcanzadoException("Seleccionó una opción fuera del rango, vuelva a ingresar el combo a modificar");
        }
        for(Producto productoIteracion : combos.get(posicion).getProductos()){
            if (productoIteracion.getNombre().equals(producto.getNombre())){

            }
        }
    }
}
