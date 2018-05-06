package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * Controller class of the Recipe view.
 * It is used to manage the different action on a recipe such as adding one, editing one, adding a new step in it, ...
 */
public class RecipeController implements Initializable {

	@FXML
	private ComboBox<Product> productsListCombo;
	@FXML
	private ComboBox<Recipe> recipesListCombo;
	@FXML
	private IntField amountIngredientTF;
	@FXML
	private IntField peopleTF;
	@FXML
	private TextField stepTF;
	@FXML
	private TextField recipeNameTF;
	@FXML
	private Button clearIngredientsBT;
	@FXML
	private Button addIngredientBT;
	@FXML
	private Button editIngredientBT;
	@FXML
	private Button removeIngredientBT;
	@FXML
	private Button amountUpBT;
	@FXML
	private Button amountDownBT;
	@FXML
	private Button saveRecipeBT;
	@FXML
	private Button deleteRecipeBT;
	@FXML
	private Button addStepBT;
	@FXML
	private Button editStepBT;
	@FXML
	private Button removeStepBT;
	@FXML
	private Button clearStepBT;
	@FXML
	private Button moveUpStepBT;
	@FXML
	private Button moveDownStepBT;
	@FXML
	private Button recipeNameBT;
	@FXML
	private TableView<Map.Entry<Product, Integer>> ingredientsTable;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> ingredientCL;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> amountIngredientCL;
	@FXML
	private TableView<String> stepsTable;
	@FXML
	private TableColumn<String, String> recipeStepCL;
	
	private ObservableMap<Product, Integer> products;
	private ObservableList<String> steps;
	private ObservableList<Map.Entry<Product, Integer>> productsContent;
	
	private Entry<Product, Integer> selectedProduct;
	private ObservableList<Entry<Product, Integer>> selectionProducts;

	private String selectedStep;
	private ObservableList<String> selectionSteps;
	
	private Recipe actualRecipe;
	private Product actualProduct;

	@FXML
	void recipeComboChanged() {
		actualRecipe = recipesListCombo.getSelectionModel().getSelectedItem();
		updateSelectedRecipe();
	}
	
	@FXML
	void productComboChanged() {
		actualProduct = productsListCombo.getSelectionModel().getSelectedItem();
		updateSelectedProduct();
	}
	
	@FXML
	void amountDown() {
		amountIngredientTF.setInt(amountIngredientTF.getInt() - 1);
	}

	@FXML
	void amountUp() {
		amountIngredientTF.setInt(amountIngredientTF.getInt() + 1);
	}

	@FXML
	void addIngredient() {
		if (productsListCombo.getSelectionModel().isEmpty()) {
			return;
		}
		Product p = productsListCombo.getSelectionModel().getSelectedItem();
		int quantity = amountIngredientTF.getInt();
		actualRecipe.addIngredient(p, quantity);
		updateTable();
	}
	
	@FXML
	void editIngredient() {
		if (selectedProduct == null) {
			return;
		}
		int quantity = amountIngredientTF.getInt();
		actualRecipe.setIngredientQuantity(selectedProduct.getKey(), quantity);
		updateTable();
	}
	
	@FXML
	void removeIngredient() {
		if (selectedProduct == null) {
			return;
		}
		actualRecipe.removeIngredient(selectedProduct.getKey());
		updateTable();

	}

	@FXML
	void clearIngredients() {
		actualRecipe.clearIngredients();
		amountIngredientTF.clear();
		updateTable();
	}

	@FXML
	void addStep() {
		if (stepTF.equals("")) {
			return;
		}
		String step = stepTF.getText();
		stepTF.clear();
		actualRecipe.addStep(step);
		updateTable();
	}

	@FXML
	void editStep() {
		if (selectedStep == null) {
			return;
		}
		actualRecipe.setStep(steps.indexOf(selectedStep), stepTF.getText());
		updateTable();
	}

	@FXML
	void removeStep() {
		if (selectedStep == null) {
			return;
		}
		actualRecipe.removeStep(steps.indexOf(selectedStep));
		updateTable();
	}

	@FXML
	void clearStep() {
		stepsTable.getSelectionModel().clearSelection();
		stepTF.clear();
		actualRecipe.clearSteps();
		updateTable();
	}

