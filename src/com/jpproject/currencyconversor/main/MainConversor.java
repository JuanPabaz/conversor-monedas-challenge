package com.jpproject.currencyconversor.main;

import java.util.Scanner;

public class MainConversor {
    public static void main(String[] args) {
        String apiKey = "8c35ce5732bb89a2969c9b16";
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest";
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
        do {
            System.out.println(menu);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:

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

        }while (opcion != 7);
    }
}
