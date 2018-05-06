package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;

import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
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
	private TableView<Product> ingredientsTable;
	@FXML
	private TableColumn<Product, String> ingredientCL;
	@FXML
	private TableColumn<Product, String> amountIngredientCL;
	@FXML
	private TableView<String> stepsTable;
	@FXML
	private TableColumn<String, String> recipeStepCL;
	
	private ObservableList<String> steps;
	
	private Product selectedProduct;
	private String selectedStep;
	
	private Recipe actualRecipe;
	private Product actualProduct;

	@FXML
	private void recipeComboChanged() {
		actualRecipe = recipesListCombo.getSelectionModel().getSelectedItem();
		updateSelectedRecipe();
	}
	
	@FXML
	private void productComboChanged() {
		actualProduct = productsListCombo.getSelectionModel().getSelectedItem();
		updateSelectedProduct();
	}
	
	@FXML
	private void amountDown() {
		amountIngredientTF.setInt(amountIngredientTF.getInt() - 1);
	}

	@FXML
	private void amountUp() {
		amountIngredientTF.setInt(amountIngredientTF.getInt() + 1);
	}

	@FXML
	private void addIngredient() {
		if (productsListCombo.getSelectionModel().isEmpty()) {
			return;
		}
		Product p = productsListCombo.getSelectionModel().getSelectedItem();
		int quantity = amountIngredientTF.getInt();
		actualRecipe.addIngredient(p, quantity);
		updateTable();
		ingredientsTable.getSelectionModel().select(p);
	}

	@FXML
	private void editIngredient() {
		if (selectedProduct == null) {
			return;
		}
		actualRecipe.removeIngredient(selectedProduct);
		addIngredient();
	}
	
	@FXML
	private void removeIngredient() {
		if (selectedProduct == null) {
			return;
		}
		actualRecipe.removeIngredient(selectedProduct);
		updateTable();

	}

	@FXML
	private void clearIngredients() {
		actualRecipe.clearIngredients();
		amountIngredientTF.clear();
		updateTable();
	}

	@FXML
	private void addStep() {
		if (stepTF.equals("")) {
			return;
		}
		String step = stepTF.getText();
		stepTF.clear();
		actualRecipe.addStep(step);
		updateTable();
		stepsTable.getSelectionModel().select(step);
	}

	@FXML
	private void editStep() {
		if (selectedStep == null) {
			return;
		}
		// TODO why not setStep(String, String) ?
		String step = stepTF.getText();
		actualRecipe.setStep(steps.indexOf(selectedStep), step);
		updateTable();
		stepsTable.getSelectionModel().select(step);
	}

	@FXML
	private void removeStep(ActionEvent event) {
		if (selectedStep == null) {
			return;
		}
		// TODO why not removeStep(String, String) ?
		actualRecipe.removeStep(steps.indexOf(selectedStep));
		updateTable();
	}

	@FXML
	private void clearStep() {
		stepsTable.getSelectionModel().clearSelection();
		stepTF.clear();
		actualRecipe.clearSteps();
		updateTable();
	}

	@FXML
	private void moveUpStep() {
		// TODO why not moveUpStep(String) ?
		actualRecipe.moveUpStep(steps.indexOf(selectedStep));
		updateTable();
	}
	
	@FXML
	private void moveDownStep() {
		// TODO why not moveDownStep(String) ?
		actualRecipe.moveDownStep(steps.indexOf(selectedStep));
		updateTable();
	}

	@FXML
	private void createRecipe() {
		Main.getInstance().showDialog("CreateRecipe", "Create recipe");
		updateRecipes();
	}
	
	@FXML
	private void saveRecipe() {
		// TODO autosave ?
		actualRecipe.save();
	}
	
	@FXML
	private void editRecipeName() {
		actualRecipe.setName(recipeNameTF.getText());
		updateTable();
	}

	@FXML
	/**
	 * Select a cell of the table products
	 * Update the status of the corresponding buttons when a product is selected (not disable)
	 */
	private void updateSelectedIngredient(Product newValue) {
		selectedProduct = newValue;
		boolean empty = selectedProduct == null;
		editIngredientBT.setDisable(empty);
		removeIngredientBT.setDisable(empty);
		if (!empty) {
			amountIngredientTF.setInt(actualRecipe.getQuantity(selectedProduct));
			productsListCombo.getSelectionModel().select(selectedProduct);;
		} else {
			amountIngredientTF.clear();
			productsListCombo.getSelectionModel().clearSelection();
		}
	}

	@FXML
	/**
	 * Select a cell of the table Step, update the corresponding fields, and enable/disable some buttons on the view
	 */

	private void updateSelectedStep(String newValue) {
		selectedStep = newValue;
		boolean empty = selectedStep == null;
		editStepBT.setDisable(empty);
		removeStepBT.setDisable(empty);
		if (!empty) {
			boolean first = selectedStep.equals(steps.get(0));
			moveUpStepBT.setDisable(first);
			boolean last = selectedStep.equals(steps.get(steps.size()-1));
			moveDownStepBT.setDisable(last);
			stepTF.setText(selectedStep);
		} else {
			moveUpStepBT.setDisable(true);
			moveDownStepBT.setDisable(true);
			stepTF.clear();
		}
	}
	
	/**
	 * Select a recipe, update the corresponding fields, and enable/disable some buttons on the view
	 */
	private void updateSelectedRecipe() {
		productsListCombo.getSelectionModel().clearSelection();
		boolean empty = actualRecipe == null;
		saveRecipeBT.setDisable(empty);
		recipeNameBT.setDisable(empty);
		recipeNameTF.setDisable(empty);
		productsListCombo.setDisable(empty);
		stepTF.setDisable(empty);
		addStepBT.setDisable(empty);
		clearIngredientsBT.setDisable(empty);
		clearStepBT.setDisable(empty);
		if (!empty) {
			peopleTF.setInt(actualRecipe.getServings());
		}
		updateTable();
	}
	
	@FXML
	/**
	 * Select a ingredient and enable/disable some buttons on the view
	 */
	private void updateSelectedProduct() {
		boolean empty = actualProduct == null;
		addIngredientBT.setDisable(empty);
		amountUpBT.setDisable(empty);
		amountDownBT.setDisable(empty);
		amountIngredientTF.setDisable(empty);
	}
	//TODO change this method to updateSelectedIngredient ( it is more appropriate)
	
	@FXML
	/**
	 * Update the table view of the recipe
	 */
	private void updateTable() {
		recipeNameTF.clear();
		ingredientsTable.getItems().clear();
		stepsTable.getItems().clear();
		if (actualRecipe != null) {
			recipeNameTF.setText(actualRecipe.getName());
			ingredientsTable.getItems().addAll(actualRecipe.getAllIngredients().keySet());
			steps.clear();
			steps.addAll(actualRecipe.getAllSteps());
			stepsTable.setItems(steps);
		}
	}
	
	private void updateRecipes() {
		recipesListCombo.getItems().clear();
		recipesListCombo.getItems().addAll(Database.getAllRecipes());
	}
	
	public void initialize(URL url, ResourceBundle rb) {
		productsListCombo.getItems().clear();
		productsListCombo.getItems().addAll(Database.getAllProducts());
		updateRecipes();
		// TODO remove steps (duplicate of model)
		steps = FXCollections.observableArrayList();
		ingredientCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> p) {
				// this callback returns property for just one cell
				return new SimpleStringProperty(p.getValue().getName());
			}
		});
		amountIngredientCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Product, String> p) {
				// this callback returns property for just one cell
				Integer amount = actualRecipe.getQuantity(p.getValue());
				return new SimpleStringProperty(amount.toString());
			}
		});
		recipeStepCL.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(
					TableColumn.CellDataFeatures<String, String> p) {
				return new SimpleStringProperty(p.getValue());
			}
		});

		ingredientsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
			@Override
			public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
				updateSelectedIngredient(newValue);
			}
		});
		stepsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				updateSelectedStep(newValue);
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

		// load data and disable unavailable inputs
		peopleTF.setDisable(true);
		updateTable();
		updateSelectedProduct();
		updateSelectedIngredient(null);
		updateSelectedStep(null);
		updateSelectedRecipe();
	}
}
