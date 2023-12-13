module com.example.cutrenavegador {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.cutrenavegador to javafx.fxml;
    exports com.example.cutrenavegador;
}