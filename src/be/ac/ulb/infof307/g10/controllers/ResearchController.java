package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Shop;

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
		shopTA.setText("");

		List<Shop> shopList = Shop.getWithProduct(Database.getProduct(productTF.getText()));
		String shopNames = "";
		for (Shop s : shopList) {
			shopNames += s.getName() + "\n";
		}
		shopTA.setText(shopNames);
	}

	public void researchProducts(ActionEvent actionEvent) {
		shopTA.setText("");

		shopTA.setText(productTF.getText());
	}
}
