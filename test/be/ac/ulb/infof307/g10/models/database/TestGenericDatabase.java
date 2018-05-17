package be.ac.ulb.infof307.g10.models.database;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestGenericDatabase extends AbstractTestDatabase {

	public static Product initProduct() {
		Product p = new Product("Pasta", 500, "g");
		Database.save(p);
		Database.close();
		return p;
	}

	public static List<Product> initList() {
		Product p = initProduct();
		List<Product> pl = Database.getAll(Product.class);
		Assert.assertEquals(1, pl.size());
		Assert.assertEquals(p, pl.get(0));
		return pl;
	}

	@Test
	public void saveGetOne() {
		Product p = initProduct();
		Product r = Database.getOne(Product.class, "SELECT r FROM Product r WHERE r.name LIKE ?1", p.getName());
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
		Database.delete(pl.get(0));
		Database.close();
		pl = Database.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void deleteAll() {
		List<Product> pl = initList();
		Database.deleteAll(Product.class);
		Database.close();
		pl = Database.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void empty() {
		List<Product> pl = initList();
		Database.empty();
		Database.close();
		pl = Database.getAll(Product.class);
		Assert.assertEquals(0, pl.size());
	}

	@Test
	public void recoverAfterError() {
		UserDAO.create("test", "test");
		try {
			UserDAO.create("test", "test");
			assert false;
		} catch (ExistingException e) {
			assert true;
		}
		User u = UserDAO.create("test2", "test2");
		Assert.assertNotNull(u);
	}

}
