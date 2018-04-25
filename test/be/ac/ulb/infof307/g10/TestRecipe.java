package be.ac.ulb.infof307.g10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;


import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;

public class TestRecipe {

	@Test
	public void test_001_addStep() {
		Recipe r = new Recipe();
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		assertTrue(r.getAllSteps().size()==1);
	}
	
	@Test
	public void test_002_getAllSteps(){
		Recipe r = new Recipe();
		String step = "Ajouter les oeufs";
		r.addStep(step);
		ArrayList<String> steps = r.getAllSteps();
		assertEquals(steps.get(0),step);
	}
	
	@Test
	public void test_003_moveStep(){
		Recipe r = new Recipe();
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
		Recipe r = new Recipe();
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		String step2 = "Battre les oeufs";
		r.addStep(step2);
		r.moveStep(0,5);
	}
	@Test
	public void test_005_removeStep(){
		Recipe r = new Recipe();
		String step1 = "Ajouter les oeufs";
		r.addStep(step1);
		r.removeStep(0);
		assertTrue(r.getAllSteps().isEmpty());
	}
	
	@Test
	public void test_006_addIngredient(){
		Recipe r = new Recipe();
		Product p = new Product("Farine d'avoine", "Delhaize", 353, 65, 12, 5, 530);
		r.addIngredient(p, 2);
		assertTrue(r.getAllIngredients().size()==1);
	}
	
	@Test
	public void test_007_getAllIngredients(){
		Recipe r = new Recipe();
		Product p = new Product("Farine d'avoine", "Delhaize", 353, 65, 12, 5, 530);
		r.addIngredient(p, 2);
		HashMap<Product,Float> map = r.getAllIngredients();
		//Normal behavior
		assertTrue(map.size()==1);
		//Cloning Test
		assertFalse(map.keySet().contains(p));
	}
	
	@Test
	public void test_008_removeIngredient(){
		Recipe r = new Recipe();
		Product p = new Product("Farine d'avoine", "Delhaize", 353, 65, 12, 5, 530);
		r.addIngredient(p, 2);
		assertFalse(r.getAllIngredients().isEmpty());
		r.removeIngredient(p);
		assertTrue(r.getAllIngredients().isEmpty());
	}
	

}
