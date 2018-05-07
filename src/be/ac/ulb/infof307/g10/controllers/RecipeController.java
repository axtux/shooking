package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;

import java.util.ResourceBundle;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.utils.GetterConverter;
import be.ac.ulb.infof307.g10.views.IntField;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
	private Button newRecipeBT;
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
	private TableView<Product> ingredientsTable;
	@FXML
	private TableColumn<Product, String> ingredientCL;
	@FXML
	private TableColumn<Product, String> amountIngredientCL;
	@FXML
	private TableView<String> stepsTable;
	@FXML
	private TableColumn<String, String> recipeStepCL;
	
	private Product selectedProduct;
	private String selectedStep;
	
	private Recipe actualRecipe;

	@FXML
	private void recipeComboChanged() {
		actualRecipe = recipesListCombo.getSelectionModel().getSelectedItem();
		updateSelectedRecipe();
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
		Product p = productsListCombo.getSelectionModel().getSelectedItem();
		int quantity = amountIngredientTF.getInt();
		actualRecipe.addIngredient(p, quantity);
		changed();
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
		changed();

	}

	@FXML
	private void clearIngredients() {
		actualRecipe.clearIngredients();
		changed();
	}

	@FXML
	private void addStep() {
		if (stepTF.equals("")) {
			return;
		}
		String step = stepTF.getText();
		stepTF.clear();
		actualRecipe.addStep(step);
		changed();
		stepsTable.getSelectionModel().select(step);
	}

	@FXML
	private void editStep() {
		if (selectedStep == null) {
			return;
		}
		String step = stepTF.getText();
		actualRecipe.setStep(selectedStep, step);
		changed();
		stepsTable.getSelectionModel().select(step);
	}

	@FXML
	private void removeStep(ActionEvent event) {
		if (selectedStep == null) {
			return;
		}
		actualRecipe.removeStep(selectedStep);
		changed();
	}

	@FXML
	private void clearStep() {
		stepsTable.getSelectionModel().clearSelection();
		stepTF.clear();
		actualRecipe.clearSteps();
		changed();
	}

	@FXML
	private void moveUpStep() {
		String s = selectedStep;
		actualRecipe.moveUpStep(s);
		changed();
		stepsTable.getSelectionModel().select(s);
	}
	
	@FXML
	private void moveDownStep() {
		String s = selectedStep;
		actualRecipe.moveDownStep(s);
		changed();
		stepsTable.getSelectionModel().select(s);
	}

	@FXML
	private void createRecipe() {
		Main.getInstance().showDialog("CreateRecipe", "Create recipe");
		updateRecipes();
	}
	
	@FXML
	private void editRecipeName(String newValue) {
		if("".equals(newValue) || actualRecipe.getName().equals(newValue)) {
			// no change or cleared
			return;
		}
		actualRecipe.setName(newValue);
		changed();
	}

	@FXML
	/**
	 * Select a cell of the table products
	 * Update the status of the corresponding buttons when a product is selected (not disable)
	 */
	private void updateSelectedIngredient(Product newValue) {
		selectedProduct = newValue;
		if (selectedProduct == null) {
			amountIngredientTF.clear();
			productsListCombo.getSelectionModel().clearSelection();
		} else {
			amountIngredientTF.setInt(actualRecipe.getQuantity(selectedProduct));
			productsListCombo.getSelectionModel().select(selectedProduct);;
		}
	}

	@FXML
	/**
	 * Select a cell of the table Step, update the corresponding fields, and enable/disable some buttons on the view
	 */

	private void updateSelectedStep(String newValue) {
		selectedStep = newValue;
		if (selectedStep == null) {
			moveUpStepBT.setDisable(true);
			moveDownStepBT.setDisable(true);
			stepTF.clear();
		} else {
			moveUpStepBT.setDisable(actualRecipe.isFirst(selectedStep));
			moveDownStepBT.setDisable(actualRecipe.isLast(selectedStep));
			stepTF.setText(selectedStep);
		}
	}
	
	/**
	 * Select a recipe, update the corresponding fields, and enable/disable some buttons on the view
	 */
	private void updateSelectedRecipe() {
		productsListCombo.getSelectionModel().clearSelection();
		if (actualRecipe == null) {
			peopleTF.clear();
		} else {
			peopleTF.setInt(actualRecipe.getServings());
		}
		updateTable();
	}

	private void changed() {
		actualRecipe.save();
		updateTable();
	}

	private void updateTable() {
		recipeNameTF.clear();
		ingredientsTable.getItems().clear();
		stepsTable.getItems().clear();
		if (actualRecipe != null) {
			recipeNameTF.setText(actualRecipe.getName());
			ingredientsTable.getItems().addAll(actualRecipe.getAllIngredients().keySet());
			stepsTable.getItems().addAll(actualRecipe.getAllSteps());
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
		
		recipeNameTF.textProperty().addListener(
			(observable, oldValue, newValue) -> editRecipeName(newValue)
		);
		
		ingredientCL.setCellValueFactory(data -> {
			return new SimpleStringProperty(data.getValue().getName());
		});
		
		amountIngredientCL.setCellValueFactory(data -> {
			int amount = actualRecipe.getQuantity(data.getValue());
			return new SimpleStringProperty(Integer.toString(amount));
		});
		
		recipeStepCL.setCellValueFactory(data -> {
			return new SimpleStringProperty(data.getValue());
		});

		ingredientsTable.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> updateSelectedIngredient(newValue)
		);
		stepsTable.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> updateSelectedStep(newValue)
		);
		
		// use Recipe name
		recipesListCombo.setConverter(GetterConverter.create(Recipe.class, "name"));
		// use Product full name
		productsListCombo.setConverter(GetterConverter.create(Product.class, "fullName"));

		BooleanBinding notSelected = productsListCombo.getSelectionModel().selectedItemProperty().isNull();
		addIngredientBT.disableProperty().bind(notSelected);
		amountDownBT.disableProperty().bind(notSelected);
		amountUpBT.disableProperty().bind(notSelected);
		amountIngredientTF.disableProperty().bind(notSelected);
		
		notSelected = recipesListCombo.getSelectionModel().selectedItemProperty().isNull();
		recipeNameTF.disableProperty().bind(notSelected);
		productsListCombo.disableProperty().bind(notSelected);
		clearIngredientsBT.disableProperty().bind(notSelected);
		stepTF.disableProperty().bind(notSelected);
		addStepBT.disableProperty().bind(notSelected);
		clearStepBT.disableProperty().bind(notSelected);

		notSelected = ingredientsTable.getSelectionModel().selectedItemProperty().isNotNull();
		editIngredientBT.disableProperty().bind(notSelected);
		removeIngredientBT.disableProperty().bind(notSelected);
		
		notSelected = stepsTable.getSelectionModel().selectedItemProperty().isNotNull();
		editStepBT.disableProperty().bind(notSelected);
		removeStepBT.disableProperty().bind(notSelected);
		
		// load data and disable unavailable inputs
		peopleTF.setDisable(true);
		updateSelectedIngredient(null);
		updateSelectedStep(null);
		updateSelectedRecipe();
	}
}
