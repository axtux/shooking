package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Controller Class of the research product view (Research)
 */
public class ResearchController {

	@FXML
	private TextField productTF;

	@FXML
	private TextArea shopTA;

	private void displayShopPrice(List<Shop> shopWithAllArticles, ArrayList priceForShoppingListAllShops) {
		String shopNamesAndPrice = "";
		for (int i = 0; i < shopWithAllArticles.size(); ++i) {
			shopNamesAndPrice += shopWithAllArticles.get(i).getName() + "    "
					+ String.valueOf(priceForShoppingListAllShops.get(i)) + " EUR \n";
		}
		shopTA.setText(shopNamesAndPrice);
	}
	
	//find the stores with all articles in stock and compute the price for the shopping list
	public void research(ActionEvent actionEvent) {
		double totalPrice = 0.0;
		List<Shop> shopWithAllArticles = new ArrayList<Shop>();
		ArrayList priceForShoppingListAllShops = new ArrayList();
		
		ShoppingList sl = ShoppingListController.getShoppingList();
		Set<Product> products = sl.getProductsAndQuantity().keySet();
		
		List<Shop> shopList = Database.getAllShops();
		
		for (Shop s : shopList) {
			totalPrice = 0.0;
			Set<Product> productInAShop = s.getStock().getProducts();
			if (!Collections.disjoint(productInAShop, products)) { // check that the products in shopping list are in
																	// the stock of a shop
				shopWithAllArticles.add(s);
				for (Map.Entry<Product, Integer> entry : sl.getProductsAndQuantity().entrySet()) {
					// System.out.print(s.getStock().getPrice(entry.getKey())+ "\n");
					totalPrice += (((s.getStock().getPrice(entry.getKey())) * entry.getValue()));// product price *	quantity																								// quantity
				}
				priceForShoppingListAllShops.add(totalPrice);
			}
		}
		displayShopPrice(shopWithAllArticles, priceForShoppingListAllShops);
	}

	public void researchProducts(ActionEvent actionEvent) {
		shopTA.setText("");
		shopTA.setText(productTF.getText());
	}
}
