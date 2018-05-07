package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the creation of a Recipe corresponding to the CreateRecipe view
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
	 * Creation of the Product
	 * The button is disable during the creation
	 */
	public void create() {
		printLabel.setText("Creating...");
		button.setDisable(true);
		
		try {
			Recipe r = new Recipe(name.getText(), serving.getInt());
			r.save();
			Main.getInstance().closeDialog();
		}catch (NullPointerException e){
			printLabel.setText(e.getMessage());
		}catch (DatabaseException e){
			printLabel.setText("Error in Database - you should not create the same recipe");
		}catch (IllegalArgumentException e){
			printLabel.setText(e.getMessage());
		}
		button.setDisable(false);
	}

}
