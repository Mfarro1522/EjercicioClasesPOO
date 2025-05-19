package com.mycompany._estructurascombinadas;

import java.util.Scanner;

/** @author Mauricio*/


    //Clase Empleado :
    class Empleado {
        int Dni;
        String nombre;
        int Edad;
        String AreaTrabajo;
        DatosFamiliares datosfamailiares;

        
        
    }

    class DatosFamiliares {
        String direccion ;
        int numHijos;
        String distrito;
    }

public class App {
    
    final static int MAX = 3;
    final static Scanner entrada = new Scanner(System.in);
    //Clase DF: 
    
    //Funciones DF :
    static void llenarDF (DatosFamiliares datosfamiliares){
        
        System.out.println("Ingrese Distrito : ");
        datosfamiliares.distrito = entrada.next();
        System.out.println("Ingrese Numero de Hijos : ");
        datosfamiliares.numHijos = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese Direccion : ");
        datosfamiliares.direccion = entrada.nextLine();
         
    }

    
    static void mostrarDF (DatosFamiliares datosfamiliares ){
        System.out.println("Distrito : "+datosfamiliares.distrito 
                + " Num Hijos : "+datosfamiliares.numHijos + " Direccion : "+datosfamiliares.direccion);
    }

    //Funciones :
    static void LlenarEmpleado (Empleado empleado){
        
        
        System.out.println("Ingrese DNI : ");
        empleado.Dni = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese Nombre : ");
        empleado.nombre = entrada.nextLine();
         
        System.out.println("Ingrese Edad : ");
        empleado.Edad = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese Area de Trabajo : ");
        empleado.AreaTrabajo = entrada.nextLine();
        
        empleado.datosfamailiares = new DatosFamiliares();
        llenarDF(empleado.datosfamailiares);
        
    }
    
    static void MostrarEmpleado (Empleado empleado ){
        System.out.println("Dni : "+empleado.Dni + " Nombre "+empleado.nombre
                +" Edad : "+empleado.Edad+" Area de Trabajo "+empleado.AreaTrabajo);
        mostrarDF(empleado.datosfamailiares);
    }
    
    
    
    public static void main(String[] args) {
        
        Empleado [] empresa = new Empleado[MAX];
        //llenamos Empleados 
        LlenarEmpres(empresa);
        //mostramos
        MostrarEmpres(empresa);

        //menu con la funciones Extra
        MenuFuncionesExtra(empresa);

        
    }
    
    //funciones para empresa
    static void LlenarEmpres (Empleado [] empresa ){
        for (int i = 0; i < MAX; i++) { 
            System.out.println("Ingrese Datos de Empleado "+ (i+1));
            empresa[i] = new Empleado();
            LlenarEmpleado(empresa[i]);
        }
    }
    static void MostrarEmpres (Empleado [] empresa){
       for (int i = 0; i < MAX; i++) {
            MostrarEmpleado(empresa[i]);
        } 
    }
    
    //Funciones Extras :

    //Empleados por Area de Trabajo
    static void EmpleadosPorArea (Empleado [] empresa){
        String area;
        System.out.println("Ingrese Area de Trabajo : ");
        area = entrada.nextLine();
        for (int i = 0; i < MAX; i++) {
            if (empresa[i].AreaTrabajo.equals(area)){
                MostrarEmpleado(empresa[i]);
            }
        }
    }

    //total de Empleados de todas la areas (aqui se se coloca cada area de trabajo y se cuenta el total y se muetra no se pide area por q mostrara todas)
    static void TotalEmpleadosPorArea (Empleado [] empresa){
        System.out.println("****Total de Empleados por Area de Trabajo****");

        // Crear un array de areas de trabajo únicas
        String[] areasUnicas = new String[MAX];
        int[] conteoAreas = new int[MAX];
        int totalAreasUnicas = 0;

        for (int i = 0; i < MAX; i++) {
            if (empresa[i] != null && empresa[i].AreaTrabajo != null) { 
                boolean encontrada = false;
                String areaActual = empresa[i].AreaTrabajo;

            
                for (int j = 0; j < totalAreasUnicas; j++) {
                    if (areaActual.equals(areasUnicas[j])) {
                        conteoAreas[j]++;
                        encontrada = true;
                        break;
                    }
                }

   
                if (!encontrada) {
                    areasUnicas[totalAreasUnicas] = areaActual;
                    conteoAreas[totalAreasUnicas] = 1;
                    totalAreasUnicas++;
                }
            }
        }

        // Mostrar el resultado
        for (int i = 0; i < totalAreasUnicas; i++) {
            System.out.println("Area de Trabajo: " + areasUnicas[i]
                    + " - Total de Empleados: " + conteoAreas[i]);
        }
    }

