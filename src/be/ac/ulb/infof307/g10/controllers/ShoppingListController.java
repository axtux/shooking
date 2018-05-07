package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.utils.GetterConverter;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller Class of the shopping list (ShoppingList)
 * It is used to update the information in the different fields and
 */
public class ShoppingListController {

	@FXML
	private Button editBT;
	
	@FXML
	private Button removeBT;
	
	@FXML
	private ComboBox<Product> productsListCombo;
	
	@FXML
	private ComboBox<Shop> shopsCombo;
	
	@FXML
	private IntField amountTF;

	@FXML
	private Label status;
	//TODO use this label to print the actions processed or the error
	
	@FXML
	private Label totalLabel;
	
	@FXML
	private TableView<Product> table;
	
	@FXML
	private TableColumn<Product, String> productCL;
	
	@FXML
	private TableColumn<Product, String> amountCL;
	
	@FXML
	private TableColumn<Product, String> priceCL;
	
	private Product selected;
	private Shop selectedShop;
	
	private ShoppingList sl;

	private void changed() {
		sl.save();
		updateTable();
	}

	@FXML
	private void clear() {
		sl.clear();
		changed();
	}	

	@FXML
	private void add() {
		Product p = productsListCombo.getValue();
		sl.addProduct(p, amountTF.getInt());
		changed();
		table.getSelectionModel().select(p);
	}

	@FXML
	private void edit() {
		if (selected == null) {
			return;
		}
		sl.removeProduct(selected);
		add();
	}

	@FXML
	private void remove() {
		if (selected == null) {
			return;
		}
		sl.removeProduct(selected);
		changed();
	}

	@FXML
	void amountUp() {
		amountTF.setInt(amountTF.getInt()+1);
	}

	@FXML
	void amountDown() {
		amountTF.setInt(amountTF.getInt()-1);
	}

	/**
	 * Update the information for the view when the user select a cell of the table products
	 */
	private void productSelected(Product newValue) {
		selected = newValue;
		if (selected != null) {
			editBT.setDisable(false);
			removeBT.setDisable(false);
			amountTF.setInt(sl.getQuantity(selected));
			productsListCombo.getSelectionModel().select(selected);
		} else { //no product selected
			editBT.setDisable(true);
			removeBT.setDisable(true);
		}
	}
	/**
	 * Update the information for the view when the user select a cell of the table products
	 */
	private void shopSelected(Shop newValue) {
		selectedShop = newValue;
		updateTable();
	}
	
	private void updateProducts() {
		productsListCombo.getItems().clear();
		productsListCombo.getItems().addAll(Database.getAllProducts());
	}
	
	private void updateShops() {
		shopsCombo.getItems().clear();
		shopsCombo.getItems().addAll(Database.getAllShops());
	}
	
	private void updateTable() {
		table.getItems().clear();
		table.getItems().addAll(sl.getProducts());
		updateTotal();
	}
	
	@FXML
	private void researchShop() {
		ResearchShopController.ssl = sl;
		Main.getInstance().showDialog("ResearchShop", "Research shop");
	}
	
	private void updateTotal() {
		if (selectedShop == null) {
			totalLabel.setText("-");
			return;
		}
		
		int total = 0;
		int price;
		for(Product p: sl.getProducts()) {
			price = selectedShop.getStock().getPrice(p, sl.getQuantity(p));
			if (price == 0) {
				totalLabel.setText("unavailable");
				return;
			}
			total += price;
		}
		totalLabel.setText(Price.toString(total));
	}

	@FXML
	private void createNewProduct() {
		Main.getInstance().showDialog("CreateProduct", "Create product");
		updateProducts();
	}

	public void initialize() {
		sl = Main.getInstance().getUser().getShoppingList();
		
		productCL.setCellValueFactory(data -> {
			return new SimpleStringProperty(data.getValue().getName());
		});
		
		amountCL.setCellValueFactory(data -> {
			int quantity = sl.getQuantity(data.getValue());
			return new SimpleStringProperty(Integer.toString(quantity));
		});
		
		priceCL.setCellValueFactory(data -> {
			if (selectedShop == null) {
				return new SimpleStringProperty("-");
			}
			int price = selectedShop.getStock().getPrice(data.getValue(), sl.getQuantity(data.getValue()));
			if (price == 0) {
				return new SimpleStringProperty("unavailable");
			}
			return new SimpleStringProperty(Price.toString(price));
		});
		
		// convert Product to string
		productsListCombo.setConverter(GetterConverter.create(Product.class, "fullName"));
		// convert Shop to string
		shopsCombo.setConverter(GetterConverter.create(Shop.class, "name"));
		
		// add listener to call selected method
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
			@Override
			public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
				productSelected(newValue);
			}
		});
		
		shopsCombo.valueProperty().addListener(new ChangeListener<Shop>() {
			@Override
			public void changed(ObservableValue<? extends Shop> observable, Shop oldValue, Shop newValue) {
				shopSelected(newValue);
			}
		});
		
		productSelected(null);
		updateProducts();
		updateShops();
		updateTable();
	}
}
