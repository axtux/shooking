package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import be.ac.ulb.infof307.g10.models.Research;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.Product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

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
		String productSugar = newProductSugar.getText();
		String productProteins = newProductProteins.getText();
		String productFat = newProductFat.getText();
		Product newProduct = new Product(productName, null, Integer.parseInt(productCalories), Integer.parseInt(productSugar), Integer.parseInt(productProteins), Integer.parseInt(productFat), 0);
		DatabaseFacade.insert(newProduct);
	}

}
