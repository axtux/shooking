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
	public void test_005_removeStep(){
		Recipe r = new Recipe("test");
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		r.removeStep(0);
		assertTrue(r.getAllSteps().isEmpty());
	}
	
	@Test
	public void test_006_addIngredient(){
		Recipe r = new Recipe("test");
		Product p = new Product("Farine d'avoine", 500, "g");
		r.addIngredient(p, 2);
		assertTrue(r.getAllIngredients().size()==1);
	}
	
	@Test
	public void test_007_getAllIngredients(){
		Recipe r = new Recipe("test");
		Product p = new Product("Farine d'avoine", 500, "g");
		r.addIngredient(p, 2);
		Map<Product,Float> map = r.getAllIngredients();
		//Normal behavior
		assertTrue(map.size()==1);
		//Cloning Test
		List<Product> ing = new ArrayList<>(map.keySet());
		assertEquals(p, ing.get(0));
	}
	
	@Test
	public void test_008_removeIngredient(){
		Recipe r = new Recipe("test");
		Product p = new Product("Farine d'avoine", 500, "g");
		r.addIngredient(p, 2);
		assertFalse(r.getAllIngredients().isEmpty());
		r.removeIngredient(p);
		assertTrue(r.getAllIngredients().isEmpty());
	}
	

}
