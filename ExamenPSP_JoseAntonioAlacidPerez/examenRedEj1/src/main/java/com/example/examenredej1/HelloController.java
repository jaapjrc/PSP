package com.example.examenredej1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

public class HelloController {

    @FXML
    private Button btnMundo;

    @FXML
    private Button btnOpinion;

    @FXML
    private Button btnPais;

    @FXML
    private Button btnVerdad;

    @FXML
    private WebView webView;

    @FXML
    protected void onMundoClick() {
        webView.getEngine().load("https://www.elmundo.es/");
    }

    @FXML
    protected void onOpinionClick() {
        webView.getEngine().load("https://www.laopiniondemurcia.es/");
    }

    @FXML
    protected void onPaisClick() {
        webView.getEngine().load("https://elpais.com/");
    }

    @FXML
    protected void onVerdadClick() {
        webView.getEngine().load("https://www.laverdad.es/");
    }

}
