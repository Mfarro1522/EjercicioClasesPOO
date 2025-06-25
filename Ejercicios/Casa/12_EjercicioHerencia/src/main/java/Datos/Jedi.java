package Datos;

public class Jedi extends UsuarioFuerza {
    // Atributos Específicos
    private String rango; 
    private boolean miembroDelConsejo;

    public Jedi() {
    }

    public Jedi(String nombre, String colorSable, int nivelPoder, int edad, String especie, String rango, boolean miembroDelConsejo) {
        super(nombre, colorSable, nivelPoder, edad, especie);
        this.rango = rango;
        this.miembroDelConsejo = miembroDelConsejo;
    }

    public String getRango() {
        return rango;
    }

    public boolean isMiembroDelConsejo() {
        return miembroDelConsejo;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + ", Rango: " + rango + ", Miembro del Consejo: " + (miembroDelConsejo ? "Sí" : "No");
    }
}
