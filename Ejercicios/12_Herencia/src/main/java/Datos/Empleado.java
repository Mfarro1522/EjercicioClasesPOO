
package Datos;

//SuperClase - Clase Padre
public class Empleado {
    private String dni;
    private String nombres;
    private int edad;

    public Empleado() {
    }

    public Empleado(String dni, String nombres, int edad) {
        this.dni = dni;
        this.nombres = nombres;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public int getEdad() {
        return edad;
    }

    
    public String mostrarDatos() {
        return "dni: " + dni + ", nombres: " + nombres + ", edad: " + edad ;
    }

    
    
    
    
    
}
