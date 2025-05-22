package Moneda;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDeMoneda {
    private static final String API_KEY = "15ca830b810e6c658e266b78";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public MonedasContact fetchCurrency(String currencyCode) {
        URI address = URI.create(BASE_URL + API_KEY + "/latest/" + currencyCode);

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Cannot connect to the server: " + e.getMessage(), e);
        }

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error in the status: " + response.statusCode() + " - " + response.body());
        }

        // Map response to MonedasContact object
        return new Gson().fromJson(response.body(), MonedasContact.class);
    }
}