	@FXML
	void moveUpStep() {
		try {
			actualRecipe.moveUpStep(steps.indexOf(selectedStep));
		} catch (IndexOutOfBoundsException e){
			
		}
		updateTable();
	}
	
	@FXML
	void moveDownStep() {
		try {
			actualRecipe.moveDownStep(steps.indexOf(selectedStep));
		} catch (IndexOutOfBoundsException e) {
			
		}
		updateTable();
	}

	@FXML
	void CreateRecipe() {
		Main.getInstance().showDialog("CreateRecipe", "Create recipe");
		recipesListCombo.getItems().clear();
		recipesListCombo.getItems().addAll(Database.getAllRecipes());
	}
	
	@FXML
	void SaveRecipe() {
		actualRecipe.save();
	}
	
	@FXML
	void DeleteRecipe() {
		// TODO Not yet implement. Recipe.delete() is not acceptable for the DB
		actualRecipe.delete();
		recipesListCombo.getItems().remove(actualRecipe);
		actualRecipe = null;
		updateSelectedRecipe();
	}
	
	@FXML
	void editRecipeName() {
		actualRecipe.setName(recipeNameTF.getText());
		updateInterface();
	}

	@FXML
	/**
	 * Select a cell of the table products
	 * Update the status of the corresponding buttons when a product is selected (not disable)
	 */
	private void updateSelectedIngredient() {
		int selectionProducstSize = selectionProducts.size();
		if (selectionProducstSize == 1) {
			selectedProduct = selectionProducts.get(0);
			editIngredientBT.setDisable(false);
			removeIngredientBT.setDisable(false);
			amountIngredientTF.setText(selectedProduct.getValue().toString());
			productsListCombo.getSelectionModel().select(selectedProduct.getKey());;
		} else {
			selectedProduct = null;
			editIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
		}
	}

	@FXML
	/**
	 * Select a cell of the table Step, update the corresponding fields, and enable/disable some buttons on the view
	 */
	private void updateSelectedStep() {
		int size = selectionSteps.size();
		if (size == 1) {
			selectedStep = selectionSteps.get(0);
			editStepBT.setDisable(false);
			removeStepBT.setDisable(false);
			moveUpStepBT.setDisable(false);
			moveDownStepBT.setDisable(false);
			if (selectedStep.equals(steps.get(0))) {
				moveUpStepBT.setDisable(true);
			}
			if (selectedStep.equals(steps.get(steps.size()-1))){
				moveDownStepBT.setDisable(true);
			}
			stepTF.setText(selectedStep);
		} else {
			selectedStep = null;
			editStepBT.setDisable(true);
			removeStepBT.setDisable(true);
			moveUpStepBT.setDisable(true);
			moveDownStepBT.setDisable(true);
			stepTF.setText("");
		}
	}
	
	/**
	 * Select a recipe, update the corresponding fields, and enable/disable some buttons on the view
	 */
	private void updateSelectedRecipe() {
		amountIngredientTF.clear();
		stepTF.clear();
		steps.clear();
		products.clear();
		if (actualRecipe == null) {
			addIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
			clearIngredientsBT.setDisable(true);
			editIngredientBT.setDisable(true);
			removeStepBT.setDisable(true);
			addStepBT.setDisable(true);
			editStepBT.setDisable(true);
			clearStepBT.setDisable(true);
			saveRecipeBT.setDisable(true);
			deleteRecipeBT.setDisable(true);
			recipeNameBT.setDisable(true);
			moveUpStepBT.setDisable(true);
			moveDownStepBT.setDisable(true);
			productsListCombo.setDisable(true);
			amountIngredientTF.setDisable(true);
			stepTF.setDisable(true);
			peopleTF.setDisable(true);
			amountUpBT.setDisable(true);
			amountDownBT.setDisable(true);
			recipeNameTF.setDisable(true);
			if (ingredientsTable.getItems() != null) {
				ingredientsTable.getItems().clear();
			}
		}
		else {
			peopleTF.setInt(actualRecipe.getServings());
			recipeNameTF.setText(actualRecipe.getName());
			steps.addAll(actualRecipe.getAllSteps());
			actualRecipe.getAllIngredients().forEach((ingredient, quantity)
					->products.put(ingredient, Math.round(quantity)));
			
			addIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
			clearIngredientsBT.setDisable(false);
			editIngredientBT.setDisable(true);
			removeStepBT.setDisable(true);
			addStepBT.setDisable(false);
			editStepBT.setDisable(true);
			clearStepBT.setDisable(false);
			saveRecipeBT.setDisable(false);
			deleteRecipeBT.setDisable(true);
			recipeNameBT.setDisable(false);
			moveUpStepBT.setDisable(true);
			moveDownStepBT.setDisable(true);
			productsListCombo.setDisable(false);
			amountIngredientTF.setDisable(true);
			stepTF.setDisable(false);
			peopleTF.setDisable(true);
			amountUpBT.setDisable(true);
			amountDownBT.setDisable(true);
			recipeNameTF.setDisable(false);
		}
		updateInterface();
	}
	
