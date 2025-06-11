package main;

import javax.swing.JOptionPane;
import Clases.ListaTuristas;
import Clases.ListaCompras;
import Clases.ListaMuseos;

/**** @author mauri*/
public class Ejercicio10_ControlVentasMuseos {
	
	static final int MAX = 3;

    public static void main(String[] args) {
    	
    	JOptionPane.showMessageDialog(null, "Bienvenido al Control de Ventas de Museos y Sitios Turísticos");
    	
    	ListaMuseos listaMuseos = new ListaMuseos();
    	llenaryMostrarMuseos(listaMuseos);
    	
    	//listas paralelas 
    	ListaTuristas listaTuristas = new ListaTuristas();
    	ListaCompras listaCompras = new ListaCompras();
    	
    	//turista inicial 
    	JOptionPane.showMessageDialog(null, "Ahora ingrese el primer turistas");
    	op_registrarTurista(listaTuristas);
		JOptionPane.showMessageDialog(null, "Ahora ingrese el primer compra");
		//registramos la primera compra
    	op_registrarCompra(listaTuristas, listaCompras, listaMuseos);
    	
    	int op;

    	do {
    		op = opciones();
    		switch (op) {
    		case 1:
    			op_registrarTurista(listaTuristas);
    			break;
    		case 2:
    			op_registrarCompra(listaTuristas, listaCompras, listaMuseos);
    			break;
    		case 3:
    			op_mostrarCompras(listaTuristas, listaCompras);
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
		
		codigo = JOptionPane.showInputDialog("Ingrese el Dni del turista: ");
		nombre = JOptionPane.showInputDialog("Ingrese el nombre del turista: ");
		tipo = JOptionPane.showInputDialog("Ingrese el Tipo (Local o Nacional) : ");
		
		listaTuristas.agregarTurista(codigo, nombre, tipo);
		
	}
    
    static void llenaryMostrarMuseos(ListaMuseos listaMuseos) {
		
		String codigo, nombre, descripcion, ubicacion;
		
		for (int i = 0; i < MAX; i++) {
			JOptionPane.showMessageDialog(null, "Ingrese los datos del museo o sitio " + (i + 1));
			codigo = JOptionPane.showInputDialog("Ingrese el codigo del museo o sitio: ");
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del museo o sitio: ");
			descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del museo o sitio: ");
			ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion del museo o sitio: ");
			
			listaMuseos.agregarMuseo(codigo, nombre, descripcion, ubicacion);
		}
		
		String datos = listaMuseos.mostrarMuseos();
		JOptionPane.showMessageDialog(null, datos);
	
    }
    
  	static void op_registrarCompra(ListaTuristas listaTuristas, ListaCompras listaCompras, ListaMuseos listaMuseos) {
		
		String codigoTurista, nombreSitio;
		int numeroEntradas;
		
		// Solicitar solo el DNI del turista
		codigoTurista = JOptionPane.showInputDialog("Ingrese el DNI del turista: ");
		
		// Verificar si el turista existe solo con el DNI
		if (!listaTuristas.existeTurista(codigoTurista)) {
			JOptionPane.showMessageDialog(null, "Turista no encontrado. Verifique que el DNI sea correcto.");
			return;
		}
		
		// Mostrar museos disponibles
		String museosDisponibles = listaMuseos.mostrarNombresMuseos();
		nombreSitio = JOptionPane.showInputDialog("Ingrese el nombre del sitio: \n\n" + museosDisponibles);
		
		// Verificar si el museo/sitio existe
		if (!listaMuseos.existeMuseo(nombreSitio)) {
			JOptionPane.showMessageDialog(null, "El museo o sitio ingresado no existe. Verifique el nombre.");
			return;
		}
		
		numeroEntradas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de entradas: "));
		
		String resultado = listaCompras.agregarCompra(codigoTurista, nombreSitio, numeroEntradas);
		JOptionPane.showMessageDialog(null, resultado);
		
	}
 
    static void op_mostrarCompras(ListaTuristas listaTuristas, ListaCompras listaCompras) {
    	String codigos = listaTuristas.mostrarTuristas();
    	String codigoTurista = JOptionPane.showInputDialog("Ingrese el Dni del turista: \n"+codigos);
    	//mostramos codigos de los turistas registrados
    	
    	String resultado = listaCompras.mostrarComprasDelTurista(codigoTurista);
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
