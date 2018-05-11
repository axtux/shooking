package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;

public class TestRecipe extends AbstractTestDatabase {

	private Recipe r;
	private Product p1;
	private Product p2;

	@Before
	public void before() {
		r = new Recipe("Testing recipe");
		r.addStep("testing step 1");
		r.addStep("testing step 2");
		r.addStep("testing step 3");
		p1 = new Product("testing product 1", 1, "g");
		p2 = new Product("testing product 2", 1, "g");
		r.addIngredient(p1, (float) 1.);
		r.addIngredient(p2, (float) 1.);
	}

	@Test
	public void test_001_addStep() {
		r.addStep("testing step 4");
		assertEquals(4, r.getAllSteps().size());
	}

	@Test
	public void test_002_getAllSteps() {
		List<String> steps = r.getAllSteps();
		assertEquals(steps.get(0), "testing step 1");
		assertEquals(steps.get(1), "testing step 2");
		assertEquals(steps.get(2), "testing step 3");
	}

	@Test
	public void test_003_moveStep() {
		r.moveStep(0, 1);
		assertEquals(r.getStep(0), "testing step 2");
		assertEquals(r.getStep(1), "testing step 1");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_004_moveStepException() {
		r.moveStep(0, 5);
	}

	@Test
	public void test_005_moveUpStep() {
		r.moveUpStep("testing step 2");
		assertEquals(r.getStep(0), "testing step 2");
		assertEquals(r.getStep(1), "testing step 1");
	}

	@Test
	public void test_006_moveDownStep() {
		r.moveDownStep("testing step 2");
		assertEquals(r.getStep(1), "testing step 3");
		assertEquals(r.getStep(2), "testing step 2");
	}

	@Test
	public void test_007_setStep() {
		r.setStep(0, "set step");
		assertEquals(r.getStep(0), "set step");
	}

	@Test
	public void test_008_setStep() {
		r.setStep("testing step 1", "set step");
		assertEquals(r.getStep(0), "set step");
	}

	@Test
	public void test_009_removeStep() {
		r.removeStep(0);
		r.removeStep(0);
		r.removeStep(0);
		assertTrue(r.getAllSteps().isEmpty());
	}

	@Test
	public void test_010_removeStep() {
		r.removeStep("testing step 1");
		r.removeStep("testing step 2");
		r.removeStep("testing step 3");
		assertTrue(r.getAllSteps().isEmpty());
	}

	@Test
	public void test_011_clearSteps() {
		r.clearSteps();
		assertTrue(r.getAllSteps().isEmpty());
	}

	@Test
	public void test_012_isFirst() {
		assertTrue(r.isFirst("testing step 1"));
		assertFalse(r.isFirst("testing step 2"));
		assertFalse(r.isFirst("testing step 3"));
	}

	@Test
	public void test_013_isLast() {
		assertFalse(r.isLast("testing step 1"));
		assertFalse(r.isLast("testing step 2"));
		assertTrue(r.isLast("testing step 3"));
	}

	@Test
	public void test_014_addIngredient() {
		r.addIngredient(new Product("testing product 3", 1, "g"), 2);
		assertEquals(3, r.getAllIngredients().size());
	}

	@Test
	public void test_015_getAllIngredients() {
		Map<Product, Float> map = r.getAllIngredients();
		// Normal behavior
		assertEquals(2, map.size());
		// Cloning Test
		map.put(new Product("bad product", 1, "g"), (float) 3.);
		assertNotEquals(map, r.getAllIngredients());
	}

	@Test
	public void test_016_removeIngredient() {
		assertFalse(r.getAllIngredients().isEmpty());
		r.removeIngredient(p1);
		r.removeIngredient(p2);
		assertTrue(r.getAllIngredients().isEmpty());
	}

	@Test
	public void test_017_setIngredientQuantity() {
		r.setIngredientQuantity(p1, (float) 2.);
		assertEquals(r.getAllIngredients().get(p1), (float) 2., 0.1);
	}

	@Test
	public void test_018_getQuantity() {
		int quantity = r.getQuantity(p2);
		assertEquals(quantity, (float) 1., 0.1);
	}

	@Test
	public void test_019_clearIngredients() {
		r.clearIngredients();
		assertTrue(r.getAllIngredients().isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_020_createRecipeException() {
		new Recipe("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_021_createRecipeException() {
		new Recipe("correct name", 0);
	}

	@Test(expected = NullPointerException.class)
	public void test_022_createRecipeException() {
		new Recipe("correct name", 1, null);
	}

	@Test
	public void test_023_RecipeToShoppingList(){

		Recipe r2 = new Recipe("Testing recipe");
		r2.addStep("testing step 1");
		r2.addStep("testing step 2");
		r2.addStep("testing step 3");
		p1 = new Product("testing pastas", 500, "g");
		p2 = new Product("testing tomatoes", 1, "pc");
		r2.addIngredient(p1, (float) 600.);
		r2.addIngredient(p2, (float) 3.);

		ShoppingList slTemp = r2.toShoppingList();
		System.out.println(slTemp.getProductsAndQuantity());
		for (Product p : slTemp.getProductsAndQuantity().keySet()) {
			System.out.println(p);
			System.out.println(slTemp.getProductsAndQuantity().get(p));
		}
	}
}
