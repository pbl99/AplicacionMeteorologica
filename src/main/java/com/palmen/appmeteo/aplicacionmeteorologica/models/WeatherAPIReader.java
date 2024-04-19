package com.palmen.appmeteo.aplicacionmeteorologica.models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherAPIReader {
    private Document doc;

    public WeatherAPIReader(String apiUrl) throws Exception {
        // Realizar la solicitud HTTP para obtener el XML de la API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Crear un DocumentBuilder para parsear el XML de la respuesta
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el documento XML de la respuesta HTTP
        this.doc = builder.parse(connection.getInputStream());

        // Cerrar la conexión
        connection.disconnect();
    }

    public String obtenerTemperaturaMaxima(String dia) {
        Element dayElement = (Element) doc.getElementsByTagName(dia).item(0);
        return dayElement.getElementsByTagName("temperature_max").item(0).getTextContent();
    }

    public String obtenerTemperaturaMinima(String dia) {
        Element dayElement = (Element) doc.getElementsByTagName(dia).item(0);
        return dayElement.getElementsByTagName("temperature_min").item(0).getTextContent();
    }

    public String obtenerEstadoClima(String dia) {
        Element dayElement = (Element) doc.getElementsByTagName(dia).item(0);
        return dayElement.getElementsByTagName("text").item(0).getTextContent();
    }

    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.tutiempo.net/xml/?lan=es&apid=axT4Xqa4qqaMMMV&lid=3081";
            WeatherAPIReader xmlHandler = new WeatherAPIReader(apiUrl);

            String dia1 = "day1";
            String dia2 = "day2";

            System.out.println("Dia 1:");
            System.out.println("Temperatura Máxima: " + xmlHandler.obtenerTemperaturaMaxima(dia1));
            System.out.println("Temperatura Mínima: " + xmlHandler.obtenerTemperaturaMinima(dia1));
            System.out.println("Estado del Clima: " + xmlHandler.obtenerEstadoClima(dia1));

            System.out.println("\nDia 2:");
            System.out.println("Temperatura Máxima: " + xmlHandler.obtenerTemperaturaMaxima(dia2));
            System.out.println("Temperatura Mínima: " + xmlHandler.obtenerTemperaturaMinima(dia2));
            System.out.println("Estado del Clima: " + xmlHandler.obtenerEstadoClima(dia2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
