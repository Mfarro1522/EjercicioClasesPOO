package com.mycompany._vectorestructuras;

import java.util.Scanner;

class Alumno {
    //atributos - campos - Datos
    String codigo;
    String nombre;
    String curso;
    int nota;  
}



public class App {
    
    static final int MAX = 2;
    static Scanner entrada = new Scanner (System.in);
    
    public static void main(String[] args) {
       //declarar alimnos por separado
       Alumno A1 , A2 , A3 , A4 , A5;
       
       //EN ARRAY
       Alumno [] alumnos;
       //asignamos 
       A1 = new Alumno();
       A2 = new Alumno();
      
       alumnos = new Alumno[MAX];
       
       //llamar funciones
        llenado(alumnos);
        presentar(alumnos);
        
        System.out.println("Ingrese Entrada");
        String codigo = entrada.next();
        
        BuscarPorCodigo(alumnos , codigo);

    }
    
    //operaciones de 1 alumno llenar mostrar
    static void LlenaAlumno(Alumno A){
        System.out.println("Ingrese Codigo");
        A.codigo = entrada.next();
        entrada.nextLine();
        System.out.println("Ingrese Nombre");
        A.nombre = entrada.nextLine();
        
        System.out.println("Ingrese Curso");
        A.curso = entrada.nextLine();
        
        System.out.println("Ingrese Nota");
        A.nota = entrada.nextInt();
    }
    
    static void MostarAlumno(Alumno A){
        System.out.println(A.codigo+" - "+A.nombre+
                " - "+A.curso + " - "+A.nota);
    }
    
    //operacion para vector Alumnos
    //llenado , presentar , Ordenar , Busqueda , Intercambiar
    
    static void llenado (Alumno [] alumnos){
        for (int i = 0; i < MAX; i++) {
             alumnos[i] = new Alumno();//error comun (iniciando)
            LlenaAlumno(alumnos[i]);
        }
    }
    
    static void presentar (Alumno [] alumnos){
        for (int i = 0; i < MAX; i++) {
           
            MostarAlumno(alumnos[i]);
        }
    }
    
    //funcion buscar alumno por codigo
    
    static void BuscarPorCodigo (Alumno[]alumnos , String codigo){
        
        boolean encontrado = false;
        int indice = 0 ;
       
        
        for (int i = 0; i < MAX; i++) {
            if(alumnos[i].codigo.equals(codigo)){
                encontrado = true;
                indice = i ; 
            }
        }
        
        if(encontrado){
            MostarAlumno(alumnos[indice]);
            
        }else { 
            System.out.println("No hay ");
        }
        
    }
    
}
