package com.francisco.micambio.principal;

import com.francisco.micambio.herramientas.Historial;
import java.util.InputMismatchException;


public class Principal implements Historial {
    public static void main(String[] args) {
        //Creación del menú y revisó del historial viejo
        Menu menu=new Menu();
        Historial.borra();

        while (!menu.isDeberiaDetenerme()){
            try {
                menu.creaMenu();
                //si la respuesta esta vacía no generara solicitud ni se créara el hístorial
                if (!menu.getSalida().isEmpty()){
                    Solicitud solicitud = new Solicitud(menu);
                    if (menu.isDeberiaDetenerme()){
                        Historial.archiva();
                        break;
                    }
                    Historial.registra(solicitud);
                }

            }catch (InputMismatchException e){
                System.out.println("Solo ingresar números");
                break;
            }catch (NullPointerException e){
                System.out.println("Error desconocido");
            }
        }
        //Mensaje de despedida.
        System.out.println("Hasta la proxima");
    }
}
