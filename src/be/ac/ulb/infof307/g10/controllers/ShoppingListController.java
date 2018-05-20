package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.User;
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
	private Label status;

	@FXML
	private Label totalLabel;

	@FXML
	private TableColumn<Product, String> productsAmountColumn;

	@FXML
	private TableColumn<Product, String> productsPriceColumn;

	@FXML
	private ComboBox<ShoppingList> shoppingListsCombo;

	@FXML
	private TextField shoppingListNames;

	@FXML
	private void editShoppingListName(String newValue) {
		try{
			ShoppingList shoppingList = currentList;
			shoppingList.setName(newValue);
			updateTable();
			updateShoppingLists();
			shoppingListsCombo.getSelectionModel().select(shoppingList);
		}
		catch (IllegalArgumentException e){
			return ;
		}
	}

	private Shop selectedShop;

	private User user;

	/**
	 * The current shopping list
	 */
	private ShoppingList currentList;


	/**
	 * Update the state
	 */
	private void changed() {
		updateTable();}

	/**
	 * Change the current shopping list
	 * @param newValue the new current shopping list
	 */
	private void shoppingListComboSelect(ShoppingList newValue) {
		currentList = newValue;
		shoppingListNames.setText(currentList.getName());
		updateTable();
	}


	/**
	 * Update the available shopping lists
	 */
	private void updateShoppingLists() {
		shoppingListsCombo.getItems().clear();
		shoppingListsCombo.getItems().addAll(user.getShoppingLists());
		if (currentList != null){
			shoppingListNames.setText(currentList.getName());
		}
	}

	@FXML
	private void productsClear() {
		currentList.clear();
		changed();
	}

	@FXML
	private void productsAdd() {
		Product p = productsCombo.getValue();
		currentList.addQuantity(p, productsAmountField.getInt());
		productsTable.getSelectionModel().select(p);
		changed();
	}

	@FXML
	private void productsEdit() {
		if (productsTableSelected == null) {
			return;
		}
		currentList.removeProduct(productsTableSelected);
		productsAdd();
	}

	@FXML
	private void productsRemove() {
		if (productsTableSelected == null) {
			return;
		}
		currentList.removeProduct(productsTableSelected);
		changed();
	}

	@Override
	protected void productsTableSelect(Product newValue) {
		super.productsTableSelect(newValue);
		if (productsTableSelected != null) {
			productsAmountField.setInt(currentList.getQuantity(productsTableSelected));
		}
	}

	/**
	 * Update the information for the view when the user select a cell of the
	 * table products
	 */
	private void shopSelected(Shop newValue) {
		selectedShop = newValue;
		updateTable();
	}

	/**
	 * Update the combo box of shop
	 */
	private void updateShops() {
		shopsCombo.getItems().clear();
		shopsCombo.getItems().addAll(ShopDAO.getAll());
	}

	/**
	 * Update the table of products
	 */
	private void updateTable() {
		productsTable.getItems().clear();
		if(currentList != null){
			productsTable.getItems().addAll(currentList.getProducts());
		}
		updateTotal();
	}

	@FXML
	private void researchShop() {
		ResearchShopController.setShoppingList(currentList);
		DialogView.show(View.RESEARCH_SHOP);
	}

	/**
	 * Update the total amount to buy the list
	 */
	private void updateTotal() {
		if (selectedShop == null || currentList==null) {
			totalLabel.setText("-");
			return;
		}

		try {
			int total = selectedShop.getStock().getPrice(currentList);
			totalLabel.setText(Price.toString(total));
		} catch (NonExistingException e) {
			totalLabel.setText("unavailable");
		}
	}

	@FXML
	private void productsNew() {
		DialogView.show(View.CREATE_PRODUCT, (event) -> updateProducts());
	}
	
	@FXML
	private void createShoppingList(){
		DialogView.show(View.CREATE_SHOPPING_LIST, (event)-> updateShoppingLists());
	}

	@Override
	public void initialize() {
		super.initialize();

		user = Main.getUser();

		productsNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

		productsAmountColumn.setCellValueFactory(cell -> {
			int quantity = currentList.getQuantity(cell.getValue());
			return new SimpleStringProperty(Integer.toString(quantity));
		});

		productsPriceColumn.setCellValueFactory(cell -> {
			if (selectedShop == null) {
				return new SimpleStringProperty("-");
			}
			try {
				Product p = cell.getValue();
				int price = selectedShop.getStock().getPrice(p, currentList.getQuantity(p));
				return new SimpleStringProperty(Price.toString(price));
			} catch (NonExistingException e) {
				return new SimpleStringProperty("unavailable");
			}
			
		});

		shoppingListsCombo.setConverter(new ToStringConverter<>(ShoppingList::getName));

		shoppingListsCombo.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> shoppingListComboSelect(newValue));
		//Button unavailable if no list selected
		BooleanBinding notSelected = shoppingListsCombo.getSelectionModel().selectedItemProperty().isNull();
		productsCombo.disableProperty().bind(notSelected);
		shopsCombo.disableProperty().bind(notSelected);
		researchShopsButton.disableProperty().bind(notSelected);
		shoppingListNames.disableProperty().bind(notSelected);
		productsClearButton.disableProperty().bind(notSelected);

		// convert Product to string
		productsCombo.setConverter(new ToStringConverter<>(Product::getFullName));
		// convert Shop to string
		shopsCombo.setConverter(new ToStringConverter<>(Shop::getName));

		shopsCombo.valueProperty().addListener((observable, oldValue, newValue) -> shopSelected(newValue));

		// TODO change this when multiple shopping lists
		productsNewButton.setDisable(false);
		shoppingListNames.textProperty().addListener((observable, oldValue, newValue) -> editShoppingListName(newValue));
		updateProducts();
		updateShoppingLists();
		updateShops();
		updateTable();
	}
	
	
}
