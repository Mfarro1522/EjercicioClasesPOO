package com.mycompany._listasobjetos;

import clases.Alumno;
import clases.ListaAlumnos;

public class App {

    public static void main(String[] args) {
        Alumno A1 = new Alumno("1", "Juan", "Epici", 18);
        Alumno A2 = new Alumno("2", "ana", "Epici", 19);
        Alumno A3 = new Alumno("3", "pepe", "Epici", 17);
        
        ListaAlumnos LA =  new ListaAlumnos();
        
        LA.Agregar(A3);
        LA.Agregar(A2);
        LA.Agregar(A1);
        
        LA.presentar();
        
    }
}
