package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.views.DialogView;

import com.lynden.gmapsfx.javascript.object.LatLong;

import be.ac.ulb.infof307.g10.db.ShopDAO;
import be.ac.ulb.infof307.g10.models.Shop;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the CreateShop view
 */
public class CreateShopController {

	private static LatLong staticPosition;

	@FXML
	private TextField name;

	@FXML
	private Button createButton;
	/**
	 * Schedule of each day
	 */
	@FXML
	private TextField monday;
	@FXML
	private TextField tuesday;
	@FXML
	private TextField wednesday;
	@FXML
	private TextField thursday;
	@FXML
	private TextField friday;
	@FXML
	private TextField saturday;
	@FXML
	private TextField sunday;
	@FXML
	private Label printLabel;

	private TextField[] schedule;

	private final LatLong position;

	/**
	 * Set position of shop to create. Should be done before object construction.
	 * @param position Position of shop to create.
	 */
	public static void setPosition(LatLong position) {
		staticPosition = position;
	}

	public CreateShopController() {
		position = staticPosition;
		if (position == null) {
			throw new NullPointerException("position must be set before creation");
		}
		staticPosition = null;
	}

	public void initialize() {
		schedule = new TextField[] { monday, tuesday, wednesday, thursday, friday, saturday, sunday };
	}

	/**
	 * Construct the schedule of the shop
	 */
	private String[] createSchedule() {
		String[] defaultSchedule = Shop.defaultSchedule();
		for (int i = 0; i < 7; i++) {
			// The user does not have to know all the schedule
			if (!schedule[i].getText().isEmpty()) {
				defaultSchedule[i] = schedule[i].getText();
			}
		}
		return defaultSchedule;
	}

	/**
	 * Creation of the Shop in the database
	 */
	@FXML
	void create() {
		createButton.setDisable(true);
		try {
			ShopDAO.createShop(name.getText(), position.getLatitude(), position.getLongitude(), createSchedule());
			DialogView.hide();
			return;
		} catch (DatabaseException e) {
			printLabel.setText("Database error");
		} catch (IllegalArgumentException e) {
			printLabel.setText(e.getMessage());
		}
		createButton.setDisable(false);
	}

}
