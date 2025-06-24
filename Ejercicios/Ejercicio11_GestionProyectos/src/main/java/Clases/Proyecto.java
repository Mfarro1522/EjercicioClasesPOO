package Clases;

public class Proyecto {
	private String codigo;
	private String descripcion;
	private double precioBase;
	private int indiceTipo;
	private int mesInicio;
	
	private String [] tipos = { "Programacion" , "Ciencia de Datos" , "Redes" , "IA"};
	private int[] dniEmpleados;
	private int cantidadEmpleados;
	private final int MAX_EMPLEADOS = 8; // 1 líder + 2 analistas + 5 personal de planta
	
	public Proyecto() {
		dniEmpleados = new int[MAX_EMPLEADOS];
		cantidadEmpleados = 0;
	}
	public Proyecto(String codigo, String descripcion, double precioBase, int indiceTipo, int mesInicio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioBase = precioBase;
		this.indiceTipo = indiceTipo;
		this.mesInicio = mesInicio;
		dniEmpleados = new int[MAX_EMPLEADOS];
		cantidadEmpleados = 0;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public int getIndiceTipo() {
		return indiceTipo;
	}
	
	public int getMesInicio() {
		return mesInicio;
	}

	public String[] getTipos() {
		return tipos;
	}

	public int[] getDniEmpleados() {
		return dniEmpleados;
	}
	
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}
	
	public boolean agregarEmpleado(int dni) {
		// Verificar que no esté lleno
		if (cantidadEmpleados >= MAX_EMPLEADOS) return false;
		
		// Verificar que el empleado no esté ya asignado
		for (int i = 0; i < cantidadEmpleados; i++) {
			if (dniEmpleados[i] == dni) return false;
		}
		
		dniEmpleados[cantidadEmpleados] = dni;
		cantidadEmpleados++;
		return true;
	}
	
	public double calcularSalario(int funcion, int horas) {
		double salarioBase = precioBase * horas;
		switch (funcion) {
			case 0: return salarioBase * 1.5; // Líder: 50% adicional
			case 1: return salarioBase * 1.2; // Analista: 20% adicional
			case 2: return salarioBase; // Personal de planta: precio base
			default: return salarioBase;
		}
	}
	
	@Override
	public String toString() {
		return "Codigo: " + codigo + " | Descripcion: " + descripcion + " | Precio Base: $" + precioBase
				+ " | Tipo: " + tipos[indiceTipo] + " | Mes Inicio: " + (mesInicio + 1) + " | Empleados: " + cantidadEmpleados;
	}
}
