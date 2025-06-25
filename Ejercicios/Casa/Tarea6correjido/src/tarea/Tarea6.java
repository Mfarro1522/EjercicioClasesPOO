package tarea;
/*** @author mauri */

import java.util.Scanner;


class Venta {
    int total;
    int pagosContado; 
    int pagosCredito; 
}

class Producto {
    int id;
    String nombreProducto;
    int precio;
}
class Empleado {
    String codigo;
    String nombre;
    String turno;
    int sueldo;
    Venta ventaR;
}



public class Tarea6 {
    
    //Funciones de LLenar 1 clase

	static void llenarEmpleado(Empleado empleado) {
	    System.out.println("Ingrese el codigo del empleado");
	    empleado.codigo = entrada.nextLine();
	    System.out.println("Ingrese el nombre del empleado");
	    empleado.nombre = entrada.nextLine();
	    System.out.println("Ingrese el turno del empleado");
	    empleado.turno = entrada.nextLine();
	    System.out.println("Ingrese el sueldo del empleado");
	    empleado.sueldo = entrada.nextInt();
	    entrada.nextLine(); 
	    
	    empleado.ventaR = new Venta();
	}
	
	static void llenarProducto(Producto producto) {
	    
	    producto.id = contadorAlmacen+1;
            System.out.println("Id asignado del producto : " + producto.id);
	    System.out.println("Ingrese el nombre del producto");
	    producto.nombreProducto = entrada.nextLine();
	    System.out.println("Ingrese el precio del producto");
	    producto.precio = entrada.nextInt();
	    entrada.nextLine();
	}
	
	//funciones de mostrar 1 clase
	
	static void mostrarEmpleado(Empleado empleado) {
	    System.out.println("Codigo: " + empleado.codigo+
	            " Nombre: " + empleado.nombre +
	            " Turno: " + empleado.turno +
	            " Sueldo: " + empleado.sueldo);
	}
	
	static void mostrarAlmacen(Producto almacen) {
	    System.out.println("Id: " + almacen.id +
	            " Nombre: " + almacen.nombreProducto +
	            " Precio: " + almacen.precio);
	}

    static final int MAX = 3;
    static Scanner entrada = new Scanner(System.in);
    static int contadorEmpleados = 0;
    static int contadorAlmacen = 0;
///////////////////////////////////////MAIN////////////////////////////////
    
    public static void main(String[] args) {
        Empleado[] Tienda = new Empleado[MAX];
        Producto[] almacen = new Producto[MAX];
        
        Menu(Tienda, almacen);

    }
    
//////////////////////////////////////////////////////////////////////////
    //funcion para llenar el arreglo de empleados cuando sea necesario
    static void llenarTienda(Empleado[] tienda) {
        if (contadorEmpleados < MAX) {
        	tienda[contadorEmpleados] = new Empleado();
            System.out.println("Empleado " + (contadorEmpleados + 1));
            //se le pasa el objeto empleado para que se llene
            llenarEmpleado(tienda[contadorEmpleados]);
            contadorEmpleados++;
        } else {
            System.out.println("No se pueden agregar mas empleados. Limite alcanzado.");
        }
    }

    //funcion para llenar el arreglo de productos cuando sea necesario
    static void llenarAlmacen(Producto[] almacen) {
        if (contadorAlmacen < MAX) {
        	almacen[contadorAlmacen] = new Producto();
            System.out.println("Producto " + (contadorAlmacen + 1));
            //se le pasa el objeto almacen para que se lllene
            llenarProducto(almacen[contadorAlmacen]);
            contadorAlmacen++;
        } else {
            System.out.println("No se pueden agregar mas productos. Limite alcanzado.");
        }
    }

    //funcion para mostrar el arreglo de empleados
    static void mostrarTienda(Empleado[] tienda) { 
        if (contadorEmpleados == 0) {
            System.out.println("No hay empleados para mostrar.");
            return;
        }
        for (int i = 0; i < contadorEmpleados; i++) { 
            System.out.println("Empleado " + (i + 1));
            mostrarEmpleado(tienda[i]);
        }
    }
    //funcion para mostrar el arreglo de productos
    static void mostrarAlmacen(Producto[] almacen) { 
        if (contadorAlmacen == 0) {
            System.out.println("No hay productos para mostrar.");
            return;
        }
        for (int i = 0; i < contadorAlmacen; i++) { 
            System.out.println("Producto " + (i + 1));
            mostrarAlmacen(almacen[i]);
        }
    }

