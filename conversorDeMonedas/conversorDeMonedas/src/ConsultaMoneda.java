import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda convertirMoneda(String monedaOrigen, String monedaDestino){
        String direccionAPI = "https://v6.exchangerate-api.com/v6/33ec1f3a240d93a254fbc326/pair/"+monedaOrigen+"/"+monedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionAPI))
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("no encontre ese formato de moneda");
        }
    }
}
