package com.jpproject.currencyconversor.models;

import java.util.Map;

public record ExchangeRateResponse(
        String result,
        String baseCode,
        Map<String, Double> conversionRates
) {}
