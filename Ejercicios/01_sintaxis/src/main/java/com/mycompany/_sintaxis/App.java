/**
 * APP para mostrar los diferentes paradigmas de programacion
 */

package com.mycompany._sintaxis;

import java.util.Scanner;

/**
 *
 * @author Jack
 */
public class App {
    
    // Declaracion de constante
    static final double PRECIO = 25;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //paradigmaSecuencial();
        //paradigmaEstructurado();
        paradigma_procedimental();
    }
    
    // Ejemplo del paradigma secuencial
    public static void paradigmaSecuencial() {
        Scanner scanner = new Scanner(System.in);
        // Tipo de datos y declaracion de variables
        int n1, n2;
        double promedio;
        
        // Entrada de datos
        System.out.print("Ingrese nota 1: ");
        n1 = scanner.nextInt();
        
        System.out.print("Ingrese nota 2: ");
        n2 = scanner.nextInt();
        
        // Proceso
        promedio = (double)(n1 + n2) / 2;
        
        // salida de datos
        System.out.println("Promedio " + promedio);
    }
    
    public static void paradigmaEstructurado() {
        String nombreProducto;
        int cantidad;
        double monto;
        
        System.out.print("Nombre producto: ");
        nombreProducto = scanner.next();
        
        System.out.print("Cantidad de productos: ");
        
        cantidad = scanner.nextInt();
        
        monto = cantidad * PRECIO;
        
        if (cantidad > 3 ) {
            double dcto = monto*0.20;
            monto = monto - dcto;
        }
        System.out.println("- Producto: "+nombreProducto+ "\n- Monto: " + monto);
    
        
        
    }
    //PROCEDIMENTAL: funciones
        //funciones que no devuelve datos: void
        //foncines que devuelve datos: return
        
    public static void paradigma_procedimental(){
        int num1,num2,num3;
        num1= leer_numero("Ingrese numero 1 : ");
        num2= leer_numero("Ingrese numero 2 : ");
        num3= leer_numero("Ingrese numero 3 : ");
        
        //Encontrar el mayor valor
         if(num1 > num2 && num2 > num3){
             System.out.println("Mayor: " + num1);
         }
         else if(num2> num3 && num3 > num1){
             System.out.println("Mayor: " + num2);
         }
         else{
             System.out.println("Mayor: " + num3);
         }
    }
    public static int leer_numero(String mensaje){
        int num;
        System.out.println(mensaje);
        num= scanner.nextInt();
        
        return num;
    }
}