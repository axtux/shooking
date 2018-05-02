package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Connector;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.UserDoesNotExistException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends MainController{

    @FXML
    TextField loginField; //login field
    @FXML
    PasswordField pwdField; //password input field
    @FXML
    Label printLabel; //text field to show if the login of the account is not possible, or if the connection succeed

    /**
     * This method is used to check the information of the user in the database and connect the user to the application
     * Some error could be shown to the user in the corresponding view
     */
    @FXML
    public void submit(){
        String log = loginField.getText();
        //Capture of the "password" field
        String pwd = pwdField.getText();
        System.out.println(pwd);
        try{
            Connector conn = new Connector();
            User user = conn.openSession(log, pwd);
            printLabel.setText("Connection ...");
            Main.getInstance().goToShoppingList();
        }
        catch(IncorrectPasswordException e){
            System.out.println("Bad Password");
            printLabel.setText("Incorrect Password !");
        } catch(UserDoesNotExistException e) {
            printLabel.setText("This user don't exist !");
        }
    }

}
