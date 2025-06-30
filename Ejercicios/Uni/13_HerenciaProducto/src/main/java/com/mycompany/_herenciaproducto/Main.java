package com.mycompany._herenciaproducto;

import javax.swing.JOptionPane;

import Clases.ProductoOnline;
import Clases.ProductoTienda;
import Listas.ListaProducto;

public class Main {

    public static void main(String[] args) {
        
    	ListaProducto lp = new ListaProducto();
    	
    	int op ;
    	
    	do {
    		op = opciones();
    		
    		switch (op) {
			case 1:
			int tipo ;

			do {
				tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de Producto \n1.Producto de Tienda\n2.Producto Online"));
				if (tipo==1) {
					String codigo = JOptionPane.showInputDialog("Ingrese el codigo del producto");
					String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
					String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
					double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
					String categoria = JOptionPane.showInputDialog("Ingrese la categoria del producto");
					String nombreTienda = JOptionPane.showInputDialog("Ingrese el nombre de la tienda");
					String nombreEstante = JOptionPane.showInputDialog("Ingrese el nombre del estante");
					
					ProductoTienda pt = new ProductoTienda(codigo, nombre, descripcion, precio, categoria, nombreTienda, nombreEstante);
					lp.agregarProducto(pt);
					
				} else if (tipo==2) {
					String codigo = JOptionPane.showInputDialog("Ingrese el codigo del producto");
					String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
					String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
					double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
					String categoria = JOptionPane.showInputDialog("Ingrese la categoria del producto");
					double descuento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el descuento del producto"));
					int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto"));
					
					ProductoOnline po = new ProductoOnline(codigo, nombre, descripcion, precio, categoria, descuento, stock);
					lp.agregarProducto(po);	
				} else {
					JOptionPane.showMessageDialog(null, "Tipo de Producto no valido");
				}

			}while (tipo != 1 && tipo != 2);
				
				break;
			case 2:
				JOptionPane.showMessageDialog(null, lp.mostrarProductos());
				
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Saliendo..");
				
				return;
				
			default:
				JOptionPane.showMessageDialog(null, "Opcion no Valida");
				break;
			}
			
		} while (op !=3);
    	
    	
    }
    
    public static int opciones() {
    	
    	String menu = "1.Agregar Producto \n"+
    	"2.Mostrar Productos \n"+
    	"3.Salir";
    	
    	int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
    	return op;

	}
    
    
}
