package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller class for the create account page
 * His aim is to detect some wrong cases in the input password and update the errorLabel
 */
public class CreateAccountController extends MainController {

    @FXML
    TextField textFieldLog; //login field
    @FXML
    PasswordField pwdField; //password input field
    @FXML
    PasswordField pwdField2; //password verification field
    @FXML
    Label errorLabel; //text field to show if the creation of the account is not possible

    /**
     * This method is used to check the information entered in the view to create the new user
     * Some error could be shown to the user in the corresponding view
     */
    @FXML
    public void submit(ActionEvent event){
    	
        String log = textFieldLog.getText();
        String pwd = pwdField.getText();
        String pwd2 = pwdField2.getText();

        if (pwd.equals(pwd2)) {
            try{
                User user = User.signup(log, pwd);
                errorLabel.setText("User created successfully");
                goToShoppingList();

            }
            catch(ExistingException e){
                errorLabel.setText("This user name already exists");
            }
        } else {
            errorLabel.setText("The two Passwords are different");
        }
    }
}
