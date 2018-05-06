package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Shop;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

/**
 * Controller Class of the research product view (Research)
 */
public class ResearchController  {
	
	@FXML
	private TextField productTF;

	@FXML
	private TextArea shopTA;

	public void research() {
		shopTA.setText("");
		List<Shop> shopList = Shop.getWithProduct(Database.getProduct(productTF.getText()));
		String shopNames = "";
		
		for (Shop s : shopList) {
			shopNames += s.getName() + "\n";
		}
		
		shopTA.setText(shopNames);
	}
	//TODO is this method used ?
	public void researchProducts() {
		shopTA.setText("");
		shopTA.setText(productTF.getText());
	}
}
