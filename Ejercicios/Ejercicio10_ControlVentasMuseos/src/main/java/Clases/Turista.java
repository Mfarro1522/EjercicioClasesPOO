package Clases;


public class Turista {
	private String Dni;
	private String nombre;
	private String Tipo;
	
	private ListaCompras listaCompras;
	

	public Turista(String dni, String nombre, String tipo) {
		super();
		Dni = dni;
		this.nombre = nombre;
		Tipo = tipo;
		
		listaCompras = new ListaCompras();
	}

	

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	

	public ListaCompras getListaCompras() {
		return listaCompras;
	}



	public void setListaCompras(ListaCompras listaCompras) {
		this.listaCompras = listaCompras;
	}



	@Override
	public String toString() {
		return "Turista [Dni=" + Dni + ", nombre=" + nombre + ", Tipo=" + Tipo + ", listaCompras="
				+ listaCompras.mostrarCompras() + "]";
	}
	
	public String agregarCompra(String nombreSitio, int numeroEntradas) {
		return listaCompras.agregarCompra(nombreSitio, numeroEntradas);
	}


	
	

}
