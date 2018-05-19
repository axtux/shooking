package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
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
		// set JPA persistence unit
		Database.setProp("name", "GL10PU");
	}

	@Override
	public void start(final Stage stage) {
		// show login view
		//* auto login TODO remove for release
		User user;
		try {
			user = UserDAO.getByUsername("test");
		} catch (NonExistingException e) {
			user = UserDAO.create("test", "test");
		}
		login(user);
		//*/logout();
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
