package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.views.GeneralView;
import be.ac.ulb.infof307.g10.views.MapRendering;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    public void goToLogin() {
        Main.getInstance().goToLogin();
    }

    public void goToTerms() {
        Main.getInstance().goToTerms();
    }

    public void goToSignUp() {
        Main.getInstance().goToCreateAccount();

    }
    public void goToRecipe() {
        Main.getInstance().goToRecipe();
    }
    public void goToShoppingList() {
        Main.getInstance().goToShoppingList();

    }

    public void goToCreateAccount(){
        Main.getInstance().goToTerms();
    }

    public void goToMap(){
        //TODO checker si pas fxml GeneralView page = new GeneralView(stage, "Login", "Menu");
        Main.getInstance().goToLogin();

    }

    public void exit(){
        Platform.exit();
    }

    private void loadFXML(String name, Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(name+".fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // never happens as resource in packed with application
            e.printStackTrace();
        }
    }

    private void update(Stage stage) {
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        return;
    }
}
