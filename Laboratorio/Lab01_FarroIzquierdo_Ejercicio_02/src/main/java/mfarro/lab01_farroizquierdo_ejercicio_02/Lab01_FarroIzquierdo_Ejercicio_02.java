package mfarro.lab01_farroizquierdo_ejercicio_02;

import java.util.Scanner;

/** @author mauri*/
public class Lab01_FarroIzquierdo_Ejercicio_02 {
	
	static Scanner entrada = new Scanner(System.in);
	// Definicion de variables de los libros en general
	static final String CATEGORIASPREDET[] = {"Accion", "Aventura", "Fantasia", "Romance", "Terror" , "Drama"};

	// Definicion de variables de los libros propios 
	static final int MAX_LIBROS = 3; // para probar el ejercicio
	static int[] codigos = new int[MAX_LIBROS];
	static String[] titulos = new String[MAX_LIBROS];
	static String[] editoriales = new String[MAX_LIBROS];
	static int[] anios = new int[MAX_LIBROS];
	static String[] categorias = new String[MAX_LIBROS];
	static int[] copias = new int[MAX_LIBROS];
	
    public static void main(String[] args) {
		
    			System.out.println("****Sistema de gestión de libros****");
    			System.out.println();
    			LlenarLibros();
    			System.out.println();
    			// Menu de opciones
    			MenuOpciones();
    	
    	
    }
    
    // Llenado de libros
    public static void LlenarLibros() {
		for (int i = 0; i < MAX_LIBROS; i++) {
			System.out.println("Llenando libro " + (i + 1) + ": ---------------------------");
			codigos[i] = validarCodigo();
			entrada.nextLine(); // Limpiar el buffer
			System.out.print("Ingrese el título del libro : ");
			titulos[i] = entrada.nextLine();
			System.out.print("Ingrese la editorial del libro : ");
			editoriales[i] = entrada.next();
			anios[i] = leerAnio();
			categorias[i] = leerCategoria();
			System.out.print("Ingrese la cantidad de copias del libro : ");
			copias[i] = entrada.nextInt();
		}
	}
    
    
    
