module com.example.examenredej1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.examenredej1 to javafx.fxml;
    exports com.example.examenredej1;
}