package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;

public class TestRecipe extends AbstractTestDatabase {

	@Test
	public void test_001_addStep() {
		Recipe r = new Recipe("test");
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		assertTrue(r.getAllSteps().size()==1);
	}
	
	@Test
	public void test_002_getAllSteps(){
		Recipe r = new Recipe("test");
		String step = "Ajouter les oeufs";
		r.addStep(step);
		List<String> steps = r.getAllSteps();
		assertEquals(steps.get(0),step);
	}
	
	@Test
	public void test_003_moveStep(){
		Recipe r = new Recipe("test");
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		String step2 = "Battre les oeufs";
		r.addStep(step2);
		r.moveStep(0,1);
		assertEquals(r.getStep(0),step2);
		assertEquals(r.getStep(1),step1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_004_moveStepException(){
		Recipe r = new Recipe("test");
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		String step2 = "Battre les oeufs";
		r.addStep(step2);
		r.moveStep(0,5);
	}

	@Test
	public void test_005_moveUpStep() {
		Recipe r = new Recipe("moveUpStep");
		String step1 = "step1";
		String step2 = "step2";
		r.addStep(step1);
		r.addStep(step2);
		r.moveUpStep(step2);
		assertEquals(r.getStep(0),step2);
		assertEquals(r.getStep(1),step1);
	}
	
	@Test
	public void test_006_moveDownStep() {
		Recipe r = new Recipe("moveUpStep");
		String step1 = "step1";
		String step2 = "step2";
		r.addStep(step1);
		r.addStep(step2);
		r.moveDownStep(step1);
		assertEquals(r.getStep(0),step2);
		assertEquals(r.getStep(1),step1);
	}
		
	@Test
	public void test_007_removeStep(){
		Recipe r = new Recipe("test");
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		r.removeStep(0);
		assertTrue(r.getAllSteps().isEmpty());
	}

	@Test
	public void test_008_setStep() {
		Recipe r = new Recipe("setStep");
		r.addStep("old step");
		r.setStep(0, "new step");
		assertEquals(r.getStep(0), "new step");
	}
	
	@Test
	public void test_009_setStep() {
		Recipe r = new Recipe("setStep");
		r.addStep("old step");
		r.setStep("old step", "new Step");
		assertEquals(r.getStep(0), "new Step");
	}
	
	@Test
	public void test_010_removeStep() {
		Recipe r = new Recipe("removeStep");
		String step = "step to remove";
		r.addStep(step);
		r.removeStep(0);
		assertTrue(r.getAllSteps().isEmpty());
	}
	
	@Test
	public void test_011_removeStep() {
		Recipe r = new Recipe("removeStep");
		String step = "step to remove";
		r.addStep(step);
		r.removeStep(step);
		assertTrue(r.getAllSteps().isEmpty());
	}
	
	@Test
	public void test_012_clearSteps() {
		Recipe r = new Recipe("clearSteps");
		r.addStep("testing step");
		r.clearSteps();
		assertTrue(r.getAllSteps().isEmpty());
	}
	
	@Test
	public void test_013_isFirst() {
		Recipe r = new Recipe("isFirst");
		r.addStep("first step");
		r.addStep("middle step");
		r.addStep("last step");
		assertTrue(r.isFirst("first step"));
		assertFalse(r.isFirst("middle step"));
	}
	
	@Test
	public void test_014_isLast() {
		Recipe r = new Recipe("isLast");
		r.addStep("first step");
		r.addStep("middle step");
		r.addStep("last step");
		assertTrue(r.isLast("last step"));
		assertFalse(r.isLast("middle step"));
	}
	
	@Test
	public void test_015_addIngredient(){
		Recipe r = new Recipe("test");
		Product p = new Product("Farine d'avoine", 500, "g");
		r.addIngredient(p, 2);
		assertTrue(r.getAllIngredients().size()==1);
	}
	
	@Test
	public void test_016_getAllIngredients(){
		Recipe r = new Recipe("test");
		Product p = new Product("Farine d'avoine", 500, "g");
		r.addIngredient(p, 2);
		Map<Product,Float> map = r.getAllIngredients();
		List<Product> ing = new ArrayList<>(map.keySet());
		//Normal behavior
		assertTrue(map.size()==1);
		//Cloning Test
		assertEquals(p, ing.get(0));
	}
	
	@Test
	public void test_017_removeIngredient(){
		Recipe r = new Recipe("test");
		Product p = new Product("Farine d'avoine", 500, "g");
		r.addIngredient(p, 2);
		assertFalse(r.getAllIngredients().isEmpty());
		r.removeIngredient(p);
		assertTrue(r.getAllIngredients().isEmpty());
	}

	@Test
	public void test_018_setIngredient() {
		Recipe r = new Recipe("setIngredient");
		Product p = new Product("test",12,"g");
		r.addIngredient(p, (float) 1.);
		r.setIngredientQuantity(p, (float) 2.);
		assertEquals(r.getAllIngredients().get(p), (float) 2., 0.1);
	}

	@Test
	public void test_019_getQuantity() {
		Recipe r = new Recipe("getQuantity");
		Product p = new Product("testing product", 500, "g");
		r.addIngredient(p, 12);
		int quantity = r.getQuantity(p);
		assertEquals(quantity, 12);
	}
	
	@Test
	public void test_020_clearIngredients() {
		Recipe r = new Recipe("clearSteps");
		r.addIngredient(new Product("test",12,"g"), 1);
		r.clearIngredients();
		assertTrue(r.getAllIngredients().isEmpty());
	}
}
