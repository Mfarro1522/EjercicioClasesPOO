package clases;

public class Alumno {
    //1.Atributos PRIVADOS
    private String codigo;
    private String nombre;
    private int edad;
    private String Carrera;
    
    //2.operaciones (Metodos)
    //A. Metodos de Acceso (Get : obtener valor privado)
    //set : modificar valor privado

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

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

        public int getEdad() {
        return edad;
    }

     //B: Constructor
     //metodo que se ejecuta cuando se utilza new

    public Alumno(String codigo, String nombre, int edad, String Carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.Carrera = Carrera;
    }
    
    public Alumno (){
    //Inicializr valores
    this.Carrera = "Epici";
    this.edad = 16;
    }
    
    public Alumno(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;

    }

    public Alumno(String codigo, String nombre, String Carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Carrera = Carrera;
    }
    
    //C: Metodos de Accion (propios)

    
    public String getAlumnos() {
        return "Alumno{" + "codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + ", Carrera=" + Carrera + '}';
    }
    
    
}
