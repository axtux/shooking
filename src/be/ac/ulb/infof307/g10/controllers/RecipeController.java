package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.utils.ToStringConverter;
import be.ac.ulb.infof307.g10.views.IntField;
import be.ac.ulb.infof307.g10.views.View;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller class of the Recipe view. It is used to manage the different
 * action on a recipe such as creation and edition.
 */
public class RecipeController extends AbstractProductController {

	@FXML
	private ComboBox<Recipe> recipesListCombo;
	@FXML
	private IntField peopleTF;
	@FXML
	private TextField stepTF;
	@FXML
	private TextField recipeNameTF;
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
	private TableColumn<Product, String> productsAmountColumn;
	@FXML
	private TableView<String> stepsTable;
	@FXML
	private TableColumn<String, String> recipeStepCL;

	private String selectedStep;

	private Recipe actualRecipe;

	private void recipesComboSelect(Recipe newValue) {
		actualRecipe = newValue;
		updateSelectedRecipe();
	}

	@FXML
	private void productsAdd() {
		Product p = productsCombo.getSelectionModel().getSelectedItem();
		int quantity = productsAmountField.getInt();
		actualRecipe.addIngredient(p, quantity);
		changed();
		productsTable.getSelectionModel().select(p);
	}

	@FXML
	private void productsEdit() {
		if (productsTableSelected == null) {
			return;
		}
		actualRecipe.removeIngredient(productsTableSelected);
		productsAdd();
	}

	@FXML
	private void productsRemove() {
		if (productsTableSelected == null) {
			return;
		}
		actualRecipe.removeIngredient(productsTableSelected);
		changed();

	}

	@FXML
	private void productsClear() {
		actualRecipe.clearIngredients();
		changed();
	}

	@FXML
	private void addStep() {
		String step = stepTF.getText().trim();
		if (step.isEmpty()) {
			return;
		}
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
	private void removeStep() {
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
		Main.getInstance().showDialog(View.CREATE_RECIPE);
		updateRecipes();
	}

	@FXML
	private void editRecipeName(String newValue) {
		if ("".equals(newValue) || actualRecipe.getName().equals(newValue)) {
			// no change or cleared
			return;
		}
		Recipe r = actualRecipe;
		actualRecipe.setName(newValue);
		changed();
		updateRecipes();
		recipesListCombo.getSelectionModel().select(r);
	}

	@Override
	protected void productsTableSelect(Product newValue) {
		super.productsTableSelect(newValue);
		if (productsTableSelected != null) {
			productsAmountField.setInt(actualRecipe.getQuantity(productsTableSelected));
		}
	}

	/**
	 * Select a cell of the table Step, update the corresponding fields, and
	 * enable/disable some buttons on the view
	 */
	@FXML
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
	 * Select a recipe, update the corresponding fields, and enable/disable some
	 * buttons on the view
	 */
	private void updateSelectedRecipe() {
		productsCombo.getSelectionModel().clearSelection();
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
		productsTable.getItems().clear();
		stepsTable.getItems().clear();
		if (actualRecipe != null) {
			recipeNameTF.setText(actualRecipe.getName());
			productsTable.getItems().addAll(actualRecipe.getAllIngredients().keySet());
			stepsTable.getItems().addAll(actualRecipe.getAllSteps());
		}
	}

	private void updateRecipes() {
		recipesListCombo.getItems().clear();
		recipesListCombo.getItems().addAll(Database.getAllRecipes());
	}

	@Override
	public void initialize() {
		super.initialize();
		updateRecipes();

		recipeNameTF.textProperty().addListener((observable, oldValue, newValue) -> editRecipeName(newValue));

		productsAmountColumn.setCellValueFactory(cell -> {
			int amount = actualRecipe.getQuantity(cell.getValue());
			return new SimpleStringProperty(Integer.toString(amount));
		});

		recipeStepCL.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue()));

		stepsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> updateSelectedStep(newValue));

		// use Recipe name
		recipesListCombo.setConverter(new ToStringConverter<>(Recipe::getName));

		recipesListCombo.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> recipesComboSelect(newValue));

		BooleanBinding notSelected = recipesListCombo.getSelectionModel().selectedItemProperty().isNull();
		recipeNameTF.disableProperty().bind(notSelected);
		productsCombo.disableProperty().bind(notSelected);
		productsClearButton.disableProperty().bind(notSelected);
		stepTF.disableProperty().bind(notSelected);
		addStepBT.disableProperty().bind(notSelected);
		clearStepBT.disableProperty().bind(notSelected);

		notSelected = stepsTable.getSelectionModel().selectedItemProperty().isNull();
		editStepBT.disableProperty().bind(notSelected);
		removeStepBT.disableProperty().bind(notSelected);

		// load data and disable unavailable inputs
		peopleTF.setDisable(true);
		updateSelectedStep(null);
		updateSelectedRecipe();
	}
}
