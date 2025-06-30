
package Datos;

//SuperClase - Clase Padre
public abstract class Empleado {
	protected String dni;
    protected String nombres;
    protected int edad;
    protected double sueldo;
    protected int numHijos;

    public Empleado() {
    }

    public Empleado(String dni, String nombres, int edad , int numHijos) {
        this.dni = dni;
        this.nombres = nombres;
        this.edad = edad;
        this.numHijos = numHijos;
    }


    
    public String mostrarDatos() {
        return   "dni: " + dni + ", nombres: " + nombres + ", edad: " + edad + "Numero de Hijos : "+ numHijos;
    }

    public abstract void CalcularSueldo();

	public void AgregarBono() {
	double bono = 80;
		if (this.numHijos>=2) {
			this.sueldo += bono*2;
		}else {
			this.sueldo += bono*numHijos;
		}
		
	}
    
    
    
}
