package com.francisco.micambio.principal;

import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        Menu menu=new Menu();
        while (!menu.deberiaDetenerme){
            try {
                menu.creaMenu();
            }catch (InputMismatchException e){
                System.out.println("Solo ingresar números");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    System.out.println("Error desconosido");;
                }
            }
        }
        System.out.println("Hasta la proxima");
    }
}
