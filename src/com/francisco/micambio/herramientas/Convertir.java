package com.francisco.micambio.herramientas;

import com.francisco.micambio.modelos.Moneda;
import com.francisco.micambio.modelos.MonedaExApi;

public interface Convertir {
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
}
