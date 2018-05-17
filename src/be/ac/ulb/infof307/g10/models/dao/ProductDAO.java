package be.ac.ulb.infof307.g10.models.dao;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class ProductDAO {

	/**
	 * Create a new Product and save it in the DB
	 * @param name		Name of the Product
	 * @param quantity	Quantity of the Product
	 * @param unitSize	Unit size of the quantity of the Product
	 * @return	The new Product
	 */
	public static Product create(String name, int quantity, String unitSize) {
		try {
			getByName(name);
			throw new ExistingException("A product with same name already exists");
		} catch (NonExistingException e) {
			Product p = new Product(name, quantity, unitSize);
			Database.save(p);
			return p;
		}
	}

	public static List<Product> getAll() throws NonExistingException {
		return Database.getAll(Product.class);
	}

	public static Product getByName(String name) throws NonExistingException {
		try{
			return Database.getOne(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1", name);
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}
}
