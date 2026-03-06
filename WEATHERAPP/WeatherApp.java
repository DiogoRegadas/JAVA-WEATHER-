import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder; // Para tratar nomes de cidades
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class WeatherApp {

    // Removi o final estático direto para evitar erro de compilação
    private static String API_KEY; 

    public static void main(String[] args) {
        try {
            // Lendo a chave dentro do main com tratamento de erro
            API_KEY = Files.readString(Path.of("apikey.txt")).trim();
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter city name: ");
            String cityName = scanner.nextLine();
            
            String weatherData = getWeatherData(cityName);
            
            // Verificação de erro da API (cidade não encontrada)
            if (weatherData.contains("\"error\"")) {
                System.out.println("City not found or API error.");
            } else {
                printWeatherInfo(weatherData);
            }
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static String getWeatherData(String cityName) throws Exception {
        // Codifica o nome da cidade (ex: "São Paulo" vira "S%C3%A3o+Paulo")
        String encodedCity = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        String url = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + encodedCity;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static void printWeatherInfo(String weatherData) {
        JSONObject json = new JSONObject(weatherData);
        JSONObject location = json.getJSONObject("location");
        JSONObject current = json.getJSONObject("current");
        
        String city = location.getString("name");
        String country = location.getString("country");
        double tempC = current.getDouble("temp_c");
        String condition = current.getJSONObject("condition").getString("text");
        
        System.out.println("\n--- Weather Forecast ---");
        System.out.println("Location: " + city + ", " + country);
        System.out.println("Temperature: " + tempC + "°C");
        System.out.println("Condition: " + condition);
    }
}