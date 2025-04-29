package com.jpproject.currencyconversor.models;

import java.time.Instant;

public class ConvertedCurrency {
    private String currencyToConvert;
    private String convertedCurrency;
    private double valueToConvert;
    private String convertedValue;
    private Instant timestamp;

    public ConvertedCurrency() {
    }

    public ConvertedCurrency(String currencyToConvert, String convertedCurrency, double valueToConvert, String convertedValue, Instant timestamp) {
        this.currencyToConvert = currencyToConvert;
        this.convertedCurrency = convertedCurrency;
        this.valueToConvert = valueToConvert;
        this.convertedValue = convertedValue;
        this.timestamp = timestamp;
    }

    public String getCurrencyToConvert() {
        return currencyToConvert;
    }

    public void setCurrencyToConvert(String currencyToConvert) {
        this.currencyToConvert = currencyToConvert;
    }

    public String getConvertedCurrency() {
        return convertedCurrency;
    }

    public void setConvertedCurrency(String convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }

    public double getValueToConvert() {
        return valueToConvert;
    }

    public void setValueToConvert(double valueToConvert) {
        this.valueToConvert = valueToConvert;
    }

    public String getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(String convertedValue) {
        this.convertedValue = convertedValue;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
