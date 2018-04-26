package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Connector;
import be.ac.ulb.infof307.g10.models.Session;
import be.ac.ulb.infof307.g10.models.exceptions.UserAlreadyExistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller class for the create account page
 * His aim is to detect some wrong cases in the input password and update the errorLabel
 */
public class CreateAccountController {

    @FXML
    TextField textFieldLog; //login field
    @FXML
    PasswordField pwdField; //password input field
    @FXML
    PasswordField pwdField2; //password verification field
    @FXML
    Label errorLabel; //text field to show if the creation of the account is not possible

    /*
    @FXML
    public void goToLogin(ActionEvent event){
        Main.getInstance().goToLogin();
    }

    @FXML
    public void exit(ActionEvent event){
        Main.getInstance().exit();
    }

*/
    @FXML
    public void submit(ActionEvent event){
        //field login recovered

        String log = textFieldLog.getText();
        //password field recovered

        String pwd = pwdField.getText();
        System.out.println(pwd);

        String pwd2 = pwdField2.getText();
        System.out.println(pwd2);

        if (pwd.equals(pwd2)) {
            try{
                Connector conn = new Connector();
                Session user = conn.createUser(log, pwd);
                //print it is ok
                errorLabel.setText("User created successfully");

            }
            catch(UserAlreadyExistException e){
                System.out.println("User Already exist");
                errorLabel.setText("This user name is already chosen");
            }
        } else {
            errorLabel.setText("The two Password are not the same");
        }
    }
}
