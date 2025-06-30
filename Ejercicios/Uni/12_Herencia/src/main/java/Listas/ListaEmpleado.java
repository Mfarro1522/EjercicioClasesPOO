package Listas;

import Datos.Empleado;

public class ListaEmpleado  {
    private final int MAX = 100;
    private Empleado[] empleados;
    private int contador = 0;

    public ListaEmpleado() {
        empleados = new Empleado[MAX];
    }

    public void agregarEmpleado(Empleado empleado) {
        if (contador < MAX) {
            empleados[contador] = empleado;
            contador++;
        } else {
            System.out.println("Lista de empleados llena.");
        }
    }

    public String mostrarEmpleados() {
    	String datos = "";
        for (int i = 0; i < contador; i++) {
            datos += "\n"+empleados[i].mostrarDatos();
        }
        return datos;
    }
    
    public void calcularSueldos() {
        for (int i = 0; i < contador; i++) {
            empleados[i].CalcularSueldo();
        }
    }
    
    public void AgregarBonos() {
        for (int i = 0; i < contador; i++) {
            empleados[i].AgregarBono();
        }
    }
    
    
    

}
