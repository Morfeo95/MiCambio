package com.francisco.micambio.principal;

import com.francisco.micambio.herramientas.Convertir;
import java.util.Scanner;

public class Menu implements Convertir {

    boolean deberiaDetenerme;

    void creaMenu(){
        System.out.println(
                """
                        *******************************************
                        Ingresa la opción deseada:
                        1) Peso Méxicano.
                        2) Dólar Americano.
                        3) Peso Argentino.
                        4) Réal Brasileño.
                        5) Euro.
                        9) Salir.
                        *******************************************
                        """
        );
        Scanner opcionMenu = new Scanner(System.in);
        int opcion = opcionMenu.nextInt();
        opcionMenu.nextLine();
        switch (opcion){
            case 1:
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Peso Méxicano a Dólares.
                        2) Peso Méxicano a Euros.
                        9) Salir.
                        """);
                opcion = opcionMenu.nextInt();
                opcionMenu.nextLine();
                if (opcion == 1){
                    System.out.println("Ingrese la cantidad a convertir.");
                    double cantidad = opcionMenu.nextDouble();
                    opcionMenu.nextLine();
                    System.out.println(cantidad+" pesos Méxicanos son: "+convierte(cantidad,"MXN", false)+" Dolares");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                } else if (opcion == 2) {
                    System.out.println("Ingrese la cantidad a convertir.");
                    double cantidad = opcionMenu.nextDouble();
                    opcionMenu.nextLine();
                    System.out.println(cantidad+" pesos Méxicanos son: "+convierteEur(cantidad,"MXN", false)+" Euros");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                else if (opcion==9){
                    break;
                }else {
                    System.out.println("Opcio inválida.");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                break;
            case 2:
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Dólar a Peso Méxicano.
                        2) Dólar a Peso Argentino.
                        3) Dólar a Real Brasileño.
                        4) Dolar a Euro.
                        9) Salir.
                        """);
                opcion = opcionMenu.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la cantidad a convertir.");
                        double cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Dólares son: "+convierte(cantidad,"MXN",true)+" Pesos Méxicanos.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad a convertir.");
                        cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Dólares son: "+convierte(cantidad,"ARS",true)+" Pesos Argentinos.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad a convertir.");
                        cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Dólares son: "+convierte(cantidad,"BRL",true)+" Réales Brasileños.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad a convertir.");
                        cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Dólares son: "+convierte(cantidad,"EUR",true)+" Euros.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Opcin inválida.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                }
                break;
            case 3:
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Peso Argentino a Dólares.
                        2) Peso Argentino a Euros.
                        9) Salir.
                        """);

                opcion = opcionMenu.nextInt();
                if (opcion == 1){
                    System.out.println("Ingrese la cantidad a convertir.");
                    double cantidad = opcionMenu.nextDouble();
                    opcionMenu.nextLine();
                    System.out.println(cantidad+" pesos Argentinos son: "+convierte(cantidad,"ARS", false)+" Dolares");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                } else if (opcion == 2) {
                    System.out.println("Ingrese la cantidad a convertir.");
                    double cantidad = opcionMenu.nextDouble();
                    opcionMenu.nextLine();
                    System.out.println(cantidad+" pesos Argentinos son: "+convierteEur(cantidad,"ARS", false)+" Euros");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                else if (opcion==9){
                    break;
                }else {
                    System.out.println("Opcio inválida.");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                break;

            case 4:
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Réal Brasileño a Dólares.
                        2) Réal Brasileño a Euros.
                        9) Salir.
                        """);

                opcion = opcionMenu.nextInt();
                if (opcion == 1){
                    System.out.println("Ingrese la cantidad a convertir.");
                    double cantidad = opcionMenu.nextDouble();
                    opcionMenu.nextLine();
                    System.out.println(cantidad+" Réales Brasileños son: "+convierte(cantidad,"BRL", false)+" Dolares");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                } else if (opcion == 2) {
                    System.out.println("Ingrese la cantidad a convertir.");
                    double cantidad = opcionMenu.nextDouble();
                    opcionMenu.nextLine();
                    System.out.println(cantidad+" Réales Brasileños son: "+convierteEur(cantidad,"BRL", false)+" Euros");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                else if (opcion==9){
                    break;
                }else {
                    System.out.println("Opcio inválida.");
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                break;
            case 5:
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Euro a Peso Méxicano.
                        2) Euro a Peso Argentino.
                        3) Euro a Real Brasileño.
                        4) Euro a Dólar.
                        9) Salir.
                        """);
                opcion = opcionMenu.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la cantidad a convertir.");
                        double cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Euros son: "+convierteEur(cantidad,"MXN",true)+" Pesos Méxicanos.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad a convertir.");
                        cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Euros son: "+convierteEur(cantidad,"ARS",true)+" Pesos Argentinos.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad a convertir.");
                        cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Euros son: "+convierteEur(cantidad,"BRL",true)+" Réales Brasileños.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad a convertir.");
                        cantidad = opcionMenu.nextDouble();
                        opcionMenu.nextLine();
                        System.out.println(cantidad+" Euros son: "+convierteEur(cantidad,"USD",true)+" Euros.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Opcin inválida.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                }
                break;
            case 9:
                this.deberiaDetenerme=true;
                break;

            default:
                System.out.println("Opción inválida");
                System.out.println("Preciona ENTER para continuar...");
                opcionMenu.nextLine();
                break;
        }

    }

}
