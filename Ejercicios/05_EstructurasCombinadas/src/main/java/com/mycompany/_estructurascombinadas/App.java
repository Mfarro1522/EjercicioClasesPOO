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
}
