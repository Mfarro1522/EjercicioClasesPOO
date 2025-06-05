package Clases;

public class compra {
	
	private final int PRECIO_ENTRADA = 10; // Precio fijo de la entrada
	
	private String nombreSitio;
	int numeroEntradas;
	double PagoTotal;
	
	public compra(String nombreSitio, int numeroEntradas) {
		super();
		this.nombreSitio = nombreSitio;
		this.numeroEntradas = numeroEntradas;
		PagoTotal = PRECIO_ENTRADA * numeroEntradas; // Calcular el pago total
	}
	
	public double getPagoTotal() {
		return PagoTotal;
	}


	@Override
	public String toString() {
		return "compra [PRECIO_ENTRADA=" + PRECIO_ENTRADA + ", nombreSitio=" + nombreSitio + ", numeroEntradas="
				+ numeroEntradas + ", PagoTotal=" + PagoTotal + "]";
	}
	
	
	
	

}
