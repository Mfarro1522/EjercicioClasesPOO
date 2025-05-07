package com.mycompany.vectoresparalelos;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class App {

    // Constant y Scanner
    static final int MAX = 3;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

    // Declaracion de vectores paralelos
    int notas[] = new int[MAX];
    String nomAlumnos[] = new String[MAX];
    String cursos[] = new String[MAX];

    llenadoDatos(notas, nomAlumnos, cursos);
    presentarDatos(notas, nomAlumnos, cursos);
    mayorNota(notas, nomAlumnos);
    AlumnoPorCurso(notas, nomAlumnos, cursos);
    



    }

    // Llenado de los vectores
    // FUNCION:
    // Sus propias variables
    //    - Los parametros (en los parentesis)
    //    - Declarar dentro de la funcion
    static void llenadoDatos(int notas[], String nomAlumnos[], String cursos[]) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("Alumno "+(i+1)+": ");
            nomAlumnos[i] = entrada.next();
            cursos[i] = leerCurso();
            notas[i] = leerNota();
        }
    }

    // Presentar vectores
    static void presentarDatos(int notas[], String nomAlumnos[], String cursos[]) {
        System.out.println("Mostrando arreglos paralelos");
        for (int i = 0; i < MAX; i++) {
            System.out.println("Nombre" + nomAlumnos[i] + " - Curso " + cursos[i] + " - Nota : " + notas[i]);
        }
    }

    // Encontrar el nombre del alumno con mayor nota
    static void mayorNota(int notas[], String nomAlumnos[]) {
        System.out.print("\nAlumno con mayor nota: ");
        int nota = -1;
        String alumno = "";

        for (int i = 0; i < MAX; i++) {
            if (nota < notas[i]) {
                nota = notas[i];
                alumno = nomAlumnos[i];
            }
        }
        System.out.print(alumno + " Nota: " + nota);
    }

    //  alumnos por cada CURSO
    static void AlumnoPorCurso(int notas[], String nomAlumnos[], String cursos[]) {
        System.out.print("\n\nCantidad alumnos por curso ");
        int contador = 0;
        String Cursox = "";

        for (int i = 0; i < MAX; i++) {
            if (!Cursox.equals(cursos[i])) {
                Cursox = cursos[i];
                
                for (int j = 0; j < MAX; j++) {
                    if (cursos[j].equals(Cursox)) {
                        contador++;
                    }
                }
                System.out.println("\nCurso " + Cursox + " : " + contador);
                contador = 0; // Reiniciar contador para el siguiente curso
                
            }
        }
    }

    // Leer nota
    static int leerNota() {
        int nota;
        do {
            System.out.print("Ingrese nota (0 - 20): ");
            nota = entrada.nextInt();
        } while (nota < 0 || nota > 20);
        return nota;
    }

    // Leer nombre alumno
    static String leerCurso() {
        String curso;
        do {
            System.out.print("Ingrese el curso (POO - HD - MATE): ");
            curso = entrada.next();
        } while (curso.equals("POO") && curso.equals("HD") && curso.equals("MATE"));
        // Validar que el curso sea uno de los tres permitidos
        return curso;
    }
}
