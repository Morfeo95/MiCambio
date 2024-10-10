package com.francisco.micambio.modelos;

public class Moneda {
    private String tipo;
    private double valor;
    private String fechaDeLaUltimaActualizacion;
    private double valorEur;
    //Las monedas so creadas apartir de Monedaexapi que extrae los datos de la api
    public Moneda(MonedaExApi monedaExApi) {
        this.valor = monedaExApi.getUsd();
        this.fechaDeLaUltimaActualizacion = monedaExApi.time_last_update_utc();
        this.tipo = monedaExApi.base_code();
        this.valorEur = monedaExApi.getEur();
    }
    //Getters y setters
    public double getValor() {
        return valor;
    }

    public double getValorEur() {
        return valorEur;
    }
    //toString Modificado.
    @Override
    public String toString() {
        return "tipo: " + tipo +
                "\nvalor: " + valor +
                "\nfechaDeLaUltimaActualizacion: " + fechaDeLaUltimaActualizacion;
    }
}
