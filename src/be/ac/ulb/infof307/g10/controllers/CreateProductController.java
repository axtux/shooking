package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller for the creation of a Product corresponding to the CreateProduct view
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
	
	/**
	 * Creation of the Product
	 * The button is disable during the creation
	 */
	public void create() {
		button.setText("Creating...");
		button.setDisable(true);
		Product p = new Product(name.getText(), size.getInt(), unit.getText());
		try {
			p.save();
		}catch (DatabaseException e){
			//TODO generate error Label to the view (create Label in view)
		}
		Main.getInstance().closeDialog();
	}

}
