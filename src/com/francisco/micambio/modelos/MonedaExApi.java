package com.francisco.micambio.modelos;

import java.util.Map;

public record MonedaExApi(Map<String, Double> conversion_rates, String time_last_update_utc, String base_code) {

    public double getUsd() {
        return conversion_rates.getOrDefault("USD", 0.0);
    }
    public double getEur() {
        return conversion_rates.getOrDefault("EUR", 0.0);
    }

}
