# Currency Conversor - Java Console App

Bienvenido al **Currency Conversor**, una aplicación de consola desarrollada en Java que permite convertir monedas entre dólares estadounidenses (USD) y otras divisas latinoamericanas (ARS, BRL, COP) utilizando la API de ExchangeRate-API.

## ✨ Funcionalidades

- Conversión entre las siguientes monedas:
    - Dólar (USD) ⇄ Peso argentino (ARS)
    - Dólar (USD) ⇄ Real brasileño (BRL)
    - Dólar (USD) ⇄ Peso colombiano (COP)
- Consulta de historial de conversiones realizadas durante la ejecución del programa.
- Interfaz de usuario mediante consola simple y clara.

## 💡 Tecnologías utilizadas

- Java 17+
- API HTTP Client (`java.net.http`)
- Gson (para parseo de JSON)
- ExchangeRate-API (versión gratuita)

## 📦 Estructura del proyecto
```
com.jpproject.currencyconversor 
    ├── calculations │ 
        └── MoneyConversion.java 
    ├── main │ 
        └── MainConversor.java 
    ├── models │ 
        ├── ConvertedCurrency.java 
        └── ExchangeRateResponse.java
```

## 🔑 API Key
La aplicación utiliza ExchangeRate-API para obtener las tasas de cambio. En el código se incluye una API key de ejemplo, pero se recomienda registrar tu propia cuenta gratuita y reemplazar la clave en:
```
String apiKey = "TU_API_KEY_AQUÍ";
```

## 📄 Historial de conversiones
Puedes consultar todas las conversiones realizadas durante la ejecución seleccionando la opción 7 del menú.

## 🧑‍💻 Autor
- Juan Pablo Giraldo Tamayo - @JuanPabaz