package com.palmen.appmeteo.aplicacionmeteorologica;

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
    private Label lblTempDiaCuarto;

    @FXML
    private Label lblTempDiaPrimero;

    @FXML
    private Label lblTempDiaQuinto;

    @FXML
    private Label lblTempDiaSegundo;

    @FXML
    private Label lblTempDiaSeptimo;

    @FXML
    private Label lblTempDiaSexto;

    @FXML
    private Label lblTempDiaTercero;

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

    @FXML
    private void initialize() {
        actualizarDiasSegunDiaActual();
    }

}