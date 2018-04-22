package be.ac.ulb.infof307.g10.controllers;


import java.net.URL;

import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import javafx.fxml.Initializable;


public class MenuController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
        return;
    }

    public void goToMap(){
        Main.getInstance().goToMap();
    }

    public void goToShoppingList(){
        Main.getInstance().goToShoppingList();
    }

    public void goToLogin(){
        Main.getInstance().goToLogin();
    }

    public void exit(){
        Main.getInstance().exit();
    }


}
