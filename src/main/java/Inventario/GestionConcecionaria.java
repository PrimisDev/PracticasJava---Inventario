package Inventario;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Practicas Java,  sistema de invetario de concecionarias y automoviles
 * @author martin.grasselli
 */

public class GestionConcecionaria {

    public static void main(String[] args) {
        final int MAX_CONCECIONARIAS = 10;
        final int MAX_AUTOS = 5;

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);


        Concecionaria concecionaria[] = new Concecionaria[MAX_CONCECIONARIAS];
        int nroConcecionarias = 0;
        Concecionaria concecionariaAux;
        Auto autoAux;

        Auto auto[] = new Auto[MAX_AUTOS];
        int numeroAutos = 0;

        boolean salir = false;
        int opcion, anioInaguracion, capacidad, cantidadAutos = 0, nroAsientos, idConcecionaria, idAuto;
        int resta;
        int descuento;
        String nombre, direccion;
        double velMaxima;

        while (!salir) { //while para ingresar opciones
            System.out.println("1. Añadir Concecionaria");
            System.out.println("2. Añadir Auto");
            System.out.println("3. Mostrar info de Concecionaria");
            System.out.println("4. Eliminar Autos");
            System.out.println("5. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        if (nroConcecionarias > MAX_CONCECIONARIAS) {
                            System.out.println("No se pueden agregar mas Concecionarias");
                        } else {
                            System.out.println("Escribe el Nombre de una Concecionaria");
                            nombre = sc.next();
                            System.out.println("Escribe la direccion de la Concecionaria");
                            direccion = sc.next();
                            System.out.println("Escribe el Año de inaguracion de la Concecionaria");
                            anioInaguracion = validaNumero(0, Integer.MAX_VALUE);
                            System.out.println("Escribe la cantidad de empleados de la Concecionaria");
                            capacidad = validaNumero(0, Integer.MAX_VALUE);

                            concecionariaAux = new Concecionaria(nombre, direccion, anioInaguracion, capacidad) {
                            };
                            concecionaria[nroConcecionarias] = concecionariaAux;
                            nroConcecionarias++;

                        }
                        break;
                    case 2:
                        if (nroConcecionarias == 0) {
                            System.out.println("No hay Concecionarias");
                        } else {
                            System.out.println("Escribe el modelo del Auto ");
                            nombre = sc.next();
                            System.out.println("Escribe el numero de asientos del Auto ");
                            nroAsientos = validaNumero(0, Integer.MAX_VALUE);
                            System.out.println("Escribe la velocidad maxima del Auto ");
                            velMaxima = sc.nextDouble();
                            System.out.print("Ingresar stock: ");
                            cantidadAutos = sc.nextInt();

                            autoAux = new Auto(nombre, nroAsientos, velMaxima, cantidadAutos);

                            System.out.println("Elige una concecionaria para guardar el auto, seleccione un numero entre 1 y " + nroConcecionarias);
                            mostrarConcecionaria(concecionaria, nroConcecionarias);

                            idConcecionaria = sc.nextInt();

                            concecionariaAux = seleccionarConcecionaria(concecionaria, nroConcecionarias, idConcecionaria);
                            if (concecionariaAux != null) {
                                concecionariaAux.aniadirAuto(autoAux);
                            } else {
                                System.out.println("No existe concecionaria, auto descartado." + "\n");
                            }
                        }
                        break;
                    case 3:
                        if (nroConcecionarias != 0) {
                            System.out.println("Actualmente tienes " + nroConcecionarias + " concecionarias." + "\n" + "Ingresar un valor entre 1 y " + nroConcecionarias + " para consultar:");
                            mostrarConcecionaria(concecionaria, nroConcecionarias);
                            idConcecionaria = sc.nextInt();
                            concecionariaAux = seleccionarConcecionaria(concecionaria, nroConcecionarias, idConcecionaria);
                            if (concecionariaAux != null) {
                                System.out.println(concecionariaAux);
                            } else {
                                System.out.println("No existe concecionaria" + "\n");
                            }
                        } else {
                            System.out.println("Todavia no existen concecionarias" + "\n");
                        }
                        break;
                    case 4:
                        if (nroConcecionarias != 0) {
                            System.out.println("Elige una concecionaria: " + nroConcecionarias + "\n");
                            mostrarConcecionaria(concecionaria, nroConcecionarias);
                            idConcecionaria = sc.nextInt();
                            concecionariaAux = seleccionarConcecionaria(concecionaria, nroConcecionarias, idConcecionaria);
                            if (concecionariaAux != null) {
                                System.out.println("Elige un Auto para eliminar, tienes " + concecionariaAux.getNumeroAutos() + "\n");
                                concecionariaAux.mostrarAutos();
                                idAuto = sc.nextInt(); //aca le digo el id del auto
                                concecionariaAux.getNumeroAutos();
                                if (concecionariaAux.getNumeroAutos() != 0) {
                                    System.out.println("Elige cuantos Autos quieres eliminar, tienes " + cantidadAutos + "\n");
                                    descuento = sc.nextInt(); //aca le digo cuantos quiero eliminar
                                    resta = cantidadAutos - descuento;
                                    System.out.println(descuento + " autos eliminados, te quedan: " + resta + " automoviles" + "\n");

                                    autoAux = new Auto(nombre= "asd", nroAsientos = 5, velMaxima= 150, cantidadAutos = resta);
                                } else {
                                    System.out.println("No tienes autos en esta concecionaria" + "\n");
                                }

                            } else {
                                System.out.println("No existe concecionaria" + "\n");
                            }
                        } else {
                            System.out.println("Todavia no existen concecionarias" + "\n");
                        }
                        break;
                    case 5:
                        System.out.println("Bay Bay!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5" + "\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un numero" + "\n");
                sc.next();
            }
        }
    }

    public static int validaNumero(int minimo, int maximo) { //Funcion para validar numeros
        Scanner sc = new Scanner(System.in);
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
        int numero;
        do {
            System.out.println("Escrie un numero");
            numero = sc.nextInt();
            if (!(numero >= minimo && numero <= maximo)) {
                System.out.println("Debes escribir un numero entre " + minimo + " y " + maximo + "\n");
            }
        } while (!(numero >= minimo && numero <= maximo));
        return numero;
    }

    public static void mostrarConcecionaria(Concecionaria[] concecionarias, int nroConcecionarias) {
        for (int i = 0; i < nroConcecionarias; i++) {
        }

    }

    public static void mostrarAutos(Auto[] autos, int nroAutos) {
        for (int i = 0; i < nroAutos; i++) {

        }

    }

    public static Concecionaria seleccionarConcecionaria(Concecionaria[] concecionarias, int nroConcecionarias, int idConcecionaria) {
        for (int i = 0; i < nroConcecionarias; i++) {
            if (concecionarias[i].getId() == idConcecionaria) {
                return concecionarias[i];
                //Funcion para seleccionar una concecionaria
            }
        }
        return null;
    }

    public static Auto resta(Auto[] autos, int idAuto, int resta) {
        for (int i = 0; i < resta; i++) {
            if (autos[i].getCantidadAutos() == idAuto) {
                return autos[i];
                //funcion para selecionar un auto
            }
        }
        return null;
    }
}

