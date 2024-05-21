import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/debd1b735c0b1820561cc3d8/latest/";

    public double fetchExchangeRate(String fromCurrency, String toCurrency) throws IOException {
        String urlString = API_URL + fromCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error al conectar con la API: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        Gson gson = new Gson();
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(content.toString(), ExchangeRateResponse.class);
        return exchangeRateResponse.getConversionRates().get(toCurrency);
    }
}
