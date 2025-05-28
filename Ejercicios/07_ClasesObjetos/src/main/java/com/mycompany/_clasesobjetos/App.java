package com.mycompany._clasesobjetos;

import clases.Alumno;
import clases.Curso;
import javax.swing.JOptionPane;

/**** @author admin*/

public class App {

    public static void main(String[] args) {
        //construir Objetos
        Alumno A1 = new Alumno();
        Alumno A2 = new Alumno();
        
        A1.setCodigo("1010AB");
        System.out.println(A1.getCodigo());
        
        A1.setNombre("Juan Perez");
        System.out.println(A1.getNombre());
        //copiar nombre de A1 a A2
        A2.setNombre(A1.getNombre());
        
        //ller carrera por pantalla
        String carrera ;
        carrera = JOptionPane.showInputDialog("Ingrese Carrera");
        A1.setCarrera(carrera);
        JOptionPane.showMessageDialog(null,"Carrera "+A1.getCarrera());
        
        JOptionPane.showMessageDialog(null,"Edad : "+ A1.getEdad());
        
       Alumno A3 = new Alumno("111" , "Fernando");
       Alumno A4 = new Alumno("666", "Ana", 19, "Fisica");
       
       JOptionPane.showMessageDialog(null, A4.getAlumnos());
       
       //creacion objetos tipo curso
       Curso C1 , C2 , C3;
       C1 = new Curso();
       C1.setCodigo("123123");
       C1.setCarrera("POO");
       C1.setCredito(4);
       
       C2 = new Curso("c1700", "Fundametos", 5, "7:30 - 10:30", "EPICI");
       
       C3 = new Curso();
       String codigo , nombre ;
       int creditos;
       
       codigo = JOptionPane.showInputDialog("Ingrese codigo : ");
       nombre = JOptionPane.showInputDialog("Ingrese nombre : ");
       creditos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Creditos"));
       
       C3.setCodigo(codigo);
       C3.setNombre(nombre);
       C3.setCredito(creditos);
       
       JOptionPane.showMessageDialog(null, C1.toString());
       JOptionPane.showMessageDialog(null, C2.toString());
       JOptionPane.showMessageDialog(null, C3.toString());
       
       //mostar cursos por carrera
       
       
    }
}
