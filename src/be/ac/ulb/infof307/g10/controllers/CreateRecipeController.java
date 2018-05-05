package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	
	/**
	 * Creation of the Product
	 * The button is disable during the creation
	 */
	public void create() {
		button.setText("Creating...");
		button.setDisable(true);
		Recipe r = new Recipe(name.getText(), serving.getInt());
		try {
			r.save();
		}catch (DatabaseException e){
			//TODO generate error Label to the view (create Label in view)
		}
		Main.getInstance().closeDialog();
	}

}
