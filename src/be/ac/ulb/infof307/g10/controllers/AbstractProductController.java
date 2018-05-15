package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.models.Product;
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

abstract public class AbstractProductController {

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
	
	protected Product productsTableSelected;
	
	@FXML
	private void productsAmountUp() {
		productsAmountField.setInt(productsAmountField.getInt()+1);
	}

	@FXML
	private void productsAmountDown() {
		productsAmountField.setInt(productsAmountField.getInt()-1);
	}
	
	protected void updateProducts() {
		productsCombo.getItems().clear();
		productsCombo.getItems().addAll(ProductDAO.getAllProducts());
	}
	
	protected void productsTableSelect(Product newValue) {
		productsTableSelected = newValue;
		if (productsTableSelected == null) {
			productsAmountField.clear();
			productsCombo.getSelectionModel().clearSelection();
		} else {
			productsCombo.getSelectionModel().select(productsTableSelected);
		}
	}
	
	public void initialize() {
		updateProducts();
		
		productsNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));

		productsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		productsTable.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> productsTableSelect(newValue)
		);

		// use Product full name
		productsCombo.setConverter(new ToStringConverter<>(Product::getFullName));

		BooleanBinding notSelected = productsCombo.getSelectionModel().selectedItemProperty().isNull();
		productsAddButton.disableProperty().bind(notSelected);
		productsAmountDownButton.disableProperty().bind(notSelected);
		productsAmountUpButton.disableProperty().bind(notSelected);
		productsAmountField.disableProperty().bind(notSelected);

		notSelected = productsTable.getSelectionModel().selectedItemProperty().isNull();
		productsEditButton.disableProperty().bind(notSelected);
		productsRemoveButton.disableProperty().bind(notSelected);
	}
}
