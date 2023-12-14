module com.example.examenprocesosej2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examenprocesosej2 to javafx.fxml;
    exports com.example.examenprocesosej2;
}