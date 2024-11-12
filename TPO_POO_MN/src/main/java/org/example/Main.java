package org.example;

import org.example.Producto.Producto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Condicion de corte doWhile
        boolean banderaMenu = true;

        //Input por shell para el usuario
        // Testing commit
        Scanner inputlog = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        Scanner input5 = new Scanner(System.in);
        Scanner input6 = new Scanner(System.in);
        Scanner input9 = new Scanner(System.in);

        //Creacion de clases gesto y combos
        GestorBebidas productos = new GestorBebidas();

        //Bebidas Prueba

        //Combos Prueba

        do {
            System.out.println(menu());
            int opcion = inputlog.nextInt();
            switch (opcion) {
                case 0:
                    banderaMenu = false;
                    break;

                //agregar producto
                case 1:
                    boolean bandera1 = true;
                    do {
                        System.out.println("Seleccionaste la opcion agregar bebida");
                        System.out.print("Ingrese el nombre de la bebida: ");
                        String nombre = input1.nextLine();
                        System.out.print("Ingrese los litos de la bebida: ");
                        float litros = input1.nextFloat();
                        System.out.print("Ingrese si es una bebida alcoholica o gaseosa (true = alcoholica, false = gaseosa)");
                        boolean esAlcoholica = input1.nextBoolean();
                        System.out.print("Ingrese el precio de venta de la bebida: ");
                        float venta = input1.nextFloat();
                        System.out.print("Ingrese el costo de la bebida: ");
                        float costo = input1.nextFloat();
                        System.out.print("Ingrese la cantidad de unidades de bebidas existentes: ");
                        int cantidad = input1.nextInt();
                        productos.agregarProducto(new Producto(nombre, litros, esAlcoholica, venta, costo, cantidad));
                        System.out.println("Le gustaria seguir agregando productos? (Ingrese 0 para volver al menu \n Ingrese 1 para seguir ingresando");
                        int opcionCargarBebida = input1.nextInt();

                        switch (opcionCargarBebida){
                            case 0:
                                bandera1 = false;

                                break;



                        }
                    }while(bandera1);
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    //Debe tener un combo Formado y verificar si no esta vacio el arreglo
                    //combos.removerCombo();
                    break;

                case 11:
                    //Solicitar nombre del producto, mostrar en que combos esta y seleccionar el combo a modificar, luego guardarlo en el arreglo
                    break;

                default:
                    System.out.println("Opcion fuera del rango, ingrese nuevamente una opcion dentro del mismo");

            }

        } while (banderaMenu);
    }

    //Hacer presupuesto
    //Combo activo o inactivo
    //Es apto para combo (Alcoholico, Gaseoso)

    private static String menu(){
        return "\nElija a de las siguientes opciones:\n" +
                " 1.Agregar Producto\n"+
                " 2.Remover Producto (x Cantidad)\n"+
                " 3.Modificar Producto\n"+
                " 4.Informacion de bebidas seleccionada\n"+
                " 5.Ver listado de todas las bebidas\n"+
                " 6.Ganancia de bebida (c/u) \n"+
                " 7.Dinero Total invertido\n"+
                " 8.Consultar todos los combos\n"+
                " 9.Agregar combo\n"+
                " 10.Remover combo\n"+
                " 11.Modificar Combo\n"+
                " 0.Salir";
    }
}