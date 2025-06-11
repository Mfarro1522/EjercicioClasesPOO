package Clases;

public class ListaMuseos {
	
	private final int MAX = 10;
	private museoycitios[] museos = new museoycitios[MAX];
	private int contador = 0;
	
	public int getContador() {
		return contador;
	}
	
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	public String agregarMuseo(String codigo, String nombre, String descripcion, String ubicacion) {
		if (contador < MAX) {
			museos[contador] = new museoycitios(codigo, nombre, descripcion, ubicacion);
			contador++;
			return "Museo agregado correctamente";
		} else {
			return "No se pueden agregar más museos";
		}
	}
	
	public boolean existeMuseo(String nombre) {
		for (int i = 0; i < contador; i++) {
			if (museos[i].getNombre().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	public String mostrarMuseos() {
		String datos = "";
		for (int i = 0; i < contador; i++) {
			datos += museos[i].toString() + "\n";
		}
		return datos;
	}
	
	public String mostrarNombresMuseos() {
		String nombres = "Museos disponibles:\n";
		for (int i = 0; i < contador; i++) {
			nombres += "- " + museos[i].getNombre() + "\n";
		}
		return nombres;
	}
}
