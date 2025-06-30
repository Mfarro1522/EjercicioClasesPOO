
package Datos;

public class EmpleadoPlanilla extends Empleado{
    //Atributos Especificos
    
    private String cargo;
    private int TiempoServicio;

    public EmpleadoPlanilla() {
    }

    public EmpleadoPlanilla(String cargo, int TiempoServicio, String dni, String nombres, int edad , int numHijos) {
        super(dni, nombres, edad , numHijos);
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
        return super.mostrarDatos() + " cargo: " + cargo + ", TiempoServicio: " + TiempoServicio + "  - Sueldo : "+ sueldo;
    }
    
    @Override
    public void CalcularSueldo() {
        if (this.cargo.equalsIgnoreCase("gerente")) {
            sueldo = 5000 ; 
        } else if (this.cargo.equalsIgnoreCase("supervisor")) {
            sueldo = 3000;
        } else if (this.cargo.equalsIgnoreCase("asistente")) {
            sueldo =  1500 ;
        } else {
            sueldo = 1000 ; 
        }
        
    }

    
    
    
}
