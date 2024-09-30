package com.francisco.micambio.modelos;

public class Moneda {
    private String tipo;
    private double valor;
    private String fechaDeLaUltimaActualizacion;
    private double valorEur;

    public Moneda(MonedaExApi monedaExApi) {
        this.valor = monedaExApi.getUsd();
        this.fechaDeLaUltimaActualizacion = monedaExApi.time_last_update_utc();
        this.tipo = monedaExApi.base_code();
        this.valorEur = monedaExApi.getEur();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public double getValorEur() {
        return valorEur;
    }

    public String getFechaDeLaUltimaActualizacion() {
        return fechaDeLaUltimaActualizacion;
    }

    @Override
    public String toString() {
        return "tipo: " + tipo +
                "\nvalor: " + valor +
                "\nfechaDeLaUltimaActualizacion: " + fechaDeLaUltimaActualizacion;
    }
}
