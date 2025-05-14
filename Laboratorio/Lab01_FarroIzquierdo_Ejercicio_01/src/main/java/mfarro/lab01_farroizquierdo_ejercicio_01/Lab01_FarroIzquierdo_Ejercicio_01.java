package mfarro.lab01_farroizquierdo_ejercicio_01;

import java.util.Scanner;
/** @author mauri*/

public class Lab01_FarroIzquierdo_Ejercicio_01 {

	static Scanner entrada = new Scanner(System.in);
	//vamos a limitarnos a la FACFyM
	static final String [] CARRERAS = { "Estadistica", "Matematica", "Fisica" , "CI", "Electronica" };
	
	//Arreglos paralelos
	/*static final int MAXCURSOS = 8; 
	static String[] codigoCurso = new String[MAXCURSOS];
	static String[] nombreCurso = new String[MAXCURSOS]; 
	static int[] creditoCurso = new int[MAXCURSOS];
	static String[] carreraCurso = new String[MAXCURSOS];*/
	
	//Arreglos paralelos (ya inicializados para facilitar la prueba)
	static String[] codigoCurso = { "CYEE1005" , "CYEE1004" , "MATG1002" , "MATE1025" , "BIOG1001" , 
			"CEDG1001" , "CYEE1014" , "ESTG1001"};
	static String[] nombreCurso = {"POO" , "Ing. de Requerimientos" , "Fundamentos Matematicos" ,
			"Logica Matematica" , "Desarrollo Sostenible" , "Desarrollo Personal" ,
             "Soporte de Sofware y Harware" , "Fundamentos de Estadistica" };
	static int[] creditoCurso = { 4 , 4 , 3 , 3 , 3 , 2 , 3 , 3 };
	static String[] carreraCurso = {"CI" , "CI" , "CI" , "CI" ,  "CI" , "CI" ,  "CI" , "CI" };
	
	
    public static void main(String[] args) {
    	
    	System.out.println("****Bienvenido al sistema de cursos (FACFyM)****");
    	//esta parte es para ingresar los datos de manera manual
    	//ingresarDatosCurso(1, codigoCurso, nombreCurso, creditoCurso, carreraCurso);
    	//mostrarDatosCurso(codigoCurso, nombreCurso, creditoCurso, carreraCurso);
    	mostrarMenu();

    }
    //en esta parte se puede agregar las funciones para ingresar los datos y mostrarlos de manera Manual 
    //pero para facilidad del ejercicio se va a los va establecer ya determinados con los valores mis cursos
    //pero si puede quitar las lineas de los comentarios y funcionan
    /*static void ingresarDatosCurso( int carrera ,String[] codigoCurso , String[] nombreCurso, int[] creditoCurso, String[] carreraCurso) {
		for (int i = 0; i < MAXCURSOS; i++) {
			System.out.println("\nCURSO" + (i+1) + " :");
			System.out.print("codigo del curso " + (i+1) + ": ");
			leerCodigo();
			System.out.print("nombre del curso " + (i+1) + ": ");
			nombreCurso[i] = entrada.next();
			System.out.print("creditos del curso " + (i+1) + ": ");
			creditoCurso[i] = entrada.nextInt();
			while (creditoCurso[i] <= 0) {
				System.out.print("Los creditos deben ser mayores a 0");
				creditoCurso[i] = entrada.nextInt();
			}
			carreraCurso[i] = CARRERAS[carrera-1];
		}
	}*/
    
    /*static void mostrarDatosCurso(String[] codigoCurso , String[] nombreCurso, int[] creditoCurso, String[] carreraCurso) {
		System.out.println("****Datos de los cursos****");
		for (int i = 0; i < MAXCURSOS; i++) {
			System.out.println("\nCURSO" + (i+1) + " :");
			System.out.println("Codigo del curso " + (i+1) + ": " + codigoCurso[i]);
			System.out.println("Nombre del curso " + (i+1) + ": " + nombreCurso[i]);
			System.out.println("Creditos del curso " + (i+1) + ": " + creditoCurso[i]);
			System.out.println("Carrera del curso " + (i+1) + ": " + carreraCurso[i]);
		}
	}*/
    
