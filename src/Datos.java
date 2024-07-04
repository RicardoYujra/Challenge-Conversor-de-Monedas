import com.google.gson.JsonObject;

public record Datos(String baseCurrency, JsonObject conversionRates) {
    // Método para obtener la tasa de conversión
    public double getExchangeRate(String toCurrency) {
        return conversionRates.get(toCurrency).getAsDouble();
    }
}
