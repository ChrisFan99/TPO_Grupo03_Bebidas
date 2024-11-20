import Combo.Combo1x1;
import Combo.ComboCompleto;
import Combo.ComboEnLaPera;
import Producto.Producto;
import Exception.ComboException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Condicion de corte doWhile
        boolean banderaMenu = true;

        //Input por shell para el usuario
        Scanner input = new Scanner(System.in);

        //Creacion de clases gesto y combos
        GestorBebidas productos = new GestorBebidas();

        //Bebidas Prueba
        Producto cocaCola = new Producto("CocaCola", 0.5f, false, 1000, 500, 50);
        Producto sprite = new Producto("Sprite", 0.5f, false, 1000, 500, 50);
        Producto fernet = new Producto("Fernet", 1.7f, true, 3000, 1500, 20);
        Producto gancia = new Producto("Gancia", 1.7f, true, 3000, 1500, 20);

        //Combos Prueba
        Combo1x1 comboCocaFernet = new Combo1x1();
        comboCocaFernet.agregarProducto(cocaCola, 1);
        comboCocaFernet.agregarProducto(fernet, 1);

        ComboEnLaPera combox6Fernet = new ComboEnLaPera();
        combox6Fernet.agregarProducto(fernet, 6);

        //Agregar  y combos
        productos.agregarProducto(cocaCola);
        productos.agregarProducto(sprite);
        productos.agregarProducto(fernet);
        productos.agregarProducto(gancia);
        productos.agregarCombo(comboCocaFernet);
        productos.agregarCombo(combox6Fernet);
        productos.descontarProductos(comboCocaFernet);
        productos.descontarProductos(combox6Fernet);

        do {
            int opcion = obtenerOpcionMenu(input);
            // Delegar todos los case en métodos auxiliares
            switch (opcion) {
                case 0:
                    banderaMenu = false;
                    break;

                case 1:
                    agregarProducto(productos, input);
                    break;

                case 2:
                    removerProducto(productos, input);
                    break;

                case 3:
                    modificarProducto(productos, input);
                    break;

                case 4:
                    informacionBebida(productos, input);
                    break;

                case 5:
                    verListadoBebidas(productos);
                    break;

                case 6:
                    capitalTotalInvertido(productos);
                    break;

                case 7:
                    listarTodosLosCombos(productos);
                    break;

                case 8:
                    agregarCrearCombo(productos, input);
                    break;

                case 9:
                    removerCombo(productos, input);
                    break;

                default:
                    System.out.println("Opcion fuera del rango, ingrese nuevamente una opcion dentro del mismo");
            }

        } while (banderaMenu);

        input.close();
    }

    // Método para obtener la opción del menú de manera segura
    private static int obtenerOpcionMenu(Scanner input) {
        int opcion = -1;
        while (opcion < 0 || opcion > 11) {
            try {
                System.out.println(menu());
                opcion = input.nextInt();
                input.nextLine(); // Limpiar el buffer
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida, por favor ingresa un número.");
                input.nextLine(); // Limpiar el buffer en caso de error
            }
        }
        return opcion;
    }

    private static String menu() {
        return "\nElija una de las siguientes opciones:\n" +
                "1. Agregar Nuevo Producto\n" +
                "2. Remover Producto\n" +
                "3. Modificar Producto (Cantidad, Costo, Venta)\n" +
                "4. Información de Bebidas Seleccionadas\n" +
                "5. Ver Listado de Todas las Bebidas\n" +
                "6. Capital Total Invertido\n" +
                "7. Listar Todos los Combos\n" +
                "8. Agregar/Crear Combo\n" +
                "9. Remover Combo\n" +
                "0. Salir";
    }


    // Métodos auxiliares para cada acción del menú

    //Case1
    private static void agregarProducto(GestorBebidas productos, Scanner input) {
        boolean bandera1 = true;
        do {
            try {
                try {
                    System.out.println("\nSeleccionaste la opcion 'agregar producto'");
                    System.out.println("--------------------------------------------------------------------------------");
                    boolean perdida = true, seguirAgregandoProductos = false;

                    //Nobre y validacion con excepciones
                    System.out.print("Ingrese el nombre de la bebida: ");
                    String nombre = input.nextLine();
                    if (productos.estaElProducto(nombre)) {
                        throw new ComboException("El nombre ingresado ya pertenece a un objeto en stock, reiniciando la carga de datos........");
                    }

                    //litros y validacion con excepciones
                    System.out.print("Ingrese los litos de la bebida: ");
                    float litros = input.nextFloat();
                    input.nextLine();
                    if (litros < 0) {
                        throw new ComboException("No se permite ingresar litros negativos, reinciando la carga de datos......");
                    }

                    //Alcolica o no, la validacion lo hace la excepcion del tipo de dato
                    System.out.print("Ingrese si es una bebida alcoholica o gaseosa (true = alcoholica, false = gaseosa): ");
                    boolean esAlcoholica = input.nextBoolean();
                    input.nextLine();

                    float venta = 0, costo = 0;
                    //Precio de venta y su validacion con excepciones
                    System.out.print("Ingrese el precio de venta de la bebida: $");
                    venta = input.nextFloat();
                    input.nextLine();
                    if (venta < 0) {
                        throw new ComboException("El precio de venta no puede ser negativo, reiniciando carga de datos..........");
                    }

                    //Costo del producto y su validacion con excepciones
                    System.out.print("Ingrese el costo de la bebida: $");
                    costo = input.nextFloat();
                    input.nextLine();
                    if (costo < 0) {
                        throw new ComboException("El costo no puede ser negativo, reiniciando carga de datos..........");
                    }

                    if (venta < costo) {
                        throw new ComboException("El precio de venta es menor al costo ingresado, reiniciando carga de datos..........");
                    }

                    //Cantidad y su validacion con excepciones
                    System.out.print("Ingrese la cantidad de unidades de bebidas existentes: ");
                    int cantidad = input.nextInt();
                    input.nextLine();
                    if (cantidad < 0) {
                        throw new ComboException("No se permite ingresar cantidades negativas, reiniciando la carga de datos........");
                    }

                    //Crear producto y agregar el gestor
                    productos.agregarProducto(new Producto(nombre, litros, esAlcoholica, venta, costo, cantidad));

                    System.out.println("Le gustaria seguir agregando productos? (Ingrese 0 para volver al menu \n Ingrese 1 para seguir ingresando)");
                    do {
                        int opcionCargarBebida = input.nextInt();
                        switch (opcionCargarBebida) {
                            case 0:
                                bandera1 = false;
                                seguirAgregandoProductos = false;
                                break;
                            case 1:
                                seguirAgregandoProductos = false;
                                break;
                            default:
                                System.out.print("Ingreso una opcion diferente, ingrese nuevamente alguna de las 2 opciones (Ingrese 0 para volver al menu \n Ingrese 1 para seguir ingresando): ");
                                seguirAgregandoProductos = true;
                        }
                    } while (seguirAgregandoProductos);
                } catch (InputMismatchException | ComboException e) {
                    if (e.getMessage() == null) {
                        System.out.println("Error: Ingreso de un tipo de dato incorrecto");
                    } else {
                        System.out.println("Error: " + e.getMessage());
                    }
                    input.nextLine(); // Limpiar el buffer
                    System.out.println("Por favor, ingrese los datos nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (bandera1);
    }

    //Case2
    private static void removerProducto(GestorBebidas productos, Scanner input) {
        boolean bandera2 = true;
        do {
            try {
                System.out.println("\nSeleccionaste la opcion 'Remover producto'");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Le gustaria ver todos los productos en stock? Ingrese 'si' o 'no'");
                String opcionVerProductos = input.nextLine();
                switch (opcionVerProductos) {
                    case "si":
                        productos.verListadoBebidas();
                        break;
                    case "no":
                        break;
                    default:
                        throw new ComboException("El parametro ingresado no corresponde a lo solicitado por consola, porfavor volver a ingresar");
                }

                System.out.print("Ingresar el nombre del producto a remover: ");
                String nombre2 = input.nextLine();
                //Verificacion si se encuentra dentro del metodo
                productos.removerProducto(nombre2);
                bandera2 = false;

            } catch (InputMismatchException | ComboException e) {
                if (e.getMessage() == null) {
                    System.out.println("Ingrese el tipo de dato solicitado, reiniciando opcion 2.....");
                } else {
                    System.out.println("Error: " + e.getMessage());
                }
                input.nextLine(); // Limpiar el buffer
                System.out.println("Por favor, ingrese los datos nuevamente.");
            }

        } while (bandera2);
    }

    //Case3
    private static void modificarProducto(GestorBebidas productos, Scanner input) {
        boolean bandera3 = true;
        do {
            try {
                System.out.println("\nSelecciono la opcion 'Modificar un producto'");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Ingresar el nombre del producto a modificar: ");
                String nombre = input.nextLine();
                productos.verInformacionDeBebidas(nombre);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Seleccione cual de estas 3 opciones le gustaria modificar (1. Cantidad - 2. Precio de Venta - 3.Valor de costo) ");
                int opcion3 = input.nextInt();
                switch (opcion3) {
                    case 1:
                        System.out.println("Ingrese la cantidad a modificar: ");
                        int nuevaCantidad = input.nextInt();
                        if (nuevaCantidad < 0) {
                            throw new ComboException("No se puede ingresar cantidades negativas, reinciando programa");
                        }
                        productos.buscarProducto(nombre).setCantidad(nuevaCantidad);
                        bandera3 = false;
                        break;
                    case 2:
                        System.out.println("Ingrese el precio de venta a modificar: ");
                        float nuevoPrecioDeVenta = input.nextFloat();
                        if (nuevoPrecioDeVenta < 0) {
                            throw new ComboException("No se puede ingresar un precio de venta negativo, reinciando programa");
                        }
                        productos.buscarProducto(nombre).setVenta(nuevoPrecioDeVenta);
                        bandera3 = false;
                        break;
                    case 3:
                        System.out.println("Ingrese el costo del producto a modificar: ");
                        float nuevoCosto = input.nextFloat();
                        if (nuevoCosto < 0) {
                            throw new ComboException("No se puede ingresar un costo del producto negativo, reinciando programa");
                        }
                        productos.buscarProducto(nombre).setCosto(nuevoCosto);
                        bandera3 = false;
                        break;
                    default:
                        throw new ComboException("Opcion ingresada fuera del rango, profavor ingrese una de las 3 opciones (1. Cantidad - 2. Precio de Venta - 3.Valor de costo), reiniciando programna......");
                }
            } catch (InputMismatchException | ComboException e) {
                if (e.getMessage() == null) {
                    System.out.println("Ingrese el tipo de dato solicitado, reiniciando ingreso de datos.....");
                } else {
                    System.out.println("Error: " + e.getMessage());
                }
                input.nextLine(); // Limpiar el buffer
                System.out.println("Por favor, ingrese los datos nuevamente.");
            }
        } while (bandera3);
    }

    //Case4
    private static void informacionBebida(GestorBebidas productos, Scanner input) {
        try {
            System.out.println("\nSelecciono la opcion 'Informacion de bebida seleccionada'");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Ingrese el nombre de la bebida para obtener su informacion: ");
            String nombreProducto = input.nextLine();
            if (!productos.estaElProducto(nombreProducto)) {
                throw new ComboException("El nombre ingresado no corresponde a ningun producto en stock, volviendo al menu.......");
            }
            productos.verInformacionDeBebidas(nombreProducto);
        } catch (InputMismatchException | ComboException e) {
            if (e.getMessage() == null) {
                System.out.println("Ingrese el tipo de dato solicitado, Volviendo al menu........");
            } else {
                System.out.println("Error: " + e.getMessage());
            }
            input.nextLine(); // Limpiar el buffer
            System.out.println("Por favor, ingrese los datos nuevamente.");
        }

    }

    //Case5
    private static void verListadoBebidas(GestorBebidas productos) {
        System.out.println("\nSelecciono la opcion 'Ver listado de bebidas'");
        System.out.println("--------------------------------------------------------------------------------");
        productos.verListadoBebidas();
    }

    //Case6
    private static void capitalTotalInvertido(GestorBebidas productos) {
        System.out.println("\nSelecciono la opcion 'Capital total invertido'");
        System.out.println("--------------------------------------------------------------------------------");
        float totalInvertido = productos.verTotalInvertido();
        System.out.println("El total invertido en stock es de: $" + totalInvertido);
    }

    //Case7
    private static void listarTodosLosCombos(GestorBebidas productos) {
        System.out.println("\nSelecciono la opcion 'Listar todos los combos'");
        System.out.println("--------------------------------------------------------------------------------");
        productos.verListadoCombos();

    }

    //Case8
    private static void agregarCrearCombo(GestorBebidas productos, Scanner input) {
        System.out.println("\nSelecciono la opcion 'Agregar/Crear Combo'");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Ingrese que tipo de combo le gustaria crear: (1. combo1x1 - 2. comboEnLaPera - 3.comboCompleto)");
        try {
            int opcionVerCombo = input.nextInt();
            input.nextLine(); // Limpiar el salto de línea residual
            switch (opcionVerCombo) {
                case 1:
                    System.out.println("Selecciono el combo 1x1");
                    System.out.println("Ingrese el nombre del producto que le gustaria agregar: (tener en cuenta que se agregara automaticamente 1 de c/u)");
                    boolean bandera91 = true;
                    Combo1x1 comboCreacion = new Combo1x1();

                    do {
                        try {
                            System.out.println("Primer producto");
                            String nombreProducto1 = input.nextLine();

                            // Buscar productos en el stock
                            Producto producto1 = productos.buscarProducto(nombreProducto1);

                            // Si no se encuentran, lanzar una excepción
                            if (producto1 == null) {
                                throw new ComboException("El producto no se encuentra en stock, reiniciando programa...");
                            }

                            System.out.println("Segundo producto");
                            String nombreProducto2 = input.nextLine();

                            Producto producto2 = productos.buscarProducto(nombreProducto2);

                            if (producto2 == null) {
                                throw new ComboException("El producto no se encuentra en stock, reiniciando programa...");
                            }

                            if ((!producto1.esAlcoholica() && !producto2.esAlcoholica()) || (producto1.esAlcoholica() && producto2.esAlcoholica())) {
                                throw new ComboException("No se puede agregar ya que son 2 productos complementarios, reiniciando programa......");
                            }

                            comboCreacion.agregarProducto(producto1, 1);
                            comboCreacion.agregarProducto(producto2, 1);

                            productos.descontarProductos(comboCreacion);

                            System.out.println("La creación del combo 1x1 se finalizó correctamente");
                            productos.agregarCombo(comboCreacion);
                            bandera91 = false;

                        } catch (ComboException exception) {
                            System.out.println("Error: " + exception.getMessage() + " Por favor, ingrese los datos nuevamente.");
                            input.nextLine(); // Limpiar el buffer después de una excepción

                        }
                    } while (bandera91);
                    break;

                case 2:
                    System.out.println("Selecciono el comboEnLaPera");
                    System.out.println("Se le solicitara que ingrese continuamente el producto y la cantidad que le gustaria para el combo");
                    boolean bandera92 = true;
                    ComboEnLaPera comboCreacionEnLaPera = new ComboEnLaPera();

                    do {
                        try {
                            System.out.println("Ingresar nombre del producto: ");
                            String nombreProducto = input.nextLine();
                            Producto producto = productos.buscarProducto(nombreProducto);
                            if (producto == null) {
                                throw new ComboException("No se encontró un producto con el nombre seleccionado.");
                            }

                            System.out.println("Ingrese la cantidad del producto: ");
                            int cantidadProducto = input.nextInt();
                            input.nextLine(); // Limpiar el buffer

                            comboCreacionEnLaPera.agregarProducto(producto, cantidadProducto);

                            if (comboCreacionEnLaPera.cantidadBebidasCombo() == 6) {
                                System.out.println("La creación del combo se finalizó correctamente");
                                productos.agregarCombo(comboCreacionEnLaPera);
                                productos.descontarProductos(comboCreacionEnLaPera);
                                bandera92 = false;
                            } else {
                                System.out.println("Producto agregado al combo correctamente. Vuelva a ingresar un nuevo producto.");
                            }

                        } catch (ComboException exception) {
                            System.out.println("Error: " + exception.getMessage());
                            input.nextLine(); // Limpiar el buffer
                        } catch (InputMismatchException exception) {
                            System.out.println("Entrada inválida. Por favor, ingrese la cantidad correctamente.");
                            input.nextLine(); // Limpiar el buffer
                        }
                    } while (bandera92);
                    break;

                case 3:
                    System.out.println("Selecciono el comboCompleto");
                    System.out.println("Se le solicitara que ingrese continuamente el producto y la cantidad que le gustaria para el combo");
                    boolean bandera93 = true;
                    ComboCompleto comboCompleto = new ComboCompleto();

                    do {
                        try {
                            System.out.println("Ingresar nombre del producto: ");
                            String nombreProducto = input.nextLine();
                            Producto producto = productos.buscarProducto(nombreProducto);
                            if (producto == null) {
                                throw new ComboException("No se encontró un producto con el nombre seleccionado.");
                            }

                            System.out.println("Ingrese la cantidad del producto: ");
                            int cantidadProducto = input.nextInt();
                            input.nextLine(); // Limpiar el buffer

                            comboCompleto.agregarProducto(producto, cantidadProducto);

                            if (comboCompleto.cantidadBebidasCombo() == 18) {
                                System.out.println("La creación del combo se finalizó correctamente");
                                productos.agregarCombo(comboCompleto);
                                productos.descontarProductos(comboCompleto);
                                bandera93 = false;
                            } else {
                                System.out.println("Producto agregado al combo correctamente. Vuelva a ingresar un nuevo producto.");
                            }

                        } catch (ComboException exception) {
                            System.out.println("Error: " + exception.getMessage());
                            input.nextLine(); // Limpiar el buffer
                        } catch (InputMismatchException exception) {
                            System.out.println("Entrada inválida. Por favor, ingrese la cantidad correctamente.");
                            input.nextLine(); // Limpiar el buffer
                        }
                    } while (bandera93);
                    break;

                default:
                    System.out.println("El parámetro ingresado no corresponde a lo solicitado por consola.");
            }
        } catch (InputMismatchException | ComboException e) {
            if (e.getMessage() == null) {
                System.out.println("Error: Ingreso de un tipo de dato incorrecto. Volviendo al menu.......");
            } else {
                System.out.println("Error: " + e.getMessage());
            }
            input.nextLine(); // Limpiar el buffer
        }
    }

    //Case9
    private static void removerCombo(GestorBebidas productos, Scanner input) {
        System.out.println("\nSelecciono la opcion 'Remover combo'");
        System.out.println("--------------------------------------------------------------------------------");
        boolean bandera9 = false;
        do {
            try {
                productos.verListadoCombos();
                System.out.println("Ingrese la posicion del combo que le gustaria eliminar: ");
                int posicion = input.nextInt();

                input.nextLine();  // limpiar el buffer

                productos.removerCombo(posicion);
                bandera9 = false;

            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("Ingrese el tipo de dato solicitado, reiniciando opcion 9........");
                input.nextLine(); // Limpiar el buffer
                bandera9 = true;
            } catch (ComboException exception) {
                System.out.println("Error: " + exception.getMessage());
                input.nextLine(); // Limpiar el buffer
                bandera9 = true;
            }
        } while (bandera9);
    }
}

