package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the creation of a Product corresponding to the CreateProduct
 * view It is used to generate the different type of message during the creation
 */
public class CreateProductController {

	@FXML
	private TextField name;

	@FXML
	private IntField size;

	@FXML
	private TextField unit;

	@FXML
	private Button button;

	@FXML
	private Label printLabel; // used to show an error on the view during the
								// creation

	/**
	 * Creation of the Product The button is disable during the creation
	 */
	public void create() {
		printLabel.setText("Creating...");
		button.setDisable(true); // we disable the button during the creation

		try {
			ProductDAO.create(name.getText(), size.getInt(), unit.getText());
			DialogView.hide();
		} catch (ExistingException | IllegalArgumentException e) {
			printLabel.setText(e.getMessage());
		}
		button.setDisable(false);
	}

}
