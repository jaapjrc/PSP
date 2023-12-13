package com.example.cutrenavegador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;


public class HelloController {
    @FXML
    private TextField txtUrl;

    @FXML
    private WebView webview;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        webview.getEngine().load(txtUrl.getText());
    }
}