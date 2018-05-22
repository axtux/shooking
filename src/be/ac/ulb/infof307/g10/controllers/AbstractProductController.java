package be.ac.ulb.infof307.g10.controllers;

import java.util.Collection;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.ProductsQuantity;
import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.utils.ToStringConverter;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Common code between {@link ShoppingListController} and
 * {@link RecipeController}. Manages a product combo box with associated
 * {@link IntField}
 */
abstract public class AbstractProductController {

	@FXML
	protected ComboBox<ProductsQuantity> productsQuantityCombo;
	@FXML
	protected TextField productsQuantityNameField;

	@FXML
	protected ComboBox<Product> productsCombo;
	@FXML
	protected IntField productsAmountField;
	@FXML
	protected Button productsAmountUpButton;
	@FXML
	protected Button productsAmountDownButton;

	@FXML
	protected Button productsAddButton;
	@FXML
	protected Button productsEditButton;
	@FXML
	protected Button productsRemoveButton;
	@FXML
	protected Button productsClearButton;

	@FXML
	protected TableView<Product> productsTable;
	@FXML
	protected TableColumn<Product, String> productsNameColumn;
	@FXML
	private TableColumn<Product, String> productsQuantityColumn;

	protected Product productsTableSelected;
	protected ProductsQuantity products;

	/*
	 * Products managment
	 */

	/**
	 * Raise by one the quantity inside the intField
	 */
	@FXML
	private void productsAmountUp() {
		productsAmountField.setInt(productsAmountField.getInt() + 1);
	}

	/**
	 * Decrease by one the quantity inside the intField
	 */
	@FXML
	private void productsAmountDown() {
		productsAmountField.setInt(productsAmountField.getInt() - 1);
	}

	/**
	 * Update the combo box of products
	 */
	protected void updateProducts() {
		productsCombo.getItems().clear();
		productsCombo.getItems().addAll(ProductDAO.getAll());
	}

	/**
	 * Update the table of product
	 */
	protected void updateProductsTable(ProductsQuantity actual) {
		productsTable.getItems().clear();
		if (actual != null) {
			productsTable.getItems().addAll(actual.getProducts());
		}
	}

	/**
	 * Update the selected product
	 * @param newValue the new selected product
	 */
	protected void productsTableSelect(Product newValue) {
		if (newValue == null) {
			productsCombo.getSelectionModel().clearSelection();
			productsAmountField.clear();
		} else {
			ProductsQuantity actual = productsQuantityCombo.getValue();
			productsCombo.getSelectionModel().select(newValue);
			productsAmountField.setInt(actual.getQuantity(newValue));
		}
	}

	/**
	 * ProductsQuantity combo management
	 */

	abstract protected Collection<? extends ProductsQuantity> getAllProductsQuantity();

	/**
	 * Update the products combo box
	 */
	protected void updateAllProductsQuantity() {
		productsQuantityCombo.getItems().clear();
		productsQuantityCombo.getItems().addAll(getAllProductsQuantity());
	}

	/**
	 * Update the selected product inside the combo box
	 * @param selected the new selected product
	 */
	protected void selectProductsQuantity(ProductsQuantity selected) {
		productsQuantityNameField.clear();
		productsCombo.getSelectionModel().clearSelection();
		if (selected != null) {
			productsQuantityNameField.setText(selected.getName());
		}
		updateProductsTable(selected);
	}

	/**
	 * Edit the name of the selected product
	 * @param newValue the new name of the selected product
	 */
	private void changeName(String newValue) {
		ProductsQuantity actual = productsQuantityCombo.getValue();
		if ("".equals(newValue) || actual.getName().equals(newValue)) {
			// no change or cleared
			return;
		}
		actual.setName(newValue);
		updateAllProductsQuantity();
		productsQuantityCombo.getSelectionModel().select(actual);
	}

	/*
	 * Products combo management
	 */

	/**
	 * Add the selected product inside the product table with the quantity
	 * of the intField
	 */
	@FXML
	private void productsAdd() {
		ProductsQuantity actual = productsQuantityCombo.getValue();
		Product p = productsCombo.getValue();
		actual.addQuantity(p, productsAmountField.getInt());
		updateProductsTable(actual);
		productsTable.getSelectionModel().select(p);
	}

	/**
	 * Replace the selected product inside the product table by the
	 * product inside the combo box with the quantity of the intField
	 */
	@FXML
	private void productsEdit() {
		productsRemove(false);
		productsAdd();
	}

	/**
	 * Remove the selected product from the product table
	 */
	@FXML
	private void productsRemove() {
		productsRemove(true);
	}

	/**
	 * Remove the selected product from the product table
	 * @param update if True : the product table is updated
	 */
	private void productsRemove(boolean update) {
		ProductsQuantity actual = productsQuantityCombo.getValue();
		actual.removeProduct(productsTable.getSelectionModel().getSelectedItem());
		if (update) {
			updateProductsTable(actual);
		}
	}

	/**
	 * Clear the products inside the product table
	 */
	@FXML
	private void productsClear() {
		ProductsQuantity actual = productsQuantityCombo.getValue();
		actual.clear();
		updateProductsTable(actual);
	}

	/**
	 * Initialization
	 */
	public void initialize() {

		productsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		productsTable.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> productsTableSelect(newValue)
		);

		productsQuantityColumn.setCellValueFactory(cell -> {
			ProductsQuantity actual = productsQuantityCombo.getValue();
			int amount = actual.getQuantity(cell.getValue());
			return new SimpleStringProperty(Integer.toString(amount));
		});

		productsQuantityCombo.setConverter(new ToStringConverter<>(ProductsQuantity::getName));
		productsQuantityCombo.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> selectProductsQuantity(newValue)
		);

		productsQuantityNameField.textProperty().addListener((observable, oldValue, newValue) -> changeName(newValue));

		//Disable the fields/buttons that should not be available without a product quantity combo
		BooleanBinding notSelected = productsQuantityCombo.getSelectionModel().selectedItemProperty().isNull();
		productsQuantityNameField.disableProperty().bind(notSelected);
		productsCombo.disableProperty().bind(notSelected);
		productsClearButton.disableProperty().bind(notSelected);

		//Disable the fields/buttons that should not be available without a selected product
		notSelected = productsCombo.getSelectionModel().selectedItemProperty().isNull();
		productsAddButton.disableProperty().bind(notSelected);
		productsAmountDownButton.disableProperty().bind(notSelected);
		productsAmountUpButton.disableProperty().bind(notSelected);
		productsAmountField.disableProperty().bind(notSelected);

		//Disable the fields/buttons that should not be available without a product table
		notSelected = productsTable.getSelectionModel().selectedItemProperty().isNull();
		productsEditButton.disableProperty().bind(notSelected);
		productsRemoveButton.disableProperty().bind(notSelected);

		updateAllProductsQuantity();
		updateProducts();
		updateProductsTable(null);
		selectProductsQuantity(null);
	}
}