    //Menu de opciones
    static void mostrarMenu() {
    	System.out.println("****Menu de opciones****");
		System.out.println("1. Ver Cursos.");
		System.out.println("2. Ver un curso en particular.");
		System.out.println("3. Modificar un curso.");
		System.out.println("4. Curso con mas creditos.");
		System.out.println("5. Cursos por carrera.");
		System.out.println("6. Total de cursos por carrera.");
		System.out.println("7. Cursos ordenados por creditos.");
		System.out.println("8. Salir.");
		
		System.out.print("Ingrese una opcion: ");
		int opcion = entrada.nextInt();
    	while (opcion != 8) {
			switch (opcion) {
				case 1: mostrarDatosCurso(); break;
				case 2: mostrarDatosCursoEspecifico(); break;
				case 3: modificarDatosCurso(); break;
				case 4: cursoConMasCreditos(); break;
				case 5: cursosPorCarrera(); break;
				case 6: totalCursosPorCarrera(); break;
				case 7: cursosOrdenadosPorCreditos();break;
				default:
					System.out.println("Opcion no valida");
			}
			mostrarMenu();
			opcion = entrada.nextInt();
		}
    }
    
    static void mostrarDatosCurso() {
        System.out.println("\n*** LISTADO DE CURSOS ***");
        for (int i = 0; i < nombreCurso.length; i++) {
            System.out.println("Curso " + (i+1) + ": " +
                    "- Codigo: " + codigoCurso[i] + " " +
                    "- Nombre: " + nombreCurso[i] + " " +
                    "- Creditos: " + creditoCurso[i] + " " +
                    "- Carrera: " + carreraCurso[i]);
        }
        System.out.println();
    }
    
