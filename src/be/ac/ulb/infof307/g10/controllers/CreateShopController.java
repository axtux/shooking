package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateShopController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField monday;

    @FXML
    private TextField tuesday;

    @FXML
    private TextField wedsnday;

    @FXML
    private TextField thursday;

    @FXML
    private TextField friday;

    @FXML
    private TextField saturday;

    @FXML
    private TextField sunday;

    @FXML
    private Button creation;

    @FXML
    void create(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert monday != null : "fx:id=\"monday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert tuesday != null : "fx:id=\"tuesday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert wedsnday != null : "fx:id=\"wedsnday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert thursday != null : "fx:id=\"thursday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert friday != null : "fx:id=\"friday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert saturday != null : "fx:id=\"saturday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert sunday != null : "fx:id=\"sunday\" was not injected: check your FXML file 'ShopCreation.fxml'.";
        assert creation != null : "fx:id=\"creation\" was not injected: check your FXML file 'ShopCreation.fxml'.";

    }
}

