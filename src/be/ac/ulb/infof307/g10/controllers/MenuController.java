package be.ac.ulb.infof307.g10.controllers;


import java.net.URL;

import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class MenuController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
        return;
    }

    @FXML
    public void goToMap(ActionEvent event){
        Main.getInstance().goToMap();
    }

    @FXML
    public void goToShoppingList(ActionEvent event){
        Main.getInstance().goToShoppingList();
    }

    @FXML
    public void goToLogin(ActionEvent event){
        Main.getInstance().goToLogin();
    }

    @FXML
    public void exit(ActionEvent event){
        Main.getInstance().exit();
    }


}
