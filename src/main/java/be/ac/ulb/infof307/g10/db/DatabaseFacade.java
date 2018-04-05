package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.User;
import sun.rmi.transport.ObjectTable;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import java.util.List;

public class DatabaseFacade {

    public DatabaseFacade(){}

    public static List<Product> getProduct(){
        Connection.getTransaction().begin();
        List<Product> l = Connection.getManager().createNamedQuery("Product.findAll").getResultList();
        Connection.getTransaction().commit();
        return  l;
    }

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


    public static Product getProduct(String name, String description) throws NoResultException{
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

    public static List<Shop> getShops(){
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


    public static void deleteList(be.ac.ulb.infof307.g10.models.List l) throws NoResultException{
        try {
            //FIXME java.lang.IllegalStateException: ???
            //Exception Description: Transaction is currently active
            Connection.getTransaction().begin();
            DatabaseFacade.getListOwner(l.getId()).setList(null);
            Connection.getTransaction().commit();
            Connection.getTransaction().begin();
            Connection.getManager().remove(l);
            Connection.getTransaction().commit();
        }catch (NoResultException e){
            Connection.getTransaction().rollback();
            throw new NoResultException();
        }
    }




//
//    public static void storeBlockChain(Chain chain){
//        Connection.getTransaction().begin();
//        if(!Connection.getManager().createNamedQuery("Chain.findAll").getResultList().isEmpty()){
//            Connection.getTransaction().rollback();
//            throw new IllegalStateException("There's already a chain in the database");
//        }
//        Connection.getManager().persist(chain);
//        Connection.getTransaction().commit();
//    }
//
//    public static Chain getStoredChain(){
//        Connection.getTransaction().begin();
//        Chain chain;
//        try {
//            chain = (Chain) Connection.getManager().createNamedQuery("Chain.findAll").getSingleResult();
//        }catch(NoResultException e){
//            chain = null;
//        }
//        Connection.getTransaction().commit();
//        return chain;
//    }
//
//    public static void updateChain(Chain chain){
//        Connection.getTransaction().begin();
//        Connection.getManager().merge(chain);
//        Connection.getTransaction().commit();
//    }
//
//    public static void removeBlockChain(Chain chain){
//        Connection.getTransaction().begin();
//        Connection.getManager().remove(chain);
//        Connection.getTransaction().commit();
//    }
//
//    public static List<Transaction> getAllTransactionsWithAddress(String... addresses){
//        List<String> addr = Arrays.asList(addresses);
//        Connection.getTransaction().begin();
//        @SuppressWarnings("unchecked")
//		List<Transaction> transactions = Connection.getManager().createQuery("SELECT t from Transaction t where t.outputOut.address IN :addr1 or t.outputBack.address IN :addr2")
//                .setParameter("addr1", addr)
//                .setParameter("addr2", addr).getResultList();
//        Connection.getTransaction().commit();
//        return transactions;
//    }
//
//    public static Block getBlockWithHash(String finalHash){
//        Connection.getTransaction().begin();
//        Block b;
//        try {
//            b = (Block) Connection.getManager().createQuery("SELECT b from Block b where b.finalHash = :finalHash").setParameter("finalHash", finalHash).getSingleResult();
//        }catch(NoResultException e){
//            b = null;
//        }
//        Connection.getTransaction().commit();
//        return b;
//    }
//
//    public static Block getLastBlock() {
//        Connection.getTransaction().begin();
//        Block b;
//        try {
//            b = (Block) Connection.getManager().createQuery("SELECT b from Block b where b.id = (SELECT max(b2.id) from Block b2)").getSingleResult();
//        }catch(NoResultException e){
//            b = null;
//        }
//        Connection.getTransaction().commit();
//        return b;
//    }

}