    static void mostrarDatosCursoEspecifico() {
    	boolean encontrado = false;
    	String codigo = leerCodigo();
    	
		
		for (int i = 0; i < nombreCurso.length; i++) {
			if (codigo.equals(codigoCurso[i])) {
				System.out.println("Curso " + (i+1) + ":" +
						"- Codigo: " + codigoCurso[i] +
						"- Nombre: " + nombreCurso[i] +
						"- Creditos: " + creditoCurso[i] +
						"- Carrera: " + carreraCurso[i]);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("El curso no existe");
			//aqui le indicamos los codigos
			System.out.println("Los codigos de los cursos son: ");
			for (int i = 0; i < codigoCurso.length; i++) {
				System.out.println(nombreCurso[i]+" = "+codigoCurso[i]);
			}
		}
	}
   
    static void modificarDatosCurso() {
    	String codigo = leerCodigo();
    	int indice = 0;
    	for (int i = 0; i < nombreCurso.length; i++) {
    		if (codigo.equals(codigoCurso[i])) {
    			indice = i;
    		}
    	}
    	System.out.println("Dato a modificar: ");
    	System.out.println("1. Codigo - 2.Nombre - 3.Creditos - 4.Carrera");
    	int opcion = entrada.nextInt();
    	switch (opcion) {
    	case 1:
			System.out.println("Ingrese el nuevo codigo: ");
			String nuevoCodigo = entrada.next();
			codigoCurso[indice] = nuevoCodigo;
  			break; 
    	case 2:
    		System.out.println("Ingrese el nuevo nombre: ");
    		String nuevoNombre = entrada.next();
    		nombreCurso[indice] = nuevoNombre;
    		break;
    	case 3:
			System.out.println("Ingrese el nuevo credito: ");
			int nuevoCredito = entrada.nextInt();
			while (nuevoCredito <= 0) {
				System.out.println("Los creditos deben ser mayores a 0");
				nuevoCredito = entrada.nextInt();
			};
			creditoCurso[indice] = nuevoCredito;
			break;
		case 4:
			System.out.println("Ingrese la nueva carrera: ");
			System.out.println("1. Estadistica - 2. Matematica - 3. Fisica - 4. CI - 5. Electronica");
			int nuevaCarrera = entrada.nextInt();
			carreraCurso[indice] = CARRERAS[nuevaCarrera-1];
			break;
		default:
			System.out.println("Opcion no valida");
		}
		System.out.println("Curso modificado");
		System.out.println("Curso " + (indice+1) + ":" +
				"- Codigo: " + codigoCurso[indice] +
				"- Nombre: " + nombreCurso[indice] +
				"- Creditos: " + creditoCurso[indice] +
				"- Carrera: " + carreraCurso[indice]);
		
    }
 
    static String leerCodigo() {//funcion para validar 
    	String codigo = "";
    	boolean valido = false;
    	do {
    		System.out.println("Ingrese el codigo del curso (ingrese ayuda para ver codigos) : ");
    		codigo = entrada.next();
    		for (int i = 0; i < codigoCurso.length; i++) {
				if (codigo.equals(codigoCurso[i])) {
					valido = true;
				}
			}
    		if (codigo.equals("ayuda")) {
    			for (int i = 0; i < codigoCurso.length; i++) {
					System.out.println(codigoCurso[i]+" = "+ nombreCurso[i]);
				}
    		}
    	}while (!valido);
    	return codigo;
    }
    
    public static void cursoConMasCreditos() {
		int max = creditoCurso[0];
		int indice = 0;
		for (int i = 1; i < creditoCurso.length; i++) {
			if (creditoCurso[i] > max) {
				max = creditoCurso[i];
				indice = i;
			}
		}
		System.out.println("El curso con mas creditos es: " + nombreCurso[indice] + " con " + max + " creditos");
	}
    
	public static void cursosPorCarrera() {
		System.out.println("Ingrese la carrera: ");
		System.out.println("1. Estadistica - 2. Matematica - 3. Fisica - 4. CI - 5. Electronica");
		int carrera = entrada.nextInt();
		for (int i = 0; i < nombreCurso.length; i++) {
			if (carreraCurso[i].equals(CARRERAS[carrera-1])) {
				System.out.println("Curso " + (i+1) + ":" +
						"- Codigo: " + codigoCurso[i] +
						"- Nombre: " + nombreCurso[i] +
						"- Creditos: " + creditoCurso[i] +
						"- Carrera: " + carreraCurso[i]);
			}
		}
	}
	
	public static void totalCursosPorCarrera() {
		int[] totalCursos = new int[CARRERAS.length];
		for (int i = 0; i < nombreCurso.length; i++) {
			for (int j = 0; j < CARRERAS.length; j++) {
				if (carreraCurso[i].equals(CARRERAS[j])) {
					totalCursos[j]++;
				}
			}
		}
		for (int i = 0; i < CARRERAS.length; i++) {
			System.out.println("Total de cursos de " + CARRERAS[i] + ": " + totalCursos[i]);
		}
	}
	
	//no ordenar los arrays solo mostrar los cursos ordenados por creditos sin modificar los originales
	public static void cursosOrdenadosPorCreditos() {
	    int[] creditosOrdenados = creditoCurso;
	    String[] nombresOrdenados = nombreCurso;
	    
	    for (int i = 0; i < creditosOrdenados.length - 1; i++) {// usamos el algoritmo de burbuja
	        for (int j = 0; j < creditosOrdenados.length - i - 1; j++) {
	            if (creditosOrdenados[j] < creditosOrdenados[j + 1]) {
	                
	                int tempCredito = creditosOrdenados[j];
	                creditosOrdenados[j] = creditosOrdenados[j + 1];
	                creditosOrdenados[j + 1] = tempCredito;
	                
	                String tempNombre = nombresOrdenados[j];
	                nombresOrdenados[j] = nombresOrdenados[j + 1];
	                nombresOrdenados[j + 1] = tempNombre;
	            
	            }
	        }
	    }
	    
	    System.out.println("Cursos ordenados por creditos (de menor a mayor): ");//mostramos los cursos ordenados
	    for (int i = 0; i < creditosOrdenados.length; i++) {
	        System.out.println("Curso " + (i+1) + ": " +
	                "- Nombre: " + nombresOrdenados[i] + " " + "- Creditos: " + creditosOrdenados[i] + " ");
	    }
	}
		
}

