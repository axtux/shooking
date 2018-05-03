package be.ac.ulb.infof307.g10.controllers;

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
	private TableView<Map.Entry<Product, Integer>> ingredientsTable;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> ingredientCL;
	@FXML
	private TableColumn<Map.Entry<Product, Integer>, String> amountIngredientCL;
	@FXML
	private TableView<String> stepsTable;
	@FXML
	private TableColumn<String, String> recipeStepCL;
	@FXML
	// private TableColumn<Map.Entry<Product, Integer>, String> stepsCL;
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
	void recipeComboChanged(ActionEvent event) {
		System.out.println("recipeComboChanged");
		actualRecipe = recipesListCombo.getSelectionModel().getSelectedItem();
		updateSelectedRecipe();
	}
	
	@FXML
	void productComboChanged(ActionEvent event) {
		System.out.println("productComboChanged");
		actualProduct = productsListCombo.getSelectionModel().getSelectedItem();
		updateSelectedProduct();
	}
	
	@FXML
	void amountDown(ActionEvent event) {
		System.out.println("amountDown");
		amountIngredientTF.setInt(amountIngredientTF.getInt() - 1);
	}

	@FXML
	void amountUp(ActionEvent event) {
		System.out.println("amountUp");
		amountIngredientTF.setInt(amountIngredientTF.getInt() + 1);
	}

	@FXML
	void addIngredient(ActionEvent event) {
		System.out.println("addIngredient");
		if (productsListCombo.getSelectionModel().isEmpty()) {
			return;
		}
		Product p = productsListCombo.getSelectionModel().getSelectedItem();
		int quantity = amountIngredientTF.getInt();
		products.put(p, quantity);
		actualRecipe.addIngredient(p, quantity);
		updateInterface();
	}

	// Edit ingredient
	@FXML
	void editIngredient(ActionEvent event) {
		//TODO MàJ not refresh on table
		System.out.println("editIngredient");
		if (selectedProduct == null) {
			return;
		}
		int quantity = amountIngredientTF.getInt();
		products.put(selectedProduct.getKey(), quantity);
		actualRecipe.addIngredient(selectedProduct.getKey(), quantity);
		updateInterface();
	}
	
	@FXML
	void removeIngredient(ActionEvent event) {
		System.out.println("removeIngredient");
		if (selectedProduct == null) {
			return;
		}
		products.remove(selectedProduct.getKey());
		actualRecipe.removeIngredient(selectedProduct.getKey());
		updateInterface();

	}

	// Clear ingredient
	@FXML
	void clearIngredients(ActionEvent event) {
		System.out.println("clearIngredients");
		products.clear();
		actualRecipe.clearIngredients();
		// in case selection is not update, clear fields
		amountIngredientTF.clear();
		peopleTF.clear();
		updateInterface();
	}

	// Add step
	@FXML
	void addStep(ActionEvent event) {
		System.out.println("addStep");
		if (stepTF.equals("")) {
			return;
		}
		String step = stepTF.getText();
		steps.add(step);
		actualRecipe.addStep(step);
		updateInterface();
	}

	// Edit step
	@FXML
	void editStep(ActionEvent event) {
		System.out.println("editStep");
		if (selectedStep == null) {
			return;
		}
		steps.set(steps.indexOf(selectedStep), stepTF.getText());
		actualRecipe.setStep(actualRecipe.getAllSteps().indexOf(selectedStep), stepTF.getText());
		updateInterface();
	}

	// Delete step
	@FXML
	void removeStep(ActionEvent event) {
		System.out.println("removeStep");
		if (selectedStep == null) {
			return;
		}
		steps.remove(selectedStep);
	}

	// Clear step
	@FXML
	void clearStep(ActionEvent event) {
		System.out.println("clearStep");
		stepsTable.getSelectionModel().clearSelection();
		// in case selection is not update, clear fields
		stepTF.clear();
		steps.clear();
		actualRecipe.clearSteps();
		updateInterface();
	}


	// Create RecipeController
	@FXML
	void CreateRecipe(ActionEvent event) {
		System.out.println("createRecipe");
		Recipe r = new Recipe("Testing name");
		r.save();
		recipesListCombo.getItems().add(r);
		//recipesListCombo.getItems().clear();
		//recipesListCombo.getItems().addAll(Database.getAllRecipes());
	}
	
	@FXML
	void SaveRecipe(ActionEvent event) {
		System.out.println("saveRecipe");
		actualRecipe.save();
	}
	
	@FXML
	void DeleteRecipe(ActionEvent event) {
		System.out.println("deleteRecipe");
		recipesListCombo.getItems().remove(actualRecipe);
		actualRecipe.delete();
		actualRecipe = null;
		updateSelectedRecipe();
	}

	@FXML
	/**
	 * Select a cell of the table products
	 * Update the status of the corresponding buttons when a product is selected (not disable)
	 */
	private void updateSelectedIngredient() {
		System.out.println("updateSelectedIngredient");
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
	 * Select a cell of the table Step
	 */
	private void updateSelectedStep() {
		System.out.println("updateSelectedStep");
		int size = selectionSteps.size();
		if (size == 1) {
			selectedStep = selectionSteps.get(0);
			editStepBT.setDisable(false);
			removeStepBT.setDisable(false);
			stepTF.setText(selectedStep);
		} else {
			selectedStep = null;
			editStepBT.setDisable(true);
			removeStepBT.setDisable(true);
		}
	}
	
	private void updateSelectedRecipe() {
		System.out.println("updateSelectedRecipe");
		amountIngredientTF.clear();
		stepTF.clear();
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
			productsListCombo.setDisable(true);
			amountIngredientTF.setDisable(true);
			stepTF.setDisable(true);
			peopleTF.setDisable(true);
			amountUpBT.setDisable(true);
			amountDownBT.setDisable(true);
			//for (int i=0; i<ingredientsTable.getItems().size(); i++){
				ingredientsTable.getItems().clear();
			//}
			products = FXCollections.observableHashMap();
			steps = FXCollections.observableArrayList();
		}
		else {
			addIngredientBT.setDisable(true);
			removeIngredientBT.setDisable(true);
			clearIngredientsBT.setDisable(false);
			editIngredientBT.setDisable(true);
			removeStepBT.setDisable(true);
			addStepBT.setDisable(false);
			editStepBT.setDisable(true);
			clearStepBT.setDisable(false);
			saveRecipeBT.setDisable(false);
			deleteRecipeBT.setDisable(false);
			productsListCombo.setDisable(false);
			amountIngredientTF.setDisable(true);
			stepTF.setDisable(false);
			peopleTF.setDisable(false);
			amountUpBT.setDisable(true);
			amountDownBT.setDisable(true);
				//TODO change recipe ingredient into int OR float
			actualRecipe.getAllIngredients().forEach((ingredient, quantity)
					->products.put(ingredient, Math.round(quantity)));
			steps.addAll(actualRecipe.getAllSteps());
		}
	}

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
	private void updateInterface() {
		System.out.println("updateInterface");
		productsContent = FXCollections.observableArrayList(products.entrySet());
		// sort by product description (case insensitive)
		productsContent.sort(new Comparator<Entry<Product, Integer>>() {
			public int compare(Entry<Product, Integer> o1, Entry<Product, Integer> o2) {
				return o1.getKey().getName().toLowerCase().compareTo(o2.getKey().getName().toLowerCase());
			}
		});
		ingredientsTable.setItems(productsContent);
		stepsTable.setItems(steps);
	}

	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("init");
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

		// update items on products update
		products.addListener(new MapChangeListener<Product, Integer>() {
			@Override
			public void onChanged(Change<? extends Product, ? extends Integer> change) {
				updateInterface();
			}
		});
		steps.addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(Change<? extends String> change) {
				updateInterface();
			}
		});

		// add listener to call selected method
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

	public void researchProduct(ActionEvent actionEvent) {
		Main.getInstance().showDialog("ResearchDialog", "Research product");
	}
}
