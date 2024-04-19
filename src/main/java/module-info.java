module com.palmen.appmeteo.aplicacionmeteorologica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.palmen.appmeteo.aplicacionmeteorologica to javafx.fxml;
    exports com.palmen.appmeteo.aplicacionmeteorologica;
}