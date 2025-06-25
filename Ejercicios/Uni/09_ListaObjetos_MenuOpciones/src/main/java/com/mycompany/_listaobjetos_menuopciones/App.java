package com.mycompany._listaobjetos_menuopciones;

import javax.swing.JOptionPane;

import clases.Alumno;
import clases.ListaAlumnos;

public class App {

	public static void main(String[] args) {

		int op;
		ListaAlumnos lista = new ListaAlumnos();

		do {
			op = opciones();
			switch (op) {
			case 1:
				op_agregarAlumno(lista);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, lista.presentar());
				break;
			case 3:
				op_buscarAlumnoPorCodigo(lista);
				break;
			case 4:
				op_presentarAlumnosPorCarrera(lista);
				break;
			case 5:
				op_totalAlumnosPorCarrera(lista);
				break;
			case 6:
				op_OrdenarPorCarrera(lista);
				break;
			case 7:
				JOptionPane.showMessageDialog(null, "Saliendo del programa...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
			}
		} while (op != 7);


	}


	public static void op_agregarAlumno(ListaAlumnos lista) {

		Alumno  nuevo;
		String codigo , nombre , carrera ;
		int edad;

		//verificar si la lista esta llena
		if (lista.hayEspacio()) {

			codigo = JOptionPane.showInputDialog("Ingrese el codigo del alumno:");
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
			carrera = JOptionPane.showInputDialog("Ingrese la carrera del alumno:");
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno:"));

			//instanciar el objeto Alumno
			nuevo = new Alumno(codigo, nombre, carrera, edad);
			lista.Agregar(nuevo);
			JOptionPane.showMessageDialog(null, "Alumno agregado correctamente");

		}else {
			JOptionPane.showMessageDialog(null, "La lista de alumnos esta llena");
		}
	}

	static void op_buscarAlumnoPorCodigo(ListaAlumnos lista) {
		String codigo = JOptionPane.showInputDialog("Ingrese el codigo del alumno a buscar:");
		JOptionPane.showMessageDialog(null, lista.encontrarPorCodigo(codigo));
		
	}
	
	static void op_presentarAlumnosPorCarrera(ListaAlumnos lista) {
		String carrera = JOptionPane.showInputDialog("Ingrese la carrera de los alumnos a presentar:");
		JOptionPane.showMessageDialog(null, lista.presentarPorCarrera(carrera));
	}
	
	static void op_totalAlumnosPorCarrera(ListaAlumnos lista) {
		// Muestra la cantidad de alumnos por carrera
		int cantidad = lista.getContador();

		if (cantidad == 0) {
			JOptionPane.showMessageDialog(null, "No hay alumnos registrados!!!");
		}
		
		String [] carrerasUnicas = lista.CarrerasUnicas();
		
		JOptionPane.showMessageDialog(null, lista.AlumnosPorCarrera(carrerasUnicas));
		
		
	}
	
	static void op_OrdenarPorCarrera(ListaAlumnos lista) {
		// Muestra la cantidad de alumnos por carrera
		int cantidad = lista.getContador();

		if (cantidad == 0) {
			JOptionPane.showMessageDialog(null, "No hay alumnos registrados!!!");
		}
		
		String [] carrerasUnicas = lista.CarrerasUnicas();
		
		JOptionPane.showMessageDialog(null, lista.OrdenarAlumnosPorCarrera(carrerasUnicas));
		
		
	}

	static int opciones() {
		String menu = "1. Agregar Alumno\n"
				+ "2. Mostrar Alumnos\n"
				+ "3. Buscar Alumno por Codigo\n"
				+ "4. Presentar alumnos Por Carrera\n"
				+ "5. Total alumnos por carrera\n"
				+ "6. Ordenar alumnos por carrera\n"
				+ "7. Salir";
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return opcion;
	}

}

