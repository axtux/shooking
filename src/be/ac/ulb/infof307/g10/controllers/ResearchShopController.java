package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Controller Class of the research product view (Research)
 */
public class ResearchShopController {

	public static ShoppingList ssl;
	private ShoppingList sl;
	@FXML
	private TextArea shopTA;

	public ResearchShopController() {
		this.sl = ResearchShopController.ssl;
		if (sl == null) {
			throw new NullPointerException();
		}
	}

	public void initialize() {
		StringBuilder all = new StringBuilder();
		for (Shop s : Database.getAllShops()) {
			try {
				int total = s.getStock().getPrice(sl);
				all.append(s.getName() + "    " + Price.toString(total) + "\n");
			} catch (NonExistingException e) {
				continue;
			}
		}
		shopTA.setText(all.toString());
		if (shopTA.getText().isEmpty()) {
			shopTA.setText("No shop with all products in selected quantity");
		}
	}

}
