package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.models.Product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNewProductController {
	@FXML
	private TextField newProductName;
	
	@FXML
	private TextField newProductCalories;
	
	@FXML
	private TextField newProductSugar;
	
	@FXML
	private TextField newProductProteins;
	
	@FXML
	private TextField newProductFat;

	@FXML
	private Button submitNewProduct;

	public void submit(ActionEvent actionEvent) {
		String productName = newProductName.getText();
		String productCalories = newProductCalories.getText();
		// TODO change to size and IntField
		new Product(productName, Integer.parseInt(productCalories), "").save();
	}

}
