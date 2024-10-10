package com.francisco.micambio.principal;

import com.francisco.micambio.herramientas.Convertir;
import com.francisco.micambio.herramientas.Historial;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu implements Convertir {
    //Asignando variables
    private boolean deberiaDetenerme;
    private String moneda;
    private String codigo;
    private LocalDateTime fecha;
    private String salida;
    private  String referecia;
    //Getters y setters
    public String getReferecia() {
        return referecia;
    }

    public boolean isDeberiaDetenerme() {
        return deberiaDetenerme;
    }

    public String getMoneda() {
        return moneda;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getSalida() {
        return salida;
    }
    //Creación del menú
    void creaMenu(){
        this.fecha = LocalDateTime.now();
        System.out.println(
                """
                        *******************************************
                        Ingresa la opción deseada:
                        1) Peso Méxicano.
                        2) Dólar Americano.
                        3) Peso Argentino.
                        4) Réal Brasileño.
                        5) Euro.
                        6) Historial.
                        9) Salir.
                        *******************************************
                        """
        );
        //Registrando opciones.
        Scanner opcionMenu = new Scanner(System.in);
        int opcion = opcionMenu.nextInt();
        opcionMenu.nextLine();
        switch (opcion){
            //opcion Pesos Méxicanos
            case 1:
                this.moneda = "Pesos Méxicanos";
                this.codigo= "MXN";
                this.referecia="Dólares.";
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Peso Méxicano a Dólares.
                        2) Peso Méxicano a Euros.
                        9) Salir.
                        """);
                opcion = opcionMenu.nextInt();
                opcionMenu.nextLine();
               if (opcion==9){
                   break;
               }else {
                   if (opcion==2){
                       this.referecia="Euros";
                   }
                   salida = imprime(opcion,moneda,codigo);
                   System.out.println(salida);
                   System.out.println("Preciona ENTER para continuar...");
                   opcionMenu.nextLine();
               }
                break;
            //Opcion Dolares
            case 2:
                this.moneda = " Dólares";
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
                opcionMenu.nextLine();
                //Cada opción cambia o asigna el valor de las constates
                switch (opcion){
                    case 1:
                        this.referecia=" Pesos Méxicanos.";
                        this.codigo="MXN";
                        salida = imprimeDolares(referecia, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar.");
                        opcionMenu.nextLine();
                        break;
                    case 2:
                        this.referecia=" Pesos Argentinos.";
                        this.codigo="ARS";
                        salida = imprimeDolares(referecia, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar.");
                        opcionMenu.nextLine();
                        break;
                    case 3:
                        this.referecia=" Réales Brasileños.";
                        this.codigo="BRL";
                        salida = imprimeDolares(referecia, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar.");
                        opcionMenu.nextLine();
                        break;
                    case 4:
                        this.referecia=" Euros.";
                        this.codigo="EUR";
                        salida = imprimeDolares(referecia, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar.");
                        opcionMenu.nextLine();
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Opcion inválida.");
                        System.out.println("Preciona ENTER para continuar...");
                        opcionMenu.nextLine();
                        break;
                }
                break;
            //Opcion Pesos Argentinos
            case 3:
                this.moneda= " Peso Argentino.";
                this.referecia="Dólares.";
                this.codigo="ARS";
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Peso Argentino a Dólares.
                        2) Peso Argentino a Euros.
                        9) Salir.
                        """);

                opcion = opcionMenu.nextInt();
                opcionMenu.nextLine();
                if (opcion==9){
                    break;
                }else {
                    if (opcion==2){
                        this.referecia="Euros";
                    }
                    salida = imprime(opcion,moneda,codigo);
                    System.out.println(salida);
                    System.out.println("Preciona ENTER para continuar...");
                    opcionMenu.nextLine();
                }
                break;
            //Opción Réales Brazileños.
            case 4:
                this.moneda=" Réales Brasileños";
                this.referecia="Dólares.";
                this.codigo="BRL";
                System.out.println("""
                        *******************************************
                        Ingresa la opción deseada:
                        1) Réal Brasileño a Dólares.
                        2) Réal Brasileño a Euros.
                        9) Salir.
                        """);

                opcion = opcionMenu.nextInt();
                opcionMenu.nextLine();
                if (opcion==9){
                    break;
                }else {
                    if (opcion==2){
                        this.referecia="Euros";
                    }
                    salida = imprime(opcion,moneda,codigo);
                    System.out.println(salida);
                    System.out.println("Preciona ENTER para cóntinuar...");
                    opcionMenu.nextLine();
                }
                    break;
            //Opcion Euros
            case 5:
                this.referecia="Euros";
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
                opcionMenu.nextLine();
                //Misma funcionalidad que en Dólares.
                switch (opcion){
                    case 1:
                        this.moneda=" Peso Méxicano";
                        this.codigo="MXN";
                        salida = imprimeEuros(moneda, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar...");
                        opcionMenu.nextLine();
                        break;
                    case 2:
                        this.moneda=" Peso Argentino";
                        this.codigo="ARS";
                        salida = imprimeEuros(moneda, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar...");
                        opcionMenu.nextLine();
                        break;
                    case 3:
                        this.moneda=" Réal Brasileño.";
                        this.codigo="BRL";
                        salida = imprimeEuros(moneda, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar...");
                        opcionMenu.nextLine();
                        break;
                    case 4:
                        this.moneda=" Dólares";
                        this.codigo="USD";
                        salida = imprimeEuros(moneda, codigo);
                        System.out.println(salida);
                        System.out.println("Preciona ENTER para cóntinuar...");
                        opcionMenu.nextLine();
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Opcin inválida.");
                        System.out.println("Preciona ENTER para cóntinuar...");
                        opcionMenu.nextLine();
                        break;
                }
                break;
            //Opción ver el historial.
            case 6:
                Historial.muestra();
                this.deberiaDetenerme=true;
                break;
            //Opcion Salir
            case 9:
                this.deberiaDetenerme=true;
                break;
            //Opciones equivocas
            default:
                System.out.println("Opción inválida");
                System.out.println("Preciona ENTER para cóntinuar...");
                opcionMenu.nextLine();
                break;
        }

    }


}
