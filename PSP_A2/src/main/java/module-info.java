module com.example.psp_a2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.psp_a2 to javafx.fxml;
    exports com.example.psp_a2;
}