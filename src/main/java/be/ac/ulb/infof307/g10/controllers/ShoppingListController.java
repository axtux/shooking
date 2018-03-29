package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Product;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Oscar
 * 
 */
public class ShoppingListController implements Initializable {
	@FXML
	private Button clearBT;
	@FXML
	private Button addBT;
	@FXML
	private Button editBT;
	@FXML
	private Button removeBT;
	@FXML
	private Button newBT;
	@FXML
	private Button goStoreBT;
	@FXML
	private Button amountUpBT;
	@FXML
	private Button amountDownBT;

	@FXML
	private TextField productTF;
	@FXML
	private TextField amountTF;

	@FXML
	private TableView<Map.Entry<Product, Integer>> table;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> productCL;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> amountCL;

	private ObservableMap<Product, Integer> products;
	private ObservableList<Map.Entry<Product, Integer>> items;
	private Entry<Product, Integer> selected;
	private ObservableList<Entry<Product, Integer>> selection;

	@FXML
	private void clear(ActionEvent event) {
		table.getSelectionModel().clearSelection();
		// in case selection is not update, clear fields
		productTF.clear();
		amountTF.clear();
		System.out.println("cleared");
	}

	@FXML
	private void add(ActionEvent event) {
		// parse quantity field
		Integer quantity;
		try {
			quantity = Integer.parseUnsignedInt(amountTF.getText());
		} catch(NumberFormatException e) {
			System.out.println("wrong number");
			return;
		}
		// add product
		Product p = new Product(productTF.getText(), 0, 0, 0, 0);
		products.put(p, quantity);
		// select it
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getKey() == p) {
				table.getSelectionModel().select(i);
			}
		}
		System.out.println("added " + productTF.getText() + ": " + quantity.toString());
	}

	@FXML
	private void edit(ActionEvent event) {
		if (selected == null) {
			return;
		}
		try {
			Integer i = Integer.parseUnsignedInt(amountTF.getText());
			products.remove(selected.getKey());
			add(null);
		} catch(NumberFormatException e) {
			updateSelected();
		}
		System.out.println("edited " + productTF.getText() + ": " + amountTF.getText());
	}

	@FXML
	private void remove(ActionEvent event) {
		if (selected == null) {
			return;
		}
		products.remove(selected.getKey());
		System.out.println("removed " + productTF.getText() + ": " + amountTF.getText());
	}

	@FXML
	void goToStore(ActionEvent event) {
		// TODO go elsewhere
		Main.getInstance().goToLogin();
		System.out.println("gone store \n");
	}

	@FXML
	void amountUp(ActionEvent event) {
		try {
			Integer i = Integer.parseUnsignedInt(amountTF.getText())+1;
			amountTF.setText(i.toString());
		} catch(NumberFormatException e) {
			amountTF.setText("1");
		}
		System.out.println("amount up\n");
	}

	@FXML
	void amountDown(ActionEvent event) {
		try {
			Integer i = Integer.parseUnsignedInt(amountTF.getText())-1;
			if (i == -1) {
				i = 0;
			}
			amountTF.setText(i.toString());
		} catch(NumberFormatException e) {
			amountTF.setText("0");
		}
		System.out.println("amount down\n");
	}

	/**
	 * Select a cell of the table products
	 */
	private void updateSelected() {
		int size = selection.size();
		if (size == 1) {
			selected = selection.get(0);
			editBT.setDisable(false);
			removeBT.setDisable(false);
			productTF.setText(selected.getKey().getProductDesc());
			amountTF.setText(selected.getValue().toString());
		} else {
			selected = null;
			editBT.setDisable(true);
			removeBT.setDisable(true);
			productTF.setText("");
			amountTF.setText("");
		}
		System.out.println("updated");
	}
	
	private void updateInterface() {
		items = FXCollections.observableArrayList(products.entrySet());
		table.setItems(items);
		System.out.println("interface updated");
	}

	public void initialize(URL url, ResourceBundle rb) {
		products = FXCollections.observableHashMap();
		
		productCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String> p) {
				// this callback returns property for just one cell
				return new SimpleStringProperty(p.getValue().getKey().getProductDesc());
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
		// TODO get actual data
		products.put(new Product("Oeufs", 0, 0, 0, 0), 1);
		products.put(new Product("Pâtes", 0, 0, 0, 0), 500);
		products.put(new Product("Bière", 0, 0, 0, 0), 42);
		
		// add listener to call selected method
		selection = table.getSelectionModel().getSelectedItems();
		selection.addListener(new ListChangeListener<Map.Entry<Product, Integer>>() {
			public void onChanged(Change<? extends Entry<Product, Integer>> c) {
				updateSelected();
			}
		});
		updateSelected();
	}
	
}
