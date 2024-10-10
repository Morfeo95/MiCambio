package com.francisco.micambio.herramientas;

import com.francisco.micambio.modelos.Moneda;
import com.francisco.micambio.modelos.MonedaExApi;

import java.util.Scanner;

public interface Convertir {
    //Utilizándo el valor de una unica moneda esta función extrae el valor de la moneda con respecto al dolar y multiplica o divide deacuerdo a la situación.
    default Double convierte(double cantidad, String codigo, boolean modo){
        MonedaExApi monedaExApi = new Receptor().crea(codigo);
        Moneda moneda = new Moneda(monedaExApi);
        if (modo){
            double valor = moneda.getValor();
            return cantidad/valor;
        }else {
            double valor = moneda.getValor();
            return cantidad*valor;
        }
    }
    //La misma funcionalidad de la anterior función pero con respecto al euro.
    default Double convierteEur(double cantidad, String codigo, boolean modo){
        MonedaExApi monedaExApi = new Receptor().crea(codigo);
        Moneda moneda = new Moneda(monedaExApi);
        if (modo){
            double valor = moneda.getValorEur();
            return cantidad/valor;
        }else {
            double valor = moneda.getValorEur();
            return cantidad*valor;
        }
    }
    //Solicita la cantidad de divisas a convertir y formatea el texto de salida
    default String imprime(int opcion, String moneda, String codigo){
        Scanner opcionMenu = new Scanner(System.in);
        if (opcion == 1){
            System.out.println("Ingrese la cantidad a cónvertir.");
            double cantidad = opcionMenu.nextDouble();
            opcionMenu.nextLine();
            return String.format("%s %s son: %.2f Dólares", cantidad, moneda, convierte(cantidad, codigo, false));

        } else if (opcion == 2) {
            System.out.println("Ingrese la cantidad a cónvertir.");
            double cantidad = opcionMenu.nextDouble();
            opcionMenu.nextLine();
            return String.format("%s %s son: %.2f Euros", cantidad, moneda, convierteEur(cantidad, codigo, false));

        }else {
           return "Opcion inválida.";
        }
    }
    //Lo mismo que la anterior función pero resumido solo para dolares
    default String imprimeDolares(String moneda, String codigo){
        Scanner opcionMenu = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a cónvertir.");
        double cantidad = opcionMenu.nextDouble();
        return String.format("%.2f Dólares son: %.2f %s", cantidad, convierte(cantidad, codigo, true), moneda);

    }
    //Misma funcion pero para euros.
    default String imprimeEuros(String moneda, String codigo){
        Scanner opcionMenu = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a cónvertir.");
        double cantidad = opcionMenu.nextDouble();
        return String.format("%.2f Euros son: %.2f %s", cantidad, convierteEur(cantidad, codigo, true), moneda);
    }
}
