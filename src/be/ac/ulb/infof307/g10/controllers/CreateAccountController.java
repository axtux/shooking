package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.exceptions.EmptyPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.EmptyUsernameException;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller class for the create account page His aim is to detect some wrong
 * cases in the input password and update the errorLabel
 */
public class CreateAccountController {

	@FXML
	private TextField textFieldLog;
	@FXML
	private PasswordField pwdField;
	@FXML
	private PasswordField pwdField2;
	/**
	 * Text field to show if the creation of the account is not possible
	 */
	@FXML
	private Label errorLabel;

	@FXML
	private void showLogin() {
		MainView.show(View.LOGIN);
	}
	/**
	 * This method is used to check the information entered in the view to
	 * create the new user Some error could be shown to the user in the
	 * corresponding view
	 */
	@FXML
	private void signup() {

		try {
			String log = textFieldLog.getText();
			String pwd = pwdField.getText();
			String pwd2 = pwdField2.getText();

			if (pwd.equals(pwd2)) {
					errorLabel.setText("User creation...");
					User user = UserDAO.create(log, pwd);
					Main.login(user);

			} else {
				errorLabel.setText("Passwords do not match");
			}
		} catch (ExistingException e) {
			errorLabel.setText("This user name already exists");
		} catch (EmptyPasswordException e) {
			errorLabel.setText("Password must not be empty");
		} catch (EmptyUsernameException e) {
			errorLabel.setText("Username must not be empty");
		}

	}
}
