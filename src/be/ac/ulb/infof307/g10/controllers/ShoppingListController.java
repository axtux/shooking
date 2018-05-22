package be.ac.ulb.infof307.g10.controllers;

import java.util.Collection;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.ProductsQuantity;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.utils.ToStringConverter;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller Class of the shopping list (ShoppingList) It is used to update the
 * information in the different fields and
 */
public class ShoppingListController extends AbstractProductController {

	@FXML
	private ComboBox<Shop> shopsCombo;

	@FXML
	private Button productsNewButton;

	@FXML
	private Button researchShopsButton;

	@FXML
	private Label totalLabel;

	@FXML
	private TableColumn<Product, String> productsPriceColumn;

	/**
	 * Update the combo box of shops
	 */
	private void updateShops() {
		shopsCombo.getItems().clear();
		shopsCombo.getItems().addAll(ShopDAO.getAll());
	}

	/**
	 * Update the table of products
	 */
	protected void updateProductsTable(ProductsQuantity newValue) {
		super.updateProductsTable(newValue);
		updateTotal();
	}

	/**
	 * Research a shop will all the products from the current shopping list in stock
	 */
	@FXML
	private void researchShop() {
		ShoppingList actual = (ShoppingList) productsQuantityCombo.getValue();
		ResearchShopController.setShoppingList(actual);
		DialogView.show(View.RESEARCH_SHOP);
	}

	/**
	 * Update the total amount to buy the list
	 */
	private void updateTotal() {
		Shop shop = shopsCombo.getValue();
		ShoppingList actual = (ShoppingList) productsQuantityCombo.getValue();
		if (shop == null || actual==null) {
			totalLabel.setText("-");
			return;
		}

		try {
			int total = shop.getStock().getPrice(actual);
			totalLabel.setText(Price.toString(total));
		} catch (NonExistingException e) {
			totalLabel.setText("unavailable");
		}
	}

	/**
	 * Creation of a new product
	 */
	@FXML
	private void productsNew() {
		DialogView.show(View.CREATE_PRODUCT, (event) -> updateProducts());
	}

	/**
	 * Creation of a new shopping list
	 */
	@FXML
	private void createShoppingList(){
		DialogView.show(View.CREATE_SHOPPING_LIST, (event)-> updateAllProductsQuantity());
	}

	@Override
	protected Collection<? extends ProductsQuantity> getAllProductsQuantity() {
		return Main.getUser().getShoppingLists();
	}

	@Override
	public void initialize() {
		super.initialize();

		productsNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFullName()));

		productsPriceColumn.setCellValueFactory(cell -> {
			Shop shop = shopsCombo.getValue();
			ShoppingList actual = (ShoppingList) productsQuantityCombo.getValue();
			if (shop == null) {
				return new SimpleStringProperty("-");
			}
			try {
				Product p = cell.getValue();
				int price = shop.getStock().getPrice(p, actual.getQuantity(p));
				return new SimpleStringProperty(Price.toString(price));
			} catch (NonExistingException e) {
				return new SimpleStringProperty("unavailable");
			}
			
		});

		//Disable buttons/combo/fields unavailable without a product quantity combo
		BooleanBinding notSelected = productsQuantityCombo.valueProperty().isNull();
		shopsCombo.disableProperty().bind(notSelected);
		researchShopsButton.disableProperty().bind(notSelected);
		productsNewButton.disableProperty().bind(notSelected);

		// convert Product to string
		productsCombo.setConverter(new ToStringConverter<>(Product::getFullName));
		// convert Shop to string
		shopsCombo.setConverter(new ToStringConverter<>(Shop::getName));

		shopsCombo.valueProperty().addListener(
			(observable, oldValue, newValue) -> updateProductsTable(productsQuantityCombo.getValue())
		);

		updateShops();
	}

}
