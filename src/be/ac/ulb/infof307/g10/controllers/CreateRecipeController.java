package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.RecipeDAO;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the creation of a Recipe corresponding to the CreateRecipe
 * view
 */
public class CreateRecipeController {

	@FXML
	private TextField name;

	@FXML
	private IntField serving;

	@FXML
	private Button button;

	@FXML
	private Label printLabel;

	/**
	 * Creation of the Product The button is disable during the creation
	 */
	public void create() {
		printLabel.setText("Creating...");
		button.setDisable(true);

		try {
			RecipeDAO.createRecipe(name.getText(), serving.getInt());
			DialogView.hide();
		} catch (NullPointerException | IllegalArgumentException e) {
			printLabel.setText(e.getMessage());
		} catch (DatabaseException e) {
			printLabel.setText("Error in Database - you should not create the same recipe");
		}
		button.setDisable(false);
	}

}
