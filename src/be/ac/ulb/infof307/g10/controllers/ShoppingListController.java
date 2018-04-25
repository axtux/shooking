package be.ac.ulb.infof307.g10.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
	private IntField amountTF;

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
	}

	@FXML
	private void add(ActionEvent event) {
		// add product
		//FIXME
		Product p = new Product(productTF.getText(), 0, "");
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
	void goBack(ActionEvent event) {
		// go to the menu
		Main.getInstance().goToMenu();
		System.out.println("go back to the Menu\n");
	}

	@FXML
	void logout(ActionEvent event) {
		// go to the login page
		Main.getInstance().goToLogin();
		System.out.println("logout\n");
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
	 * Select a cell of the table products
	 */
	private void updateSelected() {
		int size = selection.size();
		if (size == 1) {
			selected = selection.get(0);
			editBT.setDisable(false);
			removeBT.setDisable(false);
			productTF.setText(selected.getKey().getName());
			amountTF.setText(selected.getValue().toString());
		} else {
			selected = null;
			editBT.setDisable(true);
			removeBT.setDisable(true);
		}
	}
	
	private void updateInterface() {
		items = FXCollections.observableArrayList(products.entrySet());
		// sort by product description (case insensitive)
		items.sort(new Comparator<Entry<Product, Integer>>() {
			public int compare(Entry<Product, Integer> o1, Entry<Product, Integer> o2) {
				return o1.getKey().getName().toLowerCase().compareTo(o2.getKey().getName().toLowerCase());
			}
		});
		table.setItems(items);
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
		List<Product> allProducts = Database.getAllProducts();
		
		// add listener to call selected method
		selection = table.getSelectionModel().getSelectedItems();
		selection.addListener(new ListChangeListener<Map.Entry<Product, Integer>>() {
			public void onChanged(Change<? extends Entry<Product, Integer>> c) {
				updateSelected();
			}
		});
		updateSelected();
		
		amountTF.setSigned(false);
	}

	public void researchProduct(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ResearchDialog.fxml"));
			DialogPane page = loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Research product");
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);


			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
		} catch (IOException e) {
			// Exception gets thrown if the fxml file could not be loaded
			e.printStackTrace();

		}

	}
}
