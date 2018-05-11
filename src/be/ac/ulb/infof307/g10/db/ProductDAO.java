package be.ac.ulb.infof307.g10.db;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class ProductDAO extends AbstractDAO {

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
		try{
			return GenericDatabase.getAll(Product.class);
		} catch (NoResultException e) {
			throw new NonExistingException();
		}
	}

	public static Product getProduct(String name) throws NonExistingException {
		try{
			return GenericDatabase.getOne(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1", name);
		} catch (NoResultException e) {
			throw new NonExistingException();
		}
	}
}
