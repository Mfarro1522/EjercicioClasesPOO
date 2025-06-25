package Datos;

//SuperClase - Clase Padre
public class UsuarioFuerza {
    private String nombre;
    private String colorSable;
    private int nivelPoder;
    private int edad;
    private String especie;

    public UsuarioFuerza() {
    }

    public UsuarioFuerza(String nombre, String colorSable, int nivelPoder, int edad, String especie) {
        this.nombre = nombre;
        this.colorSable = colorSable;
        this.nivelPoder = nivelPoder;
        this.edad = edad;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColorSable() {
        return colorSable;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecie() {
        return especie;
    }
    
    public String mostrarDatos() {
        return "Nombre: " + nombre + ", Color Sable: " + colorSable + ", Nivel Poder: " + nivelPoder + ", Edad: " + edad + ", Especie: " + especie;
    }
}
