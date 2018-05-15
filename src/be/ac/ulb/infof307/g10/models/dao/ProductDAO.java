package be.ac.ulb.infof307.g10.models.dao;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.database.GenericDatabase;
import be.ac.ulb.infof307.g10.models.database.SaverObserver;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class ProductDAO {

	/**
	 * Create a new Product and save it in the DB
	 * @param name		Name of the Product
	 * @param quantity	Quantity of the Product
	 * @param unitSize	Unit size of the quantity of the Product
	 * @return	The new Product
	 */
	public static Product createProduct(String name, int quantity, String unitSize) {
		Product p = new Product(name, quantity, unitSize);
		p.addObserver(SaverObserver.getInstance());
		return p;
	}

	public static List<Product> getAllProducts() throws NonExistingException {
		return GenericDatabase.getAll(Product.class);
	}

	public static Product getProduct(String name) throws NonExistingException {
		try{
			return GenericDatabase.getOne(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1", name);
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}
}