    //Nombre del El Empleado con Mayor numero de Hijos
    static void EmpleadoConMayorHijos (Empleado [] empresa){
        int maxHijos = 0;
        String nombre = "";
        for (int i = 0; i < MAX; i++) {
            if (empresa[i].datosfamailiares.numHijos > maxHijos){
                maxHijos = empresa[i].datosfamailiares.numHijos;
                nombre = empresa[i].nombre;
            }
        }
        System.out.println("Empleado con mayor numero de hijos: " + nombre + " con " + maxHijos + " hijos.");
    }

    //total de empleados por distrito
    static void TotalEmpleadosPorDistrito (Empleado [] empresa){
        String distrito;
        System.out.println("Ingrese Distrito : ");
        distrito = entrada.nextLine();
        int contador = 0;
        for (int i = 0; i < MAX; i++) {
            if (empresa[i].datosfamailiares.distrito.equals(distrito)){
                contador++;
            }
        }
        System.out.println("Total de Empleados en el Distrito " + distrito + " : " + contador);
    }

    //ordenamiento Empleados por Edad (insercion)
    static void OrdenarEmpleadosPorEdad (Empleado [] empresa){
        for (int i = 1; i < MAX; i++) {
            Empleado temp = empresa[i];
            int j = i - 1;
            while (j >= 0 && empresa[j].Edad > temp.Edad) {
                empresa[j + 1] = empresa[j];
                j--;
            }
            empresa[j + 1] = temp;
        }
        System.out.println("Empleados ordenados por Edad : ");
        MostrarEmpres(empresa);
    }

    //busqueda de empleado por DNI
    static void BuscarEmpleadoPorDNI (Empleado [] empresa){
        int dni;
        System.out.println("Ingrese DNI : ");
        dni = entrada.nextInt();
        for (int i = 0; i < MAX; i++) {
            if (empresa[i].Dni == dni){
                MostrarEmpleado(empresa[i]);
            }
        }
    }

    //modificar datos de empleado
    static void ModificarDatosEmpleado (Empleado [] empresa){
        int dni;
        System.out.println("Ingrese DNI : ");
        dni = entrada.nextInt();
        for (int i = 0; i < MAX; i++) {
            if (empresa[i].Dni == dni){
                System.out.println("Ingrese nuevo nombre : ");
                empresa[i].nombre = entrada.next();
                System.out.println("Ingrese nueva edad : ");
                empresa[i].Edad = entrada.nextInt();
                System.out.println("Ingrese nuevo area de trabajo : ");
                empresa[i].AreaTrabajo = entrada.next();
                llenarDF(empresa[i].datosfamailiares);
            }
        }
    }

    //eliminar empleado ( no eliminar por q generar error  si no dejar sus datos como 0)
    static void EliminarEmpleado (Empleado [] empresa){
        int dni;
        System.out.println("Ingrese DNI : ");
        dni = entrada.nextInt();
        for (int i = 0; i < MAX; i++) {
            if (empresa[i].Dni == dni){
                empresa[i].Dni = 0;
                empresa[i].nombre = "";
                empresa[i].Edad = 0;
                empresa[i].AreaTrabajo = "";
                empresa[i].datosfamailiares.distrito = "";
                empresa[i].datosfamailiares.numHijos = 0;
                empresa[i].datosfamailiares.direccion = "";
            }
        }
    }

    //menu con la funciones Extra:
    static void MenuFuncionesExtra (Empleado [] empresa){
        int opcion;
        do {
            System.out.println("Menu de Funciones Extra");
            System.out.println("1. Empleados por Area de Trabajo");
            System.out.println("2. Total de Empleados por Area de Trabajo");
            System.out.println("3. Empleado con Mayor numero de Hijos");
            System.out.println("4. Total de empleados por distrito");
            System.out.println("5. Ordenar Empleados por Edad");
            System.out.println("6. Buscar Empleado por DNI");
            System.out.println("7. Modificar Datos de Empleado");
            System.out.println("8. Eliminar Empleado");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:EmpleadosPorArea(empresa);break;
                case 2:TotalEmpleadosPorArea(empresa);break;
                case 3:EmpleadoConMayorHijos(empresa);break;
                case 4:TotalEmpleadosPorDistrito(empresa); break;
                case 5:OrdenarEmpleadosPorEdad(empresa);break;
                case 6: BuscarEmpleadoPorDNI(empresa);break;
                case 7:ModificarDatosEmpleado(empresa); break;
                case 8:EliminarEmpleado(empresa);break;
                case 9:System.out.println("Saliendo del menu...");break;
                default:System.out.println("Opcion invalida");
            }
        } while (opcion != 9);
    }

}
