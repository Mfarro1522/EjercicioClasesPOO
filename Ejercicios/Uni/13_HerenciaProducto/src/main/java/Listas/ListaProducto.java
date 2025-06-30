package Listas;

import Clases.Producto;

public class ListaProducto {

    private Producto[] productos;
    private final int  MAX = 20;
    private int contador ;
    
	public ListaProducto() {
		this.productos = new Producto [MAX];
		contador = 0;
	}
	
	  private boolean hayEspacio() {//mejor practica daniel es un cholo
        return contador < MAX;
    }
    
    public String agregarProducto(Producto producto) {
        if (hayEspacio()) {
            productos[contador] = producto;
            contador++;
            return "Producto Agregado Correctamente";
        } else {
            return "No se pueden agregar más productos, lista llena.";
        }
    }
	
	public String mostrarProductos() {
		String datos = "";
		for (int i = 0; i < contador; i++) {
			datos += "\n"+productos[i].mostarProducto();
		}
		return datos;
	}


}