    //Menu de ventas1
    static void menuVentas(Empleado[] empleados, Producto[] almacen) {
        if (contadorEmpleados == 0 || contadorAlmacen == 0) {
            System.out.println("No hay suficientes empleados o productos para realizar una venta.");
            return;
        }
        System.out.println("****Menu de Ventas****");
        System.out.println("1. Realizar venta");
        System.out.println("2. Volver al menu principal");
        int opcion = entrada.nextInt();
        entrada.nextLine(); 
        switch (opcion) {
            case 1:
                Empleado empleadoSeleccionado = empleados[(int) (Math.random() * contadorEmpleados)];
                realizarVenta(empleadoSeleccionado, almacen);
                break;
            case 2:return; 
            default:System.out.println("Opcion no valida");break;
        }
    }
    //funcion para realizar la venta
    static void realizarVenta(Empleado empleado, Producto[] almacen) {
        if (contadorAlmacen == 0) {
            System.out.println("No hay productos en el almacen.");
            return;
        }
        System.out.println("Empleado que atiende: " + empleado.nombre);
        System.out.println("Seleccione el producto a vender:");
        for (int i = 0; i < contadorAlmacen; i++) {
            System.out.println((i + 1) + ". " + almacen[i].nombreProducto + " (Precio: " + almacen[i].precio + ")");
        }
        int indiceProduc = entrada.nextInt() - 1;
        entrada.nextLine(); 

        if (indiceProduc < 0 || indiceProduc >= contadorAlmacen) {
            System.out.println("Selección de producto no valida.");
            return;
        }

        Producto productoVendido = almacen[indiceProduc];
        System.out.println("Ingrese la cantidad de '" + productoVendido.nombreProducto + "':");
        int cantidad = entrada.nextInt();
        entrada.nextLine(); 

        if (cantidad <= 0) {
            System.out.println("Cantidad no valida.");
            return;
        }

        int montoVenta = cantidad * productoVendido.precio;

        System.out.println("Seleccione el tipo de pago:");
        System.out.println("1. Contado");
        System.out.println("2. Credito");
        int tipoPago = entrada.nextInt();
        entrada.nextLine(); 

        if (tipoPago == 1) {
            empleado.ventaR.pagosContado += 1;
        } else if (tipoPago == 2) {
            empleado.ventaR.pagosCredito += 1;
        } else {
            System.out.println("Tipo de pago no valido. Venta no registrada.");
            return;
        }
        empleado.ventaR.total += montoVenta;
        System.out.println("Venta de " + montoVenta + " registrada para " + empleado.nombre + ".");
        System.out.println("Total de ventas del empleado: " + empleado.ventaR.total);
    }

