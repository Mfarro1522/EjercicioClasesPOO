package Clases;

public class ListaPagos {
	
	private Pago[] pagos;
	private int contadorPagos;

	public ListaPagos() {
		pagos = new Pago[10];
		contadorPagos = 0;
	}

	public void agregarPago(Pago pago) {
		if (contadorPagos < pagos.length) {
			pagos[contadorPagos] = pago;
			contadorPagos++;
		} else {
			System.out.println("No se pueden agregar más pagos.");
		}
	}

	public Pago[] getPagos() {
		return pagos;
	}

	public int getContadorPagos() {
		return contadorPagos;
	}
	
	public Pago buscarPago(int indiceMes) {
		for (int i = 0; i < contadorPagos; i++) {
			if (pagos[i].getIndiceMes() == indiceMes) {
				return pagos[i];
			}
		}
		return null; 
	}

}
