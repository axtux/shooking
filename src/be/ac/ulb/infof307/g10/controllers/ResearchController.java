package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;

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
public class ResearchController  {
	
	@FXML
	private TextField productTF;

	@FXML
	private TextArea shopTA;

	public void research(ActionEvent actionEvent) {
		List<Shop> shopWithAllArticles = new ArrayList<Shop>();
		Set<Product> products = ShoppingListController.getProducts().keySet();
		List<Shop> shopList = Database.getAllShops();
		for (Shop s : shopList) {
			Set<Product> productInAShop = s.getStock().getProducts();
			if(!Collections.disjoint(productInAShop, products)) {
				shopWithAllArticles.add(s);
			}
		}
		String shopNames = "";
		for (int i =0 ; i< shopWithAllArticles.size(); ++i) {
			shopNames += shopWithAllArticles.get(i).getName() + "\n";
		}
		shopTA.setText(shopNames);
	}
		
		
		
		/*shopTA.setText("");

		List<Shop> shopList = Shop.getWithProduct(Database.getProduct(productTF.getText()));
		String shopNames = "";
		for (Shop s : shopList) {
			shopNames += s.getName() + "\n";
		}
		shopTA.setText(shopNames);
	*/
	
	public void researchProducts(ActionEvent actionEvent) {
		shopTA.setText("");
		shopTA.setText(productTF.getText());
	}
}
