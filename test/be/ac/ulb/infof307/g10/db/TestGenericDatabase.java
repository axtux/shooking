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

	public static Product initProduct() {
		Product p = new Product("Pasta", 500, "g");
		GenericDatabase.save(p);
		GenericDatabase.close();
		return p;
	}

	public static List<Product> initList() {
		Product p = initProduct();
		List<Product> pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(1, pl.size());
		Assert.assertEquals(p, pl.get(0));
		return pl;
	}

	@Test
	public void saveGetOne() {
		Product p = initProduct();
		Product r = GenericDatabase.getOne(Product.class, "SELECT r FROM Product r WHERE r.name LIKE ?1", p.getName());
		Assert.assertEquals(p, r);
	}

	@Test
	public void saveGetAll() {
		initList();
	}

	@Test
	public void delete() {
		List<Product> pl = initList();
		Database.delete(pl.get(0));
		Database.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void deleteAll() {
		List<Product> pl = initList();
		Database.deleteAll(Product.class);
		Database.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void empty() {
		List<Product> pl = initList();
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
