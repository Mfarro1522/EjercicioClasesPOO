package Datos;

public class PadawanJedi extends UsuarioFuerza {
    private String maestro; // nombre del Jedi que lo entrena

    public PadawanJedi() {
    }

    public PadawanJedi(String nombre, String colorSable, int nivelPoder, int edad, String especie, String maestro) {
        super(nombre, colorSable, nivelPoder, edad, especie);
        this.maestro = maestro;
    }

    // Gets
    public String getMaestro() {
        return maestro;
    }

    // Sobrecargamos mostrarDatos
    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + ", Maestro: " + maestro;
    }
}
