package com.francisco.micambio.herramientas;

import com.francisco.micambio.modelos.MonedaExApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Receptor {

    public MonedaExApi crea(String moneda){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/76049b0e721848229edd83cf/latest/"+moneda))
                .build();

        HttpResponse<String> response = null;
        try {
            response=client
                .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), MonedaExApi.class);


    }

}