    static int validarCodigo() {
        int codigo = 0;
        boolean valido = false;
        
        do {
            System.out.print("Ingrese el código del libro: ");
            if (entrada.hasNextInt()) {
                codigo = entrada.nextInt();
                if (codigo <= 0) {
                    System.out.println("Error: El código debe ser un número positivo. Intente nuevamente.");
                } else {
                    // Check if this code already exists
                    boolean codigoExistente = false;
                    for (int i = 0; i < codigos.length; i++) {
                        if (codigos[i] == codigo) {
                            codigoExistente = true;
                            break;
                        }
                    }
                    
                    if (codigoExistente) {
                        System.out.println("Error: El código ya existe. Intente con otro código.");
                    } else {
                        valido = true;
                    }
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero. Intente nuevamente.");
                entrada.next(); // Limpia el buffer de entrada
            }
        } while (!valido);
        
        return codigo;
    }


 
    static int leerAnio() {
		int anio = 0;
		boolean valido = false;
		do {
			System.out.print("Ingrese el año de publicación del libro: ");
			anio = entrada.nextInt();
			if (anio < 0 || anio > 2025) {
				System.out.println("Año no válido. Intente nuevamente.");
			} else {
				valido = true;
			}
		} while (!valido);
		return anio;
	}
    
    
    static String leerCategoria() {
    	String editorial = "";
    	boolean valido = false;
    	do {
			System.out.print("Ingrese la Categoria: ");
			editorial = entrada.next();
			for (int i = 0; i < CATEGORIASPREDET.length; i++) {
				if (editorial.equalsIgnoreCase(CATEGORIASPREDET[i])) {
					valido = true;
				} 
			}
    	}while (!valido);
		return editorial;	
    }
    
    // Menu de opciones
    static void MenuOpciones() {
        int opcion;
        do {
            System.out.println("****MENU****");
            System.out.println("1. Presentar todos los libros.");
            System.out.println("2. Buscar un libro");
            System.out.println("3. Préstamo de libro.");
            System.out.println("4. Resumen de libros prestados.");
            System.out.println("5. Libros por categoría.");
            System.out.println("6. Libros ordenados por la cantidad de copias.");
            System.out.println("7. Total de libros por editoriales.");
            System.out.println("8. Total de libros por año.");
            System.out.println("9. Salir.");
            System.out.print("Ingrese una opción: "); // Changed to print
            
            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine(); // Consumir la nueva línea pendiente

                switch (opcion) {
                    case 1: PresentarLibros(); break;
                    case 2: BuscarLibro(); break;
                    case 3: PrestamoLibro(); break;
                    case 4: ResumenLibrosPrestados(); break;
                    case 5: LibrosPorCategoria(); break;
                    case 6: LibrosOrdenadosPorCopias(); break;
                    case 7: TotalLibrosPorEditoriales(); break;
                    case 8: TotalLibrosPorAnio(); break;
                    case 9:
                        System.out.println("Saliendo del programa...");
                        break; 
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                entrada.nextLine(); // Consumir la entrada incorrecta
                opcion = 0; // Asignar un valor que no sea 9 para continuar el bucle
            }
            System.out.println(); // Espacio para legibilidad
        } while (opcion != 9);
    }
    
    static void PresentarLibros() {
		System.out.println("****Presentar todos los libros****");
		for (int i = 0; i < codigos.length; i++) {
			System.out.println("Libro " + (i + 1)+"( "+ anios[i]+" )" + " - "+ categorias[i]+" - " +  
					":" + " Código: " + codigos[i] + " Título: " + titulos[i] + " Editorial: " 
					+ editoriales[i] + " Copias: " + copias[i]);
		}
	}
    
    static void BuscarLibro() {
		System.out.println("****Buscar libro por código****");
        System.out.print("Ingrese el código del libro a buscar: "); // Prompt agregado
		int codigo = entrada.nextInt();
        entrada.nextLine(); // Consumir la nueva línea pendiente
		boolean encontrado = false; // Para indicar si se encontró el libro
		for (int i = 0; i < codigos.length; i++) {
			if (codigos[i] == codigo) {
				System.out.println("Libro encontrado:");
				System.out.println("Código: " + codigos[i]);
				System.out.println("Título: " + titulos[i]);
				System.out.println("Editorial: " + editoriales[i]);
				System.out.println("Año: " + anios[i]);
				System.out.println("Categoría: " + categorias[i]);
				System.out.println("Copias: " + copias[i]);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) { // Si no se encontró el libro
            System.out.println("Error: No se encontró un libro con ese código.");
        }
	}
    
 // Arrays para guardar información de préstamos
    static String[] librosPrestados = new String[100]; // Asumimos máximo 100 préstamos
    static int contadorPrestamos = 0;

    static void PrestamoLibro() {
        System.out.println("****Préstamo de libro****");
        System.out.print("Ingrese el código del libro a prestar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine(); // Consumir la nueva línea pendiente
        boolean encontrado = false;
        
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (codigos[i] == codigo) { // Condición corregida
                encontrado = true;
                if (copias[i] > 0) {
                    copias[i]--; // Reducir el número de copias
                    
                    // Guardar información del préstamo
                    String infoPrestamo = "Título: " + titulos[i] + ", Editorial: " + editoriales[i] + 
                                          ", Año: " + anios[i] + ", Categoría: " + categorias[i];
                    librosPrestados[contadorPrestamos] = infoPrestamo;
                    contadorPrestamos++;
                    
                    System.out.println("Préstamo realizado con éxito. Copias restantes: " + copias[i]);
                } else {
                    System.out.println("Error: No hay copias disponibles para este libro.");
                }
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Error: No se encontró un libro con ese código.");
        }
    }

    static void ResumenLibrosPrestados() {
        System.out.println("****Resumen de libros prestados****");
        if (contadorPrestamos == 0) {
            System.out.println("No hay libros prestados.");
        } else {
            for (int i = 0; i < contadorPrestamos; i++) {
                System.out.println((i+1) + ". " + librosPrestados[i]);
            }
        }
    }
    
    static void LibrosPorCategoria() {
        System.out.println("****Libros por categoría****");
        
        for (String categoria : CATEGORIASPREDET) {
            System.out.println("\n=== Categoría: " + categoria + " ===");
            boolean hayLibros = false;
            
            for (int i = 0; i < MAX_LIBROS; i++) {
                if (categorias[i].equalsIgnoreCase(categoria)) {
                    System.out.println("Código: " + codigos[i]);
                    System.out.println("Título: " + titulos[i]);
                    System.out.println("Editorial: " + editoriales[i]);
                    System.out.println("Año: " + anios[i]);
                    System.out.println("Copias: " + copias[i]);
                    System.out.println("-----------------------");
                    hayLibros = true;
                }
            }
            
            if (!hayLibros) {
                System.out.println("No hay libros en esta categoría.");
            }
        }
    }
    
    static void LibrosOrdenadosPorCopias() {
        System.out.println("****Libros ordenados por cantidad de copias****");
        
        // Crear arrays temporales para no modificar los originales
        String[] tempTitulos = titulos.clone();
        int[] tempCopias = copias.clone();
        
        // Algoritmo de burbuja
        for (int i = 0; i < MAX_LIBROS - 1; i++) {
            for (int j = 0; j < MAX_LIBROS - i - 1; j++) {
                if (tempCopias[j] > tempCopias[j + 1]) {
                    // Intercambiar copias
                    int tempCopia = tempCopias[j];
                    tempCopias[j] = tempCopias[j + 1];
                    tempCopias[j + 1] = tempCopia;
                    
                    // Intercambiar títulos
                    String tempTitulo = tempTitulos[j];
                    tempTitulos[j] = tempTitulos[j + 1];
                    tempTitulos[j + 1] = tempTitulo;
                }
            }
        }
        
        // Mostrar los libros ordenados
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (tempTitulos[i] != null) {
                System.out.println("Copias: " + tempCopias[i]);
                System.out.println("Título: " + tempTitulos[i]);
                System.out.println("-----------------------");
            }
        }
    }
    
    static void TotalLibrosPorEditoriales() {
        System.out.println("****Total de libros por editorial****");
        
        // Crear un array de editoriales únicas
        String[] editoralesUnicas = new String[MAX_LIBROS];
        int[] conteoEditoriales = new int[MAX_LIBROS];
        int totalEditoriales = 0;
        
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (editoriales[i] != null) {
                boolean encontrada = false;
                
                // Verificar si la editorial ya está en el array
                for (int j = 0; j < totalEditoriales; j++) {
                    if (editoriales[i].equals(editoralesUnicas[j])) {
                        conteoEditoriales[j] += copias[i];
                        encontrada = true;
                        break;
                    }
                }
                
                // Si no se encontró la editorial, agregarla
                if (!encontrada) {
                    editoralesUnicas[totalEditoriales] = editoriales[i];
                    conteoEditoriales[totalEditoriales] = copias[i];
                    totalEditoriales++;
                }
            }
        }
        
        // Mostrar el resultado
        for (int i = 0; i < totalEditoriales; i++) {
            System.out.println("Editorial: " + editoralesUnicas[i] + " - Total de libros: " + conteoEditoriales[i]);
        }
    }
    
    static void TotalLibrosPorAnio() {
        System.out.println("****Total de libros por año de publicación****");
        
        // Crear arrays para años únicos y su conteo
        int[] aniosUnicos = new int[MAX_LIBROS];
        int[] conteoAnios = new int[MAX_LIBROS];
        int totalAnios = 0;
        
        for (int i = 0; i < MAX_LIBROS; i++) {
            if (anios[i] != 0) {
                boolean encontrado = false;
                
                // Verificar si el año ya está en el array
                for (int j = 0; j < totalAnios; j++) {
                    if (anios[i] == aniosUnicos[j]) {
                        conteoAnios[j] += copias[i];
                        encontrado = true;
                        break;
                    }
                }
                
                // Si no se encontró el año, agregarlo
                if (!encontrado) {
                    aniosUnicos[totalAnios] = anios[i];
                    conteoAnios[totalAnios] = copias[i];
                    totalAnios++;
                }
            }
        }
        
        // Mostrar el resultado
        for (int i = 0; i < totalAnios; i++) {
            System.out.println("Año: " + aniosUnicos[i] + " - Total de libros: " + conteoAnios[i]);
        }
    }
  
}
