
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TipoDeCambio {
    public static double Tasa(String monedaReferencia, String monedaConvertir) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/a0abf329afe009436ddf0901/pair/"+monedaReferencia+"/"+monedaConvertir))
                        .GET()
                        .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
        return conversionRate;

    }
}
