package Clases;

public class Pago {
	private int indiceMes;
	private int horas;
	private double monto;
	private int dniEmpleado;
	private String codigoProyecto;
	
	private final String [] Meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }; 
	
	public Pago() {
		
	}
	
	public Pago(int indiceMes, int horas, double monto, int dniEmpleado, String codigoProyecto) {
		this.indiceMes = indiceMes;
		this.horas = horas;
		this.monto = monto;
		this.dniEmpleado = dniEmpleado;
		this.codigoProyecto = codigoProyecto;
	}
	public int getIndiceMes() {
		return indiceMes;
	}

	public int getHoras() {
		return horas;
	}

	public double getMonto() {
		return monto;
	}
	
	public int getDniEmpleado() {
		return dniEmpleado;
	}
	
	public String getCodigoProyecto() {
		return codigoProyecto;
	}
	@Override
	public String toString() {
		return "Mes: " + Meses[indiceMes] + " | Horas: " + horas + " | Monto: $" + monto + " | Proyecto: " + codigoProyecto;
	}
	
	
	

}
