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
	
	private double priceForShoppingList;

	@FXML
	private TextArea shopTA;

	public void research(ActionEvent actionEvent) {
		double total=0.0;
		List<Shop> shopWithAllArticles = new ArrayList<Shop>();
		ArrayList priceForShoppingListAllShops = new ArrayList();
		Set<Product> products = ShoppingListController.getProducts().keySet();
		List<Shop> shopList = Database.getAllShops();
		for (Shop s : shopList) {
			total =0.0;
			Set<Product> productInAShop = s.getStock().getProducts();
			if(!Collections.disjoint(productInAShop, products)) {
				shopWithAllArticles.add(s);
				 for (Map.Entry<Product, Integer> entry : ShoppingListController.getProducts().entrySet()) {
					 
					 System.out.print(s.getStock().getPrice(entry.getKey())+ "\n");
					 
						total += (((s.getStock().getPrice(entry.getKey()))* entry.getValue()));//prix product * quantity
					 //action.accept(entry.getKey(), entry.getValue());
							
				}
				
				 priceForShoppingListAllShops.add(total);
			}
			
					
			     }
			 
		
		String shopNames = "";
		for (int i =0 ; i< shopWithAllArticles.size(); ++i) {
			shopNames += shopWithAllArticles.get(i).getName() + String.valueOf(priceForShoppingListAllShops.get(i))+"\n";
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
