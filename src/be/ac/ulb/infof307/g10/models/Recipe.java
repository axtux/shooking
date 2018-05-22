package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OrderColumn;

@Entity
public class Recipe extends ProductsQuantity {

	private static final long serialVersionUID = -0L;

	/**
	 * Number of people for the recipe
	 */
	private int servings;

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
		super(name);
		if (servings <= 0) {
			throw new IllegalArgumentException("servings must be > 0");
		}
		this.servings = servings;
		steps = new ArrayList<>();
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
		return index >= 0 && index == steps.size() - 1;
	}

	public void clearProducts() {
		super.clear();
	}

	@Override
	public int size() {
		return super.size() + steps.size();
	}

	@Override
	public void clear() {
		clearSteps();
		clearProducts();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty() && steps.isEmpty();
	}

	public int getServings() {
		return this.servings;
	}

	/**
	 * Create a shopping list from the product of the recipe
	 * @return a shopping list containing all the products of the recipe
	 */
	public ShoppingList toShoppingList() {
		ShoppingList retShoppingList = new ShoppingList("Recipe " + getName());
		for (Product p : getProducts()) {
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
