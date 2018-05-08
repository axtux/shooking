package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller of the Login view It is used to print the different type of error
 * in the corresponding label during the connection
 */
public class LoginController extends MainController {

	@FXML
	TextField loginField;
	@FXML
	PasswordField pwdField;
	/**
	 * Text field to show if the login of the account is not possible, or if the
	 * connection succeed
	 */
	@FXML
	Label printLabel;

	/**
	 * This method is used to check the information of the user in the database
	 * and connect the user to the application Some error could be shown to the
	 * user in the corresponding view
	 */
	@FXML
	public void submit() {
		String log = loginField.getText();
		String pwd = pwdField.getText();

		try {
			printLabel.setText("Connection ...");
			User user = User.login(log, pwd);
			Main.getInstance().setUser(user);
		} catch (IncorrectPasswordException e) {
			printLabel.setText("Incorrect Password");
		} catch (NonExistingException e) {
			printLabel.setText("This user does not exist");
		}
	}
}