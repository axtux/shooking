package be.ac.ulb.infof307.g10.controllers;

import java.util.Collection;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.ProductsQuantity;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.dao.RecipeDAO;
import be.ac.ulb.infof307.g10.utils.ToStringConverter;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.IntField;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller class of the Recipe view. It is used to manage the different
 * action on a recipe such as creation and edition.
 */
public class RecipeController extends AbstractProductController {

	@FXML
	private IntField servingsField;
	@FXML
	private TextField stepTF;
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
	private Button exportAsShoppingListBT;
	@FXML
	private TableView<String> stepsTable;
	@FXML
	private TableColumn<String, String> recipeStepCL;

	private String selectedStep;

	private Recipe actualRecipe;

	@FXML
	private void addStep() {
		String step = stepTF.getText().trim();
		if (step.isEmpty()) {
			return;
		}
		actualRecipe.addStep(step);
		updateStepsTable(actualRecipe);
		stepsTable.getSelectionModel().select(step);
		stepTF.clear();
	}

	@FXML
	private void editStep() {
		if (selectedStep == null) {
			return;
		}
		String step = stepTF.getText();
		actualRecipe.setStep(selectedStep, step);
		updateStepsTable(actualRecipe);
		stepsTable.getSelectionModel().select(step);
	}

	@FXML
	private void removeStep() {
		if (selectedStep == null) {
			return;
		}
		actualRecipe.removeStep(selectedStep);
		updateStepsTable(actualRecipe);
	}

	@FXML
	private void clearStep() {
		stepsTable.getSelectionModel().clearSelection();
		stepTF.clear();
		actualRecipe.clearSteps();
		updateStepsTable(actualRecipe);
	}

	@FXML
	private void moveUpStep() {
		String s = selectedStep;
		actualRecipe.moveUpStep(s);
		updateStepsTable(actualRecipe);
		stepsTable.getSelectionModel().select(s);
	}

	@FXML
	private void moveDownStep() {
		String s = selectedStep;
		actualRecipe.moveDownStep(s);
		updateStepsTable(actualRecipe);
		stepsTable.getSelectionModel().select(s);
	}

	@FXML
	private void createRecipe() {
		DialogView.show(View.CREATE_RECIPE, (event) -> updateAllProductsQuantity());
	}

	private void updateStepsTable(Recipe actual) {
		stepsTable.getItems().clear();
		stepsTable.getItems().addAll(actual.getAllSteps());
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
	@Override
	protected void selectProductsQuantity(ProductsQuantity newValue) {
		super.selectProductsQuantity(newValue);
		if (newValue == null) {
			servingsField.clear();
		} else {
			actualRecipe = (Recipe) newValue;
			servingsField.setInt(actualRecipe.getServings());
			updateStepsTable(actualRecipe);
		}
	}

	@Override
	protected Collection<? extends ProductsQuantity> getAllProductsQuantity() {
		return RecipeDAO.getAll();
	}

	@Override
	public void initialize() {
		super.initialize();

		productsNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientName()));

		// use Product full name
		productsCombo.setConverter(new ToStringConverter<>(Product::getIngredientName));

		recipeStepCL.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue()));

		stepsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> updateSelectedStep(newValue));

		BooleanBinding notSelected = productsQuantityCombo.getSelectionModel().selectedItemProperty().isNull();
		stepTF.disableProperty().bind(notSelected);
		addStepBT.disableProperty().bind(notSelected);
		clearStepBT.disableProperty().bind(notSelected);
		exportAsShoppingListBT.disableProperty().bind(notSelected);

		notSelected = stepsTable.getSelectionModel().selectedItemProperty().isNull();
		editStepBT.disableProperty().bind(notSelected);
		removeStepBT.disableProperty().bind(notSelected);

		// load data and disable unavailable inputs
		servingsField.setDisable(true);
		updateSelectedStep(null);
	}

	/**
	 * Handler for button Export recipe as a shopping list
	 */
	@FXML
	private void exportAsShoppingList() {
		Main.getUser().addShoppingList(actualRecipe.toShoppingList());
		MainView.show(View.SHOPPING_LIST);
	}

}
