import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaConversion {

    private static final String apiKey = "a4a48772a2ece0ebb8dd9e3e"; // Reemplaza con tu clave API
    private static final String urlBase = "https://v6.exchangerate-api.com/v6/";

    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String url = urlBase + apiKey + "/latest/" + fromCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();

        return amount * exchangeRate;
    }
}
