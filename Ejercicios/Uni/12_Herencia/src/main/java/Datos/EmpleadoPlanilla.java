
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
        return super.mostrarDatos() + " cargo: " + cargo + ", TiempoServicio: " + TiempoServicio + "  - Sueldo : "+ super.getSueldo();
    }
    
    @Override
    public void CalcularSueldo() {
        if (this.cargo.equalsIgnoreCase("gerente")) {
            this.setsueldo( 5000 ); 
        } else if (this.cargo.equalsIgnoreCase("supervisor")) {
            this.setsueldo( 3000 );
        } else if (this.cargo.equalsIgnoreCase("asistente")) {
            this.setsueldo( 1500 );
        } else {
            this.setsueldo( 1000 ); 
        }
        
    }
    
    
    
}
