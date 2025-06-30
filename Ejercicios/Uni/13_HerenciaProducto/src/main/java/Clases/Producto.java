package Clases;

public abstract class Producto {
	
	
	protected String codigo;
	protected String nombre;
	protected String descripcion;
	protected double precio;
	protected String categoria;
	
	public Producto() {
	
	}

	public Producto(String codigo, String nombre, String descripcion, double precio, String categoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public String mostarProducto() {
		return "Codigo : " + codigo + ", nombre :" + nombre + ", descripcion :" + descripcion + ", precio :" + precio + ", categoria :"
				+ categoria;
	}
	
	

	

}
