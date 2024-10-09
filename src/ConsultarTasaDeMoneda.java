import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarTasaDeMoneda {

    public Moneda buscaMoneda(String monedaBase) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7a1f6c562c7eb4c9918c51ff/latest/"
                + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        //return new Gson().fromJson(response.body(), Moneda.class);

        //System.out.println(response.body());
        Moneda moneda = null;
        try {
            moneda = new Gson().fromJson(response.body(), Moneda.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return moneda;
    }
}