package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.views.DialogView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateShoppingListController {
	
	@FXML
	private TextField name;
	
	@FXML
	private Button button; // creation button
	
	@FXML
	private Label printLabel;
	
	/**
	 * Creation of the Product The button is disable during the creation
	 */
	public void create() {
		printLabel.setText("Creating...");
		button.setDisable(true);
		
		try {
			Main.getUser().addShoppingList(new ShoppingList(name.getText()));
			DialogView.hide();
		} catch (IllegalArgumentException e) {
			printLabel.setText(e.getMessage());
		}
		button.setDisable(false);
	}
}
