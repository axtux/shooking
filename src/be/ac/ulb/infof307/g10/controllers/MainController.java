package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.application.Platform;

/**
 * This class is the main controller, it implements all the methods used in the
 * different page of the application. The redirection to the over pages are
 * implemented here
 */
public class MainController {

	public void goToLogin() {
		MainView.show(View.LOGIN);
	}

	public void goToTerms() {
		MainView.show(View.TERMS_OF_USE);
	}

	public void goToSignUp() {
		MainView.show(View.CREATE_ACCOUNT);

	}

	public void goToRecipe() {
		MainView.show(View.RECIPE);
	}

	public void goToShoppingList() {
		MainView.show(View.SHOPPING_LIST);

	}

	public void goToCreateAccount() {
		DialogView.show(View.TERMS_OF_USE);
	}

	public void goToMap() {
		MainView.show(View.MAP);

	}

	public void exit() {
		Platform.exit();
	}

}
