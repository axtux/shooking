package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
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
		int total;
		int price;
		for (Shop s : Database.getAllShops()) {
			total = 0;
			for (Product p : sl.getProducts()) {
				price = s.getStock().getPrice(p, sl.getQuantity(p));
				if (price == 0) {
					total = 0;
					break;
				}
				total += price;
			}
			if (total != 0) {
				all.append(s.getName() + "    " + Price.toString(total) + "\n");
			}
		}
		shopTA.setText(all.toString());
		if (shopTA.getText().isEmpty()) {
			shopTA.setText("No shop with all products in selected quantity");
		}
	}

}
