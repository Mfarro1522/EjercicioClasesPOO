package Clases;

public class ListaTuristas {
	
	private final int MAX = 10;
	Turista [] turistas = new Turista [MAX];
	private int contador = 0 ;
	
	public Turista[] getTuristas() {
		return turistas;
	}
	public void setTuristas(Turista[] turistas) {
		this.turistas = turistas;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	public String agregarTurista(String dni, String nombre, String tipo) {
		if (contador < MAX) {
			turistas[contador] = new Turista(dni, nombre, tipo);
			contador++;
			return "Turista agregado ";
		} else {
			return "No se pueden agregar ";
		}
	}
	
	public String mostrarTuristas() {
		String datos = "";
		for (int i = 0; i < contador; i++) {
			datos += turistas[i].toString() + "\n";
		}
		return datos;
	}
	
	public String registrarCompra(String codigoTurista, String nombreSitio, int numeroEntradas) {
		for (int i = 0; i < contador; i++) {
			if (turistas[i].getDni().equals(codigoTurista)) {
				return turistas[i].agregarCompra(nombreSitio, numeroEntradas);
			}
		}
		return "Turista no encontrado";
	}
	
	public String mostrarCompras(String codigoTurista) {
		for (int i = 0; i < contador; i++) {
			if (turistas[i].getDni().equals(codigoTurista)) {
				return turistas[i].getListaCompras().mostrarCompras();
			}
		}
		return "Turista no encontrado";
	}
	
	
	

}
