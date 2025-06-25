package Datos;

public class Sith extends UsuarioFuerza {
    private String titulo; 
    private boolean tieneAprendiz;

    public Sith() {
    }

    public Sith(String nombre, String colorSable, int nivelPoder, int edad, String especie, String titulo, boolean tieneAprendiz) {
        super(nombre, colorSable, nivelPoder, edad, especie);
        this.titulo = titulo;
        this.tieneAprendiz = tieneAprendiz;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isTieneAprendiz() {
        return tieneAprendiz;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + ", Título: " + titulo + ", Tiene aprendiz: " + (tieneAprendiz ? "Sí" : "No");
    }
}
