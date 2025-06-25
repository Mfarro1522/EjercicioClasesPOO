package com.mycompany._ejercicioherencia;

import Datos.UsuarioFuerza;
import Datos.Jedi;
import Datos.Sith;
import Datos.PadawanJedi;
import Listas.ListaUsuariosFuerza;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        
        // Crear objetos de diferentes tipos de usuarios de la fuerza
        UsuarioFuerza objUF = new UsuarioFuerza("Leia Organa", "azul", 8, 19, "humano");
        Jedi objJedi = new Jedi("Obi Wan Kenobi", "azul", 19, 35, "humano", "Maestro Jedi", true);
        Sith objSith = new Sith("Darth Vader", "rojo", 26, 45, "humano", "Lord Oscuro de los Sith", false);
        PadawanJedi objPadawan = new PadawanJedi("Anakin Skywalker", "Azul", 7, 19, "Humano", "Obi Wan Kenobi");
        
//        // Crear lista de usuarios de la fuerza
//        ListaUsuariosFuerza lista = new ListaUsuariosFuerza();
//        lista.agregarUsuario(objUF);
//        lista.agregarUsuario(objJedi);
//        lista.agregarUsuario(objSith);
//        lista.agregarUsuario(objPadawan);
//        
//        // Mostrar todos los usuarios
//        JOptionPane.showMessageDialog(null, "=== USUARIOS DE LA FUERZA ===" + lista.mostrarUsuarios());
        
        // Demostrar polimorfismo
        JOptionPane.showMessageDialog(null, "=== DEMOSTRACIÓN DE POLIMORFISMO ===");
        presentarObjetos(objUF);
        presentarObjetos(objJedi);
        presentarObjetos(objSith);
        presentarObjetos(objPadawan);
    }
    

    static void presentarObjetos(UsuarioFuerza obj) {
        JOptionPane.showMessageDialog(null, obj.mostrarDatos());
    }
}