	@FXML
	/**
	 * Select a ingredient and enable/disable some buttons on the view
	 */
	private void updateSelectedProduct() {
		if (actualProduct == null) {
			addIngredientBT.setDisable(true);
			amountUpBT.setDisable(true);
			amountDownBT.setDisable(true);
			amountIngredientTF.setDisable(true);
		}
		else {
			addIngredientBT.setDisable(false);
			amountUpBT.setDisable(false);
			amountDownBT.setDisable(false);
			amountIngredientTF.setDisable(false);
		}
	}
	//TODO change this method to updateSelectedIngredient ( it is more appropriate)
	
	@FXML
	/**
	 * Update the table view of the recipe
	 */
	private void updateTable() {
		if (steps != null) {
			steps.clear();
		}
		else {
			steps = FXCollections.observableArrayList();
		}
		if (products != null) {
			products.clear();
		}
		else {
			products = FXCollections.observableHashMap();
		}
		if (actualRecipe != null) {
			steps.addAll(actualRecipe.getAllSteps());
			actualRecipe.getAllIngredients().forEach((ingredient, quantity)
					->products.put(ingredient, Math.round(quantity)));
		}
		updateInterface();
	}
	
	//TODO add doc for this method
	private void updateInterface() {
		productsContent = FXCollections.observableArrayList(products.entrySet());
		productsContent.sort(new Comparator<Entry<Product, Integer>>() {
			public int compare(Entry<Product, Integer> o1, Entry<Product, Integer> o2) {
				return o1.getKey().getName().toLowerCase().compareTo(o2.getKey().getName().toLowerCase());
			}
		});
		ingredientsTable.setItems(productsContent);
		stepsTable.setItems(steps);
	}

	public void initialize(URL url, ResourceBundle rb) {
		productsListCombo.getItems().clear();
		productsListCombo.getItems().addAll(Database.getAllProducts());
		recipesListCombo.getItems().clear();
		recipesListCombo.getItems().addAll(Database.getAllRecipes());
		products = FXCollections.observableHashMap();
		steps = FXCollections.observableArrayList();
		ingredientCL.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String> p) {
						// this callback returns property for just one cell
						return new SimpleStringProperty(p.getValue().getKey().getName());
					}
				});
		amountIngredientCL.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							TableColumn.CellDataFeatures<Map.Entry<Product, Integer>, String> p) {
						// this callback returns property for just one cell
						return new SimpleStringProperty(p.getValue().getValue().toString());
					}
				});
		recipeStepCL.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(
							TableColumn.CellDataFeatures<String, String> p) {
						return new SimpleStringProperty(p.getValue());
					}
				});

		selectionProducts = ingredientsTable.getSelectionModel().getSelectedItems();
		selectionProducts.addListener(new ListChangeListener<Map.Entry<Product, Integer>>() {
			public void onChanged(Change<? extends Entry<Product, Integer>> c) {
				updateSelectedIngredient();
			}
		});
		selectionSteps = stepsTable.getSelectionModel().getSelectedItems();
		selectionSteps.addListener(new ListChangeListener<String>() {
			public void onChanged(Change<? extends String> c) {
				updateSelectedStep();
			}
		});
		// add available recipes in the select list
		recipesListCombo.setConverter(new StringConverter<Recipe>() {
			@Override
			public String toString(Recipe r) {
				return r.getName();
			}
			@Override
			public Recipe fromString(String string) { return null; }
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

		updateInterface();
		updateSelectedRecipe();
		amountIngredientTF.setSigned(false);

	}

	public void researchProduct() {
		Main.getInstance().showDialog("ResearchDialog", "Research product");
	}
}
