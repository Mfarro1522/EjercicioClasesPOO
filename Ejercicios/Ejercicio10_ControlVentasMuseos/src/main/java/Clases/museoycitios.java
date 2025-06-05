package Clases;

public class museoycitios {
	
	private String codigo;
	private String nombre;
	private String descripcion;
	private String ubicacion;
	
	public museoycitios(String codigo, String nombre, String descripcion, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "MuseosCitios [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ubicacion="
				+ ubicacion + "]";
	}
	
	
	
	

}
