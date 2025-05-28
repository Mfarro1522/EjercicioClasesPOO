package clases;
//lista con arreglo no es lista normal
public class ListaAlumnos {
    private final int MAX = 10;
    
    //VECTOR
    private Alumno [] alumnos =  new Alumno[MAX] ;
    //contador de alumnos actuales 
    private int contador ;
    //
    
    
    //funcionalidadees /Operaciones (Metodos)

    public ListaAlumnos() {
    }

    public ListaAlumnos(Alumno[] alumnos, int contador) {
        this.alumnos = alumnos;
        this.contador = contador;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void Agregar (Alumno nuevo){
        if(contador<MAX){
           alumnos[contador] = nuevo; 
        }
        contador++;
    }
    public void presentar (){
        for (int i = 0; i < contador; i++) {
            System.out.println(alumnos[i].toString());
        }
    }
    
}
