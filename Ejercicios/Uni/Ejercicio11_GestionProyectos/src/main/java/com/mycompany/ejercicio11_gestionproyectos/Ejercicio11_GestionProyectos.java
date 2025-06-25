package com.mycompany.ejercicio11_gestionproyectos;

import javax.swing.JOptionPane;
import Clases.GestorProyectos;

public class Ejercicio11_GestionProyectos {

    public static void main(String[] args) {
        
        GestorProyectos gestor = new GestorProyectos();
        Ejercicio11_GestionProyectos app = new Ejercicio11_GestionProyectos();
        
        String opcion;
        
        do {
            opcion = app.opciones();
            
            if (opcion != null) {
                switch (opcion) {
                    case "1":
                        gestor.agregarProyecto();
                        break;
                    case "2":
                        gestor.agregarEmpleado();
                        break;
                    case "3":
                        gestor.mostrarProyectosConEmpleados();
                        break;
                    case "4":
                        gestor.mostrarPagosPorEmpleado();
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }
            }
        } while (opcion != null && !opcion.equals("5"));
    }
    
    public String opciones() {
        String menu = "=== GESTIÓN DE PROYECTOS SIMPLE ===\n\n"
                + "1. Agregar Proyecto\n"
                + "2. Agregar Empleado\n"
                + "3. Mostrar Proyectos con Empleados\n"
                + "4. Mostrar Pagos por Empleado\n"
                + "5. Salir\n\n"
                + "Seleccione una opción:";
        
        return JOptionPane.showInputDialog(menu);
    }
}