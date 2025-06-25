package clases;

public class Alumno {
    private String codigo;
    private String nombre ;
    private String carrera;
    private int edad;

    public Alumno() {
    }

    public Alumno(String codigo, String nombre, String carrera, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.edad = edad;
    }
    //getter
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getEdad() {
        return edad;
    }
    //setter (cuando se necesite)
    
    //

    @Override
    public String toString() {
        return "Alumno{" + "codigo=" + codigo + ", nombre=" + nombre + ", carrera=" + carrera + ", edad=" + edad + '}';
    }
    
    
    
}
