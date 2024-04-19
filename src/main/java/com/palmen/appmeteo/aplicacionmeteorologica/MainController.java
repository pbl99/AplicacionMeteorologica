package com.palmen.appmeteo.aplicacionmeteorologica;

import com.palmen.appmeteo.aplicacionmeteorologica.models.WeatherAPIReader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MainController {
    @FXML
    private ImageView imgDiaCuarto;

    @FXML
    private ImageView imgDiaPrimero;

    @FXML
    private ImageView imgDiaQuinto;

    @FXML
    private ImageView imgDiaSegundo;

    @FXML
    private ImageView imgDiaSeptimo;

    @FXML
    private ImageView imgDiaSexto;

    @FXML
    private ImageView imgDiaTercero;

    @FXML
    private Label lblDiaCuarto;

    @FXML
    private Label lblDiaPrimero;

    @FXML
    private Label lblDiaQuinto;

    @FXML
    private Label lblDiaSegundo;

    @FXML
    private Label lblDiaSeptimo;

    @FXML
    private Label lblDiaSexto;

    @FXML
    private Label lblDiaTercero;

    @FXML
    private Label lblTempMaxDiaCuarto;

    @FXML
    private Label lblTempMaxDiaPrimero;

    @FXML
    private Label lblTempMaxDiaQuinto;

    @FXML
    private Label lblTempMaxDiaSegundo;

    @FXML
    private Label lblTempMaxDiaSeptimo;

    @FXML
    private Label lblTempMaxDiaSexto;

    @FXML
    private Label lblTempMaxDiaTercero;

    @FXML
    private Label lblTempMinDiaCuarto;

    @FXML
    private Label lblTempMinDiaPrimero;

    @FXML
    private Label lblTempMinDiaQuinto;

    @FXML
    private Label lblTempMinDiaSegundo;

    @FXML
    private Label lblTempMinDiaSeptimo;

    @FXML
    private Label lblTempMinDiaSexto;

    @FXML
    private Label lblTempMinDiaTercero;

    public void actualizarDiasSegunDiaActual() {
        // Obtener la fecha actual
        LocalDate today = LocalDate.now();

        // Obtener el día de la semana actual
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        // Definir los nombres de los días de la semana
        String[] diasSemana = {"DOMINGO", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO"};

        // Encontrar la posición del día actual en el arreglo
        int indexDiaActual = dayOfWeek.getValue();

        // Actualizar los labels de los días de la semana
        for (int i = 0; i < 7; i++) {
            String diaActual = diasSemana[indexDiaActual];
            switch (i) {
                case 0:
                    lblDiaPrimero.setText(diaActual);
                    break;
                case 1:
                    lblDiaSegundo.setText(diaActual);
                    break;
                case 2:
                    lblDiaTercero.setText(diaActual);
                    break;
                case 3:
                    lblDiaCuarto.setText(diaActual);
                    break;
                case 4:
                    lblDiaQuinto.setText(diaActual);
                    break;
                case 5:
                    lblDiaSexto.setText(diaActual);
                    break;
                case 6:
                    lblDiaSeptimo.setText(diaActual);
                    break;
            }
            indexDiaActual = (indexDiaActual + 1) % 7; // Avanzar al siguiente día, circularmente
        }

    }

    public void actualizarTemperaturasSegunDia() {
        try {
            WeatherAPIReader weatherAPIReader = new WeatherAPIReader("https://api.tutiempo.net/xml/?lan=es&apid=axT4Xqa4qqaMMMV&lid=3081");
            // Obtener el día actual
            LocalDate today = LocalDate.now();
            DayOfWeek dayOfWeek = today.getDayOfWeek();
            String[] diasSemana = {"DOMINGO", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO"};
            int indexDiaActual = dayOfWeek.getValue() - 1; // Indices del array comienzan desde 0

            // Iterar sobre los próximos 7 días para actualizar las temperaturas
            for (int i = 0; i < 7; i++) {
                String dia = "day" + (i + 1); // Obtener el día correspondiente
                String temperaturaMaxima = weatherAPIReader.obtenerTemperaturaMaxima(dia);
                String temperaturaMinima = weatherAPIReader.obtenerTemperaturaMinima(dia);

                // Actualizar las temperaturas según el día de la semana
                switch (i) {
                    case 0:
                        lblTempMaxDiaPrimero.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaPrimero.setText(temperaturaMinima + "º MIN");
                        break;
                    case 1:
                        lblTempMaxDiaSegundo.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaSegundo.setText(temperaturaMinima + "º MIN");
                        break;
                    case 2:
                        lblTempMaxDiaTercero.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaTercero.setText(temperaturaMinima + "º MIN");
                        break;
                    case 3:
                        lblTempMaxDiaCuarto.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaCuarto.setText(temperaturaMinima + "º MIN");
                        break;
                    case 4:
                        lblTempMaxDiaQuinto.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaQuinto.setText(temperaturaMinima + "º MIN");
                        break;
                    case 5:
                        lblTempMaxDiaSexto.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaSexto.setText(temperaturaMinima + "º MIN");
                    case 6:
                        lblTempMaxDiaSeptimo.setText(temperaturaMaxima + "º MAX");
                        lblTempMinDiaSeptimo.setText(temperaturaMinima + "º MIN");
                }

                // Avanzar al siguiente día circularmente
               // indexDiaActual = (indexDiaActual + 1) % 7;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize() {
        actualizarDiasSegunDiaActual();
        actualizarTemperaturasSegunDia();
    }

}