package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	//Singleton pattern
	private static Main instance;

	private User user;

	/**
	 * Singleton pattern
	 * @return Main instance
	 */
	public static Main getInstance() {
		return instance;
	}

	public Main() {
		super();
		instance = this;
	}


	@Override
	public void init() {
		Database.init();
	}

	@Override
	public void start(final Stage stage) {
		MainView.show(View.LOGIN);
	}

	public static void main(final String[] args) {
		launch(args);
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
		MainView.show(View.SHOPPING_LIST);
	}

}
