package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.utils.ToStringConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * Controller Class of the shopping list (ShoppingList) It is used to update the
 * information in the different fields and
 */
public class ShoppingListController extends AbstractProductController {

	@FXML
	private ComboBox<Shop> shopsCombo;

	@FXML
	private Label status;

	@FXML
	private Label totalLabel;

	@FXML
	private TableColumn<Product, String> productsAmountColumn;

	@FXML
	private TableColumn<Product, String> productsPriceColumn;

	private Shop selectedShop;

	private ShoppingList sl;

	private void changed() {
		try {
			sl.save();
		} catch (DatabaseException e) {
			status.setText("Database error");
		}
		updateTable();
	}

	@FXML
	private void productsClear() {
		sl.clear();
		changed();
	}

	@FXML
	private void productsAdd() {
		Product p = productsCombo.getValue();
		sl.addProduct(p, productsAmountField.getInt());
		changed();
		productsTable.getSelectionModel().select(p);
	}

	@FXML
	private void productsEdit() {
		if (productsTableSelected == null) {
			return;
		}
		sl.removeProduct(productsTableSelected);
		productsAdd();
	}

	@FXML
	private void productsRemove() {
		if (productsTableSelected == null) {
			return;
		}
		sl.removeProduct(productsTableSelected);
		changed();
	}

	@Override
	protected void productsTableSelect(Product newValue) {
		super.productsTableSelect(newValue);
		if (productsTableSelected != null) {
			productsAmountField.setInt(sl.getQuantity(productsTableSelected));
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

	private void updateShops() {
		shopsCombo.getItems().clear();
		shopsCombo.getItems().addAll(Database.getAllShops());
	}

	private void updateTable() {
		productsTable.getItems().clear();
		productsTable.getItems().addAll(sl.getProducts());
		updateTotal();
	}

	@FXML
	private void researchShop() {
		Main.getInstance().showCreateRecipeDialog(sl);
	}

	private void updateTotal() {
		if (selectedShop == null) {
			totalLabel.setText("-");
			return;
		}

		try {
			int total = selectedShop.getStock().getPrice(sl);
			totalLabel.setText(Price.toString(total));
		} catch (NonExistingException e) {
			totalLabel.setText("unavailable");
		}
	}

	@FXML
	private void productsNew() {
		Main.getInstance().showCreateProductDialog();
		updateProducts();
	}

	@Override
	public void initialize() {
		super.initialize();
		sl = Main.getInstance().getUser().getShoppingList();

		productsNameColumn.setCellValueFactory(data -> {
			return new SimpleStringProperty(data.getValue().getName());
		});

		productsAmountColumn.setCellValueFactory(data -> {
			int quantity = sl.getQuantity(data.getValue());
			return new SimpleStringProperty(Integer.toString(quantity));
		});

		productsPriceColumn.setCellValueFactory(data -> {
			if (selectedShop == null) {
				return new SimpleStringProperty("-");
			}
			try {
				Product p = data.getValue();
				int price = selectedShop.getStock().getPrice(p, sl.getQuantity(p));
				return new SimpleStringProperty(Price.toString(price));
			} catch (NonExistingException e) {
				return new SimpleStringProperty("unavailable");
			}
			
		});

		// convert Product to string
		productsCombo.setConverter(new ToStringConverter<>((product) -> {
			return product.getFullName();
		}));
		// convert Shop to string
		shopsCombo.setConverter(new ToStringConverter<>((shop) -> {
			return shop.getName();
		}));

		shopsCombo.valueProperty().addListener(new ChangeListener<Shop>() {
			@Override
			public void changed(ObservableValue<? extends Shop> observable, Shop oldValue, Shop newValue) {
				shopSelected(newValue);
			}
		});

		updateProducts();
		updateShops();
		updateTable();
	}
}
