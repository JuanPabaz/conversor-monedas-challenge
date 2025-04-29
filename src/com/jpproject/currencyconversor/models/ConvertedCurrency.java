package com.jpproject.currencyconversor.models;

import java.time.Instant;

public class ConvertedCurrency {
    private String currencyToConvert;
    private String convertedCurrency;
    private double valueToConvert;
    private String convertedValue;
    private Instant timestamp;

    public ConvertedCurrency(String currencyToConvert, String convertedCurrency, double valueToConvert, String convertedValue, Instant timestamp) {
        this.currencyToConvert = currencyToConvert;
        this.convertedCurrency = convertedCurrency;
        this.valueToConvert = valueToConvert;
        this.convertedValue = convertedValue;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Conversión de " + valueToConvert + " " + currencyToConvert + " a " + convertedCurrency + " es: " + convertedValue + " " + convertedCurrency + " en " + timestamp;
    }
}
