package be.ac.ulb.infof307.g10.models.dao;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * Data access object for {@link Product}
 */
final public class ProductDAO {

	/**
	 * Avoid object creation
	 */
	private ProductDAO() {
	}
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

	/**
	 * Return all the existing products
	 * @return a list containing all the existing products
	 */
	public static List<Product> getAll() {
		return Database.getAll(Product.class);
	}

	/**
	 * Research a product with a certain name inside the database.
	 * @param name the name of the product
	 * @return The product with that name
	 * @throws NonExistingException If {@link Product} does not exists.
	 */
	public static Product getByName(String name) throws NonExistingException {
		try{
			return Database.getOne(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1", name);
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}
}
