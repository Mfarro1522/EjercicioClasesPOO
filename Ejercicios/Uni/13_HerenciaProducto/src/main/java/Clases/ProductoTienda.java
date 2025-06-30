package Clases;

public class ProductoTienda extends Producto {

    private String nombreTienda;
    private String nombreEstante;

    public ProductoTienda() {
        super();
        this.nombreTienda = "";
        this.nombreEstante = "";
    }

    public ProductoTienda(String codigo, String nombre, String descripcion, double precio, String categoria, String nombreTienda, String nombreEstante) {
        super(codigo, nombre, descripcion, precio, categoria);
        this.nombreTienda = nombreTienda;
        this.nombreEstante = nombreEstante;
    }

    //getters
    public String getNombreTienda() {
        return nombreTienda;
    }
    public String getNombreEstante() {
        return nombreEstante;
    }
    

	@Override
    public String mostarProducto() {
    	
    	return super.mostarProducto() + "Nombre de Tienda :" + nombreTienda + ", nombreEstante :" + nombreEstante;
    }
}
