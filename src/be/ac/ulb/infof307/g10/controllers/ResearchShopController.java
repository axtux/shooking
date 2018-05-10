package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller Class of the research product view (Research)
 */
public class ResearchShopController {

	public static ShoppingList ssl;
	private final ShoppingList sl;
	private final Map<Shop, Integer> shopsPrice;
	@FXML
	private TableView<Shop> shopsTable;
	@FXML
	private TableColumn<Shop, String> shopsNameColumn;
	@FXML
	private TableColumn<Shop, String> shopsPriceColumn;

	public ResearchShopController() {
		this.sl = ResearchShopController.ssl;
		if (sl == null) {
			throw new NullPointerException();
		}
		shopsPrice = new HashMap<>();
	}

	public void initialize() {
		shopsNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
		shopsPriceColumn.setCellValueFactory(cell -> {
			int price = shopsPrice.get(cell.getValue());
			return new SimpleStringProperty(Price.toString(price));
		});

		for (Shop s : Database.getAllShops()) {
			try {
				int total = s.getStock().getPrice(sl);
				shopsPrice.put(s, total);
			} catch (NonExistingException e) {
				// at least one product not within stock
				// do not add this shop to the list
			}
		}
		shopsTable.getItems().clear();
		shopsTable.getItems().addAll(shopsPrice.keySet());
	}

}
