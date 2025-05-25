package com.mycompany.farroizquierdo_mauriciofabian;

import java.util.Scanner;

/** @author mauricio Farro  */

class Banco{
String nombreBanco;
int maxRetiros;
int comisionDepositos;
}

class Movimiento {
    int cantDeposito;
    int cantRetiro;
}

class Cuenta {
    int dni;
    String nombres;
    String nombreBanco;
    double saldo;
    Movimiento movimientos;
}

public class FarroIzquierdo_MauricioFabian {
    
    static Scanner entrada = new Scanner(System.in);
    //constantes
    
    static final int MAX_CUENTAS = 3;
    static final int MAX_BANCOS = 3;
    
    //contadore
    static int contadorCuentas = 0;
    
    //FUNCIONES DE LAS Clases :
    //llenado
    
    static void llenarBanco (Banco banco ){
        System.out.print("Ingrese el Nombre del Banco : ");
        banco.nombreBanco = entrada.nextLine();
        System.out.print("Ingrese la cantidad maxima de retiros : ");
        banco.maxRetiros = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Ingrese El porcentaje de la comision : ");
        banco.comisionDepositos = entrada.nextInt();
        entrada.nextLine();
    }
    
    static void llenarCuenta (Cuenta cuenta , Banco [] bancos ){
        System.out.print("Ingrese Dni : ");
        cuenta.dni = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Ingrese Nombre : ");
        cuenta.nombres = entrada.nextLine();
        System.out.println("Bancos Disponibles : ");
        for (int i = 0; i < MAX_BANCOS; i++) {
            System.out.println((i+1)+". "+bancos[i].nombreBanco);
        }
        System.out.print("Elija su banco : ");
        int indiceBancoElegido = entrada.nextInt();
        entrada.nextLine();
        
        while (indiceBancoElegido < 1 || indiceBancoElegido > MAX_BANCOS){
            System.out.println("Elija una opcion valida");
            indiceBancoElegido = entrada.nextInt();
            entrada.nextLine();
        }
        cuenta.nombreBanco = bancos[indiceBancoElegido-1].nombreBanco;
        System.out.print("Saldo Inicial : ");
        cuenta.saldo = entrada.nextDouble();
        entrada.nextLine();
        cuenta.movimientos = new Movimiento();//creamos la clase movimiento
    }
    
    //mostrar
    static void mostrarBanco (Banco banco){
        System.out.println("Nombre : "+banco.nombreBanco
                +" Retiros Maximos : "+banco.maxRetiros 
                + " Porcentaje de comision : "+banco.comisionDepositos);
    }
    
    static void mostrarCuenta (Cuenta cuenta) {
        System.out.println("Dni : "+cuenta.dni
                +" Nombres : "+cuenta.nombres
                +" Nombre Banco "+cuenta.nombreBanco
                +" Saldo : "+cuenta.saldo);
    }
    
    
/////////////////////////////////////MAIN////////
    
    public static void main(String[] args) {
       
       Banco [] bancos = new Banco[MAX_BANCOS];
       Cuenta [] cuentas = new Cuenta[MAX_CUENTAS];
       
        llenarBancos(bancos); //llenamos todos los datos
        cuentas[0] = new Cuenta();
        System.out.println();
        System.out.println("Llenado de cuena inicial : ");
        llenarCuenta(cuentas[0], bancos);//cuenta incial 
        contadorCuentas++;
        
        
        //menu 
        System.out.println();
        menu(bancos, cuentas);

    }
    
/////////////////////////////////////MAIN///////
    
    //FUNCIONES De los Arreglos
    //llenar ----------------------------------------------
    static void llenarBancos (Banco [] bancos ){
    	System.out.println();
        System.out.println("---- LLenando Bancos ----");
        for (int i = 0; i < MAX_BANCOS; i++) {
            System.out.println("Banco "+(i+1)); 
            bancos[i] = new Banco();
            llenarBanco(bancos[i]);
        }
    } 
    
    static void llenarCuentas (Cuenta [] cuentas , Banco [] bancos){
        if(contadorCuentas<MAX_CUENTAS){
            System.out.println("Cuenta "+(contadorCuentas+1));
            cuentas[contadorCuentas] = new Cuenta();
            llenarCuenta(cuentas[contadorCuentas] , bancos);
            contadorCuentas++; 
        } else {
            System.out.println("No puede Agregar Mas Cuentas");
        }
    }
    
    //mostrar ----------------------------------------------
    static void mostrarBancos (Banco [] bancos ){
        for (int i = 0; i < MAX_BANCOS; i++) {
            mostrarBanco(bancos[i]);
        }
    }
    
    static void mostrarCuentas (Cuenta [] cuentas) {
        if (contadorCuentas == 0) {
            System.out.println("No hay cuentas registradas");
            return;
        }
        for (int i = 0; i < contadorCuentas; i++) { 
            if (cuentas[i] != null) {
                mostrarCuenta(cuentas[i]);
            }
        }
    }
    
