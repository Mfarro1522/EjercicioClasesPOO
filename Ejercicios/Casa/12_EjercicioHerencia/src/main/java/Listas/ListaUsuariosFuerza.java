package Listas;

import Datos.UsuarioFuerza;

public class ListaUsuariosFuerza {
    private final int MAX = 100;
    private UsuarioFuerza[] usuarios;
    private int contador = 0;

    public ListaUsuariosFuerza() {
        usuarios = new UsuarioFuerza[MAX];
    }

    public void agregarUsuario(UsuarioFuerza usuario) {
        if (contador < MAX) {
            usuarios[contador] = usuario;
            contador++;
        } else {
            System.out.println("Lista de usuarios de la fuerza llena.");
        }
    }

    public String mostrarUsuarios() {
        String datos = "";
        for (int i = 0; i < contador; i++) {
            datos += "\n" + usuarios[i].mostrarDatos();
        }
        return datos;
    }
}
