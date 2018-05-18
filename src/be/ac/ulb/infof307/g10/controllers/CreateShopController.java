package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.views.DialogView;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

import com.lynden.gmapsfx.javascript.object.LatLong;

import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
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

	/**
	 * Construct the schedule of the shop
	 */
	private Map<DayOfWeek, String> createSchedule() {
		Map<DayOfWeek, String> schedule = new HashMap<>();
		
		schedule.put(DayOfWeek.MONDAY, monday.getText());
		schedule.put(DayOfWeek.TUESDAY, tuesday.getText());
		schedule.put(DayOfWeek.WEDNESDAY, wednesday.getText());
		schedule.put(DayOfWeek.THURSDAY, thursday.getText());
		schedule.put(DayOfWeek.FRIDAY, friday.getText());
		schedule.put(DayOfWeek.SATURDAY, saturday.getText());
		schedule.put(DayOfWeek.SUNDAY, sunday.getText());
		
		return schedule;
	}

	/**
	 * Creation of the Shop in the database
	 */
	@FXML
	void create() {
		createButton.setDisable(true);
		try {
			ShopDAO.create(name.getText(), position.getLatitude(), position.getLongitude(), createSchedule());
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
