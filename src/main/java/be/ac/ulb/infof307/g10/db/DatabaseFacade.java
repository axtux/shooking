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

    public static void fillDB(){
        insert(new User("User1", "User1", null));
        insert(new User("User2", "User2", null));

        insert(new Product ("Farine d'avoine", "Delhaize", 353, 65, 12, 5, 530));
        insert(new Product ("Farine d'avoine", "Carrefour", 353, 65, 12, 5, 520));
        insert(new Product ("Farine d'avoine", "Colruyt", 353, 65, 12, 5, 510));
        insert(new Product ("Farine d'avoine", "Aldi", 353, 65, 12, 5, 500));

        insert(new Product ("Farines blanche (froment)", "Delhaize", 353, 75, 9, 1, 130));
        insert(new Product ("Farines blanche (froment)", "Carrefour", 353, 75, 9, 1, 120));
        insert(new Product ("Farines blanche (froment)", "Colruyt", 353, 75, 9, 1, 110));
        insert(new Product ("Farines blanche (froment)", "Aldi", 353, 75, 9, 1, 100));

        insert(new Product ("pain", "Delhaize", 238, 49, 8, 1, 130));
        insert(new Product ("pain", "Carrefour", 238, 49, 8, 1, 120));
        insert(new Product ("pain", "Colruyt", 238, 49, 8, 1, 110));
        insert(new Product ("pain", "Aldi", 238, 49, 8, 1, 100));

        insert(new Product ("Pain de blé (complet)", "Delhaize", 239, 49, 8, 1, 130));
        insert(new Product ("Pain de blé (complet)", "Carrefour", 239, 49, 8, 1, 120));
        insert(new Product ("Pain de blé (complet)", "Colruyt", 239, 49, 8, 1, 110));
        insert(new Product ("Pain de blé (complet)", "Aldi", 239, 49, 8, 1, 100));

        insert(new Product ("Pain de seigle", "Delhaize", 241, 51, 7, 1, 130));
        insert(new Product ("Pain de seigle", "Carrefour", 241, 51, 7, 1, 120));
        insert(new Product ("Pain de seigle", "Colruyt", 241, 51, 7, 1, 110));
        insert(new Product ("Pain de seigle", "Aldi", 241, 51, 7, 1, 100));

        insert(new Product ("Biscottes de blé", "Delhaize", 362, 75, 10, 2, 230));
        insert(new Product ("Biscottes de blé", "Carrefour", 362, 75, 10, 2, 220));
        insert(new Product ("Biscottes de blé", "Colruyt", 362, 75, 10, 2, 210));
        insert(new Product ("Biscottes de blé", "Aldi", 362, 75, 10, 2, 200));

        insert(new Product ("Biscuits ordinaires", "Delhaize", 360, 25, 2, 1, 130));
        insert(new Product ("Biscuits ordinaires", "Carrefour", 360, 25, 2, 1, 120));
        insert(new Product ("Biscuits ordinaires", "Colruyt", 360, 25, 2, 1, 110));
        insert(new Product ("Biscuits ordinaires", "Aldi", 360, 25, 2, 1, 100));

        insert(new Product ("Biscuits secs (petits beurre)", "Delhaize", 420, 77, 5, 10, 130));
        insert(new Product ("Biscuits secs (petits beurre)", "Carrefour", 420, 77, 5, 10, 120));
        insert(new Product ("Biscuits secs (petits beurre)", "Colruyt", 420, 77, 5, 10, 110));
        insert(new Product ("Biscuits secs (petits beurre)", "Aldi", 420, 77, 5, 10, 100));

        insert(new Product ("Biscuits à la cuillère", "Delhaize", 410, 77, 7, 7, 730));
        insert(new Product ("Biscuits à la cuillère", "Carrefour", 410, 77, 7, 7, 720));
        insert(new Product ("Biscuits à la cuillère", "Colruyt", 410, 77, 7, 7, 710));
        insert(new Product ("Biscuits à la cuillère", "Aldi", 410, 77, 7, 7, 700));

        insert(new Product ("Semoules et pâtes", "Delhaize", 375, 76, 12, 1, 130));
        insert(new Product ("Semoules et pâtes", "Carrefour", 375, 76, 12, 1, 120));
        insert(new Product ("Semoules et pâtes", "Colruyt", 375, 76, 12, 1, 110));
        insert(new Product ("Semoules et pâtes", "Aldi", 375, 76, 12, 1, 100));

        insert(new Product ("Purée en sachet (poudre seule)", "Delhaize", 365, 81, 8, 1, 130));
        insert(new Product ("Purée en sachet (poudre seule)", "Carrefour", 365, 81, 8, 1, 120));
        insert(new Product ("Purée en sachet (poudre seule)", "Colruyt", 365, 81, 8, 1, 110));
        insert(new Product ("Purée en sachet (poudre seule)", "Aldi", 365, 81, 8, 1, 100));

        insert(new Product ("Purée en sachet (dans 1L lait)", "Delhaize", 86, 13, 4, 2, 230));
        insert(new Product ("Purée en sachet (dans 1L lait)", "Carrefour", 86, 13, 4, 2, 220));
        insert(new Product ("Purée en sachet (dans 1L lait)", "Colruyt", 86, 13, 4, 2, 210));
        insert(new Product ("Purée en sachet (dans 1L lait)", "Aldi", 86, 13, 4, 2, 200));

        insert(new Product ("Flan.alsa avec lait demi-écrémé", "Delhaize", 99, 16, 3, 2, 230));
        insert(new Product ("Flan.alsa avec lait demi-écrémé", "Carrefour", 99, 16, 3, 2, 220));
        insert(new Product ("Flan.alsa avec lait demi-écrémé", "Colruyt", 99, 16, 3, 2, 210));
        insert(new Product ("Flan.alsa avec lait demi-écrémé", "Aldi", 99, 16, 3, 2, 200));

        insert(new Product ("Lait entier", "Delhaize", 68, 4, 3, 3, 330));
        insert(new Product ("Lait entier", "Carrefour", 68, 4, 3, 3, 320));
        insert(new Product ("Lait entier", "Colruyt", 68, 4, 3, 3, 310));
        insert(new Product ("Lait entier", "Aldi", 68, 4, 3, 3, 300));

        insert(new Product ("Lait demi-écrémé", "Delhaize", 45, 4, 3, 1, 130));
        insert(new Product ("Lait demi-écrémé", "Carrefour", 45, 4, 3, 1, 120));
        insert(new Product ("Lait demi-écrémé", "Colruyt", 45, 4, 3, 1, 110));
        insert(new Product ("Lait demi-écrémé", "Aldi", 45, 4, 3, 1, 100));

        insert(new Product ("Lait écrémé", "Delhaize", 36, 5, 3, 1, 130));
        insert(new Product ("Lait écrémé", "Carrefour", 36, 5, 3, 1, 120));
        insert(new Product ("Lait écrémé", "Colruyt", 36, 5, 3, 1, 110));
        insert(new Product ("Lait écrémé", "Aldi", 36, 5, 3, 1, 100));

        insert(new Product ("Crème", "Delhaize", 298, 4, 3, 30, 130));
        insert(new Product ("Crème", "Carrefour", 298, 4, 3, 30, 120));
        insert(new Product ("Crème", "Colruyt", 298, 4, 3, 30, 110));
        insert(new Product ("Crème", "Aldi", 298, 4, 3, 30, 100));

        insert(new Product ("Yoghourt", "Delhaize", 45, 6, 4, 1, 130));
        insert(new Product ("Yoghourt", "Carrefour", 45, 6, 4, 1, 120));
        insert(new Product ("Yoghourt", "Colruyt", 45, 6, 4, 1, 110));
        insert(new Product ("Yoghourt", "Aldi", 45, 6, 4, 1, 100));

        insert(new Product ("Beurre", "Delhaize", 760, 1, 1, 83, 330));
        insert(new Product ("Beurre", "Carrefour", 760, 1, 1, 83, 320));
        insert(new Product ("Beurre", "Colruyt", 760, 1, 1, 83, 310));
        insert(new Product ("Beurre", "Aldi", 760, 1, 1, 83, 300));

        insert(new Product ("Beurre.41%", "Delhaize", 370, 1, 1, 41, 130));
        insert(new Product ("Beurre.41%", "Carrefour", 370, 1, 1, 41, 120));
        insert(new Product ("Beurre.41%", "Colruyt", 370, 1, 1, 41, 110));
        insert(new Product ("Beurre.41%", "Aldi", 370, 1, 1, 41, 100));

        insert(new Product ("Fromage blanc, maigre 0%", "Delhaize", 64, 3, 12, 1, 130));
        insert(new Product ("Fromage blanc, maigre 0%", "Carrefour", 64, 3, 12, 1, 120));
        insert(new Product ("Fromage blanc, maigre 0%", "Colruyt", 64, 3, 12, 1, 110));
        insert(new Product ("Fromage blanc, maigre 0%", "Aldi", 64, 3, 12, 1, 100));

        insert(new Product ("fromage blanc 20%", "Delhaize", 72, 2, 7, 3, 330));
        insert(new Product ("fromage blanc 20%", "Carrefour", 72, 2, 7, 3, 320));
        insert(new Product ("fromage blanc 20%", "Colruyt", 72, 2, 7, 3, 310));
        insert(new Product ("fromage blanc 20%", "Aldi", 72, 2, 7, 3, 300));

        insert(new Product ("Fromage blanc, mi-gros", "Delhaize", 93, 2, 11, 4, 430));
        insert(new Product ("Fromage blanc, mi-gros", "Carrefour", 93, 2, 11, 4, 420));
        insert(new Product ("Fromage blanc, mi-gros", "Colruyt", 93, 2, 11, 4, 410));
        insert(new Product ("Fromage blanc, mi-gros", "Aldi", 93, 2, 11, 4, 400));

        insert(new Product ("Fromage blanc, gras", "Delhaize", 126, 2, 10, 8, 830));
        insert(new Product ("Fromage blanc, gras", "Carrefour", 126, 2, 10, 8, 820));
        insert(new Product ("Fromage blanc, gras", "Colruyt", 126, 2, 10, 8, 810));
        insert(new Product ("Fromage blanc, gras", "Aldi", 126, 2, 10, 8, 800));

        insert(new Product ("Fromage blanc, petit-suisse", "Delhaize", 168, 2, 10, 12, 230));
        insert(new Product ("Fromage blanc, petit-suisse", "Carrefour", 168, 2, 10, 12, 220));
        insert(new Product ("Fromage blanc, petit-suisse", "Colruyt", 168, 2, 10, 12, 210));
        insert(new Product ("Fromage blanc, petit-suisse", "Aldi", 168, 2, 10, 12, 200));

        insert(new Product ("Brie", "Delhaize", 271, 1, 17, 21, 130));
        insert(new Product ("Brie", "Carrefour", 271, 1, 17, 21, 120));
        insert(new Product ("Brie", "Colruyt", 271, 1, 17, 21, 110));
        insert(new Product ("Brie", "Aldi", 271, 1, 17, 21, 100));

        insert(new Product ("Camembert", "Delhaize", 312, 4, 20, 24, 430));
        insert(new Product ("Camembert", "Carrefour", 312, 4, 20, 24, 420));
        insert(new Product ("Camembert", "Colruyt", 312, 4, 20, 24, 410));
        insert(new Product ("Camembert", "Aldi", 312, 4, 20, 24, 400));

        insert(new Product ("Gruyère", "Delhaize", 391, 1, 29, 30, 130));
        insert(new Product ("Gruyère", "Carrefour", 391, 1, 29, 30, 120));
        insert(new Product ("Gruyère", "Colruyt", 391, 1, 29, 30, 110));
        insert(new Product ("Gruyère", "Aldi", 391, 1, 29, 30, 100));

        insert(new Product ("Hollande", "Delhaize", 331, 3, 29, 25, 530));
        insert(new Product ("Hollande", "Carrefour", 331, 3, 29, 25, 520));
        insert(new Product ("Hollande", "Colruyt", 331, 3, 29, 25, 510));
        insert(new Product ("Hollande", "Aldi", 331, 3, 29, 25, 500));

        insert(new Product ("Huiles végétales", "Delhaize", 900, 1, 1, 99, 930));
        insert(new Product ("Huiles végétales", "Carrefour", 900, 1, 1, 99, 920));
        insert(new Product ("Huiles végétales", "Colruyt", 900, 1, 1, 99, 910));
        insert(new Product ("Huiles végétales", "Aldi", 900, 1, 1, 99, 900));

        insert(new Product ("Margarines", "Delhaize", 752, 1, 1, 83, 330));
        insert(new Product ("Margarines", "Carrefour", 752, 1, 1, 83, 320));
        insert(new Product ("Margarines", "Colruyt", 752, 1, 1, 83, 310));
        insert(new Product ("Margarines", "Aldi", 752, 1, 1, 83, 300));

        insert(new Product ("Graisses animales", "Delhaize", 778, 1, 1, 86, 630));
        insert(new Product ("Graisses animales", "Carrefour", 778, 1, 1, 86, 620));
        insert(new Product ("Graisses animales", "Colruyt", 778, 1, 1, 86, 610));
        insert(new Product ("Graisses animales", "Aldi", 778, 1, 1, 86, 600));

        insert(new Product ("Mayonnaise", "Delhaize", 710, 3, 2, 78, 830));
        insert(new Product ("Mayonnaise", "Carrefour", 710, 3, 2, 78, 820));
        insert(new Product ("Mayonnaise", "Colruyt", 710, 3, 2, 78, 810));
        insert(new Product ("Mayonnaise", "Aldi", 710, 3, 2, 78, 800));

        insert(new Product ("Oeuf entier", "Delhaize", 162, 1, 13, 12, 230));
        insert(new Product ("Oeuf entier", "Carrefour", 162, 1, 13, 12, 220));
        insert(new Product ("Oeuf entier", "Colruyt", 162, 1, 13, 12, 210));
        insert(new Product ("Oeuf entier", "Aldi", 162, 1, 13, 12, 200));

        insert(new Product ("Jaune d'oeuf", "Delhaize", 368, 1, 16, 33, 330));
        insert(new Product ("Jaune d'oeuf", "Carrefour", 368, 1, 16, 33, 320));
        insert(new Product ("Jaune d'oeuf", "Colruyt", 368, 1, 16, 33, 310));
        insert(new Product ("Jaune d'oeuf", "Aldi", 368, 1, 16, 33, 300));

        insert(new Product ("Blanc d'oeuf", "Delhaize", 48, 1, 11, 1, 130));
        insert(new Product ("Blanc d'oeuf", "Carrefour", 48, 1, 11, 1, 120));
        insert(new Product ("Blanc d'oeuf", "Colruyt", 48, 1, 11, 1, 110));
        insert(new Product ("Blanc d'oeuf", "Aldi", 48, 1, 11, 1, 100));

        insert(new Product ("Boeufs (mi-gras)", "Delhaize", 250, 1, 17, 20, 130));
        insert(new Product ("Boeufs (mi-gras)", "Carrefour", 250, 1, 17, 20, 120));
        insert(new Product ("Boeufs (mi-gras)", "Colruyt", 250, 1, 17, 20, 110));
        insert(new Product ("Boeufs (mi-gras)", "Aldi", 250, 1, 17, 20, 100));

        insert(new Product ("Cheval", "Delhaize", 110, 1, 21, 2, 230));
        insert(new Product ("Cheval", "Carrefour", 110, 1, 21, 2, 220));
        insert(new Product ("Cheval", "Colruyt", 110, 1, 21, 2, 210));
        insert(new Product ("Cheval", "Aldi", 110, 1, 21, 2, 200));

        insert(new Product ("Mouton", "Delhaize", 250, 1, 17, 19, 930));
        insert(new Product ("Mouton", "Carrefour", 250, 1, 17, 19, 920));
        insert(new Product ("Mouton", "Colruyt", 250, 1, 17, 19, 910));
        insert(new Product ("Mouton", "Aldi", 250, 1, 17, 19, 900));

        insert(new Product ("Veau", "Delhaize", 168, 1, 19, 10, 130));
        insert(new Product ("Veau", "Carrefour", 168, 1, 19, 10, 120));
        insert(new Product ("Veau", "Colruyt", 168, 1, 19, 10, 110));
        insert(new Product ("Veau", "Aldi", 168, 1, 19, 10, 100));

        insert(new Product ("Porc", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Porc", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Porc", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Porc", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Jambon", "Delhaize", 302, 8, 22, 22, 230));
        insert(new Product ("Jambon", "Carrefour", 302, 8, 22, 22, 220));
        insert(new Product ("Jambon", "Colruyt", 302, 8, 22, 22, 210));
        insert(new Product ("Jambon", "Aldi", 302, 8, 22, 22, 200));

        insert(new Product ("Lard", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Lard", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Lard", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Lard", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Cervelle", "Delhaize", 130, 2, 10, 9, 930));
        insert(new Product ("Cervelle", "Carrefour", 130, 2, 10, 9, 920));
        insert(new Product ("Cervelle", "Colruyt", 130, 2, 10, 9, 910));
        insert(new Product ("Cervelle", "Aldi", 130, 2, 10, 9, 900));

        insert(new Product ("Coeur", "Delhaize", 126, 1, 17, 6, 630));
        insert(new Product ("Coeur", "Carrefour", 126, 1, 17, 6, 620));
        insert(new Product ("Coeur", "Colruyt", 126, 1, 17, 6, 610));
        insert(new Product ("Coeur", "Aldi", 126, 1, 17, 6, 600));

        insert(new Product ("Foie", "Delhaize", 116, 1, 20, 4, 430));
        insert(new Product ("Foie", "Carrefour", 116, 1, 20, 4, 420));
        insert(new Product ("Foie", "Colruyt", 116, 1, 20, 4, 410));
        insert(new Product ("Foie", "Aldi", 116, 1, 20, 4, 400));

        insert(new Product ("Langue", "Delhaize", 201, 1, 16, 15, 530));
        insert(new Product ("Langue", "Carrefour", 201, 1, 16, 15, 520));
        insert(new Product ("Langue", "Colruyt", 201, 1, 16, 15, 510));
        insert(new Product ("Langue", "Aldi", 201, 1, 16, 15, 500));

        insert(new Product ("Boudin (grillé)", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Boudin (grillé)", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Boudin (grillé)", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Boudin (grillé)", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Jambon cuit", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Jambon cuit", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Jambon cuit", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Jambon cuit", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Jambon fumé", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Jambon fumé", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Jambon fumé", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Jambon fumé", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Pâté de foie gras", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Pâté de foie gras", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Pâté de foie gras", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Pâté de foie gras", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Salami", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Salami", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Salami", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Salami", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Saucisse", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Saucisse", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Saucisse", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Saucisse", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("Saucisson", "Delhaize", 290, 1, 16, 25, 530));
        insert(new Product ("Saucisson", "Carrefour", 290, 1, 16, 25, 520));
        insert(new Product ("Saucisson", "Colruyt", 290, 1, 16, 25, 510));
        insert(new Product ("Saucisson", "Aldi", 290, 1, 16, 25, 500));

        insert(new Product ("pâté.rillettes", "Delhaize", 510, 1, 15, 50, 130));
        insert(new Product ("pâté.rillettes", "Carrefour", 510, 1, 15, 50, 120));
        insert(new Product ("pâté.rillettes", "Colruyt", 510, 1, 15, 50, 110));
        insert(new Product ("pâté.rillettes", "Aldi", 510, 1, 15, 50, 100));

        insert(new Product ("Cassoulet préparé complet", "Delhaize", 146, 9, 10, 8, 830));
        insert(new Product ("Cassoulet préparé complet", "Carrefour", 146, 9, 10, 8, 820));
        insert(new Product ("Cassoulet préparé complet", "Colruyt", 146, 9, 10, 8, 810));
        insert(new Product ("Cassoulet préparé complet", "Aldi", 146, 9, 10, 8, 800));

        insert(new Product ("Choucroute garnie", "Delhaize", 113, 3, 9, 3, 330));
        insert(new Product ("Choucroute garnie", "Carrefour", 113, 3, 9, 3, 320));
        insert(new Product ("Choucroute garnie", "Colruyt", 113, 3, 9, 3, 310));
        insert(new Product ("Choucroute garnie", "Aldi", 113, 3, 9, 3, 300));

        insert(new Product ("poule", "Delhaize", 302, 1, 18, 25, 530));
        insert(new Product ("poule", "Carrefour", 302, 1, 18, 25, 520));
        insert(new Product ("poule", "Colruyt", 302, 1, 18, 25, 510));
        insert(new Product ("poule", "Aldi", 302, 1, 18, 25, 500));

        insert(new Product ("poulet", "Delhaize", 150, 1, 21, 8, 830));
        insert(new Product ("poulet", "Carrefour", 150, 1, 21, 8, 820));
        insert(new Product ("poulet", "Colruyt", 150, 1, 21, 8, 810));
        insert(new Product ("poulet", "Aldi", 150, 1, 21, 8, 800));

        insert(new Product ("Oie", "Delhaize", 200, 1, 22, 14, 430));
        insert(new Product ("Oie", "Carrefour", 200, 1, 22, 14, 420));
        insert(new Product ("Oie", "Colruyt", 200, 1, 22, 14, 410));
        insert(new Product ("Oie", "Aldi", 200, 1, 22, 14, 400));

        insert(new Product ("Autruche", "Delhaize", 140, 1, 26, 2, 230));
        insert(new Product ("Autruche", "Carrefour", 140, 1, 26, 2, 220));
        insert(new Product ("Autruche", "Colruyt", 140, 1, 26, 2, 210));
        insert(new Product ("Autruche", "Aldi", 140, 1, 26, 2, 200));

        insert(new Product ("Dinde", "Delhaize", 170, 1, 29, 5, 530));
        insert(new Product ("Dinde", "Carrefour", 170, 1, 29, 5, 520));
        insert(new Product ("Dinde", "Colruyt", 170, 1, 29, 5, 510));
        insert(new Product ("Dinde", "Aldi", 170, 1, 29, 5, 500));

        insert(new Product ("Gibiers à poils", "Delhaize", 100, 1, 20, 3, 330));
        insert(new Product ("Gibiers à poils", "Carrefour", 100, 1, 20, 3, 320));
        insert(new Product ("Gibiers à poils", "Colruyt", 100, 1, 20, 3, 310));
        insert(new Product ("Gibiers à poils", "Aldi", 100, 1, 20, 3, 300));

        insert(new Product ("Gibiers à plumes", "Delhaize", 108, 1, 22, 3, 330));
        insert(new Product ("Gibiers à plumes", "Carrefour", 108, 1, 22, 3, 320));
        insert(new Product ("Gibiers à plumes", "Colruyt", 108, 1, 22, 3, 310));
        insert(new Product ("Gibiers à plumes", "Aldi", 108, 1, 22, 3, 300));

        insert(new Product ("Ail", "Delhaize", 139, 28, 6, 1, 130));
        insert(new Product ("Ail", "Carrefour", 139, 28, 6, 1, 120));
        insert(new Product ("Ail", "Colruyt", 139, 28, 6, 1, 110));
        insert(new Product ("Ail", "Aldi", 139, 28, 6, 1, 100));

        insert(new Product ("Asperges", "Delhaize", 26, 3, 2, 1, 130));
        insert(new Product ("Asperges", "Carrefour", 26, 3, 2, 1, 120));
        insert(new Product ("Asperges", "Colruyt", 26, 3, 2, 1, 110));
        insert(new Product ("Asperges", "Aldi", 26, 3, 2, 1, 100));

        insert(new Product ("Betteraves (rouges)", "Delhaize", 40, 8, 1, 1, 130));
        insert(new Product ("Betteraves (rouges)", "Carrefour", 40, 8, 1, 1, 120));
        insert(new Product ("Betteraves (rouges)", "Colruyt", 40, 8, 1, 1, 110));
        insert(new Product ("Betteraves (rouges)", "Aldi", 40, 8, 1, 1, 100));

        insert(new Product ("Carottes (cuites)", "Delhaize", 32, 6, 1, 1, 130));
        insert(new Product ("Carottes (cuites)", "Carrefour", 32, 6, 1, 1, 120));
        insert(new Product ("Carottes (cuites)", "Colruyt", 32, 6, 1, 1, 110));
        insert(new Product ("Carottes (cuites)", "Aldi", 32, 6, 1, 1, 100));

        insert(new Product ("Céleris", "Delhaize", 20, 3, 1, 1, 130));
        insert(new Product ("Céleris", "Carrefour", 20, 3, 1, 1, 120));
        insert(new Product ("Céleris", "Colruyt", 20, 3, 1, 1, 110));
        insert(new Product ("Céleris", "Aldi", 20, 3, 1, 1, 100));

        insert(new Product ("Céleris raves", "Delhaize", 44, 8, 2, 1, 130));
        insert(new Product ("Céleris raves", "Carrefour", 44, 8, 2, 1, 120));
        insert(new Product ("Céleris raves", "Colruyt", 44, 8, 2, 1, 110));
        insert(new Product ("Céleris raves", "Aldi", 44, 8, 2, 1, 100));

        insert(new Product ("Cerfeuil", "Delhaize", 65, 11, 3, 1, 130));
        insert(new Product ("Cerfeuil", "Carrefour", 65, 11, 3, 1, 120));
        insert(new Product ("Cerfeuil", "Colruyt", 65, 11, 3, 1, 110));
        insert(new Product ("Cerfeuil", "Aldi", 65, 11, 3, 1, 100));

        insert(new Product ("Champignons", "Delhaize", 28, 4, 2, 1, 130));
        insert(new Product ("Champignons", "Carrefour", 28, 4, 2, 1, 120));
        insert(new Product ("Champignons", "Colruyt", 28, 4, 2, 1, 110));
        insert(new Product ("Champignons", "Aldi", 28, 4, 2, 1, 100));

        insert(new Product ("Chicorée", "Delhaize", 20, 3, 1, 1, 130));
        insert(new Product ("Chicorée", "Carrefour", 20, 3, 1, 1, 120));
        insert(new Product ("Chicorée", "Colruyt", 20, 3, 1, 1, 110));
        insert(new Product ("Chicorée", "Aldi", 20, 3, 1, 1, 100));

        insert(new Product ("Choucroute", "Delhaize", 27, 5, 1, 1, 130));
        insert(new Product ("Choucroute", "Carrefour", 27, 5, 1, 1, 120));
        insert(new Product ("Choucroute", "Colruyt", 27, 5, 1, 1, 110));
        insert(new Product ("Choucroute", "Aldi", 27, 5, 1, 1, 100));

        insert(new Product ("Choux de Bruxelles", "Delhaize", 54, 8, 4, 1, 130));
        insert(new Product ("Choux de Bruxelles", "Carrefour", 54, 8, 4, 1, 120));
        insert(new Product ("Choux de Bruxelles", "Colruyt", 54, 8, 4, 1, 110));
        insert(new Product ("Choux de Bruxelles", "Aldi", 54, 8, 4, 1, 100));

        insert(new Product ("Chou-fleur", "Delhaize", 30, 4, 2, 1, 130));
        insert(new Product ("Chou-fleur", "Carrefour", 30, 4, 2, 1, 120));
        insert(new Product ("Chou-fleur", "Colruyt", 30, 4, 2, 1, 110));
        insert(new Product ("Chou-fleur", "Aldi", 30, 4, 2, 1, 100));

        insert(new Product ("Chou rouge", "Delhaize", 38, 7, 1, 1, 130));
        insert(new Product ("Chou rouge", "Carrefour", 38, 7, 1, 1, 120));
        insert(new Product ("Chou rouge", "Colruyt", 38, 7, 1, 1, 110));
        insert(new Product ("Chou rouge", "Aldi", 38, 7, 1, 1, 100));

        insert(new Product ("Ciboulette", "Delhaize", 39, 8, 1, 1, 130));
        insert(new Product ("Ciboulette", "Carrefour", 39, 8, 1, 1, 120));
        insert(new Product ("Ciboulette", "Colruyt", 39, 8, 1, 1, 110));
        insert(new Product ("Ciboulette", "Aldi", 39, 8, 1, 1, 100));

        insert(new Product ("Concombre", "Delhaize", 12, 2, 1, 1, 130));
        insert(new Product ("Concombre", "Carrefour", 12, 2, 1, 1, 120));
        insert(new Product ("Concombre", "Colruyt", 12, 2, 1, 1, 110));
        insert(new Product ("Concombre", "Aldi", 12, 2, 1, 1, 100));

        insert(new Product ("Cornichons", "Delhaize", 12, 2, 1, 1, 130));
        insert(new Product ("Cornichons", "Carrefour", 12, 2, 1, 1, 120));
        insert(new Product ("Cornichons", "Colruyt", 12, 2, 1, 1, 110));
        insert(new Product ("Cornichons", "Aldi", 12, 2, 1, 1, 100));

        insert(new Product ("Cresson", "Delhaize", 21, 3, 1, 1, 130));
        insert(new Product ("Cresson", "Carrefour", 21, 3, 1, 1, 120));
        insert(new Product ("Cresson", "Colruyt", 21, 3, 1, 1, 110));
        insert(new Product ("Cresson", "Aldi", 21, 3, 1, 1, 100));

        insert(new Product ("Echalotes", "Delhaize", 75, 17, 1, 1, 130));
        insert(new Product ("Echalotes", "Carrefour", 75, 17, 1, 1, 120));
        insert(new Product ("Echalotes", "Colruyt", 75, 17, 1, 1, 110));
        insert(new Product ("Echalotes", "Aldi", 75, 17, 1, 1, 100));

        insert(new Product ("Endives", "Delhaize", 22, 4, 1, 1, 130));
        insert(new Product ("Endives", "Carrefour", 22, 4, 1, 1, 120));
        insert(new Product ("Endives", "Colruyt", 22, 4, 1, 1, 110));
        insert(new Product ("Endives", "Aldi", 22, 4, 1, 1, 100));

        insert(new Product ("Epinards", "Delhaize", 32, 3, 3, 1, 130));
        insert(new Product ("Epinards", "Carrefour", 32, 3, 3, 1, 120));
        insert(new Product ("Epinards", "Colruyt", 32, 3, 3, 1, 110));
        insert(new Product ("Epinards", "Aldi", 32, 3, 3, 1, 100));

        insert(new Product ("Haricots verts", "Delhaize", 23, 4, 1, 1, 130));
        insert(new Product ("Haricots verts", "Carrefour", 23, 4, 1, 1, 120));
        insert(new Product ("Haricots verts", "Colruyt", 23, 4, 1, 1, 110));
        insert(new Product ("Haricots verts", "Aldi", 23, 4, 1, 1, 100));

        insert(new Product ("Laitue", "Delhaize", 18, 2, 1, 1, 130));
        insert(new Product ("Laitue", "Carrefour", 18, 2, 1, 1, 120));
        insert(new Product ("Laitue", "Colruyt", 18, 2, 1, 1, 110));
        insert(new Product ("Laitue", "Aldi", 18, 2, 1, 1, 100));

        insert(new Product ("Navets", "Delhaize", 29, 6, 1, 1, 130));
        insert(new Product ("Navets", "Carrefour", 29, 6, 1, 1, 120));
        insert(new Product ("Navets", "Colruyt", 29, 6, 1, 1, 110));
        insert(new Product ("Navets", "Aldi", 29, 6, 1, 1, 100));

        insert(new Product ("Oignons", "Delhaize", 40, 8, 1, 1, 130));
        insert(new Product ("Oignons", "Carrefour", 40, 8, 1, 1, 120));
        insert(new Product ("Oignons", "Colruyt", 40, 8, 1, 1, 110));
        insert(new Product ("Oignons", "Aldi", 40, 8, 1, 1, 100));

        insert(new Product ("Persil", "Delhaize", 55, 8, 3, 1, 130));
        insert(new Product ("Persil", "Carrefour", 55, 8, 3, 1, 120));
        insert(new Product ("Persil", "Colruyt", 55, 8, 3, 1, 110));
        insert(new Product ("Persil", "Aldi", 55, 8, 3, 1, 100));

        insert(new Product ("Poireaux", "Delhaize", 42, 7, 2, 1, 130));
        insert(new Product ("Poireaux", "Carrefour", 42, 7, 2, 1, 120));
        insert(new Product ("Poireaux", "Colruyt", 42, 7, 2, 1, 110));
        insert(new Product ("Poireaux", "Aldi", 42, 7, 2, 1, 100));

        insert(new Product ("Pois", "Delhaize", 70, 12, 4, 1, 130));
        insert(new Product ("Pois", "Carrefour", 70, 12, 4, 1, 120));
        insert(new Product ("Pois", "Colruyt", 70, 12, 4, 1, 110));
        insert(new Product ("Pois", "Aldi", 70, 12, 4, 1, 100));

        insert(new Product ("Poivrons", "Delhaize", 22, 3, 1, 1, 130));
        insert(new Product ("Poivrons", "Carrefour", 22, 3, 1, 1, 120));
        insert(new Product ("Poivrons", "Colruyt", 22, 3, 1, 1, 110));
        insert(new Product ("Poivrons", "Aldi", 22, 3, 1, 1, 100));

        insert(new Product ("Pommes de terre", "Delhaize", 86, 19, 2, 1, 130));
        insert(new Product ("Pommes de terre", "Carrefour", 86, 19, 2, 1, 120));
        insert(new Product ("Pommes de terre", "Colruyt", 86, 19, 2, 1, 110));
        insert(new Product ("Pommes de terre", "Aldi", 86, 19, 2, 1, 100));

        insert(new Product ("Radis", "Delhaize", 20, 4, 1, 1, 130));
        insert(new Product ("Radis", "Carrefour", 20, 4, 1, 1, 120));
        insert(new Product ("Radis", "Colruyt", 20, 4, 1, 1, 110));
        insert(new Product ("Radis", "Aldi", 20, 4, 1, 1, 100));

        insert(new Product ("Salsifis", "Delhaize", 77, 12, 4, 1, 130));
        insert(new Product ("Salsifis", "Carrefour", 77, 12, 4, 1, 120));
        insert(new Product ("Salsifis", "Colruyt", 77, 12, 4, 1, 110));
        insert(new Product ("Salsifis", "Aldi", 77, 12, 4, 1, 100));

        insert(new Product ("Scaroles", "Delhaize", 37, 4, 1, 1, 130));
        insert(new Product ("Scaroles", "Carrefour", 37, 4, 1, 1, 120));
        insert(new Product ("Scaroles", "Colruyt", 37, 4, 1, 1, 110));
        insert(new Product ("Scaroles", "Aldi", 37, 4, 1, 1, 100));

        insert(new Product ("Tomates", "Delhaize", 20, 3, 1, 1, 130));
        insert(new Product ("Tomates", "Carrefour", 20, 3, 1, 1, 120));
        insert(new Product ("Tomates", "Colruyt", 20, 3, 1, 1, 110));
        insert(new Product ("Tomates", "Aldi", 20, 3, 1, 1, 100));

        insert(new Product ("Haricots blancs secs", "Delhaize", 330, 60, 19, 1, 130));
        insert(new Product ("Haricots blancs secs", "Carrefour", 330, 60, 19, 1, 120));
        insert(new Product ("Haricots blancs secs", "Colruyt", 330, 60, 19, 1, 110));
        insert(new Product ("Haricots blancs secs", "Aldi", 330, 60, 19, 1, 100));

        insert(new Product ("Lentilles", "Delhaize", 330, 56, 22, 1, 130));
        insert(new Product ("Lentilles", "Carrefour", 330, 56, 22, 1, 120));
        insert(new Product ("Lentilles", "Colruyt", 330, 56, 22, 1, 110));
        insert(new Product ("Lentilles", "Aldi", 330, 56, 22, 1, 100));

        insert(new Product ("Pois secs", "Delhaize", 330, 56, 23, 1, 130));
        insert(new Product ("Pois secs", "Carrefour", 330, 56, 23, 1, 120));
        insert(new Product ("Pois secs", "Colruyt", 330, 56, 23, 1, 110));
        insert(new Product ("Pois secs", "Aldi", 330, 56, 23, 1, 100));

        insert(new Product ("Pois chiches", "Delhaize", 361, 61, 18, 5, 530));
        insert(new Product ("Pois chiches", "Carrefour", 361, 61, 18, 5, 520));
        insert(new Product ("Pois chiches", "Colruyt", 361, 61, 18, 5, 510));
        insert(new Product ("Pois chiches", "Aldi", 361, 61, 18, 5, 500));

        insert(new Product ("Poids.cassés", "Delhaize", 342, 60, 22, 1, 130));
        insert(new Product ("Poids.cassés", "Carrefour", 342, 60, 22, 1, 120));
        insert(new Product ("Poids.cassés", "Colruyt", 342, 60, 22, 1, 110));
        insert(new Product ("Poids.cassés", "Aldi", 342, 60, 22, 1, 100));

        insert(new Product ("Maïs", "Delhaize", 360, 70, 10, 5, 530));
        insert(new Product ("Maïs", "Carrefour", 360, 70, 10, 5, 520));
        insert(new Product ("Maïs", "Colruyt", 360, 70, 10, 5, 510));
        insert(new Product ("Maïs", "Aldi", 360, 70, 10, 5, 500));

        insert(new Product ("Riz", "Delhaize", 349, 78, 7, 1, 130));
        insert(new Product ("Riz", "Carrefour", 349, 78, 7, 1, 120));
        insert(new Product ("Riz", "Colruyt", 349, 78, 7, 1, 110));
        insert(new Product ("Riz", "Aldi", 349, 78, 7, 1, 100));

        insert(new Product ("Frittes chips", "Delhaize", 544, 50, 7, 37, 730));
        insert(new Product ("Frittes chips", "Carrefour", 544, 50, 7, 37, 720));
        insert(new Product ("Frittes chips", "Colruyt", 544, 50, 7, 37, 710));
        insert(new Product ("Frittes chips", "Aldi", 544, 50, 7, 37, 700));

        insert(new Product ("Abricots", "Delhaize", 44, 10, 1, 1, 130));
        insert(new Product ("Abricots", "Carrefour", 44, 10, 1, 1, 120));
        insert(new Product ("Abricots", "Colruyt", 44, 10, 1, 1, 110));
        insert(new Product ("Abricots", "Aldi", 44, 10, 1, 1, 100));

        insert(new Product ("Airelles", "Delhaize", 25, 5, 1, 1, 130));
        insert(new Product ("Airelles", "Carrefour", 25, 5, 1, 1, 120));
        insert(new Product ("Airelles", "Colruyt", 25, 5, 1, 1, 110));
        insert(new Product ("Airelles", "Aldi", 25, 5, 1, 1, 100));

        insert(new Product ("Ananas", "Delhaize", 51, 12, 1, 1, 130));
        insert(new Product ("Ananas", "Carrefour", 51, 12, 1, 1, 120));
        insert(new Product ("Ananas", "Colruyt", 51, 12, 1, 1, 110));
        insert(new Product ("Ananas", "Aldi", 51, 12, 1, 1, 100));

        insert(new Product ("Bananes", "Delhaize", 90, 20, 1, 1, 130));
        insert(new Product ("Bananes", "Carrefour", 90, 20, 1, 1, 120));
        insert(new Product ("Bananes", "Colruyt", 90, 20, 1, 1, 110));
        insert(new Product ("Bananes", "Aldi", 90, 20, 1, 1, 100));

        insert(new Product ("Cerises", "Delhaize", 77, 17, 1, 1, 130));
        insert(new Product ("Cerises", "Carrefour", 77, 17, 1, 1, 120));
        insert(new Product ("Cerises", "Colruyt", 77, 17, 1, 1, 110));
        insert(new Product ("Cerises", "Aldi", 77, 17, 1, 1, 100));

        insert(new Product ("Citrons", "Delhaize", 43, 2, 1, 1, 130));
        insert(new Product ("Citrons", "Carrefour", 43, 2, 1, 1, 120));
        insert(new Product ("Citrons", "Colruyt", 43, 2, 1, 1, 110));
        insert(new Product ("Citrons", "Aldi", 43, 2, 1, 1, 100));

        insert(new Product ("Figues fraîches", "Delhaize", 80, 18, 1, 1, 130));
        insert(new Product ("Figues fraîches", "Carrefour", 80, 18, 1, 1, 120));
        insert(new Product ("Figues fraîches", "Colruyt", 80, 18, 1, 1, 110));
        insert(new Product ("Figues fraîches", "Aldi", 80, 18, 1, 1, 100));

        insert(new Product ("Fraises", "Delhaize", 40, 7, 1, 1, 130));
        insert(new Product ("Fraises", "Carrefour", 40, 7, 1, 1, 120));
        insert(new Product ("Fraises", "Colruyt", 40, 7, 1, 1, 110));
        insert(new Product ("Fraises", "Aldi", 40, 7, 1, 1, 100));

        insert(new Product ("Framboises", "Delhaize", 40, 8, 1, 1, 130));
        insert(new Product ("Framboises", "Carrefour", 40, 8, 1, 1, 120));
        insert(new Product ("Framboises", "Colruyt", 40, 8, 1, 1, 110));
        insert(new Product ("Framboises", "Aldi", 40, 8, 1, 1, 100));

        insert(new Product ("Groseilles", "Delhaize", 30, 5, 1, 1, 130));
        insert(new Product ("Groseilles", "Carrefour", 30, 5, 1, 1, 120));
        insert(new Product ("Groseilles", "Colruyt", 30, 5, 1, 1, 110));
        insert(new Product ("Groseilles", "Aldi", 30, 5, 1, 1, 100));

        insert(new Product ("Mandarines", "Delhaize", 40, 9, 1, 1, 130));
        insert(new Product ("Mandarines", "Carrefour", 40, 9, 1, 1, 120));
        insert(new Product ("Mandarines", "Colruyt", 40, 9, 1, 1, 110));
        insert(new Product ("Mandarines", "Aldi", 40, 9, 1, 1, 100));

        insert(new Product ("Melons", "Delhaize", 31, 6, 1, 1, 130));
        insert(new Product ("Melons", "Carrefour", 31, 6, 1, 1, 120));
        insert(new Product ("Melons", "Colruyt", 31, 6, 1, 1, 110));
        insert(new Product ("Melons", "Aldi", 31, 6, 1, 1, 100));

        insert(new Product ("Oranges", "Delhaize", 44, 9, 1, 1, 130));
        insert(new Product ("Oranges", "Carrefour", 44, 9, 1, 1, 120));
        insert(new Product ("Oranges", "Colruyt", 44, 9, 1, 1, 110));
        insert(new Product ("Oranges", "Aldi", 44, 9, 1, 1, 100));

        insert(new Product ("Pamplemousses", "Delhaize", 43, 9, 1, 1, 130));
        insert(new Product ("Pamplemousses", "Carrefour", 43, 9, 1, 1, 120));
        insert(new Product ("Pamplemousses", "Colruyt", 43, 9, 1, 1, 110));
        insert(new Product ("Pamplemousses", "Aldi", 43, 9, 1, 1, 100));

        insert(new Product ("Pêches", "Delhaize", 52, 12, 1, 1, 130));
        insert(new Product ("Pêches", "Carrefour", 52, 12, 1, 1, 120));
        insert(new Product ("Pêches", "Colruyt", 52, 12, 1, 1, 110));
        insert(new Product ("Pêches", "Aldi", 52, 12, 1, 1, 100));

        insert(new Product ("Poires", "Delhaize", 61, 14, 1, 1, 130));
        insert(new Product ("Poires", "Carrefour", 61, 14, 1, 1, 120));
        insert(new Product ("Poires", "Colruyt", 61, 14, 1, 1, 110));
        insert(new Product ("Poires", "Aldi", 61, 14, 1, 1, 100));

        insert(new Product ("Pommes", "Delhaize", 52, 12, 1, 1, 130));
        insert(new Product ("Pommes", "Carrefour", 52, 12, 1, 1, 120));
        insert(new Product ("Pommes", "Colruyt", 52, 12, 1, 1, 110));
        insert(new Product ("Pommes", "Aldi", 52, 12, 1, 1, 100));

        insert(new Product ("Prunes", "Delhaize", 64, 10, 1, 1, 130));
        insert(new Product ("Prunes", "Carrefour", 64, 10, 1, 1, 120));
        insert(new Product ("Prunes", "Colruyt", 64, 10, 1, 1, 110));
        insert(new Product ("Prunes", "Aldi", 64, 10, 1, 1, 100));

        insert(new Product ("Raisins", "Delhaize", 81, 17, 1, 1, 130));
        insert(new Product ("Raisins", "Carrefour", 81, 17, 1, 1, 120));
        insert(new Product ("Raisins", "Colruyt", 81, 17, 1, 1, 110));
        insert(new Product ("Raisins", "Aldi", 81, 17, 1, 1, 100));

        insert(new Product ("Rhubarbes", "Delhaize", 16, 3, 1, 1, 130));
        insert(new Product ("Rhubarbes", "Carrefour", 16, 3, 1, 1, 120));
        insert(new Product ("Rhubarbes", "Colruyt", 16, 3, 1, 1, 110));
        insert(new Product ("Rhubarbes", "Aldi", 16, 3, 1, 1, 100));

        insert(new Product ("Amandes", "Delhaize", 620, 17, 20, 54, 430));
        insert(new Product ("Amandes", "Carrefour", 620, 17, 20, 54, 420));
        insert(new Product ("Amandes", "Colruyt", 620, 17, 20, 54, 410));
        insert(new Product ("Amandes", "Aldi", 620, 17, 20, 54, 400));

        insert(new Product ("Arachides", "Delhaize", 560, 26, 23, 40, 130));
        insert(new Product ("Arachides", "Carrefour", 560, 26, 23, 40, 120));
        insert(new Product ("Arachides", "Colruyt", 560, 26, 23, 40, 110));
        insert(new Product ("Arachides", "Aldi", 560, 26, 23, 40, 100));

        insert(new Product ("Châtaignes", "Delhaize", 199, 40, 4, 2, 230));
        insert(new Product ("Châtaignes", "Carrefour", 199, 40, 4, 2, 220));
        insert(new Product ("Châtaignes", "Colruyt", 199, 40, 4, 2, 210));
        insert(new Product ("Châtaignes", "Aldi", 199, 40, 4, 2, 200));

        insert(new Product ("Châtaignes sèches", "Delhaize", 371, 73, 7, 5, 530));
        insert(new Product ("Châtaignes sèches", "Carrefour", 371, 73, 7, 5, 520));
        insert(new Product ("Châtaignes sèches", "Colruyt", 371, 73, 7, 5, 510));
        insert(new Product ("Châtaignes sèches", "Aldi", 371, 73, 7, 5, 500));

        insert(new Product ("Dattes", "Delhaize", 306, 73, 2, 1, 130));
        insert(new Product ("Dattes", "Carrefour", 306, 73, 2, 1, 120));
        insert(new Product ("Dattes", "Colruyt", 306, 73, 2, 1, 110));
        insert(new Product ("Dattes", "Aldi", 306, 73, 2, 1, 100));

        insert(new Product ("Figues sèches", "Delhaize", 275, 62, 4, 1, 130));
        insert(new Product ("Figues sèches", "Carrefour", 275, 62, 4, 1, 120));
        insert(new Product ("Figues sèches", "Colruyt", 275, 62, 4, 1, 110));
        insert(new Product ("Figues sèches", "Aldi", 275, 62, 4, 1, 100));

        insert(new Product ("Noisettes", "Delhaize", 656, 15, 14, 60, 130));
        insert(new Product ("Noisettes", "Carrefour", 656, 15, 14, 60, 120));
        insert(new Product ("Noisettes", "Colruyt", 656, 15, 14, 60, 110));
        insert(new Product ("Noisettes", "Aldi", 656, 15, 14, 60, 100));

        insert(new Product ("Noix", "Delhaize", 660, 15, 15, 60, 130));
        insert(new Product ("Noix", "Carrefour", 660, 15, 15, 60, 120));
        insert(new Product ("Noix", "Colruyt", 660, 15, 15, 60, 110));
        insert(new Product ("Noix", "Aldi", 660, 15, 15, 60, 100));

        insert(new Product ("Pruneaux", "Delhaize", 290, 70, 2, 1, 130));
        insert(new Product ("Pruneaux", "Carrefour", 290, 70, 2, 1, 120));
        insert(new Product ("Pruneaux", "Colruyt", 290, 70, 2, 1, 110));
        insert(new Product ("Pruneaux", "Aldi", 290, 70, 2, 1, 100));

        insert(new Product ("Bonbons divers", "Delhaize", 378, 94, 1, 1, 130));
        insert(new Product ("Bonbons divers", "Carrefour", 378, 94, 1, 1, 120));
        insert(new Product ("Bonbons divers", "Colruyt", 378, 94, 1, 1, 110));
        insert(new Product ("Bonbons divers", "Aldi", 378, 94, 1, 1, 100));

        insert(new Product ("Cacao.super.instantané", "Delhaize", 386, 87, 3, 2, 230));
        insert(new Product ("Cacao.super.instantané", "Carrefour", 386, 87, 3, 2, 220));
        insert(new Product ("Cacao.super.instantané", "Colruyt", 386, 87, 3, 2, 210));
        insert(new Product ("Cacao.super.instantané", "Aldi", 386, 87, 3, 2, 200));

        insert(new Product ("Chocolats", "Delhaize", 530, 63, 2, 30, 130));
        insert(new Product ("Chocolats", "Carrefour", 530, 63, 2, 30, 120));
        insert(new Product ("Chocolats", "Colruyt", 530, 63, 2, 30, 110));
        insert(new Product ("Chocolats", "Aldi", 530, 63, 2, 30, 100));

        insert(new Product ("Confitures", "Delhaize", 280, 70, 1, 1, 130));
        insert(new Product ("Confitures", "Carrefour", 280, 70, 1, 1, 120));
        insert(new Product ("Confitures", "Colruyt", 280, 70, 1, 1, 110));
        insert(new Product ("Confitures", "Aldi", 280, 70, 1, 1, 100));

        insert(new Product ("Miel", "Delhaize", 300, 75, 1, 1, 130));
        insert(new Product ("Miel", "Carrefour", 300, 75, 1, 1, 120));
        insert(new Product ("Miel", "Colruyt", 300, 75, 1, 1, 110));
        insert(new Product ("Miel", "Aldi", 300, 75, 1, 1, 100));

        insert(new Product ("Pâtisseries", "Delhaize", 475, 80, 5, 15, 530));
        insert(new Product ("Pâtisseries", "Carrefour", 475, 80, 5, 15, 520));
        insert(new Product ("Pâtisseries", "Colruyt", 475, 80, 5, 15, 510));
        insert(new Product ("Pâtisseries", "Aldi", 475, 80, 5, 15, 500));

        insert(new Product ("Sucre", "Delhaize", 400, 99, 1, 1, 130));
        insert(new Product ("Sucre", "Carrefour", 400, 99, 1, 1, 120));
        insert(new Product ("Sucre", "Colruyt", 400, 99, 1, 1, 110));
        insert(new Product ("Sucre", "Aldi", 400, 99, 1, 1, 100));

        insert(new Product ("Compote de pommes", "Delhaize", 99, 24, 1, 1, 130));
        insert(new Product ("Compote de pommes", "Carrefour", 99, 24, 1, 1, 120));
        insert(new Product ("Compote de pommes", "Colruyt", 99, 24, 1, 1, 110));
        insert(new Product ("Compote de pommes", "Aldi", 99, 24, 1, 1, 100));

        insert(new Product ("Crème de marrons", "Delhaize", 240, 60, 1, 1, 130));
        insert(new Product ("Crème de marrons", "Carrefour", 240, 60, 1, 1, 120));
        insert(new Product ("Crème de marrons", "Colruyt", 240, 60, 1, 1, 110));
        insert(new Product ("Crème de marrons", "Aldi", 240, 60, 1, 1, 100));

        insert(new Product ("Sauce.bechamel *58/100", "Delhaize", 570, 41, 5, 43, 330));
        insert(new Product ("Sauce.bechamel *58/100", "Carrefour", 570, 41, 5, 43, 320));
        insert(new Product ("Sauce.bechamel *58/100", "Colruyt", 570, 41, 5, 43, 310));
        insert(new Product ("Sauce.bechamel *58/100", "Aldi", 570, 41, 5, 43, 300));

        insert(new Product ("Bière", "Delhaize", 35, 4, 1, 1, 130));
        insert(new Product ("Bière", "Carrefour", 35, 4, 1, 1, 120));
        insert(new Product ("Bière", "Colruyt", 35, 4, 1, 1, 110));
        insert(new Product ("Bière", "Aldi", 35, 4, 1, 1, 100));

        insert(new Product ("Cidre", "Delhaize", 40, 5, 1, 1, 130));
        insert(new Product ("Cidre", "Carrefour", 40, 5, 1, 1, 120));
        insert(new Product ("Cidre", "Colruyt", 40, 5, 1, 1, 110));
        insert(new Product ("Cidre", "Aldi", 40, 5, 1, 1, 100));

        insert(new Product ("Eaux de vie", "Delhaize", 280, 1, 1, 1, 130));
        insert(new Product ("Eaux de vie", "Carrefour", 280, 1, 1, 1, 120));
        insert(new Product ("Eaux de vie", "Colruyt", 280, 1, 1, 1, 110));
        insert(new Product ("Eaux de vie", "Aldi", 280, 1, 1, 1, 100));

        insert(new Product ("Limonade", "Delhaize", 48, 12, 1, 1, 130));
        insert(new Product ("Limonade", "Carrefour", 48, 12, 1, 1, 120));
        insert(new Product ("Limonade", "Colruyt", 48, 12, 1, 1, 110));
        insert(new Product ("Limonade", "Aldi", 48, 12, 1, 1, 100));

        insert(new Product ("Vin (blanc 10 doux)", "Delhaize", 80, 8, 1, 1, 130));
        insert(new Product ("Vin (blanc 10 doux)", "Carrefour", 80, 8, 1, 1, 120));
        insert(new Product ("Vin (blanc 10 doux)", "Colruyt", 80, 8, 1, 1, 110));
        insert(new Product ("Vin (blanc 10 doux)", "Aldi", 80, 8, 1, 1, 100));

        insert(new Product ("Vin (rouge 10)", "Delhaize", 65, 1, 1, 1, 130));
        insert(new Product ("Vin (rouge 10)", "Carrefour", 65, 1, 1, 1, 120));
        insert(new Product ("Vin (rouge 10)", "Colruyt", 65, 1, 1, 1, 110));
        insert(new Product ("Vin (rouge 10)", "Aldi", 65, 1, 1, 1, 100));

        insert(new Product ("Coca-Cola", "Delhaize", 1, 1, 1, 1, 130));
        insert(new Product ("Coca-Cola", "Carrefour", 1, 1, 1, 1, 120));
        insert(new Product ("Coca-Cola", "Colruyt", 1, 1, 1, 1, 110));
        insert(new Product ("Coca-Cola", "Aldi", 1, 1, 1, 1, 100));

        insert(new Product ("Jus d'oranges", "Delhaize", 50, 12, 1, 1, 130));
        insert(new Product ("Jus d'oranges", "Carrefour", 50, 12, 1, 1, 120));
        insert(new Product ("Jus d'oranges", "Colruyt", 50, 12, 1, 1, 110));
        insert(new Product ("Jus d'oranges", "Aldi", 50, 12, 1, 1, 100));

        insert(new Product ("Crabe crevette", "Delhaize", 70, 1, 15, 1, 130));
        insert(new Product ("Crabe crevette", "Carrefour", 70, 1, 15, 1, 120));
        insert(new Product ("Crabe crevette", "Colruyt", 70, 1, 15, 1, 110));
        insert(new Product ("Crabe crevette", "Aldi", 70, 1, 15, 1, 100));

        insert(new Product ("Langouste homard", "Delhaize", 70, 1, 15, 1, 130));
        insert(new Product ("Langouste homard", "Carrefour", 70, 1, 15, 1, 120));
        insert(new Product ("Langouste homard", "Colruyt", 70, 1, 15, 1, 110));
        insert(new Product ("Langouste homard", "Aldi", 70, 1, 15, 1, 100));

        insert(new Product ("Anchois", "Delhaize", 160, 1, 20, 8, 830));
        insert(new Product ("Anchois", "Carrefour", 160, 1, 20, 8, 820));
        insert(new Product ("Anchois", "Colruyt", 160, 1, 20, 8, 810));
        insert(new Product ("Anchois", "Aldi", 160, 1, 20, 8, 800));

        insert(new Product ("Anguille", "Delhaize", 200, 1, 14, 8, 830));
        insert(new Product ("Anguille", "Carrefour", 200, 1, 14, 8, 820));
        insert(new Product ("Anguille", "Colruyt", 200, 1, 14, 8, 810));
        insert(new Product ("Anguille", "Aldi", 200, 1, 14, 8, 800));

        insert(new Product ("Brochet", "Delhaize", 78, 1, 18, 1, 130));
        insert(new Product ("Brochet", "Carrefour", 78, 1, 18, 1, 120));
        insert(new Product ("Brochet", "Colruyt", 78, 1, 18, 1, 110));
        insert(new Product ("Brochet", "Aldi", 78, 1, 18, 1, 100));

        insert(new Product ("Cabillaud", "Delhaize", 68, 1, 16, 1, 130));
        insert(new Product ("Cabillaud", "Carrefour", 68, 1, 16, 1, 120));
        insert(new Product ("Cabillaud", "Colruyt", 68, 1, 16, 1, 110));
        insert(new Product ("Cabillaud", "Aldi", 68, 1, 16, 1, 100));

        insert(new Product ("Carpe", "Delhaize", 90, 1, 18, 2, 230));
        insert(new Product ("Carpe", "Carrefour", 90, 1, 18, 2, 220));
        insert(new Product ("Carpe", "Colruyt", 90, 1, 18, 2, 210));
        insert(new Product ("Carpe", "Aldi", 90, 1, 18, 2, 200));

        insert(new Product ("Colin", "Delhaize", 86, 1, 17, 2, 230));
        insert(new Product ("Colin", "Carrefour", 86, 1, 17, 2, 220));
        insert(new Product ("Colin", "Colruyt", 86, 1, 17, 2, 210));
        insert(new Product ("Colin", "Aldi", 86, 1, 17, 2, 200));

        insert(new Product ("Dorade", "Delhaize", 77, 1, 17, 1, 130));
        insert(new Product ("Dorade", "Carrefour", 77, 1, 17, 1, 120));
        insert(new Product ("Dorade", "Colruyt", 77, 1, 17, 1, 110));
        insert(new Product ("Dorade", "Aldi", 77, 1, 17, 1, 100));

        insert(new Product ("Eglefin", "Delhaize", 71, 1, 17, 1, 130));
        insert(new Product ("Eglefin", "Carrefour", 71, 1, 17, 1, 120));
        insert(new Product ("Eglefin", "Colruyt", 71, 1, 17, 1, 110));
        insert(new Product ("Eglefin", "Aldi", 71, 1, 17, 1, 100));

        insert(new Product ("Hareng", "Delhaize", 122, 1, 17, 6, 630));
        insert(new Product ("Hareng", "Carrefour", 122, 1, 17, 6, 620));
        insert(new Product ("Hareng", "Colruyt", 122, 1, 17, 6, 610));
        insert(new Product ("Hareng", "Aldi", 122, 1, 17, 6, 600));

        insert(new Product ("Limande et Sole", "Delhaize", 73, 1, 16, 1, 130));
        insert(new Product ("Limande et Sole", "Carrefour", 73, 1, 16, 1, 120));
        insert(new Product ("Limande et Sole", "Colruyt", 73, 1, 16, 1, 110));
        insert(new Product ("Limande et Sole", "Aldi", 73, 1, 16, 1, 100));

        insert(new Product ("Maquereau", "Delhaize", 128, 1, 14, 8, 830));
        insert(new Product ("Maquereau", "Carrefour", 128, 1, 14, 8, 820));
        insert(new Product ("Maquereau", "Colruyt", 128, 1, 14, 8, 810));
        insert(new Product ("Maquereau", "Aldi", 128, 1, 14, 8, 800));

        insert(new Product ("Merlan", "Delhaize", 69, 1, 16, 1, 130));
        insert(new Product ("Merlan", "Carrefour", 69, 1, 16, 1, 120));
        insert(new Product ("Merlan", "Colruyt", 69, 1, 16, 1, 110));
        insert(new Product ("Merlan", "Aldi", 69, 1, 16, 1, 100));

        insert(new Product ("Perche", "Delhaize", 112, 1, 19, 4, 430));
        insert(new Product ("Perche", "Carrefour", 112, 1, 19, 4, 420));
        insert(new Product ("Perche", "Colruyt", 112, 1, 19, 4, 410));
        insert(new Product ("Perche", "Aldi", 112, 1, 19, 4, 400));

        insert(new Product ("Raie", "Delhaize", 89, 1, 20, 1, 130));
        insert(new Product ("Raie", "Carrefour", 89, 1, 20, 1, 120));
        insert(new Product ("Raie", "Colruyt", 89, 1, 20, 1, 110));
        insert(new Product ("Raie", "Aldi", 89, 1, 20, 1, 100));

        insert(new Product ("Sardines", "Delhaize", 174, 1, 21, 10, 130));
        insert(new Product ("Sardines", "Carrefour", 174, 1, 21, 10, 120));
        insert(new Product ("Sardines", "Colruyt", 174, 1, 21, 10, 110));
        insert(new Product ("Sardines", "Aldi", 174, 1, 21, 10, 100));

        insert(new Product ("Sardines (en conserve)", "Delhaize", 188, 1, 20, 12, 230));
        insert(new Product ("Sardines (en conserve)", "Carrefour", 188, 1, 20, 12, 220));
        insert(new Product ("Sardines (en conserve)", "Colruyt", 188, 1, 20, 12, 210));
        insert(new Product ("Sardines (en conserve)", "Aldi", 188, 1, 20, 12, 200));

        insert(new Product ("Saumon", "Delhaize", 114, 1, 16, 8, 830));
        insert(new Product ("Saumon", "Carrefour", 114, 1, 16, 8, 820));
        insert(new Product ("Saumon", "Colruyt", 114, 1, 16, 8, 810));
        insert(new Product ("Saumon", "Aldi", 114, 1, 16, 8, 800));

        insert(new Product ("Saumon (en conserve)", "Delhaize", 170, 1, 20, 10, 130));
        insert(new Product ("Saumon (en conserve)", "Carrefour", 170, 1, 20, 10, 120));
        insert(new Product ("Saumon (en conserve)", "Colruyt", 170, 1, 20, 10, 110));
        insert(new Product ("Saumon (en conserve)", "Aldi", 170, 1, 20, 10, 100));

        insert(new Product ("Thon", "Delhaize", 225, 1, 27, 13, 330));
        insert(new Product ("Thon", "Carrefour", 225, 1, 27, 13, 320));
        insert(new Product ("Thon", "Colruyt", 225, 1, 27, 13, 310));
        insert(new Product ("Thon", "Aldi", 225, 1, 27, 13, 300));

        insert(new Product ("Thon (en conserve)", "Delhaize", 225, 1, 25, 20, 130));
        insert(new Product ("Thon (en conserve)", "Carrefour", 225, 1, 25, 20, 120));
        insert(new Product ("Thon (en conserve)", "Colruyt", 225, 1, 25, 20, 110));
        insert(new Product ("Thon (en conserve)", "Aldi", 225, 1, 25, 20, 100));

        insert(new Product ("Truite", "Delhaize", 94, 1, 16, 2, 230));
        insert(new Product ("Truite", "Carrefour", 94, 1, 16, 2, 220));
        insert(new Product ("Truite", "Colruyt", 94, 1, 16, 2, 210));
        insert(new Product ("Truite", "Aldi", 94, 1, 16, 2, 200));

        insert(new Product ("Turbot", "Delhaize", 118, 1, 16, 6, 630));
        insert(new Product ("Turbot", "Carrefour", 118, 1, 16, 6, 620));
        insert(new Product ("Turbot", "Colruyt", 118, 1, 16, 6, 610));
        insert(new Product ("Turbot", "Aldi", 118, 1, 16, 6, 600));

        Shop delhaize = new Shop("Delhaize");
        Shop carrefour = new Shop("Carrefour");
        Shop colruyt = new Shop("Colruyt");
        Shop aldi = new Shop("Aldi");


        delhaize.addProduct(getProduct("Farine d'avoine", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Farines blanche (froment)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("pain", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pain de blé (complet)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pain de seigle", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Biscottes de blé", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Biscuits ordinaires", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Biscuits secs (petits beurre)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Biscuits à la cuillère", "Delhaize"), 73);
        delhaize.addProduct(getProduct("Semoules et pâtes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Purée en sachet (poudre seule)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Purée en sachet (dans 1L lait)", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Flan.alsa avec lait demi-écrémé", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Lait entier", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Lait demi-écrémé", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Lait écrémé", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Crème", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Yoghourt", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Beurre", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Beurre.41%", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Fromage blanc, maigre 0%", "Delhaize"), 13);
        delhaize.addProduct(getProduct("fromage blanc 20%", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Fromage blanc, mi-gros", "Delhaize"), 43);
        delhaize.addProduct(getProduct("Fromage blanc, gras", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Fromage blanc, petit-suisse", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Brie", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Camembert", "Delhaize"), 43);
        delhaize.addProduct(getProduct("Gruyère", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Hollande", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Huiles végétales", "Delhaize"), 93);
        delhaize.addProduct(getProduct("Margarines", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Graisses animales", "Delhaize"), 63);
        delhaize.addProduct(getProduct("Mayonnaise", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Oeuf entier", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Jaune d'oeuf", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Blanc d'oeuf", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Boeufs (mi-gras)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cheval", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Mouton", "Delhaize"), 93);
        delhaize.addProduct(getProduct("Veau", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Porc", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Jambon", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Lard", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Cervelle", "Delhaize"), 93);
        delhaize.addProduct(getProduct("Coeur", "Delhaize"), 63);
        delhaize.addProduct(getProduct("Foie", "Delhaize"), 43);
        delhaize.addProduct(getProduct("Langue", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Boudin (grillé)", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Jambon cuit", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Jambon fumé", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Pâté de foie gras", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Salami", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Saucisse", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Saucisson", "Delhaize"), 53);
        delhaize.addProduct(getProduct("pâté.rillettes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cassoulet préparé complet", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Choucroute garnie", "Delhaize"), 33);
        delhaize.addProduct(getProduct("poule", "Delhaize"), 53);
        delhaize.addProduct(getProduct("poulet", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Oie", "Delhaize"), 43);
        delhaize.addProduct(getProduct("Autruche", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Dinde", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Gibiers à poils", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Gibiers à plumes", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Ail", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Asperges", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Betteraves (rouges)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Carottes (cuites)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Céleris", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Céleris raves", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cerfeuil", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Champignons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Chicorée", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Choucroute", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Choux de Bruxelles", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Chou-fleur", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Chou rouge", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Ciboulette", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Concombre", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cornichons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cresson", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Echalotes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Endives", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Epinards", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Haricots verts", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Laitue", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Navets", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Oignons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Persil", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Poireaux", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pois", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Poivrons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pommes de terre", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Radis", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Salsifis", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Scaroles", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Tomates", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Haricots blancs secs", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Lentilles", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pois secs", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pois chiches", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Poids.cassés", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Maïs", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Riz", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Frittes chips", "Delhaize"), 73);
        delhaize.addProduct(getProduct("Abricots", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Airelles", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Ananas", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Bananes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cerises", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Citrons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Figues fraîches", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Fraises", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Framboises", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Groseilles", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Mandarines", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Melons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Oranges", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pamplemousses", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pêches", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Poires", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pommes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Prunes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Raisins", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Rhubarbes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Amandes", "Delhaize"), 43);
        delhaize.addProduct(getProduct("Arachides", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Châtaignes", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Châtaignes sèches", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Dattes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Figues sèches", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Noisettes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Noix", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pruneaux", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Bonbons divers", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cacao.super.instantané", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Chocolats", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Confitures", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Miel", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Pâtisseries", "Delhaize"), 53);
        delhaize.addProduct(getProduct("Sucre", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Compote de pommes", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Crème de marrons", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Sauce.bechamel *58/100", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Bière", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cidre", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Eaux de vie", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Limonade", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Vin (blanc 10 doux)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Vin (rouge 10)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Coca-Cola", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Jus d'oranges", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Crabe crevette", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Langouste homard", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Anchois", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Anguille", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Brochet", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Cabillaud", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Carpe", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Colin", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Dorade", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Eglefin", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Hareng", "Delhaize"), 63);
        delhaize.addProduct(getProduct("Limande et Sole", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Maquereau", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Merlan", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Perche", "Delhaize"), 43);
        delhaize.addProduct(getProduct("Raie", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Sardines", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Sardines (en conserve)", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Saumon", "Delhaize"), 83);
        delhaize.addProduct(getProduct("Saumon (en conserve)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Thon", "Delhaize"), 33);
        delhaize.addProduct(getProduct("Thon (en conserve)", "Delhaize"), 13);
        delhaize.addProduct(getProduct("Truite", "Delhaize"), 23);
        delhaize.addProduct(getProduct("Turbot", "Delhaize"), 63);



        carrefour.addProduct(getProduct("Farine d'avoine", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Farines blanche (froment)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("pain", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pain de blé (complet)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pain de seigle", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Biscottes de blé", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Biscuits ordinaires", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Biscuits secs (petits beurre)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Biscuits à la cuillère", "Carrefour"), 72);
        carrefour.addProduct(getProduct("Semoules et pâtes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Purée en sachet (poudre seule)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Purée en sachet (dans 1L lait)", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Flan.alsa avec lait demi-écrémé", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Lait entier", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Lait demi-écrémé", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Lait écrémé", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Crème", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Yoghourt", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Beurre", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Beurre.41%", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Fromage blanc, maigre 0%", "Carrefour"), 12);
        carrefour.addProduct(getProduct("fromage blanc 20%", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Fromage blanc, mi-gros", "Carrefour"), 42);
        carrefour.addProduct(getProduct("Fromage blanc, gras", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Fromage blanc, petit-suisse", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Brie", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Camembert", "Carrefour"), 42);
        carrefour.addProduct(getProduct("Gruyère", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Hollande", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Huiles végétales", "Carrefour"), 92);
        carrefour.addProduct(getProduct("Margarines", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Graisses animales", "Carrefour"), 62);
        carrefour.addProduct(getProduct("Mayonnaise", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Oeuf entier", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Jaune d'oeuf", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Blanc d'oeuf", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Boeufs (mi-gras)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cheval", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Mouton", "Carrefour"), 92);
        carrefour.addProduct(getProduct("Veau", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Porc", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Jambon", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Lard", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Cervelle", "Carrefour"), 92);
        carrefour.addProduct(getProduct("Coeur", "Carrefour"), 62);
        carrefour.addProduct(getProduct("Foie", "Carrefour"), 42);
        carrefour.addProduct(getProduct("Langue", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Boudin (grillé)", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Jambon cuit", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Jambon fumé", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Pâté de foie gras", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Salami", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Saucisse", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Saucisson", "Carrefour"), 52);
        carrefour.addProduct(getProduct("pâté.rillettes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cassoulet préparé complet", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Choucroute garnie", "Carrefour"), 32);
        carrefour.addProduct(getProduct("poule", "Carrefour"), 52);
        carrefour.addProduct(getProduct("poulet", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Oie", "Carrefour"), 42);
        carrefour.addProduct(getProduct("Autruche", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Dinde", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Gibiers à poils", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Gibiers à plumes", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Ail", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Asperges", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Betteraves (rouges)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Carottes (cuites)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Céleris", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Céleris raves", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cerfeuil", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Champignons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Chicorée", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Choucroute", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Choux de Bruxelles", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Chou-fleur", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Chou rouge", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Ciboulette", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Concombre", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cornichons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cresson", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Echalotes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Endives", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Epinards", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Haricots verts", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Laitue", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Navets", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Oignons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Persil", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Poireaux", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pois", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Poivrons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pommes de terre", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Radis", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Salsifis", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Scaroles", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Tomates", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Haricots blancs secs", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Lentilles", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pois secs", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pois chiches", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Poids.cassés", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Maïs", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Riz", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Frittes chips", "Carrefour"), 72);
        carrefour.addProduct(getProduct("Abricots", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Airelles", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Ananas", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Bananes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cerises", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Citrons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Figues fraîches", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Fraises", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Framboises", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Groseilles", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Mandarines", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Melons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Oranges", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pamplemousses", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pêches", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Poires", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pommes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Prunes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Raisins", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Rhubarbes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Amandes", "Carrefour"), 42);
        carrefour.addProduct(getProduct("Arachides", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Châtaignes", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Châtaignes sèches", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Dattes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Figues sèches", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Noisettes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Noix", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pruneaux", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Bonbons divers", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cacao.super.instantané", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Chocolats", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Confitures", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Miel", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Pâtisseries", "Carrefour"), 52);
        carrefour.addProduct(getProduct("Sucre", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Compote de pommes", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Crème de marrons", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Sauce.bechamel *58/100", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Bière", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cidre", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Eaux de vie", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Limonade", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Vin (blanc 10 doux)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Vin (rouge 10)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Coca-Cola", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Jus d'oranges", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Crabe crevette", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Langouste homard", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Anchois", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Anguille", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Brochet", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Cabillaud", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Carpe", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Colin", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Dorade", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Eglefin", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Hareng", "Carrefour"), 62);
        carrefour.addProduct(getProduct("Limande et Sole", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Maquereau", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Merlan", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Perche", "Carrefour"), 42);
        carrefour.addProduct(getProduct("Raie", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Sardines", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Sardines (en conserve)", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Saumon", "Carrefour"), 82);
        carrefour.addProduct(getProduct("Saumon (en conserve)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Thon", "Carrefour"), 32);
        carrefour.addProduct(getProduct("Thon (en conserve)", "Carrefour"), 12);
        carrefour.addProduct(getProduct("Truite", "Carrefour"), 22);
        carrefour.addProduct(getProduct("Turbot", "Carrefour"), 62);



        colruyt.addProduct(getProduct("Farine d'avoine", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Farines blanche (froment)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("pain", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pain de blé (complet)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pain de seigle", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Biscottes de blé", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Biscuits ordinaires", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Biscuits secs (petits beurre)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Biscuits à la cuillère", "Colruyt"), 71);
        colruyt.addProduct(getProduct("Semoules et pâtes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Purée en sachet (poudre seule)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Purée en sachet (dans 1L lait)", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Flan.alsa avec lait demi-écrémé", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Lait entier", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Lait demi-écrémé", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Lait écrémé", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Crème", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Yoghourt", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Beurre", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Beurre.41%", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Fromage blanc, maigre 0%", "Colruyt"), 11);
        colruyt.addProduct(getProduct("fromage blanc 20%", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Fromage blanc, mi-gros", "Colruyt"), 41);
        colruyt.addProduct(getProduct("Fromage blanc, gras", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Fromage blanc, petit-suisse", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Brie", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Camembert", "Colruyt"), 41);
        colruyt.addProduct(getProduct("Gruyère", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Hollande", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Huiles végétales", "Colruyt"), 91);
        colruyt.addProduct(getProduct("Margarines", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Graisses animales", "Colruyt"), 61);
        colruyt.addProduct(getProduct("Mayonnaise", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Oeuf entier", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Jaune d'oeuf", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Blanc d'oeuf", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Boeufs (mi-gras)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cheval", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Mouton", "Colruyt"), 91);
        colruyt.addProduct(getProduct("Veau", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Porc", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Jambon", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Lard", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Cervelle", "Colruyt"), 91);
        colruyt.addProduct(getProduct("Coeur", "Colruyt"), 61);
        colruyt.addProduct(getProduct("Foie", "Colruyt"), 41);
        colruyt.addProduct(getProduct("Langue", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Boudin (grillé)", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Jambon cuit", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Jambon fumé", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Pâté de foie gras", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Salami", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Saucisse", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Saucisson", "Colruyt"), 51);
        colruyt.addProduct(getProduct("pâté.rillettes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cassoulet préparé complet", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Choucroute garnie", "Colruyt"), 31);
        colruyt.addProduct(getProduct("poule", "Colruyt"), 51);
        colruyt.addProduct(getProduct("poulet", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Oie", "Colruyt"), 41);
        colruyt.addProduct(getProduct("Autruche", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Dinde", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Gibiers à poils", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Gibiers à plumes", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Ail", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Asperges", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Betteraves (rouges)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Carottes (cuites)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Céleris", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Céleris raves", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cerfeuil", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Champignons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Chicorée", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Choucroute", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Choux de Bruxelles", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Chou-fleur", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Chou rouge", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Ciboulette", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Concombre", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cornichons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cresson", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Echalotes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Endives", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Epinards", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Haricots verts", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Laitue", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Navets", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Oignons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Persil", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Poireaux", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pois", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Poivrons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pommes de terre", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Radis", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Salsifis", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Scaroles", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Tomates", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Haricots blancs secs", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Lentilles", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pois secs", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pois chiches", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Poids.cassés", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Maïs", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Riz", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Frittes chips", "Colruyt"), 71);
        colruyt.addProduct(getProduct("Abricots", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Airelles", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Ananas", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Bananes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cerises", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Citrons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Figues fraîches", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Fraises", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Framboises", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Groseilles", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Mandarines", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Melons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Oranges", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pamplemousses", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pêches", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Poires", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pommes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Prunes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Raisins", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Rhubarbes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Amandes", "Colruyt"), 41);
        colruyt.addProduct(getProduct("Arachides", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Châtaignes", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Châtaignes sèches", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Dattes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Figues sèches", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Noisettes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Noix", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pruneaux", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Bonbons divers", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cacao.super.instantané", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Chocolats", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Confitures", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Miel", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Pâtisseries", "Colruyt"), 51);
        colruyt.addProduct(getProduct("Sucre", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Compote de pommes", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Crème de marrons", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Sauce.bechamel *58/100", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Bière", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cidre", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Eaux de vie", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Limonade", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Vin (blanc 10 doux)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Vin (rouge 10)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Coca-Cola", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Jus d'oranges", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Crabe crevette", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Langouste homard", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Anchois", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Anguille", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Brochet", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Cabillaud", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Carpe", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Colin", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Dorade", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Eglefin", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Hareng", "Colruyt"), 61);
        colruyt.addProduct(getProduct("Limande et Sole", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Maquereau", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Merlan", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Perche", "Colruyt"), 41);
        colruyt.addProduct(getProduct("Raie", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Sardines", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Sardines (en conserve)", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Saumon", "Colruyt"), 81);
        colruyt.addProduct(getProduct("Saumon (en conserve)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Thon", "Colruyt"), 31);
        colruyt.addProduct(getProduct("Thon (en conserve)", "Colruyt"), 11);
        colruyt.addProduct(getProduct("Truite", "Colruyt"), 21);
        colruyt.addProduct(getProduct("Turbot", "Colruyt"), 61);



        aldi.addProduct(getProduct("Farine d'avoine", "Aldi"), 50);
        aldi.addProduct(getProduct("Farines blanche (froment)", "Aldi"), 10);
        aldi.addProduct(getProduct("pain", "Aldi"), 10);
        aldi.addProduct(getProduct("Pain de blé (complet)", "Aldi"), 10);
        aldi.addProduct(getProduct("Pain de seigle", "Aldi"), 10);
        aldi.addProduct(getProduct("Biscottes de blé", "Aldi"), 20);
        aldi.addProduct(getProduct("Biscuits ordinaires", "Aldi"), 10);
        aldi.addProduct(getProduct("Biscuits secs (petits beurre)", "Aldi"), 10);
        aldi.addProduct(getProduct("Biscuits à la cuillère", "Aldi"), 70);
        aldi.addProduct(getProduct("Semoules et pâtes", "Aldi"), 10);
        aldi.addProduct(getProduct("Purée en sachet (poudre seule)", "Aldi"), 10);
        aldi.addProduct(getProduct("Purée en sachet (dans 1L lait)", "Aldi"), 20);
        aldi.addProduct(getProduct("Flan.alsa avec lait demi-écrémé", "Aldi"), 20);
        aldi.addProduct(getProduct("Lait entier", "Aldi"), 30);
        aldi.addProduct(getProduct("Lait demi-écrémé", "Aldi"), 10);
        aldi.addProduct(getProduct("Lait écrémé", "Aldi"), 10);
        aldi.addProduct(getProduct("Crème", "Aldi"), 10);
        aldi.addProduct(getProduct("Yoghourt", "Aldi"), 10);
        aldi.addProduct(getProduct("Beurre", "Aldi"), 30);
        aldi.addProduct(getProduct("Beurre.41%", "Aldi"), 10);
        aldi.addProduct(getProduct("Fromage blanc, maigre 0%", "Aldi"), 10);
        aldi.addProduct(getProduct("fromage blanc 20%", "Aldi"), 30);
        aldi.addProduct(getProduct("Fromage blanc, mi-gros", "Aldi"), 40);
        aldi.addProduct(getProduct("Fromage blanc, gras", "Aldi"), 80);
        aldi.addProduct(getProduct("Fromage blanc, petit-suisse", "Aldi"), 20);
        aldi.addProduct(getProduct("Brie", "Aldi"), 10);
        aldi.addProduct(getProduct("Camembert", "Aldi"), 40);
        aldi.addProduct(getProduct("Gruyère", "Aldi"), 10);
        aldi.addProduct(getProduct("Hollande", "Aldi"), 50);
        aldi.addProduct(getProduct("Huiles végétales", "Aldi"), 90);
        aldi.addProduct(getProduct("Margarines", "Aldi"), 30);
        aldi.addProduct(getProduct("Graisses animales", "Aldi"), 60);
        aldi.addProduct(getProduct("Mayonnaise", "Aldi"), 80);
        aldi.addProduct(getProduct("Oeuf entier", "Aldi"), 20);
        aldi.addProduct(getProduct("Jaune d'oeuf", "Aldi"), 30);
        aldi.addProduct(getProduct("Blanc d'oeuf", "Aldi"), 10);
        aldi.addProduct(getProduct("Boeufs (mi-gras)", "Aldi"), 10);
        aldi.addProduct(getProduct("Cheval", "Aldi"), 20);
        aldi.addProduct(getProduct("Mouton", "Aldi"), 90);
        aldi.addProduct(getProduct("Veau", "Aldi"), 10);
        aldi.addProduct(getProduct("Porc", "Aldi"), 50);
        aldi.addProduct(getProduct("Jambon", "Aldi"), 20);
        aldi.addProduct(getProduct("Lard", "Aldi"), 50);
        aldi.addProduct(getProduct("Cervelle", "Aldi"), 90);
        aldi.addProduct(getProduct("Coeur", "Aldi"), 60);
        aldi.addProduct(getProduct("Foie", "Aldi"), 40);
        aldi.addProduct(getProduct("Langue", "Aldi"), 50);
        aldi.addProduct(getProduct("Boudin (grillé)", "Aldi"), 50);
        aldi.addProduct(getProduct("Jambon cuit", "Aldi"), 50);
        aldi.addProduct(getProduct("Jambon fumé", "Aldi"), 50);
        aldi.addProduct(getProduct("Pâté de foie gras", "Aldi"), 50);
        aldi.addProduct(getProduct("Salami", "Aldi"), 50);
        aldi.addProduct(getProduct("Saucisse", "Aldi"), 50);
        aldi.addProduct(getProduct("Saucisson", "Aldi"), 50);
        aldi.addProduct(getProduct("pâté.rillettes", "Aldi"), 10);
        aldi.addProduct(getProduct("Cassoulet préparé complet", "Aldi"), 80);
        aldi.addProduct(getProduct("Choucroute garnie", "Aldi"), 30);
        aldi.addProduct(getProduct("poule", "Aldi"), 50);
        aldi.addProduct(getProduct("poulet", "Aldi"), 80);
        aldi.addProduct(getProduct("Oie", "Aldi"), 40);
        aldi.addProduct(getProduct("Autruche", "Aldi"), 20);
        aldi.addProduct(getProduct("Dinde", "Aldi"), 50);
        aldi.addProduct(getProduct("Gibiers à poils", "Aldi"), 30);
        aldi.addProduct(getProduct("Gibiers à plumes", "Aldi"), 30);
        aldi.addProduct(getProduct("Ail", "Aldi"), 10);
        aldi.addProduct(getProduct("Asperges", "Aldi"), 10);
        aldi.addProduct(getProduct("Betteraves (rouges)", "Aldi"), 10);
        aldi.addProduct(getProduct("Carottes (cuites)", "Aldi"), 10);
        aldi.addProduct(getProduct("Céleris", "Aldi"), 10);
        aldi.addProduct(getProduct("Céleris raves", "Aldi"), 10);
        aldi.addProduct(getProduct("Cerfeuil", "Aldi"), 10);
        aldi.addProduct(getProduct("Champignons", "Aldi"), 10);
        aldi.addProduct(getProduct("Chicorée", "Aldi"), 10);
        aldi.addProduct(getProduct("Choucroute", "Aldi"), 10);
        aldi.addProduct(getProduct("Choux de Bruxelles", "Aldi"), 10);
        aldi.addProduct(getProduct("Chou-fleur", "Aldi"), 10);
        aldi.addProduct(getProduct("Chou rouge", "Aldi"), 10);
        aldi.addProduct(getProduct("Ciboulette", "Aldi"), 10);
        aldi.addProduct(getProduct("Concombre", "Aldi"), 10);
        aldi.addProduct(getProduct("Cornichons", "Aldi"), 10);
        aldi.addProduct(getProduct("Cresson", "Aldi"), 10);
        aldi.addProduct(getProduct("Echalotes", "Aldi"), 10);
        aldi.addProduct(getProduct("Endives", "Aldi"), 10);
        aldi.addProduct(getProduct("Epinards", "Aldi"), 10);
        aldi.addProduct(getProduct("Haricots verts", "Aldi"), 10);
        aldi.addProduct(getProduct("Laitue", "Aldi"), 10);
        aldi.addProduct(getProduct("Navets", "Aldi"), 10);
        aldi.addProduct(getProduct("Oignons", "Aldi"), 10);
        aldi.addProduct(getProduct("Persil", "Aldi"), 10);
        aldi.addProduct(getProduct("Poireaux", "Aldi"), 10);
        aldi.addProduct(getProduct("Pois", "Aldi"), 10);
        aldi.addProduct(getProduct("Poivrons", "Aldi"), 10);
        aldi.addProduct(getProduct("Pommes de terre", "Aldi"), 10);
        aldi.addProduct(getProduct("Radis", "Aldi"), 10);
        aldi.addProduct(getProduct("Salsifis", "Aldi"), 10);
        aldi.addProduct(getProduct("Scaroles", "Aldi"), 10);
        aldi.addProduct(getProduct("Tomates", "Aldi"), 10);
        aldi.addProduct(getProduct("Haricots blancs secs", "Aldi"), 10);
        aldi.addProduct(getProduct("Lentilles", "Aldi"), 10);
        aldi.addProduct(getProduct("Pois secs", "Aldi"), 10);
        aldi.addProduct(getProduct("Pois chiches", "Aldi"), 50);
        aldi.addProduct(getProduct("Poids.cassés", "Aldi"), 10);
        aldi.addProduct(getProduct("Maïs", "Aldi"), 50);
        aldi.addProduct(getProduct("Riz", "Aldi"), 10);
        aldi.addProduct(getProduct("Frittes chips", "Aldi"), 70);
        aldi.addProduct(getProduct("Abricots", "Aldi"), 10);
        aldi.addProduct(getProduct("Airelles", "Aldi"), 10);
        aldi.addProduct(getProduct("Ananas", "Aldi"), 10);
        aldi.addProduct(getProduct("Bananes", "Aldi"), 10);
        aldi.addProduct(getProduct("Cerises", "Aldi"), 10);
        aldi.addProduct(getProduct("Citrons", "Aldi"), 10);
        aldi.addProduct(getProduct("Figues fraîches", "Aldi"), 10);
        aldi.addProduct(getProduct("Fraises", "Aldi"), 10);
        aldi.addProduct(getProduct("Framboises", "Aldi"), 10);
        aldi.addProduct(getProduct("Groseilles", "Aldi"), 10);
        aldi.addProduct(getProduct("Mandarines", "Aldi"), 10);
        aldi.addProduct(getProduct("Melons", "Aldi"), 10);
        aldi.addProduct(getProduct("Oranges", "Aldi"), 10);
        aldi.addProduct(getProduct("Pamplemousses", "Aldi"), 10);
        aldi.addProduct(getProduct("Pêches", "Aldi"), 10);
        aldi.addProduct(getProduct("Poires", "Aldi"), 10);
        aldi.addProduct(getProduct("Pommes", "Aldi"), 10);
        aldi.addProduct(getProduct("Prunes", "Aldi"), 10);
        aldi.addProduct(getProduct("Raisins", "Aldi"), 10);
        aldi.addProduct(getProduct("Rhubarbes", "Aldi"), 10);
        aldi.addProduct(getProduct("Amandes", "Aldi"), 40);
        aldi.addProduct(getProduct("Arachides", "Aldi"), 10);
        aldi.addProduct(getProduct("Châtaignes", "Aldi"), 20);
        aldi.addProduct(getProduct("Châtaignes sèches", "Aldi"), 50);
        aldi.addProduct(getProduct("Dattes", "Aldi"), 10);
        aldi.addProduct(getProduct("Figues sèches", "Aldi"), 10);
        aldi.addProduct(getProduct("Noisettes", "Aldi"), 10);
        aldi.addProduct(getProduct("Noix", "Aldi"), 10);
        aldi.addProduct(getProduct("Pruneaux", "Aldi"), 10);
        aldi.addProduct(getProduct("Bonbons divers", "Aldi"), 10);
        aldi.addProduct(getProduct("Cacao.super.instantané", "Aldi"), 20);
        aldi.addProduct(getProduct("Chocolats", "Aldi"), 10);
        aldi.addProduct(getProduct("Confitures", "Aldi"), 10);
        aldi.addProduct(getProduct("Miel", "Aldi"), 10);
        aldi.addProduct(getProduct("Pâtisseries", "Aldi"), 50);
        aldi.addProduct(getProduct("Sucre", "Aldi"), 10);
        aldi.addProduct(getProduct("Compote de pommes", "Aldi"), 10);
        aldi.addProduct(getProduct("Crème de marrons", "Aldi"), 10);
        aldi.addProduct(getProduct("Sauce.bechamel *58/100", "Aldi"), 30);
        aldi.addProduct(getProduct("Bière", "Aldi"), 10);
        aldi.addProduct(getProduct("Cidre", "Aldi"), 10);
        aldi.addProduct(getProduct("Eaux de vie", "Aldi"), 10);
        aldi.addProduct(getProduct("Limonade", "Aldi"), 10);
        aldi.addProduct(getProduct("Vin (blanc 10 doux)", "Aldi"), 10);
        aldi.addProduct(getProduct("Vin (rouge 10)", "Aldi"), 10);
        aldi.addProduct(getProduct("Coca-Cola", "Aldi"), 10);
        aldi.addProduct(getProduct("Jus d'oranges", "Aldi"), 10);
        aldi.addProduct(getProduct("Crabe crevette", "Aldi"), 10);
        aldi.addProduct(getProduct("Langouste homard", "Aldi"), 10);
        aldi.addProduct(getProduct("Anchois", "Aldi"), 80);
        aldi.addProduct(getProduct("Anguille", "Aldi"), 80);
        aldi.addProduct(getProduct("Brochet", "Aldi"), 10);
        aldi.addProduct(getProduct("Cabillaud", "Aldi"), 10);
        aldi.addProduct(getProduct("Carpe", "Aldi"), 20);
        aldi.addProduct(getProduct("Colin", "Aldi"), 20);
        aldi.addProduct(getProduct("Dorade", "Aldi"), 10);
        aldi.addProduct(getProduct("Eglefin", "Aldi"), 10);
        aldi.addProduct(getProduct("Hareng", "Aldi"), 60);
        aldi.addProduct(getProduct("Limande et Sole", "Aldi"), 10);
        aldi.addProduct(getProduct("Maquereau", "Aldi"), 80);
        aldi.addProduct(getProduct("Merlan", "Aldi"), 10);
        aldi.addProduct(getProduct("Perche", "Aldi"), 40);
        aldi.addProduct(getProduct("Raie", "Aldi"), 10);
        aldi.addProduct(getProduct("Sardines", "Aldi"), 10);
        aldi.addProduct(getProduct("Sardines (en conserve)", "Aldi"), 20);
        aldi.addProduct(getProduct("Saumon", "Aldi"), 80);
        aldi.addProduct(getProduct("Saumon (en conserve)", "Aldi"), 10);
        aldi.addProduct(getProduct("Thon", "Aldi"), 30);
        aldi.addProduct(getProduct("Thon (en conserve)", "Aldi"), 10);
        aldi.addProduct(getProduct("Truite", "Aldi"), 20);
        aldi.addProduct(getProduct("Turbot", "Aldi"), 60);

        insert(delhaize);
        insert(carrefour);
        insert(colruyt);
        insert(aldi);

    }

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
