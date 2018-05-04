package be.ac.ulb.infof307.g10.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;// delete 

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	private IntField amountTF;

	@FXML
	private Label status;
	//TODO use this label to print the actions processed or the error
	
	// SAVE TOTAL SHOPPING LIST
	@FXML
	private Label totaLabel;
	//TODO
	

	@FXML
	private TableView<Map.Entry<Product, Integer>> table;
	
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> productCL;
	
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> amountCL;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> priceCL; // PRICE COLUMN TO BE IMPLEMENTED 

	
	
	private ObservableMap<Product, Integer> products;
	
	private ObservableList<Map.Entry<Product, Integer>> items;
	
	private Entry<Product, Integer> selected;
	
	private ObservableList<Entry<Product, Integer>> selection;

	@FXML
	private void clear(ActionEvent event) {
		table.getSelectionModel().clearSelection();
		// in case selection is not update, clear fields
		amountTF.clear();
	}	

	@FXML
	private void add(ActionEvent event) {
		// add product
		//FIXME
		Product p = productsListCombo.getSelectionModel().getSelectedItem();
		products.put(p, amountTF.getInt());
		// select it
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getKey() == p) {
				table.getSelectionModel().select(i);
			}
		}
	}

	@FXML
	private void edit(ActionEvent event) {
		if (selected == null) {
			return;
		}
		products.remove(selected.getKey());
		add(null);
	}

	@FXML
	private void remove(ActionEvent event) {
		if (selected == null) {
			return;
		}
		products.remove(selected.getKey());
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
		int size = selection.size();
		if (size == 1) {
			selected = selection.get(0);
			editBT.setDisable(false);
			removeBT.setDisable(false);
			amountTF.setText(selected.getValue().toString());
			productsListCombo.getSelectionModel().select(selected.getKey());
		} else { //no product selected
			selected = null;
			editBT.setDisable(true);
			removeBT.setDisable(true);
		}
	}
	
	private void updateInterface() {
		productsListCombo.getItems().clear();
		productsListCombo.getItems().addAll(Database.getAllProducts());
		items = FXCollections.observableArrayList(products.entrySet());
		// sort by product description (case insensitive)
		items.sort(new Comparator<Entry<Product, Integer>>() {
			public int compare(Entry<Product, Integer> o1, Entry<Product, Integer> o2) {
				return o1.getKey().getName().toLowerCase().compareTo(o2.getKey().getName().toLowerCase());
			}
		});
		table.setItems(items);
	}

	@FXML
	private void createNewProduct(ActionEvent event) throws IOException {
		Main.getInstance().showDialog("CreateProduct", "Create product");
		updateInterface();
	}
	
	// THIS IS THE  BUTTON OF THE METHOD  OF THE  RESEARCH SHOPS IN ORDER TO BE IMPLEMENTED  
	
	public void researchProduct(ActionEvent actionEvent) {
		Main.getInstance().showDialog("ResearchDialog", "Research product");
	}

	// THIS IS THE  BUTTON OF THE METHOD  OF THE  SAVE LIST IN ORDER TO BE IMPLEMENTED  
	
		public void saveList(ActionEvent actionEvent) {
			JOptionPane.showMessageDialog(null,"THIS IS THE  BUTTON OF THE METHOD  OF THE  SAVE LIST IN ORDER TO BE IMPLEMENTED"); 
		}



	public void initialize(URL url, ResourceBundle rb) {
		products = FXCollections.observableHashMap();
		
		productCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String> p) {
				// this callback returns property for just one cell
				return new SimpleStringProperty(p.getValue().getKey().getName());
			}
		});
		
		amountCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String> p) {
				// this callback returns property for just one cell
				return new SimpleStringProperty(p.getValue().getValue().toString());
			}
		});
		
		// update items on products update
		products.addListener(new MapChangeListener<Product, Integer>() {
			@Override
			public void onChanged(Change<? extends Product, ? extends Integer> change) {
				updateInterface();
			}
		});
		
		// add available products in the select list
		productsListCombo.setConverter(new StringConverter<Product>() {
			@Override
			public String toString(Product p) {
				return p.getFullName();
			}
			@Override
			public Product fromString(String string) { return null; }
		});
		
		// add listener to call selected method
		selection = table.getSelectionModel().getSelectedItems();
		selection.addListener(new ListChangeListener<Map.Entry<Product, Integer>>() {
			public void onChanged(Change<? extends Entry<Product, Integer>> c) {
				updateSelected();
			}
		});
		
		updateSelected();
		updateInterface();
	}
}
