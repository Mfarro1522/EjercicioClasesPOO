package Clases;

public class ListaTuristas {
	
	private final int MAX = 10;
	private Turista [] turistas = new Turista [MAX];
	private int contador = 0 ;
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
	
	public boolean existeTurista(String dni) {
		for (int i = 0; i < contador; i++) {
			if (turistas[i].getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeTuristaCompleto(String dni, String nombre) {
		for (int i = 0; i < contador; i++) {
			if (turistas[i].getDni().equals(dni) && turistas[i].getNombre().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	public String mostrarTuristas() {
		String datos = "";
		for (int i = 0; i < contador; i++) {
			datos += turistas[i].toString() + "\n";		}
		return datos;
	}
}
