package be.ac.ulb.infof307.g10.db;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;

public class TestGenericDatabase extends AbstractTestDatabase {

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
		List<Product> pl = initList();
		Assert.assertNotNull(pl);
	}

	@Test
	public void delete() {
		List<Product> pl = initList();
		GenericDatabase.delete(pl.get(0));
		GenericDatabase.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void deleteAll() {
		List<Product> pl = initList();
		GenericDatabase.deleteAll(Product.class);
		GenericDatabase.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void empty() {
		List<Product> pl = initList();
		GenericDatabase.empty();
		GenericDatabase.close();
		pl = GenericDatabase.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}
}
