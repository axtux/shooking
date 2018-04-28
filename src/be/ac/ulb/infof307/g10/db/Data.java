package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Data {
	public static void fillDB() {
		List<Shop> shops = getShops();
		List<Product> products;
		int i = 0;

		Database.setAutoCommit(false);
		for(Shop s: shops) {
			products = getProducts();
			for(Product p: products) {
				// change product to match shop, low cost first
				p.setDescription(s.getName());
				p.setPrice(p.getPrice()+10*i);
				// add product to shop with random quantity
				s.getStock().addProduct(p, ThreadLocalRandom.current().nextInt(100));
				Database.insert(p);
			}
			i++;
			Database.insert(s);
		}

		// insert recipes
		for(Recipe r: getRecipes()) {
			Database.insert(r);
		}

		Database.setAutoCommit(true);
	}
	
	public static List<Shop> getShops() {
		ArrayList<Shop> list = new ArrayList<>();

		// TODO rename method ?
		list.add(Shop.create("Aldi", 0.0, 0.0));
		list.add(Shop.create("Colruyt", 0.0, 0.0));
		list.add(Shop.create("Carrefour", 0.0, 0.0));
		list.add(Shop.create("Delhaize", 0.0, 0.0));
		
		return list;
	}
	
	/**
	 * Return a List of Recipes to put it in the DB
	 * @return	List of Recipes
	 */
	public static List<Recipe> getRecipes() {
		ArrayList<Recipe> list = new ArrayList<>();
		
		list.add(new Recipe("Omelette au fromage", 1));
		list.add(new Recipe("Pancake tombé dans la neige avant le 31 Décembre", 1));
		
		return list;
	}
	
	/**
	 * Get stock with random quantity for each product
	 * @param max Maximum quantity per product.
	 * @return Stock
	 */
	public static ShoppingList getStock(int max) {
		ShoppingList s = new ShoppingList();
		for(Product p: getProducts()) {
			s.addProduct(p, ThreadLocalRandom.current().nextInt(max+1));
		}
		return s;
	}
	
	public static List<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<>();

		list.add(new Product ("Farine d'avoine", "", 353, 65, 12, 5, 500));
		list.add(new Product ("Farines blanche (froment)", "", 353, 75, 9, 1, 100));
		list.add(new Product ("pain", "", 238, 49, 8, 1, 100));
		list.add(new Product ("Pain de blé (complet)", "", 239, 49, 8, 1, 100));
		list.add(new Product ("Pain de seigle", "", 241, 51, 7, 1, 100));
		list.add(new Product ("Biscottes de blé", "", 362, 75, 10, 2, 200));
		list.add(new Product ("Biscuits ordinaires", "", 360, 25, 2, 1, 100));
		list.add(new Product ("Biscuits secs (petits beurre)", "", 420, 77, 5, 10, 100));
		list.add(new Product ("Biscuits à la cuillère", "", 410, 77, 7, 7, 700));
		list.add(new Product ("Semoules et pâtes", "", 375, 76, 12, 1, 100));
		list.add(new Product ("Purée en sachet (poudre seule)", "", 365, 81, 8, 1, 100));
		list.add(new Product ("Purée en sachet (dans 1L lait)", "", 86, 13, 4, 2, 200));
		list.add(new Product ("Flan.alsa avec lait demi-écrémé", "", 99, 16, 3, 2, 200));
		list.add(new Product ("Lait entier", "", 68, 4, 3, 3, 300));
		list.add(new Product ("Lait demi-écrémé", "", 45, 4, 3, 1, 100));
		list.add(new Product ("Lait écrémé", "", 36, 5, 3, 1, 100));
		list.add(new Product ("Crème", "", 298, 4, 3, 30, 100));
		list.add(new Product ("Yoghourt", "", 45, 6, 4, 1, 100));
		list.add(new Product ("Beurre", "", 760, 1, 1, 83, 300));
		list.add(new Product ("Beurre.41%", "", 370, 1, 1, 41, 100));
		list.add(new Product ("Fromage blanc, maigre 0%", "", 64, 3, 12, 1, 100));
		list.add(new Product ("fromage blanc 20%", "", 72, 2, 7, 3, 300));
		list.add(new Product ("Fromage blanc, mi-gros", "", 93, 2, 11, 4, 400));
		list.add(new Product ("Fromage blanc, gras", "", 126, 2, 10, 8, 800));
		list.add(new Product ("Fromage blanc, petit-suisse", "", 168, 2, 10, 12, 200));
		list.add(new Product ("Brie", "", 271, 1, 17, 21, 100));
		list.add(new Product ("Camembert", "", 312, 4, 20, 24, 400));
		list.add(new Product ("Gruyère", "", 391, 1, 29, 30, 100));
		list.add(new Product ("Hollande", "", 331, 3, 29, 25, 500));
		list.add(new Product ("Huiles végétales", "", 900, 1, 1, 99, 900));
		list.add(new Product ("Margarines", "", 752, 1, 1, 83, 300));
		list.add(new Product ("Graisses animales", "", 778, 1, 1, 86, 600));
		list.add(new Product ("Mayonnaise", "", 710, 3, 2, 78, 800));
		list.add(new Product ("Oeuf entier", "", 162, 1, 13, 12, 200));
		list.add(new Product ("Jaune d'oeuf", "", 368, 1, 16, 33, 300));
		list.add(new Product ("Blanc d'oeuf", "", 48, 1, 11, 1, 100));
		list.add(new Product ("Boeufs (mi-gras)", "", 250, 1, 17, 20, 100));
		list.add(new Product ("Cheval", "", 110, 1, 21, 2, 200));
		list.add(new Product ("Mouton", "", 250, 1, 17, 19, 900));
		list.add(new Product ("Veau", "", 168, 1, 19, 10, 100));
		list.add(new Product ("Porc", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Jambon", "", 302, 8, 22, 22, 200));
		list.add(new Product ("Lard", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Cervelle", "", 130, 2, 10, 9, 900));
		list.add(new Product ("Coeur", "", 126, 1, 17, 6, 600));
		list.add(new Product ("Foie", "", 116, 1, 20, 4, 400));
		list.add(new Product ("Langue", "", 201, 1, 16, 15, 500));
		list.add(new Product ("Boudin (grillé)", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Jambon cuit", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Jambon fumé", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Pâté de foie gras", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Salami", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Saucisse", "", 290, 1, 16, 25, 500));
		list.add(new Product ("Saucisson", "", 290, 1, 16, 25, 500));
		list.add(new Product ("pâté.rillettes", "", 510, 1, 15, 50, 100));
		list.add(new Product ("Cassoulet préparé complet", "", 146, 9, 10, 8, 800));
		list.add(new Product ("Choucroute garnie", "", 113, 3, 9, 3, 300));
		list.add(new Product ("poule", "", 302, 1, 18, 25, 500));
		list.add(new Product ("poulet", "", 150, 1, 21, 8, 800));
		list.add(new Product ("Oie", "", 200, 1, 22, 14, 400));
		list.add(new Product ("Autruche", "", 140, 1, 26, 2, 200));
		list.add(new Product ("Dinde", "", 170, 1, 29, 5, 500));
		list.add(new Product ("Gibiers à poils", "", 100, 1, 20, 3, 300));
		list.add(new Product ("Gibiers à plumes", "", 108, 1, 22, 3, 300));
		list.add(new Product ("Ail", "", 139, 28, 6, 1, 100));
		list.add(new Product ("Asperges", "", 26, 3, 2, 1, 100));
		list.add(new Product ("Betteraves (rouges)", "", 40, 8, 1, 1, 100));
		list.add(new Product ("Carottes (cuites)", "", 32, 6, 1, 1, 100));
		list.add(new Product ("Céleris", "", 20, 3, 1, 1, 100));
		list.add(new Product ("Céleris raves", "", 44, 8, 2, 1, 100));
		list.add(new Product ("Cerfeuil", "", 65, 11, 3, 1, 100));
		list.add(new Product ("Champignons", "", 28, 4, 2, 1, 100));
		list.add(new Product ("Chicorée", "", 20, 3, 1, 1, 100));
		list.add(new Product ("Choucroute", "", 27, 5, 1, 1, 100));
		list.add(new Product ("Choux de Bruxelles", "", 54, 8, 4, 1, 100));
		list.add(new Product ("Chou-fleur", "", 30, 4, 2, 1, 100));
		list.add(new Product ("Chou rouge", "", 38, 7, 1, 1, 100));
		list.add(new Product ("Ciboulette", "", 39, 8, 1, 1, 100));
		list.add(new Product ("Concombre", "", 12, 2, 1, 1, 100));
		list.add(new Product ("Cornichons", "", 12, 2, 1, 1, 100));
		list.add(new Product ("Cresson", "", 21, 3, 1, 1, 100));
		list.add(new Product ("Echalotes", "", 75, 17, 1, 1, 100));
		list.add(new Product ("Endives", "", 22, 4, 1, 1, 100));
		list.add(new Product ("Epinards", "", 32, 3, 3, 1, 100));
		list.add(new Product ("Haricots verts", "", 23, 4, 1, 1, 100));
		list.add(new Product ("Laitue", "", 18, 2, 1, 1, 100));
		list.add(new Product ("Navets", "", 29, 6, 1, 1, 100));
		list.add(new Product ("Oignons", "", 40, 8, 1, 1, 100));
		list.add(new Product ("Persil", "", 55, 8, 3, 1, 100));
		list.add(new Product ("Poireaux", "", 42, 7, 2, 1, 100));
		list.add(new Product ("Pois", "", 70, 12, 4, 1, 100));
		list.add(new Product ("Poivrons", "", 22, 3, 1, 1, 100));
		list.add(new Product ("Pommes de terre", "", 86, 19, 2, 1, 100));
		list.add(new Product ("Radis", "", 20, 4, 1, 1, 100));
		list.add(new Product ("Salsifis", "", 77, 12, 4, 1, 100));
		list.add(new Product ("Scaroles", "", 37, 4, 1, 1, 100));
		list.add(new Product ("Tomates", "", 20, 3, 1, 1, 100));
		list.add(new Product ("Haricots blancs secs", "", 330, 60, 19, 1, 100));
		list.add(new Product ("Lentilles", "", 330, 56, 22, 1, 100));
		list.add(new Product ("Pois secs", "", 330, 56, 23, 1, 100));
		list.add(new Product ("Pois chiches", "", 361, 61, 18, 5, 500));
		list.add(new Product ("Poids.cassés", "", 342, 60, 22, 1, 100));
		list.add(new Product ("Maïs", "", 360, 70, 10, 5, 500));
		list.add(new Product ("Riz", "", 349, 78, 7, 1, 100));
		list.add(new Product ("Frittes chips", "", 544, 50, 7, 37, 700));
		list.add(new Product ("Abricots", "", 44, 10, 1, 1, 100));
		list.add(new Product ("Airelles", "", 25, 5, 1, 1, 100));
		list.add(new Product ("Ananas", "", 51, 12, 1, 1, 100));
		list.add(new Product ("Bananes", "", 90, 20, 1, 1, 100));
		list.add(new Product ("Cerises", "", 77, 17, 1, 1, 100));
		list.add(new Product ("Citrons", "", 43, 2, 1, 1, 100));
		list.add(new Product ("Figues fraîches", "", 80, 18, 1, 1, 100));
		list.add(new Product ("Fraises", "", 40, 7, 1, 1, 100));
		list.add(new Product ("Framboises", "", 40, 8, 1, 1, 100));
		list.add(new Product ("Groseilles", "", 30, 5, 1, 1, 100));
		list.add(new Product ("Mandarines", "", 40, 9, 1, 1, 100));
		list.add(new Product ("Melons", "", 31, 6, 1, 1, 100));
		list.add(new Product ("Oranges", "", 44, 9, 1, 1, 100));
		list.add(new Product ("Pamplemousses", "", 43, 9, 1, 1, 100));
		list.add(new Product ("Pêches", "", 52, 12, 1, 1, 100));
		list.add(new Product ("Poires", "", 61, 14, 1, 1, 100));
		list.add(new Product ("Pommes", "", 52, 12, 1, 1, 100));
		list.add(new Product ("Prunes", "", 64, 10, 1, 1, 100));
		list.add(new Product ("Raisins", "", 81, 17, 1, 1, 100));
		list.add(new Product ("Rhubarbes", "", 16, 3, 1, 1, 100));
		list.add(new Product ("Amandes", "", 620, 17, 20, 54, 400));
		list.add(new Product ("Arachides", "", 560, 26, 23, 40, 100));
		list.add(new Product ("Châtaignes", "", 199, 40, 4, 2, 200));
		list.add(new Product ("Châtaignes sèches", "", 371, 73, 7, 5, 500));
		list.add(new Product ("Dattes", "", 306, 73, 2, 1, 100));
		list.add(new Product ("Figues sèches", "", 275, 62, 4, 1, 100));
		list.add(new Product ("Noisettes", "", 656, 15, 14, 60, 100));
		list.add(new Product ("Noix", "", 660, 15, 15, 60, 100));
		list.add(new Product ("Pruneaux", "", 290, 70, 2, 1, 100));
		list.add(new Product ("Bonbons divers", "", 378, 94, 1, 1, 100));
		list.add(new Product ("Cacao.super.instantané", "", 386, 87, 3, 2, 200));
		list.add(new Product ("Chocolats", "", 530, 63, 2, 30, 100));
		list.add(new Product ("Confitures", "", 280, 70, 1, 1, 100));
		list.add(new Product ("Miel", "", 300, 75, 1, 1, 100));
		list.add(new Product ("Pâtisseries", "", 475, 80, 5, 15, 500));
		list.add(new Product ("Sucre", "", 400, 99, 1, 1, 100));
		list.add(new Product ("Compote de pommes", "", 99, 24, 1, 1, 100));
		list.add(new Product ("Crème de marrons", "", 240, 60, 1, 1, 100));
		list.add(new Product ("Sauce.bechamel *58/100", "", 570, 41, 5, 43, 300));
		list.add(new Product ("Bière", "", 35, 4, 1, 1, 100));
		list.add(new Product ("Cidre", "", 40, 5, 1, 1, 100));
		list.add(new Product ("Eaux de vie", "", 280, 1, 1, 1, 100));
		list.add(new Product ("Limonade", "", 48, 12, 1, 1, 100));
		list.add(new Product ("Vin (blanc 10 doux)", "", 80, 8, 1, 1, 100));
		list.add(new Product ("Vin (rouge 10)", "", 65, 1, 1, 1, 100));
		list.add(new Product ("Coca-Cola", "", 1, 1, 1, 1, 100));
		list.add(new Product ("Jus d'oranges", "", 50, 12, 1, 1, 100));
		list.add(new Product ("Crabe crevette", "", 70, 1, 15, 1, 100));
		list.add(new Product ("Langouste homard", "", 70, 1, 15, 1, 100));
		list.add(new Product ("Anchois", "", 160, 1, 20, 8, 800));
		list.add(new Product ("Anguille", "", 200, 1, 14, 8, 800));
		list.add(new Product ("Brochet", "", 78, 1, 18, 1, 100));
		list.add(new Product ("Cabillaud", "", 68, 1, 16, 1, 100));
		list.add(new Product ("Carpe", "", 90, 1, 18, 2, 200));
		list.add(new Product ("Colin", "", 86, 1, 17, 2, 200));
		list.add(new Product ("Dorade", "", 77, 1, 17, 1, 100));
		list.add(new Product ("Eglefin", "", 71, 1, 17, 1, 100));
		list.add(new Product ("Hareng", "", 122, 1, 17, 6, 600));
		list.add(new Product ("Limande et Sole", "", 73, 1, 16, 1, 100));
		list.add(new Product ("Maquereau", "", 128, 1, 14, 8, 800));
		list.add(new Product ("Merlan", "", 69, 1, 16, 1, 100));
		list.add(new Product ("Perche", "", 112, 1, 19, 4, 400));
		list.add(new Product ("Raie", "", 89, 1, 20, 1, 100));
		list.add(new Product ("Sardines", "", 174, 1, 21, 10, 100));
		list.add(new Product ("Sardines (en conserve)", "", 188, 1, 20, 12, 200));
		list.add(new Product ("Saumon", "", 114, 1, 16, 8, 800));
		list.add(new Product ("Saumon (en conserve)", "", 170, 1, 20, 10, 100));
		list.add(new Product ("Thon", "", 225, 1, 27, 13, 300));
		list.add(new Product ("Thon (en conserve)", "", 225, 1, 25, 20, 100));
		list.add(new Product ("Truite", "", 94, 1, 16, 2, 200));
		list.add(new Product ("Turbot", "", 118, 1, 16, 6, 600));
		
		return list;
	}
}
