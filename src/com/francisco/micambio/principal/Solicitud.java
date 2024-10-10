package com.francisco.micambio.principal;

import java.time.LocalDateTime;

public class Solicitud{
    //Asignando variables
    private LocalDateTime fechaDeLaSolicitud;
    private String resultadoDeLaSolicitud;
    private String monedaUno;
    private String monedaDos;
    //Cada solicitud es creada apartir de un menú
    public Solicitud(Menu menu) {
        this.fechaDeLaSolicitud = menu.getFecha();
        if (!menu.getSalida().equals("Opcion inválida.")){
            this.resultadoDeLaSolicitud=menu.getSalida();
        }else {
            this.resultadoDeLaSolicitud="Error en la solicitud.";
        }
        this.monedaUno=menu.getMoneda();
        this.monedaDos= menu.getReferecia();
    }
    //Formato del toString
    @Override
    public String toString() {
        return "Solicitud: " +
                "\n fechaDeLaSolicitud: " + fechaDeLaSolicitud +
                "\n resultadoeLaSolicitud: " + resultadoDeLaSolicitud +
                "\n monedaUno: " + monedaUno +
                "\n monedaDos: " + monedaDos +
                ". \n";
    }
}
