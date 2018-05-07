package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import javafx.application.Platform;

/**
 * This class is the main controller, it implements all the methods used in the different page of the application.
 * The redirection to the over pages are implemented here
 */
public class MainController {


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
        Main.getInstance().goToMap();

    }

    public void exit(){
        Platform.exit();
    }

}
