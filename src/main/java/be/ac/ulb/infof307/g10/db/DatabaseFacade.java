package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.Objects.*;

import javax.persistence.NoResultException;
import java.util.ArrayList;
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
        Connection.getTransaction().begin();
        User u = (User) Connection.getManager().createQuery("SELECT b from User b where b.username LIKE :username").setParameter("username", username).getSingleResult();
        Connection.getTransaction().commit();
        return u;
    }

    public static User getListOwner(Long list_id) throws NoResultException{
        Connection.getTransaction().begin();
        User u = (User) Connection.getManager().createQuery("SELECT b from User b where b.list_id LIKE :list_id").setParameter("list_id", list_id).getSingleResult();
        Connection.getTransaction().commit();
        return u;
    }


    public static void insertUser(User u) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().persist(u);
        Connection.getTransaction().commit();
    }

    public static void updateUser(User u) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().merge(u);
        Connection.getTransaction().commit();
    }

    public static void deleteUser(User u) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().remove(u);
        Connection.getTransaction().commit();
    }

    public static void insertProduct(Product p) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().persist(p);
        Connection.getTransaction().commit();
    }

    public static Product getProduct(String name, String description) throws NoResultException{
        Connection.getTransaction().begin();
        //FIXME - multiple result crash
        Product p = (Product) Connection.getManager().createQuery("SELECT b FROM Product b WHERE b.name LIKE :name AND b.description LIKE :description").setParameter("name", name).setParameter("description", description).getSingleResult();
        Connection.getTransaction().commit();
        return p;
    }

    public static List<Product> getProducts(String name) throws NoResultException{
        Connection.getTransaction().begin();
        List<Product> p = (List<Product>) Connection.getManager().createQuery("SELECT b FROM Product b WHERE b.name LIKE :name").setParameter("name", name).getResultList();
        Connection.getTransaction().commit();
        return p;
    }

    public static void deleteProduct(Product p) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().remove(p);
        Connection.getTransaction().commit();
    }

    public static void insertShop(Shop s) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().persist(s);
        Connection.getTransaction().commit();
    }

    public static Shop getShop(String name) throws NoResultException{
        Connection.getTransaction().begin();
        Shop s = (Shop) Connection.getManager().createQuery("SELECT b FROM Shop b WHERE b.name LIKE :name").setParameter("name", name).getSingleResult();
        Connection.getTransaction().commit();
        return s;
    }

    public static List<Shop> getShops(){
        Connection.getTransaction().begin();
        List<Shop> l = Connection.getManager().createNamedQuery("Shop.findAll").getResultList();
        Connection.getTransaction().commit();
        return  l;
    }


    public static void deleteShop(Shop s) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().remove(s);
        Connection.getTransaction().commit();
    }

    public static void insertList(be.ac.ulb.infof307.g10.Objects.List l) throws NoResultException{
        Connection.getTransaction().begin();
        Connection.getManager().persist(l);
        Connection.getTransaction().commit();
    }

    public static void deleteList(be.ac.ulb.infof307.g10.Objects.List l) throws NoResultException{
        //FIXME java.lang.IllegalStateException: ???
        //Exception Description: Transaction is currently active
        Connection.getTransaction().begin();
        DatabaseFacade.getListOwner(l.getId()).setList(null);
        Connection.getTransaction().commit();
        Connection.getTransaction().begin();
        Connection.getManager().remove(l);
        Connection.getTransaction().commit();
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
