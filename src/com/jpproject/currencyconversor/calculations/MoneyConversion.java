package com.jpproject.currencyconversor.calculations;

import com.jpproject.currencyconversor.models.ExchangeRateResponse;

public class MoneyConversion {
    public static Double convertCurrencies(int opcion, ExchangeRateResponse exchangeRateResponse) {
        return switch (opcion) {
            case 1 -> exchangeRateResponse.usd() / exchangeRateResponse.ars();
            case 2 -> exchangeRateResponse.ars() * exchangeRateResponse.usd();
            case 3 -> exchangeRateResponse.usd() / exchangeRateResponse.brl();
            case 4 -> exchangeRateResponse.usd() * exchangeRateResponse.brl();
            case 5 -> exchangeRateResponse.usd() / exchangeRateResponse.cop();
            case 6 -> exchangeRateResponse.usd() * exchangeRateResponse.cop();
            default -> null;
        };
    }
}
