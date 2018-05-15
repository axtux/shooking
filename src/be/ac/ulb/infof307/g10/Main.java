package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.database.Data;
import be.ac.ulb.infof307.g10.models.database.GenericDatabase;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Saves currently logged in user.
	 */
	private static User user;

	@Override
	public void init() {
		GenericDatabase.setProp("name", "GL10PU");
		if (GenericDatabase.isEmpty()) {
			Data.fillDB();
		}
	}

	@Override
	public void start(final Stage stage) {
		// show login view
		logout();
	}

	public static void main(final String[] args) {
		launch(args);
	}

	/**
	 * Get currently logged in user
	 * @return User logged in
	 */
	public static User getUser() {
		return user;
	}

	public static void login(final User u) {
		user = u;
		MainView.show(View.SHOPPING_LIST);
	}

	public static void logout() {
		user = null;
		MainView.show(View.LOGIN);
	}

}
