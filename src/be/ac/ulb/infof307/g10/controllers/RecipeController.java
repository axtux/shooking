package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.net.URL;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

/**
 * Controller class of the Recipe view
 */
public class RecipeController implements Initializable {
	
	
	@FXML
	private TextField ingredientTF;
	
	@FXML
	private IntField amountIngredientTF;
	
	@FXML
	private IntField peopleTF;
	
	@FXML
	private TextField stepTF;
	
	@FXML
	private Button editIngredientBT;
	
	@FXML
	private Button removeIngredientBT;
	
	@FXML
	private Button editStepBT1;
	
	@FXML
	private Button removeStepBT;
	
	@FXML
	private TableView<Map.Entry<Product, Integer>> table;
	
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> ingredientCL;
	
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> amountIngredientCL;
	
	@FXML
	private TableView<Map.Entry<Product, Integer>> stateTable;
	
	
	private ObservableMap<Product, Integer> products;
	
	private ObservableList<Map.Entry<Product, Integer>> items;
	
	private Entry<Product, Integer> selected;
	
	private ObservableList<Entry<Product, Integer>> selection;
	
	private ObservableMap<Product, Integer> steps;
	
	private Entry<Product, Integer> selectedStep;
	
	
	@FXML
	void add(ActionEvent event) {
		
		//FIXME
		Product p = new Product(ingredientTF.getText(), 1, "");
		products.put(p, amountIngredientTF.getInt());
		
		for (int i = 0; i < items.size(); i++) { // select it
			
			if (items.get(i).getKey() == p) {
				table.getSelectionModel().select(i);
				
			}
		}
	}
	
	@FXML
	void amountDown(ActionEvent event) {
		amountIngredientTF.setInt(amountIngredientTF.getInt() - 1);
	}
	
	@FXML
	void amountUp(ActionEvent event) {
		amountIngredientTF.setInt(amountIngredientTF.getInt() + 1);
	}
	
	@FXML
	void clear(ActionEvent event) {
		table.getSelectionModel().clearSelection();
		// in case selection is not update, we clear here under the different fields
		ingredientTF.clear();
		amountIngredientTF.clear();
		peopleTF.clear();
	}
	
	@FXML
	void edit(ActionEvent event) {
		if (selected == null) {
			return;
		}
		products.remove(selected.getKey());
		add(null);
	}
	
	
	@FXML
	void addStep(ActionEvent event) {
		System.out.println(stepTF.getText());
	}
	
	@FXML
	void editStep(ActionEvent event) {
		if (selectedStep == null) {
			return;
		}
		steps.remove(selectedStep.getKey());
		addStep(null);
	}
	
	@FXML
	void removeStep(ActionEvent event) {
		if (selectedStep == null) {
			return;
		}
		steps.remove(selectedStep.getKey());
	}
	
	@FXML
	void clearStep(ActionEvent event) {
		stateTable.getSelectionModel().clearSelection();
		stepTF.clear(); // in case selection is not update, clear fields
	}
	
	@FXML
	void remove(ActionEvent event) {
		if (selected == null) {
			return;
		}
		products.remove(selected.getKey());
	}
	
	@FXML
	void CreateRecipe(ActionEvent event) {
		System.out.println("New RecipeController");
	}
	
	/**
	 * Select a cell of the table products
	 * Update the status of the corresponding buttons when a product is selected (not disable)
	 */
	@FXML
	private void updateSelected() {
		int size = selection.size();
		if (size == 1) {
			selected = selection.get(0);
			editIngredientBT.setDisable(false);
			removeIngredientBT.setDisable(false);
			ingredientTF.setText(selected.getKey().getName());
			amountIngredientTF.setText(selected.getValue().toString());
			
		} else {
			selected = null;
			editIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
		}
	}
	
	@FXML
	/**
	 * Select a cell of the table Step
	 */
	private void updateSelectedStep() {
		int size = selection.size();
		if (size == 1) {
			selected = selection.get(0);
			editStepBT1.setDisable(false);
			removeStepBT.setDisable(false);
			stepTF.setText(selectedStep.getKey().getName());
			
			
		} else {
			selectedStep = null;
			editStepBT1.setDisable(true);
			removeStepBT.setDisable(true);
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
		ingredientCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String> p) {
				// this callback returns property for just one cell
				return new SimpleStringProperty(p.getValue().getKey().getName());
			}
		});
		amountIngredientCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
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
		
		// add listener to call selected method
		selection = table.getSelectionModel().getSelectedItems();
		selection.addListener(new ListChangeListener<Map.Entry<Product, Integer>>() {
			public void onChanged(Change<? extends Entry<Product, Integer>> c) {
				updateSelected();
			}
		});
		
		updateSelected();
		amountIngredientTF.setSigned(false);
		
	}
	
	
	public void researchProduct(ActionEvent actionEvent) {
		Main.getInstance().showDialog("ResearchDialog", "Research product");
	}
}