    // moviemiento -------------------------------------------------------
    static void realizarMovimiento (Banco [] bancos ,Cuenta [] cuentas){
        if (contadorCuentas == 0) {
            System.out.println("No hay cuentas registradas");
            return;
        }
        
        for (int i = 0; i < contadorCuentas ; i++) { 
            if (cuentas[i] != null) {
                System.out.println((i+1)+". Cuenta de : "+cuentas[i].nombres);
            }
        }
        System.out.println("Elija su cuenta");
        int opcioncuenta = entrada.nextInt();
        entrada.nextLine();
        //validamos que elija el correcto 
        while (opcioncuenta < 1 || opcioncuenta > contadorCuentas){
            System.out.println("Elija una opcion valida");
            opcioncuenta = entrada.nextInt();
            entrada.nextLine();
        }
        
        // Validar que la cuenta seleccionada no sea null
        if (cuentas[opcioncuenta-1] == null) {
            System.out.println("Error: Cuenta no válida");
            return;
        }
        
        //menu de operaciones
        System.out.println();
        System.out.println("****MENU DE MOVIMIENTOS****");
        System.out.println("Saldo : "+cuentas[opcioncuenta-1].saldo);
        System.out.println("1.Retiro \n2.Deposito");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        while (opcion < 1 || opcion > 2){
            System.out.println("Elija una Opcion valida");
            opcion = entrada.nextInt();
            entrada.nextLine();
        }
        
        //opciones
        
        //opcion 1 : retiro
        if(opcion == 1){
            // Buscar el banco correspondiente a la cuenta
            String nombreBancoCuenta = cuentas[opcioncuenta-1].nombreBanco;
            Banco bancoCuenta = null;
            for (int i = 0; i < MAX_BANCOS; i++) {
                if (bancos[i].nombreBanco.equals(nombreBancoCuenta)) {
                    bancoCuenta = bancos[i];
                    break;
                }
            }
            
            // Validar que se encontró el banco
            if (bancoCuenta == null) {
                System.out.println("Error: No se encontró el banco");
                return;
            }
            
            // Validar maximo de retiros
            if (cuentas[opcioncuenta-1].movimientos.cantRetiro >= bancoCuenta.maxRetiros) {
                System.out.println("ha alcanzado el maximo de retiros");
                return;
            }
            System.out.println("monto a Retirar:");
            int monto = entrada.nextInt();
            entrada.nextLine();
            // Validamos el monto
            if(monto > 0 && monto <= cuentas[opcioncuenta-1].saldo){
                cuentas[opcioncuenta-1].saldo -= monto;
                cuentas[opcioncuenta-1].movimientos.cantRetiro++; // Incrementa contador de retiros
                System.out.println("Retiro realizado; Saldo Disponible : " + cuentas[opcioncuenta-1].saldo);
                System.out.println("Cantidad de retiros realizados: " + cuentas[opcioncuenta-1].movimientos.cantRetiro);
            } else {
                System.out.println("No cuenta con saldo suficiente");
            }
            
        //opcion 2 : deposito 
        } else if(opcion == 2){
            System.out.println("Ingrese el monto a depositar:");
            int monto = entrada.nextInt();
            entrada.nextLine();
            
            if(monto > 0){
                
                //Primero buscamos al banco por el nombre que ya tenemos en la cuenta
                String nombreBancoCuenta = cuentas[opcioncuenta-1].nombreBanco;
                Banco bancoCuenta = null;
                for (int i = 0; i < MAX_BANCOS; i++) {
                    if (bancos[i].nombreBanco.equals(nombreBancoCuenta)) {
                        bancoCuenta = bancos[i];
                        break;
                    }
                }
                
                // Validar que se encontró el banco
                if (bancoCuenta == null) {
                    System.out.println("Error: No se encontró el banco");
                    return;
                }
                
               //sacamos la comision
               double comision = 0;
               //para que sea double /double y no redondee
               comision = monto * bancoCuenta.comisionDepositos / 100.00; 
               
                double montoFinal = monto - comision; //aqui se aplica la comision
                cuentas[opcioncuenta-1].saldo += montoFinal;
                cuentas[opcioncuenta-1].movimientos.cantDeposito++; // Incrementa contador de depositos
                System.out.println("Deposito realizado; Saldo Disponible : " + cuentas[opcioncuenta-1].saldo);
                System.out.println("despositos de su cuenta : " + cuentas[opcioncuenta-1].movimientos.cantDeposito);
            } else {
                System.out.println("para poder cobrar comision este banco asegura que minimamente se deposite 1 sol");
            }
        }
    }

    static void menu(Banco [] bancos ,Cuenta [] cuentas ){
        int opcion ;
        do {
        System.out.println("1.Registrar Cuenta");
        System.out.println("2.Registrar Movimiento");
        System.out.println("3.Presentar Todas Las cuentas");
        System.out.println("4.Salir");
        
        while (!entrada.hasNextInt()) {
            System.out.println("Por favor ingrese un número válido");
            entrada.next();
        }
        opcion = entrada.nextInt();
        entrada.nextLine();
        
        switch (opcion) {
            case 1:llenarCuentas(cuentas , bancos);break;
            case 2:realizarMovimiento(bancos , cuentas);break;
            case 3:mostrarCuentas(cuentas);break;
            case 4:System.out.println("Saliendo...");break;
            default: 
                System.out.println("Elija una opcion correcta");
                    
            }
        }while (opcion !=4);
        
    }
}
