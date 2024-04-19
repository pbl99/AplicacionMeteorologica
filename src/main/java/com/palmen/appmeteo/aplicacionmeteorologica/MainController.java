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

        if (dayOfWeek == DayOfWeek.WEDNESDAY) {
            lblDiaPrimero.setText("MIERCOLES");
            lblDiaSegundo.setText("JUEVES");
            lblDiaTercero.setText("VIERNES");
            lblDiaCuarto.setText("SABADO");
            lblDiaQuinto.setText("DOMINGO");
            lblDiaSexto.setText("LUNES");
            lblDiaSeptimo.setText("MARTES");
        }
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            lblDiaPrimero.setText("VIERNES");
            lblDiaSegundo.setText("SABADO");
            lblDiaTercero.setText("DOMINGO");
            lblDiaCuarto.setText("LUNES");
            lblDiaQuinto.setText("MARTES");
            lblDiaSexto.setText("MIERCOLES");
            lblDiaSeptimo.setText("JUEVES");
        }
    }

    @FXML
    private void initialize() {
        actualizarDiasSegunDiaActual();
    }

}