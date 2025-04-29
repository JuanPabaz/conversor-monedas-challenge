package com.jpproject.currencyconversor.calculations;

import com.jpproject.currencyconversor.models.ExchangeRateResponse;

public class MoneyConversion {
    public static Double convertCurrencies(int opcion, ExchangeRateResponse exchangeRateResponse, double value) {
        return switch (opcion) {
            case 1-> value * exchangeRateResponse.conversionRates().get("ARS");
            case 2,4,6 -> value * exchangeRateResponse.conversionRates().get("USD");
            case 3 -> value * exchangeRateResponse.conversionRates().get("BRL");
            case 5 -> value * exchangeRateResponse.conversionRates().get("COP");
            default -> null;
        };
    }
}
