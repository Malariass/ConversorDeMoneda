import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    private final ExchangeRateService exchangeRateService;

    public CurrencyConverter() {
        this.exchangeRateService = new ExchangeRateService();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            printMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    convertCurrency("USD", "ARS");
                    break;
                case 2:
                    convertCurrency("ARS", "USD");
                    break;
                case 3:
                    convertCurrency("USD", "BRL");
                    break;
                case 4:
                    convertCurrency("BRL", "USD");
                    break;
                case 5:
                    convertCurrency("USD", "COP");
                    break;
                case 6:
                    convertCurrency("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 7);
    }

    private void printMenu() {
        System.out.println("Bienvenido al conversor de moneda UwU");
        System.out.println("Elija una opción:");
        System.out.println("1) Dólar a Peso argentino");
        System.out.println("2) Peso argentino a Dólar");
        System.out.println("3) Dólar a Real brasileño");
        System.out.println("4) Real brasileño a Dólar");
        System.out.println("5) Dólar a Peso colombiano");
        System.out.println("6) Peso colombiano a Dólar");
        System.out.println("7) Salir");
    }

    private void convertCurrency(String fromCurrency, String toCurrency) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad en " + fromCurrency + ": ");
        double amount = scanner.nextDouble();

        try {
            double exchangeRate = exchangeRateService.fetchExchangeRate(fromCurrency, toCurrency);
            double convertedAmount = amount * exchangeRate;
            System.out.printf("%.2f %s son %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IOException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
