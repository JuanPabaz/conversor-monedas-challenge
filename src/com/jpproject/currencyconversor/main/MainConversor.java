package com.jpproject.currencyconversor.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpproject.currencyconversor.calculations.MoneyConversion;
import com.jpproject.currencyconversor.models.ExchangeRateResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
                7) Salir
                Elija una opción valida:
                """;
        String subMenu = """
                Ingrese la cantidad a convertir:
                """;
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        do {
            System.out.println(menu);
            opcion = Integer.parseInt(sc.nextLine());
            System.out.println(subMenu);
            double value = Double.parseDouble(sc.nextLine());
            double conversion;
            String currencyCode;
            ExchangeRateResponse exchangeRateResponse;
            try {
                switch (opcion) {
                    case 1, 3, 5:
                        currencyCode = "USD";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        System.out.println("El valor de conversión de " + value + " dolares en pesos argentinos es: " + conversion + " pesos argentinos");
                        break;
                    case 2:
                        currencyCode = "ARS";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        System.out.println("El valor de conversión de " + value + " dolares en pesos argentinos es: " + conversion + " pesos argentinos");
                        break;
                    case 4:
                        currencyCode = "BRL";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        System.out.println("El valor de conversión de " + value + " dolares en pesos argentinos es: " + conversion + " pesos argentinos");
                        break;
                    case 6:
                        currencyCode = "COP";
                        exchangeRateResponse = sendRequest(gson, currencyCode, client, url);
                        conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse, value);
                        System.out.println("El valor de conversión de " + value + " dolares en pesos argentinos es: " + conversion + " pesos argentinos");
                        break;
                    case 7:
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
