
package com.mycompany._herencia;

import Datos.Empleado;
import Datos.EmpleadoContratado;
import Datos.EmpleadoPlanilla;
import Datos.EmpleadoTemporal;
import Listas.ListaEmpleado;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
      
        //Empleado objE = new Empleado("12345678", "Pedri Quispe", 22);
        EmpleadoPlanilla objEP = new EmpleadoPlanilla("Gerente", 25, "123456789", "Critiano mamani", 45 , 0);
        EmpleadoContratado objEC = new EmpleadoContratado(20, 30, "98745612", "Lionel condorcanqui", 30 , 2);
        EmpleadoTemporal objET = new EmpleadoTemporal("1254795", "Lamine Lujan Carrion", 30 , 3 , 3 , 6 , 20.0);
        
//        //PRUEBA INDIVIDUAL
//        JOptionPane.showMessageDialog(null, objE.mostrarDatos());
//        JOptionPane.showMessageDialog(null, objEP.mostrarDatos());
//        JOptionPane.showMessageDialog(null, objEC.mostrarDatos());
//        
//        //PRUEBA DE HERENCIA
//        presentarObjetos(objE);
//        presentarObjetos(objEP);
//        presentarObjetos(objEC);
        
        ListaEmpleado Lista = new ListaEmpleado();
        //Lista.agregarEmpleado(objE);
        Lista.agregarEmpleado(objEP);
        Lista.agregarEmpleado(objEC);
        Lista.agregarEmpleado(objET);
        
        Lista.calcularSueldos();
        Lista.AgregarBonos();
        JOptionPane.showMessageDialog(null, Lista.mostrarEmpleados());;
        
    }
    
    static void presentarObjetos(Empleado obj) {
    	JOptionPane.showMessageDialog(null, obj.mostrarDatos());
    }
    
}
