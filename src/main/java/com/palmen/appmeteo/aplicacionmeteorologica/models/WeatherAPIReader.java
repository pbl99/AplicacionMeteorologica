package com.palmen.appmeteo.aplicacionmeteorologica.models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


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

    public String obtenerImagenClima(String estadoClima) {
        // HashMap para mapear los estados del clima a las rutas de las imágenes correspondientes
        HashMap<String, String> imagenesClima = new HashMap<>();
        imagenesClima.put("Parcialmente nuboso", "https://v5i.tutiempo.net/wi/01/30/4.png");
        imagenesClima.put("Cubierto", "https://v5i.tutiempo.net/wi/01/30/7.png");
        imagenesClima.put("Muy nuboso", "https://v5i.tutiempo.net/wi/01/30/6.png");
        imagenesClima.put("Cubierto con lluvias", "https://v5i.tutiempo.net/wi/01/30/19.png");
        //imagenesClima.put("Muy nuboso con lluvias", "lluviaFuerte.png");
        imagenesClima.put("Muy nuboso con probabilidad de lluvia", "https://v5i.tutiempo.net/wi/01/30/19.png");

        // Obtener la ruta de la imagen correspondiente al estado del clima
        return imagenesClima.getOrDefault(estadoClima, "tormenta.png");
    }
}
