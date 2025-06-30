package Clases;

public class ProductoOnline extends Producto {

    private double descuento;
    private int stock;

    public ProductoOnline() {
        super();
        this.descuento = 0.0;
        this.stock = 0;
    }

    public ProductoOnline(String codigo, String nombre, String descripcion, double precio, String categoria, double descuento, int stock) {
        super(codigo, nombre, descripcion, precio, categoria);
        this.descuento = descuento;
        this.stock = stock;
    }

    //getter 
    public double getDescuento() {
        return descuento;
    }
    public int getStock() {
        return stock;
    }
   

	@Override
    public String mostarProducto() {
    	
    	return super.mostarProducto() + "Nombre de Tienda :" + "descuento :" + descuento + ", stock :" + stock;
    }

   

}
