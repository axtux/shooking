package be.ac.ulb.infof307.g10.db;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestGenericDatabase {

	@BeforeClass
	public static void beforeClass() {
		GenericDatabase.empty();
	}

	@After
	public void after() {
		GenericDatabase.empty();
	}

	@Test
	public void saveGetOne() {
		Product p = new Product("Pasta", 500, "g");
		GenericDatabase.save(p);
		GenericDatabase.close();
		Product r = GenericDatabase.getOne(Product.class, "SELECT r FROM Product r WHERE r.name LIKE ?1", p.getName());
		// TODO make equals working
		//Assert.assertEquals(p, r);
	}

	@Test
	public void saveGetAll() {
		Product p = new Product("Pasta", 500, "g");
		GenericDatabase.save(p);
		GenericDatabase.close();
		List<Product> pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(1, pl.size());
		// TODO make equals working
		//Assert.assertEquals(p, pl.get(0));
	}

	@Test
	public void delete() {
		Product p = new Product("Pasta", 500, "g");
		GenericDatabase.save(p);
		GenericDatabase.close();
		List<Product> pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(1, pl.size());
		//Assert.assertEquals(p, pl.get(0));
		Database.delete(pl.get(0));
		Database.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void deleteAll() {
		Product p = new Product("Pasta", 500, "g");
		GenericDatabase.save(p);
		GenericDatabase.close();
		List<Product> pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(1, pl.size());
		//Assert.assertEquals(p, pl.get(0));
		Database.deleteAll(Product.class);
		Database.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void empty() {
		Product p = new Product("Pasta", 500, "g");
		GenericDatabase.save(p);
		GenericDatabase.close();
		List<Product> pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(1, pl.size());
		//Assert.assertEquals(p, pl.get(0));
		Database.empty();
		Database.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void recoverAfterError() {
		User.signup("test", "test");
		try {
			User.signup("test", "test");
			assert false;
		} catch(ExistingException e) {
			assert true;
		}
		User.signup("test2", "test2");
	}
}
