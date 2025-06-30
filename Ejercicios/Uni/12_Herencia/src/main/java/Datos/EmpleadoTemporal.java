package Datos;

public class EmpleadoTemporal extends Empleado{
	
	private int DiasporSemana;
	private int Horas;
	private double precioHora; 

	public EmpleadoTemporal() {
	}

	public EmpleadoTemporal(String dni, String nombres, int edad , int numHijos , int DiasporSemana, int Horas , double precioHora ) {
		super(dni, nombres, edad ,numHijos);
		this.DiasporSemana = DiasporSemana;
		this.Horas = Horas;
		this.precioHora=precioHora;
	}
	//gets
	public int getDiasporSemana() {
		return DiasporSemana;
	}
	public int getHoras() {
		return Horas;
	}
	public double getPrecioHora() {
		return precioHora;
	}

	//Sobrecargamos mostrarDatos
	@Override
	public String mostrarDatos() {
		return super.mostrarDatos() + " Dias por semana: " + DiasporSemana + "Horas: " + Horas + " Precio por hora: " + precioHora + "- Sueldo : "+ sueldo;
	}

	@Override
	public void CalcularSueldo() {	

		this.sueldo = DiasporSemana * Horas * precioHora;

		
		
	}



	

	
}
