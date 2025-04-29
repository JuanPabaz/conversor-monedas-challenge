package com.jpproject.currencyconversor.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpproject.currencyconversor.calculations.MoneyConversion;
import com.jpproject.currencyconversor.models.ConvertedCurrency;
import com.jpproject.currencyconversor.models.ExchangeRateResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConversor {
    public static void main(String[] args) {
        String apiKey = "8c35ce5732bb89a2969c9b16";
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/";
        Scanner sc = new Scanner(System.in);
        int opcion;
        String menu = """
                Sea bienvenido al conversor de monedas.
                
                1) Dolar => Peso argentino
                2) Peso argentino => Dolar
                3) Dolar => Real brasileño
                4) Real brasileño => Dolar
                5) Dolar => Peso colombiano
                6) Peso colombiano => Dolar
                7) Listado de conversiones
                8) Salir
                Elija una opción valida:
                """;
        String subMenu = """
                Ingrese la cantidad a convertir:
                """;
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        List<ConvertedCurrency> convertedCurrencies = new ArrayList<>();

        do {
            System.out.println(menu);
            opcion = Integer.parseInt(sc.nextLine());
            double value;
            Double conversion;
            String currencyCode;
            ExchangeRateResponse exchangeRateResponse;
            String formatted;
            try {
                switch (opcion) {
                    case 1, 3, 5:
                        System.out.println(subMenu);
                        value = Double.parseDouble(sc.nextLine());
                        currencyCode = "USD";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        String convertedCurrency;
                        String convertedCurrencyCode;
                        if (opcion == 1){
                            convertedCurrency = "pesos argentinos";
                            convertedCurrencyCode = "ARS";
                        }else if (opcion == 3){
                            convertedCurrency = "reales brasileños";
                            convertedCurrencyCode = "BRL";
                        }else{
                            convertedCurrency = "pesos colombianos";
                            convertedCurrencyCode = "COP";
                        }
                        formatted = String.format("%.2f", conversion);
                        convertedCurrencies.add(new ConvertedCurrency(currencyCode,convertedCurrencyCode, value, formatted, Instant.now()));
                        System.out.println("El valor de conversión de " + value + " dolares a "+ convertedCurrency + " es: " + formatted + " " + convertedCurrency);
                        break;
                    case 2:
                        System.out.println(subMenu);
                        value = Double.parseDouble(sc.nextLine());
                        currencyCode = "ARS";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        formatted = String.format("%.2f", conversion);
                        convertedCurrencies.add(new ConvertedCurrency(currencyCode,"USD", value, formatted, Instant.now()));
                        System.out.println("El valor de conversión de " + value + " pesos argentinos a dolares es: " + formatted + " pesos argentinos");
                        break;
                    case 4:
                        System.out.println(subMenu);
                        value = Double.parseDouble(sc.nextLine());
                        currencyCode = "BRL";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        formatted = String.format("%.2f", conversion);
                        convertedCurrencies.add(new ConvertedCurrency(currencyCode,"USD", value, formatted, Instant.now()));
                        System.out.println("El valor de conversión de " + value + " reales brasileños a dolares es: " + formatted + " pesos argentinos");
                        break;
                    case 6:
                        System.out.println(subMenu);
                        value = Double.parseDouble(sc.nextLine());
                        currencyCode = "COP";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        formatted = String.format("%.2f", conversion);
                        convertedCurrencies.add(new ConvertedCurrency(currencyCode,"USD", value, formatted, Instant.now()));
                        System.out.println("El valor de conversión de " + value + " pesos colombianos a dolares es: " + formatted + " pesos argentinos");
                        break;
                    case 7:
                        if (convertedCurrencies.isEmpty()) {
                            System.out.println("No se han generado conversiones");
                        }else {
                            System.out.println(convertedCurrencies);
                        }
                        break;
                    case 8:
                        System.out.println("Saliendo del conversor");
                        break;
                    default:
                        System.out.println("Ingrese una opción valida");
                }
            }catch (IOException e){
                System.out.println("Error al enviar la petición");
            }


        }while (opcion != 7);
    }

    public static ExchangeRateResponse sendRequest(Gson gson, String currencyCode, HttpClient client, String url) throws IOException {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url+currencyCode))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, ExchangeRateResponse.class);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
