package com.example.psp_a2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button btnPing;

    @FXML
    private Button btnDir;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnCalculator;



    @FXML
    protected void onPingClick() { HelloApplication.ping(); }

    @FXML
    protected void onDirClick() {
        HelloApplication.dir();
    }

    @FXML
    protected void onHelpClick() {
        HelloApplication.help();
    }

    @FXML
    protected void onCalcClick() {
        HelloApplication.calculator();
    }

}