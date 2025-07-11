package Clases;

public class ListaCompras {
	
	private final int MAX = 10;
	compra [] listaCompras = new compra[MAX];
	private int contador = 0 ;
	

	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	public String agregarCompra(String nombreSitio, int numeroEntradas) {
		if (contador < MAX) {
			listaCompras[contador] = new compra(nombreSitio, numeroEntradas);
			contador++;//aumentamos el contador 
			return "Total " + listaCompras[contador-1].getPagoTotal() +" . Compra agregada"; //restamos para no apuntar al array vacio si no al anterior que justamente es que que encontramos
		} else {
			return "No se pueden agregar";
		}
	}
	
	public String mostrarCompras() {
		String datos = "";
		for (int i = 0; i < contador; i++) {
			datos += listaCompras[i].toString() + "\n";
		}
		return datos;
	}
	
	
	

}