    //funcion para mostrar las ventas
    static void mostrarVentas(Empleado [] tienda){
        if (contadorEmpleados == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("****Ventas por empleado****");
        for (int i = 0; i < contadorEmpleados; i++) {
            Empleado emp = tienda[i];
            System.out.println("Empleado: " + emp.nombre);
            if (emp.ventaR != null) {
                System.out.println("  Total ventas: " + emp.ventaR.total);
                System.out.println("  Pagos al contado: " + emp.ventaR.pagosContado);
                System.out.println("  Pagos a credito: " + emp.ventaR.pagosCredito);
            } else {
                System.out.println("  No tiene ventas registradas.");
            }
        }
    }

    // Nueva función para solicitar y mostrar ventas de un empleado específico
    static void MostrarVentasEmpleado(Empleado[] tienda) {
        if (contadorEmpleados > 0) {
            System.out.println("Seleccione el empleado para mostrar sus ventas (1-" + contadorEmpleados + "):");
            for (int i = 0; i < contadorEmpleados; i++) {
                System.out.println((i + 1) + ". " + tienda[i].nombre);
            }
            int empIndex = entrada.nextInt() - 1;
            entrada.nextLine(); 
            if (empIndex >= 0 && empIndex < contadorEmpleados) {
                
                System.out.println("Empleado: " + tienda[empIndex].nombre);
                System.out.println("Total ventas: " + tienda[empIndex].ventaR.total);
                System.out.println("Pagos al contado: " + tienda[empIndex].ventaR.pagosContado);
                System.out.println("Pagos a credito: " + tienda[empIndex].ventaR.pagosCredito);
            } else {
                System.out.println("Selección invalida.");
            }
        } else {
            System.out.println("No hay empleados registrados.");
        }
    }

    //funciones extras
    //Empleados por turno
    static void empleadosTurno(Empleado[] tienda) {
        if (contadorEmpleados == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("****Empleados por turno****");
        System.out.println("Ingrese el turno a buscar (Ej: Manana, Tarde, Noche):");
        String turnoBuscado = entrada.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < contadorEmpleados; i++) {
            if (tienda[i].turno.equalsIgnoreCase(turnoBuscado)) {
                System.out.println("Empleado: " + tienda[i].nombre + ", Codigo: " + tienda[i].codigo);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron empleados en el turno '" + turnoBuscado + "'.");
        }
    }
    //empleado que mas vende
    static void empleadoMasVende(Empleado[] empleados) {
        if (contadorEmpleados == 0) {
            System.out.println("No hay empleados para evaluar.");
            return;
        }
        int maxVentas = -1;
        Empleado empleadoConMasVentas = null;
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].ventaR != null && empleados[i].ventaR.total > maxVentas) {
                maxVentas = empleados[i].ventaR.total;
                empleadoConMasVentas = empleados[i];
            }
        }
        if (empleadoConMasVentas != null) {
            System.out.println("Empleado que mas vende: " + empleadoConMasVentas.nombre + " con un total de " + maxVentas);
        } else {
            System.out.println("No hay ventas registradas o ningun empleado ha vendido.");
        }
    }

    //total de ventas por tipos de pago
    static void totalVentas(Empleado[] empleados) {
        if (contadorEmpleados == 0) {
            System.out.println("No hay empleados para calcular ventas totales.");
            return;
        }
        int totalContadoGeneral = 0;
        int totalCreditoGeneral = 0;
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].ventaR != null) {
                totalContadoGeneral += empleados[i].ventaR.pagosContado;
                totalCreditoGeneral += empleados[i].ventaR.pagosCredito;
            }
        }
        System.out.println("Total general de ventas al contado: " + totalContadoGeneral);
        System.out.println("Total general de ventas a credito: " + totalCreditoGeneral);
    }

    //ordenar por total monto de ventas
    static void ordenarVentas(Empleado[] empleados) {
        if (contadorEmpleados > 0) {
        	 if (contadorEmpleados == 0) {
             	System.out.println("No hay empleados para ordenar.");
                 return;
             }
             for (int i = 0; i < contadorEmpleados - 1; i++) {
                 for (int j = 0; j < contadorEmpleados - i - 1; j++) {
                     int totalVentasJ = (empleados[j].ventaR != null) ? empleados[j].ventaR.total : 0;
                     int totalVentasJ1 = (empleados[j + 1].ventaR != null) ? empleados[j + 1].ventaR.total : 0;
                     if (totalVentasJ < totalVentasJ1) {
                         Empleado temp = empleados[j];
                         empleados[j] = empleados[j + 1];
                         empleados[j + 1] = temp;
                     }
                 }
             }
            System.out.println("Empleados ordenados por monto de ventas (descendente):");
            mostrarTienda(empleados);
        } else {
            System.out.println("No hay empleados para ordenar.");
        }
    }

    //menu principal
    static void Menu(Empleado[] Tienda, Producto[] almacen) {
        int opcion;
        do {
            System.out.println("\n****MENU PRINCIPAL****");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Agregar producto al almacen");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Mostrar productos del almacen");
            System.out.println("5. Realizar venta");
            System.out.println("6. Mostrar ventas");
            System.out.println("7. Mostrar ventas de un empleado");
            System.out.println("8. Mostrar empleados por turno");
            System.out.println("9. Mostrar empleado que mas vende");
            System.out.println("10. Mostrar total de ventas (contado/credito)");
            System.out.println("11. Ordenar empleados por monto de ventas");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir la nueva línea

            switch (opcion) {
            case 1:llenarTienda(Tienda);break;
            case 2:llenarAlmacen(almacen);break;
            case 3:mostrarTienda(Tienda);break;
            case 4:mostrarAlmacen(almacen);break;
            case 5:menuVentas(Tienda , almacen);break;
            case 6:mostrarVentas(Tienda ); break;
            case 7:MostrarVentasEmpleado(Tienda);break;
            case 8:empleadosTurno(Tienda);break;
            case 9:empleadoMasVende(Tienda);break;
            case 10:totalVentas(Tienda);break;
            case 11:ordenarVentas(Tienda);break;
            case 12:System.out.println("Saliendo del programa...");break;
            default:System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 12);
      }



}
