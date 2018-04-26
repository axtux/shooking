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
import java.util.ResourceBundle;

public class MainController implements Initializable {


    public void goToLogin(Stage stage) {
        GeneralView page = new GeneralView(stage, "Login", "Menu");
        String[] buttons = {"logout","goTo"};
        page.disableButtons(buttons);

        page.setTitle("Login Page");
        //loadFXML("Login");
        //update();
    }


     public void goToTerms(Stage stage) {
         stage.setTitle("Terms of use");
         loadFXML("TermsOfUse",stage);
         update(stage);
     }

     public void goToSignUp(Stage stage) {
         GeneralView page = new GeneralView(stage, "CreateAccount", "Menu");
         String[] buttons = {"logout","goTo"};
         page.disableButtons(buttons);

         page.setTitle("Login Page");

     }


     public void goToShoppingList(Stage stage) {
         GeneralView page = new GeneralView(stage, "ShoppingList", "Menu");
         String[] buttons = {"logout","goTo"};
         page.disableButtons(buttons);

         page.setTitle("Login Page");

     }



     public void goToMap(Stage stage){
         GeneralView page = new GeneralView(stage, "Login", "Menu");
         String[] buttons = {"logout","goTo"};
         page.disableButtons(buttons);

         page.setTitle("Login Page");

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
