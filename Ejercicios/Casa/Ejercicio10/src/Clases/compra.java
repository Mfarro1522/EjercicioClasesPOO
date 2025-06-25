package Clases;

public class compra {
	
	private final int PRECIO_ENTRADA = 10; // Precio fijo de la entrada
	
	private String dniTurista;
	private String nombreSitio;
	int numeroEntradas;
	double PagoTotal;
	
	public compra(String dniTurista, String nombreSitio, int numeroEntradas) {
		super();
		this.dniTurista = dniTurista;
		this.nombreSitio = nombreSitio;
		this.numeroEntradas = numeroEntradas;
		PagoTotal = PRECIO_ENTRADA * numeroEntradas; // Calcular el pago total
	}	
	public String getDniTurista() {
		return dniTurista;
	}

	public void setDniTurista(String dniTurista) {
		this.dniTurista = dniTurista;
	}

	public String getNombreSitio() {
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}

	public int getNumeroEntradas() {
		return numeroEntradas;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
	}
	
	public double getPagoTotal() {
		return PagoTotal;
	}

	@Override
	public String toString() {
		return "nombreSitio :" + nombreSitio + ", numeroEntradas :"
				+ numeroEntradas + ", PagoTotal :" + PagoTotal;
	}

}
