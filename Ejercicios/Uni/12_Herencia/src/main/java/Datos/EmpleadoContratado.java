package Datos;

public class EmpleadoContratado extends Empleado{
    private int horasTrabajadas;
    private double precioHora;

    public EmpleadoContratado() {
    }

    public EmpleadoContratado(int horasTrabajadas, double precioHora, String dni, String nombres, int edad) {
        super(dni, nombres, edad);
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
        return super.mostrarDatos() + " horasTrabajadas: " + horasTrabajadas + ", precioHora: " + precioHora + "  - Sueldo : "+ super.getSueldo();
    }

    @Override
    public void CalcularSueldo() {

        double sueldo = horasTrabajadas * precioHora;
        this.setsueldo(sueldo);
       
    }

}
