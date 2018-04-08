package be.ac.ulb.infof307.g10.models;

import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;

import java.util.*;
import java.util.List;

public class Research {


    /**
     * Research class
     * @author Benjamin Nicodeme
     *
     */
    public List<Shop> getStoreWithProducts(List<Product> products){
        List<Shop> sl = new ArrayList<>();

        for (Product p : products) {
            List<Shop> sl2 = getStoreWithProduct(p);
            for (Shop s: sl2) {
                if (!sl.contains(s)){
                    sl.add(s);
                }
            }
        }
        return sl;
    }


    public List<Shop> getStoreWithProduct(Object product){
        List<Shop> sl = new ArrayList<>();
        for (Shop s : DatabaseFacade.getShops()) {
            if (s.getStock().containsKey(product)){
                sl.add(s);
            }

        }
        return sl;
    }

}
