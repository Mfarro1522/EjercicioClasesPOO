package Clases;

public class ListaProyectos {
	
	private Proyecto[] proyectos;
	private int contadorProyectos;

	public ListaProyectos() {
		proyectos = new Proyecto[10];
		contadorProyectos = 0;
	}

	public void agregarProyecto(Proyecto proyecto) {
		if (contadorProyectos < proyectos.length) {
			proyectos[contadorProyectos] = proyecto;
			contadorProyectos++;
		} else {
			System.out.println("No se pueden agregar más proyectos.");
		}
	}

	public Proyecto[] getProyectos() {
		return proyectos;
	}

	public int getContadorProyectos() {
		return contadorProyectos;
	}
	
	public Proyecto buscarProyecto(String codigo) {
		for (int i = 0; i < contadorProyectos; i++) {
			if (proyectos[i].getCodigo().equals(codigo)) {
				return proyectos[i];
			}
		}
		return null; // Si no se encuentra el proyecto
	}

}
