import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    //vectores paralelos que almacenan los datos del cine
    static String[] TITULOSENEMICION = {"El Padrino", "El Pianista", "La vida es bella", "Coraline", "Cars"};
    static String[] GENEROSAASIGNAR = {"Accion", "Drama", "Drama", "Aventura", "Comedia"};
    static char[] letraId = {'A', 'B', 'C', 'D', 'E'}; // N para Interstellar para evitar duplicidad de prefijo
    static int[] MAX_ENTRADAS = {5, 3, 4, 2, 6}; // Máximo de entradas por película
    static final double [] PRECIOSENTRADA = {10.0, 12.0, 8.0, 9.0, 7.0}; // Precios de las entradas por película

    //este vector me facilita la creacion de la funcion de contar entrada por pelicula
    static int[] contadorportitulo = new int[TITULOSENEMICION.length]; // tambien para crear los id
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("****Boleteria del Cine****");

        System.out.print("Numero de Compras (0-10) : ");
        int cantidadCompras = entrada.nextInt(); // Solo lee el numero y no el salto de linea
        if (cantidadCompras > 10) {
            System.out.println("Demasiadas Compras Intenta de nuevo");
            //return; una forma
            System.exit(0); //otra
        }
        entrada.nextLine(); // por eso aca lo consumimos para que no salte de linea cuando pida el nombre del cliente

        System.out.println("Peliculas disponibles:");
        for (int j = 0; j < TITULOSENEMICION.length; j++) {
            System.out.println((j + 1) + ". " + TITULOSENEMICION[j] + " - " + GENEROSAASIGNAR[j] + " - s/." + PRECIOSENTRADA[j]);
         }

        // Vectores paralelos para almacenar los datos de cada compra
        String[] nombres = new String[cantidadCompras];
        String[] titulosticket = new String[cantidadCompras];
        String[] generosticket = new String[cantidadCompras];
        String[] idticket = new String[cantidadCompras];

        ingresarDatosCompra(cantidadCompras, nombres, titulosticket, generosticket, idticket);
        mostrarDatosCompra(cantidadCompras, nombres, titulosticket, generosticket, idticket);
        mostrarContadorEntradas();
        ventaEntradas(cantidadCompras, nombres, titulosticket, generosticket, idticket);
    }

    // Función para ingresar datos de compra
    public static void ingresarDatosCompra(int cantidadCompras, String[] nombres, String[] titulos,
                                           String[] generos, String[] id) {
        for (int i = 0; i < cantidadCompras; i++) {
            System.out.println("\n--- Compra N° : " + (i + 1) + " ---");
            System.out.print("Nombre del cliente: ");
            nombres[i] = entrada.nextLine();

            int indice = leerPelicula();

            titulos[i] = TITULOSENEMICION[indice];
            generos[i] = GENEROSAASIGNAR[indice]; // asignamos generos dependiendo ya que titulosenemision y generospor peliculas tambien son paralelos

            contadorportitulo[indice]++;
            //letra id tambien es paralelo con titulosenemision y generospoepelicuas
            id[i] = letraId[indice] + "" + contadorportitulo[indice];
        }
    }

    // Función para validar el título de la película
    public static int leerPelicula() {
        int opcion = -1;
        int indice = -1;

        while (indice == -1) {
            System.out.print("Seleccione una Pelicula: ");

            opcion = entrada.nextInt();
            entrada.nextLine(); // de igual manera consumimos el salto de linea

            if (opcion >= 1 && opcion <= TITULOSENEMICION.length) {
                 int indiceSeleccionado = opcion - 1;
                 if (contadorportitulo[indiceSeleccionado] < MAX_ENTRADAS[indiceSeleccionado]) {
                    indice = indiceSeleccionado;
                 } else {
                    System.out.println("disculpe'" + TITULOSENEMICION[indiceSeleccionado] + "' ya esta lleno");
                 }
            } else {
                System.out.println("opcion no valida seleccione una de estas opciones");
                for (int i = 0; i < TITULOSENEMICION.length; i++) {
                    System.out.println((i + 1) + ". " + TITULOSENEMICION[i]);
                }
            }
        }
        return indice;
    }

    // Función para mostrar los datos de todas las compras
    public static void mostrarDatosCompra(int cantidadCompras, String[] nombresClientes, String[] titulosPeliculas,
                                          String[] generosPeliculas, String[] idsPeliculas) {
        System.out.println("\n--- Ticket de compras ---");
        if (cantidadCompras == 0) {
            System.out.println("no se realizo ninguna compra");
            return;
        }
        for (int i = 0; i < cantidadCompras; i++) {
            System.out.println("\nCompra N° " + (i + 1));
            System.out.println("Nombre del Cliente: " + nombresClientes[i]);
            System.out.println("Pelicula: " + titulosPeliculas[i]);
            System.out.println("Genero: " + generosPeliculas[i]);
            System.out.println("ID: " + idsPeliculas[i]);
        }
    }   
    //funcion para mostrar el contador de entradas por pelicula
    public static void mostrarContadorEntradas() {
        System.out.println("\n--- Contador de entradas por película ---");
        for (int i = 0; i < TITULOSENEMICION.length; i++) {
           if(contadorportitulo[i] > 0) {
            System.out.println("Pelicula: " + TITULOSENEMICION[i]);
            System.out.println("Entradas vendidas: " + contadorportitulo[i]);
            }
        }
    }


    //funcion para la venta de entradas
    public static void ventaEntradas(int cantidadCompras, String[] nombresClientes, String[] titulosPeliculas,
                                      String[] generosPeliculas, String[] idsPeliculas) {
        System.out.println("\n--- Resumen de la compra ---");
        if (cantidadCompras == 0) {
            System.out.println("no se realizo ninguna compra");
            return;
        }
        //mostramos el resumen de la compra cantidad de entradas por pelicula apoyados del Id
        for (int i = 0; i < TITULOSENEMICION.length; i++) {
            if(contadorportitulo[i] > 0) {
                System.out.println("\n"+contadorportitulo[i]+" tickets comprados de " + TITULOSENEMICION[i] );
                System.out.println("Total por pelicula: s/." + (contadorportitulo[i] * PRECIOSENTRADA[i]));
            }
        }
        //mostramos el total recaudado
        double totalRecaudado = 0;
        for (int i = 0; i < TITULOSENEMICION.length; i++) {
            totalRecaudado += contadorportitulo[i] * PRECIOSENTRADA[i];
        }
        System.out.println("\nTotal recaudado: s/." + totalRecaudado);
       
    }
}

