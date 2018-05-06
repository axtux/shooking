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
	void editIngredient(ActionEvent event) {
		// TODO trouble if selectedProduct has changed
		if (selectedProduct == null) {
			return;
		}
		int quantity = amountIngredientTF.getInt();
		actualRecipe.setIngredientQuantity(selectedProduct, quantity);
		updateTable();
	}
	
	@FXML
	void removeIngredient() {
		if (selectedProduct == null) {
			return;
		}
		actualRecipe.removeIngredient(selectedProduct);
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
		// TODO why not setStep(String, String) ?
		actualRecipe.setStep(steps.indexOf(selectedStep), stepTF.getText());
		updateTable();
	}

	@FXML
	void removeStep() {
		if (selectedStep == null) {
			return;
		}
		// TODO why not removeStep(String, String) ?
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
		// TODO why not moveUpStep(String) ?
		actualRecipe.moveUpStep(steps.indexOf(selectedStep));
		updateTable();
	}
	
	@FXML
	void moveDownStep() {
		// TODO why not moveDownStep(String) ?
		actualRecipe.moveDownStep(steps.indexOf(selectedStep));
		updateTable();
	}

	@FXML
	void CreateRecipe() {
		Main.getInstance().showDialog("CreateRecipe", "Create recipe");
		updateRecipes();
	}
	
	@FXML
	void saveRecipe() {
		// TODO autosave ?
		actualRecipe.save();
	}
	
	@FXML
	void editRecipeName() {
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
		if (selectedProduct != null) {
			editIngredientBT.setDisable(false);
			removeIngredientBT.setDisable(false);
			amountIngredientTF.setInt(actualRecipe.getQuantity(selectedProduct));
			productsListCombo.getSelectionModel().select(selectedProduct);;
		} else {
			editIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
		}
	}

	@FXML
	/**
	 * Select a cell of the table Step, update the corresponding fields, and enable/disable some buttons on the view
	 */

	private void updateSelectedStep(String newValue) {
		selectedStep = newValue;
		if (selectedStep != null) {
			editStepBT.setDisable(false);
			removeStepBT.setDisable(false);
			boolean first = selectedStep.equals(steps.get(0));
			moveUpStepBT.setDisable(first);
			boolean last = selectedStep.equals(steps.get(steps.size()-1));
			moveDownStepBT.setDisable(last);
			stepTF.setText(selectedStep);
		} else {
			editStepBT.setDisable(true);
			removeStepBT.setDisable(true);
			moveUpStepBT.setDisable(true);
			moveDownStepBT.setDisable(true);
			stepTF.clear();
		}
	}
	
	/**
	 * Select a recipe, update the corresponding fields, and enable/disable some buttons on the view
	 */
	private void updateSelectedRecipe() {
		amountIngredientTF.clear();
		stepTF.clear();
		steps.clear();
		// TODO call other selected methods
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
			addIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
			clearIngredientsBT.setDisable(false);
			editIngredientBT.setDisable(true);
			removeStepBT.setDisable(true);
			addStepBT.setDisable(false);
			editStepBT.setDisable(true);
			clearStepBT.setDisable(false);
			saveRecipeBT.setDisable(false);
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
		updateTable();
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
		if (actualRecipe != null) {
			steps.clear();
			steps.addAll(actualRecipe.getAllSteps());
			ingredientsTable.getItems().clear();
			ObservableList<Product> ingredients = FXCollections.observableArrayList(actualRecipe.getAllIngredients().keySet());
			ingredientsTable.setItems(ingredients);
			stepsTable.setItems(steps);
		}
	}
	
	public void updateRecipes() {
		recipesListCombo.getItems().clear();
		recipesListCombo.getItems().addAll(Database.getAllRecipes());
	}
	
	public void initialize(URL url, ResourceBundle rb) {
		productsListCombo.getItems().clear();
		productsListCombo.getItems().addAll(Database.getAllProducts());
		updateRecipes();
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

		updateTable();
		updateSelectedRecipe();
		amountIngredientTF.setSigned(false);

	}

	public void researchProduct() {
		Main.getInstance().showDialog("ResearchDialog", "Research product");
	}
}
