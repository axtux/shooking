package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import be.ac.ulb.infof307.g10.models.Research;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.Product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class ResearchController  {
	@FXML
	private TextField productTF;

	@FXML
	private TextArea shopTA;

	@FXML
	private Button researchBT;

	public void research(ActionEvent actionEvent) {
		Research r = new Research();
		shopTA.setText("");

		List<Shop> shopList = r.getStoreWithProducts(DatabaseFacade.getProducts(productTF.getText()));
		String shopNames = "";
		for (Shop s : shopList) {
			shopNames += s.getName() + "\n";
		}
		shopTA.setText(shopNames);
	}

	public void researchProducts(ActionEvent actionEvent) {
		shopTA.setText("");

		List<Product> productsList = DatabaseFacade.getProductByName(productTF.getText());

		String productsNames = "";
		for (Product s : productsList) {
			productsNames += s.getName() + "\n";
		}
		shopTA.setText(productsNames);
	}
}
