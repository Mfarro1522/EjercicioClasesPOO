
package Datos;

public class EmpleadoPlanilla extends Empleado{
    //Atributos Especificos
    
    private String cargo;
    private int TiempoServicio;

    public EmpleadoPlanilla() {
    }

    public EmpleadoPlanilla(String cargo, int TiempoServicio, String dni, String nombres, int edad) {
        super(dni, nombres, edad);
        this.cargo = cargo;
        this.TiempoServicio = TiempoServicio;
    }

    public String getCargo() {
        return cargo;
    }

    public int getTiempoServicio() {
        return TiempoServicio;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + " cargo: " + cargo + ", TiempoServicio: " + TiempoServicio ;
    }
    
    
    
    
}
