package com.example.examenprocesosej2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private Button btnCPaint;

    @FXML
    private Button btnCPaint2;

    @FXML
    private Button btnPaint;

    @FXML
    private Button btnPaint2;

    // Controlan que el usuario no pueda ejecutar los métodos para cerrar a no ser que
    // el método para abrir este en ejecucción
    private boolean control = false;
    private boolean control1 = false;
    private boolean control2 = false;


    @FXML
    protected void onPaintClick(){
        if (!control) {
            HelloApplication.paint();
            control = true;
            control1 = true;
        }
    }

    @FXML
    protected void onPaint2Click(){
        if (!control) {
            HelloApplication.paint2();
            control = true;
            control2 = true;
        }
    }

    @FXML
    protected void onCPaintClick(){
        if (control1) {
            HelloApplication.cPaint();
            control = false;
            control1 = false;
        }
    }

    @FXML
    protected void onCPaint2Click(){
        if (control2) {
            HelloApplication.cPaint2();
            control = false;
            control1 = false;
        }
    }

}
