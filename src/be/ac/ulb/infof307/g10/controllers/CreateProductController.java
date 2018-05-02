package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateProductController {
	@FXML
	private TextField name;
	
	@FXML
	private IntField size;
	
	@FXML
	private TextField unit;
	
	@FXML
	private Button button;
	
	public void create(ActionEvent actionEvent) {
		button.setText("Creating...");
		button.setDisable(true);
		Product p = new Product(name.getText(), size.getInt(), unit.getText());
		p.save();
		Main.getInstance().closeDialog();
	}

}
