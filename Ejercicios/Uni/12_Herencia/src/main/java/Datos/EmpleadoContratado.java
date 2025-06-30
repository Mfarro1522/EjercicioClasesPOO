package Datos;

public class EmpleadoContratado extends Empleado{
    private int horasTrabajadas;
    private double precioHora;

    public EmpleadoContratado() {
    }

    public EmpleadoContratado(int horasTrabajadas, double precioHora, String dni, String nombres, int edad , int numHijos) {
        super(dni, nombres, edad , numHijos);
        this.horasTrabajadas = horasTrabajadas;
        this.precioHora = precioHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + " horasTrabajadas: " + horasTrabajadas + ", precioHora: " + precioHora + "  - Sueldo : "+ sueldo;
    }

    @Override
    public void CalcularSueldo() {

        this.sueldo = horasTrabajadas * precioHora;
        
       
    }


}


