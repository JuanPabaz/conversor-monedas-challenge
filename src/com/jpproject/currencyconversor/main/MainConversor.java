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
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/USD";
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
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                .create();

        do {
            System.out.println(menu);
            opcion = Integer.parseInt(sc.nextLine());

            try {
                switch (opcion) {
                    case 1:
                        System.out.println(subMenu);
                        double value = Double.parseDouble(sc.nextLine());
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());
                        String json = response.body();
                        ExchangeRateResponse exchangeRateResponse = gson.fromJson(json, ExchangeRateResponse.class);
                        Double conversion = MoneyConversion.convertCurrencies(opcion, exchangeRateResponse);
                        System.out.println("El valor de conversión de " + value + " dolares en pesos argentinos es: " + conversion + " pesos argentinos");
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        System.out.println("Saliendo del conversor");
                        break;
                    default:
                        System.out.println("Ingrese una opción valida");
                }

            }catch (IOException | InterruptedException e){
                System.out.println("Error al enviar la petición");
            }


        }while (opcion != 7);
    }
}
