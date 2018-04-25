package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseFacade {

    public DatabaseFacade(){}

    /**
     * fill db
     */
    public static void fillDB(){
        (new FillDB()).fill();
    }


    /**
     * empty db
     */
    public static void emptyDB(){
        Connection.getTransaction().begin();
        Connection.getManager().createQuery("delete from Product p").executeUpdate();
        Connection.getManager().createQuery("delete from User u").executeUpdate();
        Connection.getManager().createQuery("delete from Shop p").executeUpdate();
        Connection.getManager().createQuery("delete from ShoppingList l").executeUpdate();
        Connection.getTransaction().commit();

    }


    /**
     *
     * @param username
     * @return
     * @throws NoResultException
     */
    public static User getUser(String username) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            User u = (User) Connection.getManager().createQuery("SELECT b from User b where b.username LIKE :username").setParameter("username", username).getSingleResult();
            Connection.getTransaction().commit();
            return u;
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        } 
    }

    /**
     *
     * @param list_id
     * @return
     * @throws NoResultException
     */
    public static User getListOwner(Long list_id) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            User u = (User) Connection.getManager().createQuery("SELECT b from User b where b.list_id LIKE :list_id").setParameter("list_id", list_id).getSingleResult();
            Connection.getTransaction().commit();
            return u;
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }

    }

    /**
     *
     * @param o
     * @throws NoResultException
     * @throws RollbackException
     */
    public static void insert(Object o) throws NoResultException, RollbackException {
        try {
            Connection.getTransaction().begin();
            Connection.getManager().persist(o);
            Connection.getTransaction().commit();
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

    /**
     *
     * @param o
     * @throws NoResultException
     */
    public static void delete(Object o) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            Connection.getManager().remove(o);
            Connection.getTransaction().commit();
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

    /**
     *
     * @param o
     * @throws NoResultException
     */
    public static void update(Object o) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            Connection.getManager().merge(o);
            Connection.getTransaction().commit();
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }


    /**
     *
     * @param name
     * @param description
     * @return a product from a name and description
     * @throws NoResultException
     */
    public static Product getProductFromNameAndDesc(String name, String description) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            //FIXME - multiple result crash
            Product p = (Product) Connection.getManager().createQuery("SELECT b FROM Product b WHERE b.name LIKE :name AND b.description LIKE :description").setParameter("name", name).setParameter("description", description).getSingleResult();
            Connection.getTransaction().commit();
            return p;
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

    /**
     *
     * @param name
     * @return a list of product from a name
     * @throws NoResultException
     */
    public static List<Product> getProducts(String name) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            List<Product> p = (List<Product>) Connection.getManager().createQuery("SELECT b FROM Product b WHERE b.name LIKE :name").setParameter("name", name).getResultList();
            Connection.getTransaction().commit();
            return p;
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

    /**
     *
     * @param name
     * @return a shop from its name
     * @throws NoResultException
     */
    public static Shop getShop(String name) throws NoResultException{
        try {
            Connection.getTransaction().begin();
            Shop s = (Shop) Connection.getManager().createQuery("SELECT b FROM Shop b WHERE b.name LIKE :name").setParameter("name", name).getSingleResult();
            Connection.getTransaction().commit();
            return s;
        }
        catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

    /**
     *
     * @return all shops
     * @throws NoResultException
     */
    public static List<Shop> getAllShops() throws NoResultException {
        try {
            Connection.getTransaction().begin();
            List<Shop> l = Connection.getManager().createNamedQuery("Shop.findAll").getResultList();
            Connection.getTransaction().commit();
            return l;
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

    /**
     *
     * @param l
     * @throws NoResultException
     */
    public static void deleteList(ShoppingList l) throws NoResultException{
        try {
            //FIXME java.lang.IllegalStateException: ???
            //Exception Description: Transaction is currently active
            Connection.getTransaction().begin();
            DatabaseFacade.getListOwner(l.getId()).setShoppingList(null);
            Connection.getTransaction().commit();
            Connection.getTransaction().begin();
            Connection.getManager().remove(l);
            Connection.getTransaction().commit();
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }

}
