package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OrderColumn;

@Entity
public class Recipe extends ProductsQuantity {

	private static final long serialVersionUID = -0L;

	/**
	 * Name of the recipe
	 */
	@Column(unique = true)
	private String name;

	/**
	 * Number of people for the recipe
	 */
	private int servings;

	/**
	 * Mapping between products and quantities of it
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Product, Float> ingredients;

	/**
	 * List of different steps of the recipe
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@OrderColumn
	private List<String> steps;

	/**
	 * Needed by JPA
	 */
	protected Recipe() {
	}

	/**
	 * Constructor for a new Recipe
	 * 
	 * @param name
	 *            Name of the Recipe
	 * @param servings
	 *            Number of people for the recipe
	 */
	public Recipe(String name, int servings) {
		setName(name);
		if (servings <= 0) {
			throw new IllegalArgumentException("servings must be > 0");
		}
		this.servings = servings;
		ingredients = new HashMap<>();
		steps = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		this.name = name;
		this.changed();
	}

	public int getQuantity(Product ingredient) {
		return Math.round(ingredients.getOrDefault(ingredient, (float) 0));
	}

	/**
	 * Get steps
	 * 
	 * @return List of steps
	 */
	public List<String> getAllSteps() {
		return new ArrayList<>(steps);
	}

	/**
	 * Getter for a particular step
	 * 
	 * @param index
	 *            index of the step
	 * @return The i th step
	 */
	public String getStep(int index) throws IndexOutOfBoundsException {
		return steps.get(index);
	}

	/**
	 * Replace the oldStep by newStep
	 * 
	 * @param oldStep
	 *            Actual step to change
	 * @param newStep
	 *            New step
	 */
	public void setStep(String oldStep, String newStep) {
		int index = steps.indexOf(oldStep);
		steps.set(index, newStep);
		this.changed();
	}

	/**
	 * Add a step at the end of the recipe
	 * 
	 * @param step
	 *            the new last step
	 */
	public void addStep(String step) {
		steps.add(step);
		this.changed();
	}

	/**
	 * Swap steps at index1 and index2.
	 * 
	 * @param index1
	 *            Step index to swap.
	 * @param index2
	 *            Step index to swap.
	 */
	private void swapStep(int index1, int index2) throws IndexOutOfBoundsException {
		String tmp = steps.get(index1);
		steps.set(index1, steps.get(index2));
		steps.set(index2, tmp);
		this.changed();
	}

	/**
	 * Move up the step. Index of step is decreased.
	 * 
	 * @param step
	 *            Initial step to move up
	 */
	public void moveUpStep(String step) throws IndexOutOfBoundsException {
		int index = steps.indexOf(step);
		swapStep(index, index - 1);
	}

	/**
	 * Move down the step. Index of step is increased.
	 * 
	 * @param step
	 *            Initial step to move up
	 */
	public void moveDownStep(String step) throws IndexOutOfBoundsException {
		int index = steps.indexOf(step);
		swapStep(index, index + 1);
	}

	public void removeStep(String step) {
		int index = steps.indexOf(step);
		steps.remove(index);
		this.changed();
	}

	/**
	 * Delete all steps
	 */
	public void clearSteps() {
		this.steps.clear();
		this.changed();
	}

	/**
	 * Return true if the step is the first in the steps list
	 * 
	 * @param step
	 *            The step to test
	 * @return true is the step is the first (false otherwise)
	 */
	public boolean isFirst(String step) {
		int index = steps.indexOf(step);
		return index == 0;
	}

	/**
	 * Return true if the step is the last in the steps list
	 * 
	 * @param step
	 *            The step to test
	 * @return true is the step is the last (false otherwise)
	 */
	public boolean isLast(String step) {
		int index = steps.lastIndexOf(step);
		return index == steps.size() - 1;
	}

	/**
	 * Add an ingredient in the ingredients list. If the product is already
	 * present, the older quantity is erased by the new one
	 * 
	 * @param product
	 *            The new product
	 * @param quantity
	 *            The quantity of the product needed in the recipe
	 */
	public void addIngredient(Product product, float quantity) {
		float before = ingredients.getOrDefault(product, (float) 0);
		ingredients.put(product, before + quantity);
		this.changed();
	}

	/**
	 * Modify the quantity of the selected product
	 * 
	 * @param product
	 *            The product already in the ingredients list
	 * @param quantity
	 *            The new quantity of the product
	 */
	public void setIngredientQuantity(Product product, float quantity) {
		if (ingredients.containsKey(product)) {
			ingredients.put(product, quantity);
		}
		this.changed();
	}

	/**
	 * Remove the ingredient p if present
	 * 
	 * @param p
	 *            the ingredient to remove
	 */
	public void removeIngredient(Product p) {
		ingredients.remove(p);
		this.changed();
	}

	/**
	 * Get ingredients
	 * 
	 * @return Map of each ingredients to its quantity
	 */
	public Map<Product, Float> getAllIngredients() {
		return new HashMap<>(ingredients);
	}

	/**
	 * Delete all ingredients
	 */
	public void clearIngredients() {
		this.ingredients.clear();
		this.changed();
	}

	public int getServings() {
		return this.servings;
	}

	public ShoppingList toShoppingList() {
		ShoppingList retShoppingList = new ShoppingList("Recipe " + this.name);
		for (Product p : ingredients.keySet()) {
			int quantityToHave = getQuantity(p);
			int q = 0;
			while (p.getSize() * q < quantityToHave) {
				q++;
			}
			retShoppingList.addQuantity(p, q);
		}
		return retShoppingList;
	}

}
