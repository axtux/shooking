package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestRecipe {

	private Recipe r;
	private Product p1;
	private Product p2;

	@Before
	public void before() {
		r = new Recipe("Testing recipe", 1);
		r.addStep("testing step 1");
		r.addStep("testing step 2");
		r.addStep("testing step 3");
		p1 = new Product("testing product 1", 1, "g");
		p2 = new Product("testing product 2", 1, "g");
		r.addQuantity(p1, 1);
		r.addQuantity(p2, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRecipeExceptionName() {
		new Recipe("", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRecipeExceptionServing() {
		new Recipe("correct name", 0);
	}
	
	@Test
	public void addStep() {
		r.addStep("testing step 4");
		assertEquals(4, r.getAllSteps().size());
	}

	@Test
	public void getAllSteps() {
		List<String> steps = r.getAllSteps();
		assertEquals(steps.get(0), "testing step 1");
		assertEquals(steps.get(1), "testing step 2");
		assertEquals(steps.get(2), "testing step 3");
	}

	@Test
	public void moveUpStep() {
		r.moveUpStep("testing step 2");
		assertEquals(r.getStep(0), "testing step 2");
		assertEquals(r.getStep(1), "testing step 1");
	}

	@Test
	public void moveDownStep() {
		r.moveDownStep("testing step 2");
		assertEquals(r.getStep(1), "testing step 3");
		assertEquals(r.getStep(2), "testing step 2");
	}
	
	@Test
	public void setStep() {
		r.setStep("testing step 1", "set step");
		assertEquals(r.getStep(0), "set step");
	}
	
	@Test
	public void removeStep() {
		r.removeStep("testing step 1");
		r.removeStep("testing step 2");
		r.removeStep("testing step 3");
		assertTrue(r.getAllSteps().isEmpty());
	}

	@Test
	public void clearSteps() {
		r.clearSteps();
		assertTrue(r.getAllSteps().isEmpty());
	}

	@Test
	public void isFirst() {
		assertTrue(r.isFirst("testing step 1"));
		assertFalse(r.isFirst("testing step 2"));
		assertFalse(r.isFirst("testing step 3"));
	}

	@Test
	public void isLast() {
		assertFalse(r.isLast("testing step 1"));
		assertFalse(r.isLast("testing step 2"));
		assertTrue(r.isLast("testing step 3"));
	}

	@Test
	public void addIngredient() {
		r.addQuantity(new Product("testing product 3", 1, "g"), 2);
		assertEquals(3, r.size());
	}

	@Test
	public void removeIngredient() {
		assertFalse(r.isEmpty());
		r.removeProduct(p1);
		r.removeProduct(p2);
		assertTrue(r.getProducts().isEmpty());
	}
	
	@Test
	public void setIngredientQuantity() {
		r.setQuantity(p1, 2);
		assertEquals(r.getQuantity(p1), (float) 2., 0.1);
	}

	@Test
	public void getQuantity() {
		int quantity = r.getQuantity(p2);
		assertEquals(quantity, (float) 1., 0.1);
	}

	@Test
	public void clearIngredients() {
		r.clearProducts();
		assertTrue(r.getProducts().isEmpty());
	}

	@Test
	public void toShoppingList(){

		Recipe r2 = new Recipe("Testing recipe", 1);
		r2.addStep("testing step 1");
		r2.addStep("testing step 2");
		r2.addStep("testing step 3");
		p1 = new Product("testing pastas", 500, "g");
		p2 = new Product("testing tomatoes", 1, "pc");
		r2.addQuantity(p1, 600);
		r2.addQuantity(p2, 3);

		ShoppingList slTemp = r2.toShoppingList();

		assertEquals(slTemp.getQuantity(p1), 2);
		assertEquals(slTemp.getQuantity(p2), 3);
	}
}
