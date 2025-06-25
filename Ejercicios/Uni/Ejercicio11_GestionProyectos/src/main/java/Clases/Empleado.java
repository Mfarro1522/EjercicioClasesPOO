package Clases;

public class Empleado {
	
	private int dni;
	private String nombre; 
	private String domicilio;
	private String genero;
	private int edad;
	private int indiceFuncion;
	
	private String [] funciones = { "Lider" , "Analista" , "Personal de planta"};
	
	public Empleado(int dni, String nombre, String domicilio, String genero, int edad, int indiceFuncion) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.genero = genero;
		this.edad = edad;
		this.indiceFuncion = indiceFuncion;
	}

	public Empleado() {
	}
	public int getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getGenero() {
		return genero;
	}
	
	public int getEdad() {
		return edad;
	}

	public int getIndiceFuncion() {
		return indiceFuncion;
	}
		public String[] getFunciones() {
		return funciones;
	}
	
	@Override
	public String toString() {
		return "DNI: " + dni + " | Nombre: " + nombre + " | Distrito: " + domicilio + " | Genero: " + genero
				+ " | Edad: " + edad + " | Funcion: " + funciones[indiceFuncion];
	}
}
