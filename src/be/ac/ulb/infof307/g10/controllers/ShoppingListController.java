package be.ac.ulb.infof307.g10.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Price;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * Controller Class of the shopping list (ShoppingList)
 *
 */
public class ShoppingListController extends MainController {

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
	private void clear(ActionEvent event) {
		sl.clear();
		changed();
	}	

	@FXML
	private void add(ActionEvent event) {
		Product p = productsListCombo.getValue();
		sl.addProduct(p, amountTF.getInt());
		changed();
		table.getSelectionModel().select(p);
	}

	@FXML
	private void edit(ActionEvent event) {
		if (selected == null) {
			return;
		}
		sl.removeProduct(selected);
		add(null);
	}

	@FXML
	private void remove(ActionEvent event) {
		if (selected == null) {
			return;
		}
		sl.removeProduct(selected);
		changed();
	}

	@FXML
	void amountUp(ActionEvent event) {
		amountTF.setInt(amountTF.getInt()+1);
	}

	@FXML
	void amountDown(ActionEvent event) {
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
	private void createNewProduct(ActionEvent event) throws IOException {
		Main.getInstance().showDialog("CreateProduct", "Create product");
		updateProducts();
	}

	public void initialize(URL url, ResourceBundle rb) {
		sl = Main.getInstance().getUser().getShoppingList();
		
		productCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> p) {
				// this callback returns property for just one cell
				return new SimpleStringProperty(p.getValue().getName());
			}
		});
		
		amountCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> p) {
				// this callback returns property for just one cell
				int quantity = sl.getQuantity(p.getValue());
				return new SimpleStringProperty(Integer.toString(quantity));
			}
		});
		
		priceCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> p) {
				if (selectedShop == null) {
					return new SimpleStringProperty("-");
				}
				int price = selectedShop.getStock().getPrice(p.getValue(), sl.getQuantity(p.getValue()));
				if (price == 0) {
					return new SimpleStringProperty("unavailable");
				}
				return new SimpleStringProperty(Price.toString(price));
			}
		});
		
		// convert Product to string
		productsListCombo.setConverter(new StringConverter<Product>() {
			@Override
			public String toString(Product p) {
				if(p==null) {
					return "";
				}
				return p.getFullName();
			}
			@Override
			public Product fromString(String string) { return null; }
		});
		
		// convert Shop to string
		shopsCombo.setConverter(new StringConverter<Shop>() {
			@Override
			public String toString(Shop s) {
				return s.getName();
			}
			@Override
			public Shop fromString(String string) { return null; }
		});
		
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
