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

	@FXML
	private void productsAmountUp() {
		productsAmountField.setInt(productsAmountField.getInt() + 1);
	}

	@FXML
	private void productsAmountDown() {
		productsAmountField.setInt(productsAmountField.getInt() - 1);
	}

	protected void updateProducts() {
		productsCombo.getItems().clear();
		productsCombo.getItems().addAll(ProductDAO.getAll());
	}

	/**
	 * Products table management
	 */

	protected void updateProductsTable(ProductsQuantity actual) {
		productsTable.getItems().clear();
		if (actual != null) {
			productsTable.getItems().addAll(actual.getProducts());
		}
	}

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

	protected void updateAllProductsQuantity() {
		productsQuantityCombo.getItems().clear();
		productsQuantityCombo.getItems().addAll(getAllProductsQuantity());
	}

	protected void selectProductsQuantity(ProductsQuantity selected) {
		productsQuantityNameField.clear();
		productsCombo.getSelectionModel().clearSelection();
		if (selected != null) {
			productsQuantityNameField.setText(selected.getName());
		}
		updateProductsTable(selected);
	}

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

	/**
	 * Products combo management
	 */

	@FXML
	private void productsAdd() {
		ProductsQuantity actual = productsQuantityCombo.getValue();
		Product p = productsCombo.getValue();
		actual.addQuantity(p, productsAmountField.getInt());
		updateProductsTable(actual);
		productsTable.getSelectionModel().select(p);
	}

	@FXML
	private void productsEdit() {
		productsRemove(false);
		productsAdd();
	}

	@FXML
	private void productsRemove() {
		productsRemove(true);
	}

	private void productsRemove(boolean update) {
		ProductsQuantity actual = productsQuantityCombo.getValue();
		actual.removeProduct(productsTable.getSelectionModel().getSelectedItem());
		if (update) {
			updateProductsTable(actual);
		}
	}

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

		BooleanBinding notSelected = productsQuantityCombo.getSelectionModel().selectedItemProperty().isNull();
		productsQuantityNameField.disableProperty().bind(notSelected);
		productsCombo.disableProperty().bind(notSelected);
		productsClearButton.disableProperty().bind(notSelected);

		notSelected = productsCombo.getSelectionModel().selectedItemProperty().isNull();
		productsAddButton.disableProperty().bind(notSelected);
		productsAmountDownButton.disableProperty().bind(notSelected);
		productsAmountUpButton.disableProperty().bind(notSelected);
		productsAmountField.disableProperty().bind(notSelected);

		notSelected = productsTable.getSelectionModel().selectedItemProperty().isNull();
		productsEditButton.disableProperty().bind(notSelected);
		productsRemoveButton.disableProperty().bind(notSelected);

		updateAllProductsQuantity();
		updateProducts();
		updateProductsTable(null);
		selectProductsQuantity(null);
	}
}
