package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.views.View;
import javafx.application.Platform;

/**
 * This class is the main controller, it implements all the methods used in the
 * different page of the application. The redirection to the over pages are
 * implemented here
 */
public class MainController {

	public void goToLogin() {
		Main.getInstance().show(View.LOGIN);
	}

	public void goToTerms() {
		Main.getInstance().show(View.TERMS_OF_USE);
	}

	public void goToSignUp() {
		Main.getInstance().show(View.CREATE_ACCOUNT);

	}

	public void goToRecipe() {
		Main.getInstance().show(View.RECIPE);
	}

	public void goToShoppingList() {
		Main.getInstance().show(View.SHOPPING_LIST);

	}

	public void goToCreateAccount() {
		Main.getInstance().showDialog(View.TERMS_OF_USE);
	}

	public void goToMap() {
		Main.getInstance().show(View.MAP);

	}

	public void exit() {
		Platform.exit();
	}

}
