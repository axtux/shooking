package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecipeDAO {

	@Test
	public void test_001_createRecipe() {
		Recipe r = RecipeDAO.createRecipe("#test createRecipe", 12);
		assertNotNull(r);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_002_createRecipeException() {
		Recipe r = RecipeDAO.createRecipe("", -1);
		assertNull(r);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_003_createRecipeException() {
		Recipe r = RecipeDAO.createRecipe("#test createRecipeException", 12, null, null);
		assertNull(r);
	}
}
