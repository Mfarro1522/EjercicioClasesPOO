package clases;
//lista con arreglo no es lista normal
public class ListaAlumnos {
    private final int MAX = 10;
    
    //VECTOR
    private Alumno [] alumnos =  new Alumno[MAX] ;
    //contador de alumnos actuales 
    private int contador ;
    //
    
    
    //funcionalidadees /Operaciones (Metodos)

    public ListaAlumnos() {
    }

    public ListaAlumnos(Alumno[] alumnos, int contador) {
        this.alumnos = alumnos;
        this.contador = contador;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void Agregar (Alumno nuevo){
        if(contador<MAX){
           alumnos[contador] = nuevo; 
        }
        contador++;
    }
//    public void presentar (){ esto esta mal por q los objetos no interarcutan con el usuario no deberia de haber el system.out.println
//        for (int i = 0; i < contador; i++) {
//            System.out.println(alumnos[i].toString());
//        }
//    }
    
    public String  presentar (){
    	String datos = "";
        for (int i = 0; i < contador; i++) {
            datos = datos + alumnos[i].toString() + "\n";
        }
        return datos;
    }
    
    public boolean hayEspacio() {
		return contador < MAX;
	}
    
    public Alumno buscarPorCodigo(String codigo) {
		for (int i = 0; i < contador; i++) {
			if (alumnos[i].getCodigo().equals(codigo)) {
				return alumnos[i];
			}
		}
		return null; // Si no se encuentra el alumno
	}
	
	public String encontrarPorCodigo(String codigo) {
		for (int i = 0; i < contador ; i++) {
			if(alumnos[i].getCodigo().equals(codigo)) {
				return alumnos[i].toString();
			} 
		}
		return "Alumno no encontrado con el codigo: " + codigo;
	}
	
	public String presentarPorCarrera(String carrera) {
		String datos = "";
		for (int i = 0; i < contador; i++) {
			if (alumnos[i].getCarrera().equalsIgnoreCase(carrera)) {
				datos += alumnos[i].toString() + "\n";
			}
		}
		if (datos.equals("")) {
			return "No hay alumnos en la carrera: " + carrera;
		} else {
			return datos;
		}
	
	}
	
	public String [] CarrerasUnicas() {
		String[] carreras = new String[contador];
		int indice = 0;
		
		for (int i = 0; i < contador; i++) {
			String carreraActual = alumnos[i].getCarrera();
			boolean existe = false;
			
			for (int j = 0; j < indice; j++) {
				if (carreras[j].equalsIgnoreCase(carreraActual)) {
					existe = true;
					break;
				}
			}
			
			if (!existe) {
				carreras[indice++] = carreraActual;
			}
		}
		
		return carreras;
	}
	
	public String AlumnosPorCarrera(String [] carreasUnicas)  {
		String datos = "";
		if ( carreasUnicas.length == 0) {
			return "No hay carreras registradas";
		} else {
			for (int i = 0; i < carreasUnicas.length; i++) {
				String carreraActual = carreasUnicas[i];
				int contadorPorCarrera = 0;

				for (int j = 0; j < contador; j++) {
					if (alumnos[j].getCarrera().equalsIgnoreCase(carreraActual)) {
						contadorPorCarrera++;
					}
				}

				datos += "La carrera " + carreraActual + " tiene " + contadorPorCarrera + " alumnos\n";
			}
			return datos;
		}
	}
	
	public String OrdenarAlumnosPorCarrera(String [] carrerasUnicas) {
		//ordenamos las carreras unicas por orden alfabetico
		String datos = "";
		
		for (int i = 0; i < carrerasUnicas.length - 1; i++) {
			for (int j = i + 1; j < carrerasUnicas.length; j++) {
				if (carrerasUnicas[i].compareToIgnoreCase(carrerasUnicas[j]) > 0) {
					String temp = carrerasUnicas[i];
					carrerasUnicas[i] = carrerasUnicas[j];
					carrerasUnicas[j] = temp;
				}
			}
		}
		
		//imprimimos los alumnos por carrera ya ordenados 
		for (String carrera : carrerasUnicas) {
			datos += "Alumnos de la carrera " + carrera + ":\n";
			for (int j = 0; j < contador; j++) {
				if (alumnos[j].getCarrera().equalsIgnoreCase(carrera)) {
					datos += alumnos[j].toString() + "\n";
				}
			}
			datos += "\n"; // Añadir un salto de línea entre carreras
		}
		return datos;
	}
    
}
