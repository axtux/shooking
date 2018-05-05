package be.ac.ulb.infof307.g10.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
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
	
	// SAVE TOTAL SHOPPING LIST
	@FXML
	private Label totaLabel;
	//TODO
	
	@FXML
	private TableView<Product> table;
	
	@FXML
	private TableColumn<Product, String> productCL;
	
	@FXML
	private TableColumn<Product, String> amountCL;
	
	@FXML
	private TableColumn<Product, String> priceCL;
	
	private Product selected;
	
	private ShoppingList sl;

	private void changed() {
		sl.save();
		updateInterface();
	}

	@FXML
	private void clear(ActionEvent event) {
		sl.clear();
		changed();
	}	

	@FXML
	private void add(ActionEvent event) {
		Product p = productsListCombo.getSelectionModel().getSelectedItem();
		sl.addProduct(p, amountTF.getInt());
		changed();
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
	private void updateSelected() {
		selected = table.getSelectionModel().getSelectedItem();
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
	
	private void updateInterface() {
		productsListCombo.getItems().clear();
		productsListCombo.getItems().addAll(Database.getAllProducts());
		
		shopsCombo.getItems().clear();
		shopsCombo.getItems().addAll(Database.getAllShops());
		
		table.getItems().clear();
		table.getItems().addAll(sl.getProductsAndQuantity().keySet());
	}

	@FXML
	private void createNewProduct(ActionEvent event) throws IOException {
		Main.getInstance().showDialog("CreateProduct", "Create product");
		updateInterface();
	}
	
	public void researchProduct(ActionEvent actionEvent) {
		// TODO research
	}

	public void saveList(ActionEvent actionEvent) {
		// TODO save
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
		
		// convert Product to string
		productsListCombo.setConverter(new StringConverter<Product>() {
			@Override
			public String toString(Product p) {
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
		table.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Product>() {
			public void onChanged(Change<? extends Product> c) {
				updateSelected();
			}
		});
		
		updateSelected();
		updateInterface();
	}
}
