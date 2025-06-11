package Clases;

public class Turista {
	private String Dni;
	private String nombre;
	private String Tipo;

	public Turista(String dni, String nombre, String tipo) {
		super();
		Dni = dni;
		this.nombre = nombre;
		Tipo = tipo;
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
	
	@Override
	public String toString() {
		return "Dni : " + Dni + ", nombre : " + nombre + ", Tipo : " + Tipo;
	}
}
