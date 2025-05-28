package clases;

public class Curso {
    //atributos 
    private String codigo;
    private String nombre;
    private int credito;
    private String horario;
    private String carrera;
    
    //constructores
    public Curso() {
    }

    public Curso(String codigo, String nombre, int credito, String horario, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.credito = credito;
        this.horario = horario;
        this.carrera = carrera;
    }
    
     public Curso(String codigo, String nombre, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
    }
    
    //getter and setter

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

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    //retornar datos 
    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + ", credito=" + credito + ", horario=" + horario + ", carrera=" + carrera + '}';
    }
    
    
    
}
