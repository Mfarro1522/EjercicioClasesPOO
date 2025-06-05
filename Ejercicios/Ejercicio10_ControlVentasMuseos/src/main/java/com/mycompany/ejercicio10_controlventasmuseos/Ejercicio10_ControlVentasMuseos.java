package com.mycompany.ejercicio10_controlventasmuseos;

import javax.swing.JOptionPane;

import Clases.ListaTuristas;
import Clases.museoycitios;

/**** @author mauri*/
public class Ejercicio10_ControlVentasMuseos {
	
	static final int MAX = 3;

    public static void main(String[] args) {
    	
    	JOptionPane.showMessageDialog(null, "Primero ingrese los museos o sitios de interes");
    	
    	museoycitios [] museosycitios = new museoycitios[MAX];
    	llenaryMostrarMuseos(museosycitios);
    	
    	//turistas 
    	ListaTuristas listaTuristas = new ListaTuristas();
    	//turista inicial 
    	JOptionPane.showMessageDialog(null, "Ahora ingrese el primer turistas");
    	op_registrarTurista(listaTuristas);
    	
    	int op;
    	
    	do {
			op = opciones();
			switch (op) {
			case 1:
				op_registrarTurista(listaTuristas);
				break;
			case 2:
				op_registrarCompra(listaTuristas);
				break;
			case 3:
				op_mostrarCompras(listaTuristas);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "saliendo del programa...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "opcion no valida");
			}
		} while (op != 4);
    	
    	
        
    }
    
    static void op_registrarTurista(ListaTuristas listaTuristas) {
    	
    	String codigo, nombre, tipo;
		
		codigo = JOptionPane.showInputDialog("Ingrese el codigo del turista: ");
		nombre = JOptionPane.showInputDialog("Ingrese el nombre del turista: ");
		tipo = JOptionPane.showInputDialog("Ingrese el Tipo (Local o Nacional) : ");
		
		listaTuristas.agregarTurista(codigo, nombre, tipo);
		
	}
    
    static void llenaryMostrarMuseos(museoycitios [] museosycitios) {
		
		String codigo, nombre, descripcion, ubicacion;
		
		for (int i = 0; i < museosycitios.length; i++) {
			codigo = JOptionPane.showInputDialog("Ingrese el codigo del museo o sitio: ");
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del museo o sitio: ");
			descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del museo o sitio: ");
			ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion del museo o sitio: ");
			
			museosycitios[i] = new museoycitios(codigo, nombre, descripcion, ubicacion);
		}
		
		String datos = "";
		for (int i = 0 ; i < museosycitios.length ; i++) {
		datos = datos + museosycitios[i].toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, datos);
	
    }
    
    static void op_registrarCompra(ListaTuristas listaTuristas) {
		
		String codigoTurista, nombreSitio;
		int numeroEntradas;
		
		codigoTurista = JOptionPane.showInputDialog("Ingrese el codigo del turista: ");
		nombreSitio = JOptionPane.showInputDialog("Ingrese el nombre del sitio: ");
		numeroEntradas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de entradas: "));
		
		String resultado = listaTuristas.registrarCompra(codigoTurista, nombreSitio, numeroEntradas);
		JOptionPane.showMessageDialog(null, resultado);
		
	}
    
    static void op_mostrarCompras(ListaTuristas listaTuristas) {
    	String codigoTurista = JOptionPane.showInputDialog("Ingrese el codigo del turista: ");
    	String resultado = listaTuristas.mostrarCompras(codigoTurista);
    	JOptionPane.showMessageDialog(null, resultado);
    }
    
 
    
    static int opciones() {
		String menu = "1. Registrar Turista \n"+
				"2. Registrar Compra \n"+
				"3. Mostrar Compras \n"+
				"4. Salir" ;
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return opcion;
	}
}
