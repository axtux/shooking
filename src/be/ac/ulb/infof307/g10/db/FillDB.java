package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.User;

import static be.ac.ulb.infof307.g10.db.DatabaseFacade.getProductFromNameAndDesc;
import static be.ac.ulb.infof307.g10.db.DatabaseFacade.insert;

public class FillDB {
    public void fill(){

        insert(new User("User1", "User1"));
        insert(new User("User2", "User2"));

        insert(new Product("Farine d'avoine", "Delhaize", 353, 65, 12, 5, 530));
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

        Shop delhaize = new Shop("Delhaize", 0.0, 0.0);
        Shop carrefour = new Shop("Carrefour", 0.0, 0.0);
        Shop colruyt = new Shop("Colruyt", 0.0, 0.0);
        Shop aldi = new Shop("Aldi", 0.0, 0.0);


        delhaize.addProduct(getProductFromNameAndDesc("Farine d'avoine", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Farines blanche (froment)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("pain", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pain de blé (complet)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pain de seigle", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Biscottes de blé", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Biscuits ordinaires", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Biscuits secs (petits beurre)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Biscuits à la cuillère", "Delhaize"), 73);
        delhaize.addProduct(getProductFromNameAndDesc("Semoules et pâtes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Purée en sachet (poudre seule)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Purée en sachet (dans 1L lait)", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Flan.alsa avec lait demi-écrémé", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Lait entier", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Lait demi-écrémé", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Lait écrémé", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Crème", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Yoghourt", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Beurre", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Beurre.41%", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Fromage blanc, maigre 0%", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("fromage blanc 20%", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Fromage blanc, mi-gros", "Delhaize"), 43);
        delhaize.addProduct(getProductFromNameAndDesc("Fromage blanc, gras", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Fromage blanc, petit-suisse", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Brie", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Camembert", "Delhaize"), 43);
        delhaize.addProduct(getProductFromNameAndDesc("Gruyère", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Hollande", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Huiles végétales", "Delhaize"), 93);
        delhaize.addProduct(getProductFromNameAndDesc("Margarines", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Graisses animales", "Delhaize"), 63);
        delhaize.addProduct(getProductFromNameAndDesc("Mayonnaise", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Oeuf entier", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Jaune d'oeuf", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Blanc d'oeuf", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Boeufs (mi-gras)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cheval", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Mouton", "Delhaize"), 93);
        delhaize.addProduct(getProductFromNameAndDesc("Veau", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Porc", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Jambon", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Lard", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Cervelle", "Delhaize"), 93);
        delhaize.addProduct(getProductFromNameAndDesc("Coeur", "Delhaize"), 63);
        delhaize.addProduct(getProductFromNameAndDesc("Foie", "Delhaize"), 43);
        delhaize.addProduct(getProductFromNameAndDesc("Langue", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Boudin (grillé)", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Jambon cuit", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Jambon fumé", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Pâté de foie gras", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Salami", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Saucisse", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Saucisson", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("pâté.rillettes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cassoulet préparé complet", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Choucroute garnie", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("poule", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("poulet", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Oie", "Delhaize"), 43);
        delhaize.addProduct(getProductFromNameAndDesc("Autruche", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Dinde", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Gibiers à poils", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Gibiers à plumes", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Ail", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Asperges", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Betteraves (rouges)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Carottes (cuites)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Céleris", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Céleris raves", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cerfeuil", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Champignons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Chicorée", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Choucroute", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Choux de Bruxelles", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Chou-fleur", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Chou rouge", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Ciboulette", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Concombre", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cornichons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cresson", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Echalotes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Endives", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Epinards", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Haricots verts", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Laitue", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Navets", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Oignons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Persil", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Poireaux", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pois", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Poivrons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pommes de terre", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Radis", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Salsifis", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Scaroles", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Tomates", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Haricots blancs secs", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Lentilles", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pois secs", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pois chiches", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Poids.cassés", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Maïs", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Riz", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Frittes chips", "Delhaize"), 73);
        delhaize.addProduct(getProductFromNameAndDesc("Abricots", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Airelles", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Ananas", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Bananes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cerises", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Citrons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Figues fraîches", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Fraises", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Framboises", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Groseilles", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Mandarines", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Melons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Oranges", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pamplemousses", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pêches", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Poires", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pommes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Prunes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Raisins", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Rhubarbes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Amandes", "Delhaize"), 43);
        delhaize.addProduct(getProductFromNameAndDesc("Arachides", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Châtaignes", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Châtaignes sèches", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Dattes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Figues sèches", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Noisettes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Noix", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pruneaux", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Bonbons divers", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cacao.super.instantané", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Chocolats", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Confitures", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Miel", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Pâtisseries", "Delhaize"), 53);
        delhaize.addProduct(getProductFromNameAndDesc("Sucre", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Compote de pommes", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Crème de marrons", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Sauce.bechamel *58/100", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Bière", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cidre", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Eaux de vie", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Limonade", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Vin (blanc 10 doux)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Vin (rouge 10)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Coca-Cola", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Jus d'oranges", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Crabe crevette", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Langouste homard", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Anchois", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Anguille", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Brochet", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Cabillaud", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Carpe", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Colin", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Dorade", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Eglefin", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Hareng", "Delhaize"), 63);
        delhaize.addProduct(getProductFromNameAndDesc("Limande et Sole", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Maquereau", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Merlan", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Perche", "Delhaize"), 43);
        delhaize.addProduct(getProductFromNameAndDesc("Raie", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Sardines", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Sardines (en conserve)", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Saumon", "Delhaize"), 83);
        delhaize.addProduct(getProductFromNameAndDesc("Saumon (en conserve)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Thon", "Delhaize"), 33);
        delhaize.addProduct(getProductFromNameAndDesc("Thon (en conserve)", "Delhaize"), 13);
        delhaize.addProduct(getProductFromNameAndDesc("Truite", "Delhaize"), 23);
        delhaize.addProduct(getProductFromNameAndDesc("Turbot", "Delhaize"), 63);



        carrefour.addProduct(getProductFromNameAndDesc("Farine d'avoine", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Farines blanche (froment)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("pain", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pain de blé (complet)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pain de seigle", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Biscottes de blé", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Biscuits ordinaires", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Biscuits secs (petits beurre)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Biscuits à la cuillère", "Carrefour"), 72);
        carrefour.addProduct(getProductFromNameAndDesc("Semoules et pâtes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Purée en sachet (poudre seule)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Purée en sachet (dans 1L lait)", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Flan.alsa avec lait demi-écrémé", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Lait entier", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Lait demi-écrémé", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Lait écrémé", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Crème", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Yoghourt", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Beurre", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Beurre.41%", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Fromage blanc, maigre 0%", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("fromage blanc 20%", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Fromage blanc, mi-gros", "Carrefour"), 42);
        carrefour.addProduct(getProductFromNameAndDesc("Fromage blanc, gras", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Fromage blanc, petit-suisse", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Brie", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Camembert", "Carrefour"), 42);
        carrefour.addProduct(getProductFromNameAndDesc("Gruyère", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Hollande", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Huiles végétales", "Carrefour"), 92);
        carrefour.addProduct(getProductFromNameAndDesc("Margarines", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Graisses animales", "Carrefour"), 62);
        carrefour.addProduct(getProductFromNameAndDesc("Mayonnaise", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Oeuf entier", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Jaune d'oeuf", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Blanc d'oeuf", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Boeufs (mi-gras)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cheval", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Mouton", "Carrefour"), 92);
        carrefour.addProduct(getProductFromNameAndDesc("Veau", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Porc", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Jambon", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Lard", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Cervelle", "Carrefour"), 92);
        carrefour.addProduct(getProductFromNameAndDesc("Coeur", "Carrefour"), 62);
        carrefour.addProduct(getProductFromNameAndDesc("Foie", "Carrefour"), 42);
        carrefour.addProduct(getProductFromNameAndDesc("Langue", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Boudin (grillé)", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Jambon cuit", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Jambon fumé", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Pâté de foie gras", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Salami", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Saucisse", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Saucisson", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("pâté.rillettes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cassoulet préparé complet", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Choucroute garnie", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("poule", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("poulet", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Oie", "Carrefour"), 42);
        carrefour.addProduct(getProductFromNameAndDesc("Autruche", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Dinde", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Gibiers à poils", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Gibiers à plumes", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Ail", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Asperges", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Betteraves (rouges)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Carottes (cuites)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Céleris", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Céleris raves", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cerfeuil", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Champignons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Chicorée", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Choucroute", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Choux de Bruxelles", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Chou-fleur", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Chou rouge", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Ciboulette", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Concombre", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cornichons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cresson", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Echalotes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Endives", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Epinards", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Haricots verts", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Laitue", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Navets", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Oignons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Persil", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Poireaux", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pois", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Poivrons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pommes de terre", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Radis", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Salsifis", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Scaroles", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Tomates", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Haricots blancs secs", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Lentilles", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pois secs", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pois chiches", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Poids.cassés", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Maïs", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Riz", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Frittes chips", "Carrefour"), 72);
        carrefour.addProduct(getProductFromNameAndDesc("Abricots", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Airelles", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Ananas", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Bananes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cerises", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Citrons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Figues fraîches", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Fraises", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Framboises", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Groseilles", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Mandarines", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Melons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Oranges", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pamplemousses", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pêches", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Poires", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pommes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Prunes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Raisins", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Rhubarbes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Amandes", "Carrefour"), 42);
        carrefour.addProduct(getProductFromNameAndDesc("Arachides", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Châtaignes", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Châtaignes sèches", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Dattes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Figues sèches", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Noisettes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Noix", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pruneaux", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Bonbons divers", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cacao.super.instantané", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Chocolats", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Confitures", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Miel", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Pâtisseries", "Carrefour"), 52);
        carrefour.addProduct(getProductFromNameAndDesc("Sucre", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Compote de pommes", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Crème de marrons", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Sauce.bechamel *58/100", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Bière", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cidre", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Eaux de vie", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Limonade", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Vin (blanc 10 doux)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Vin (rouge 10)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Coca-Cola", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Jus d'oranges", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Crabe crevette", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Langouste homard", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Anchois", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Anguille", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Brochet", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Cabillaud", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Carpe", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Colin", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Dorade", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Eglefin", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Hareng", "Carrefour"), 62);
        carrefour.addProduct(getProductFromNameAndDesc("Limande et Sole", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Maquereau", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Merlan", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Perche", "Carrefour"), 42);
        carrefour.addProduct(getProductFromNameAndDesc("Raie", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Sardines", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Sardines (en conserve)", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Saumon", "Carrefour"), 82);
        carrefour.addProduct(getProductFromNameAndDesc("Saumon (en conserve)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Thon", "Carrefour"), 32);
        carrefour.addProduct(getProductFromNameAndDesc("Thon (en conserve)", "Carrefour"), 12);
        carrefour.addProduct(getProductFromNameAndDesc("Truite", "Carrefour"), 22);
        carrefour.addProduct(getProductFromNameAndDesc("Turbot", "Carrefour"), 62);



        colruyt.addProduct(getProductFromNameAndDesc("Farine d'avoine", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Farines blanche (froment)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("pain", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pain de blé (complet)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pain de seigle", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Biscottes de blé", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Biscuits ordinaires", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Biscuits secs (petits beurre)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Biscuits à la cuillère", "Colruyt"), 71);
        colruyt.addProduct(getProductFromNameAndDesc("Semoules et pâtes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Purée en sachet (poudre seule)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Purée en sachet (dans 1L lait)", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Flan.alsa avec lait demi-écrémé", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Lait entier", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Lait demi-écrémé", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Lait écrémé", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Crème", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Yoghourt", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Beurre", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Beurre.41%", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Fromage blanc, maigre 0%", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("fromage blanc 20%", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Fromage blanc, mi-gros", "Colruyt"), 41);
        colruyt.addProduct(getProductFromNameAndDesc("Fromage blanc, gras", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Fromage blanc, petit-suisse", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Brie", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Camembert", "Colruyt"), 41);
        colruyt.addProduct(getProductFromNameAndDesc("Gruyère", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Hollande", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Huiles végétales", "Colruyt"), 91);
        colruyt.addProduct(getProductFromNameAndDesc("Margarines", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Graisses animales", "Colruyt"), 61);
        colruyt.addProduct(getProductFromNameAndDesc("Mayonnaise", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Oeuf entier", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Jaune d'oeuf", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Blanc d'oeuf", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Boeufs (mi-gras)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cheval", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Mouton", "Colruyt"), 91);
        colruyt.addProduct(getProductFromNameAndDesc("Veau", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Porc", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Jambon", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Lard", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Cervelle", "Colruyt"), 91);
        colruyt.addProduct(getProductFromNameAndDesc("Coeur", "Colruyt"), 61);
        colruyt.addProduct(getProductFromNameAndDesc("Foie", "Colruyt"), 41);
        colruyt.addProduct(getProductFromNameAndDesc("Langue", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Boudin (grillé)", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Jambon cuit", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Jambon fumé", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Pâté de foie gras", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Salami", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Saucisse", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Saucisson", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("pâté.rillettes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cassoulet préparé complet", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Choucroute garnie", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("poule", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("poulet", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Oie", "Colruyt"), 41);
        colruyt.addProduct(getProductFromNameAndDesc("Autruche", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Dinde", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Gibiers à poils", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Gibiers à plumes", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Ail", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Asperges", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Betteraves (rouges)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Carottes (cuites)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Céleris", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Céleris raves", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cerfeuil", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Champignons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Chicorée", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Choucroute", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Choux de Bruxelles", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Chou-fleur", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Chou rouge", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Ciboulette", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Concombre", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cornichons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cresson", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Echalotes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Endives", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Epinards", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Haricots verts", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Laitue", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Navets", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Oignons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Persil", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Poireaux", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pois", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Poivrons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pommes de terre", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Radis", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Salsifis", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Scaroles", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Tomates", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Haricots blancs secs", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Lentilles", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pois secs", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pois chiches", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Poids.cassés", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Maïs", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Riz", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Frittes chips", "Colruyt"), 71);
        colruyt.addProduct(getProductFromNameAndDesc("Abricots", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Airelles", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Ananas", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Bananes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cerises", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Citrons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Figues fraîches", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Fraises", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Framboises", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Groseilles", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Mandarines", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Melons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Oranges", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pamplemousses", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pêches", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Poires", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pommes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Prunes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Raisins", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Rhubarbes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Amandes", "Colruyt"), 41);
        colruyt.addProduct(getProductFromNameAndDesc("Arachides", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Châtaignes", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Châtaignes sèches", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Dattes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Figues sèches", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Noisettes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Noix", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pruneaux", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Bonbons divers", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cacao.super.instantané", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Chocolats", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Confitures", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Miel", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Pâtisseries", "Colruyt"), 51);
        colruyt.addProduct(getProductFromNameAndDesc("Sucre", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Compote de pommes", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Crème de marrons", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Sauce.bechamel *58/100", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Bière", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cidre", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Eaux de vie", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Limonade", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Vin (blanc 10 doux)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Vin (rouge 10)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Coca-Cola", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Jus d'oranges", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Crabe crevette", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Langouste homard", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Anchois", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Anguille", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Brochet", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Cabillaud", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Carpe", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Colin", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Dorade", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Eglefin", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Hareng", "Colruyt"), 61);
        colruyt.addProduct(getProductFromNameAndDesc("Limande et Sole", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Maquereau", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Merlan", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Perche", "Colruyt"), 41);
        colruyt.addProduct(getProductFromNameAndDesc("Raie", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Sardines", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Sardines (en conserve)", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Saumon", "Colruyt"), 81);
        colruyt.addProduct(getProductFromNameAndDesc("Saumon (en conserve)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Thon", "Colruyt"), 31);
        colruyt.addProduct(getProductFromNameAndDesc("Thon (en conserve)", "Colruyt"), 11);
        colruyt.addProduct(getProductFromNameAndDesc("Truite", "Colruyt"), 21);
        colruyt.addProduct(getProductFromNameAndDesc("Turbot", "Colruyt"), 61);



        aldi.addProduct(getProductFromNameAndDesc("Farine d'avoine", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Farines blanche (froment)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("pain", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pain de blé (complet)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pain de seigle", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Biscottes de blé", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Biscuits ordinaires", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Biscuits secs (petits beurre)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Biscuits à la cuillère", "Aldi"), 70);
        aldi.addProduct(getProductFromNameAndDesc("Semoules et pâtes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Purée en sachet (poudre seule)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Purée en sachet (dans 1L lait)", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Flan.alsa avec lait demi-écrémé", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Lait entier", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Lait demi-écrémé", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Lait écrémé", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Crème", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Yoghourt", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Beurre", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Beurre.41%", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Fromage blanc, maigre 0%", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("fromage blanc 20%", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Fromage blanc, mi-gros", "Aldi"), 40);
        aldi.addProduct(getProductFromNameAndDesc("Fromage blanc, gras", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Fromage blanc, petit-suisse", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Brie", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Camembert", "Aldi"), 40);
        aldi.addProduct(getProductFromNameAndDesc("Gruyère", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Hollande", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Huiles végétales", "Aldi"), 90);
        aldi.addProduct(getProductFromNameAndDesc("Margarines", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Graisses animales", "Aldi"), 60);
        aldi.addProduct(getProductFromNameAndDesc("Mayonnaise", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Oeuf entier", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Jaune d'oeuf", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Blanc d'oeuf", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Boeufs (mi-gras)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cheval", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Mouton", "Aldi"), 90);
        aldi.addProduct(getProductFromNameAndDesc("Veau", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Porc", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Jambon", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Lard", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Cervelle", "Aldi"), 90);
        aldi.addProduct(getProductFromNameAndDesc("Coeur", "Aldi"), 60);
        aldi.addProduct(getProductFromNameAndDesc("Foie", "Aldi"), 40);
        aldi.addProduct(getProductFromNameAndDesc("Langue", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Boudin (grillé)", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Jambon cuit", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Jambon fumé", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Pâté de foie gras", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Salami", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Saucisse", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Saucisson", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("pâté.rillettes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cassoulet préparé complet", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Choucroute garnie", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("poule", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("poulet", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Oie", "Aldi"), 40);
        aldi.addProduct(getProductFromNameAndDesc("Autruche", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Dinde", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Gibiers à poils", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Gibiers à plumes", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Ail", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Asperges", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Betteraves (rouges)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Carottes (cuites)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Céleris", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Céleris raves", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cerfeuil", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Champignons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Chicorée", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Choucroute", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Choux de Bruxelles", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Chou-fleur", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Chou rouge", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Ciboulette", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Concombre", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cornichons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cresson", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Echalotes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Endives", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Epinards", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Haricots verts", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Laitue", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Navets", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Oignons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Persil", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Poireaux", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pois", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Poivrons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pommes de terre", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Radis", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Salsifis", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Scaroles", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Tomates", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Haricots blancs secs", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Lentilles", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pois secs", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pois chiches", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Poids.cassés", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Maïs", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Riz", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Frittes chips", "Aldi"), 70);
        aldi.addProduct(getProductFromNameAndDesc("Abricots", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Airelles", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Ananas", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Bananes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cerises", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Citrons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Figues fraîches", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Fraises", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Framboises", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Groseilles", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Mandarines", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Melons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Oranges", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pamplemousses", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pêches", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Poires", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pommes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Prunes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Raisins", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Rhubarbes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Amandes", "Aldi"), 40);
        aldi.addProduct(getProductFromNameAndDesc("Arachides", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Châtaignes", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Châtaignes sèches", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Dattes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Figues sèches", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Noisettes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Noix", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pruneaux", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Bonbons divers", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cacao.super.instantané", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Chocolats", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Confitures", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Miel", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Pâtisseries", "Aldi"), 50);
        aldi.addProduct(getProductFromNameAndDesc("Sucre", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Compote de pommes", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Crème de marrons", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Sauce.bechamel *58/100", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Bière", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cidre", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Eaux de vie", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Limonade", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Vin (blanc 10 doux)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Vin (rouge 10)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Coca-Cola", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Jus d'oranges", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Crabe crevette", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Langouste homard", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Anchois", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Anguille", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Brochet", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Cabillaud", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Carpe", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Colin", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Dorade", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Eglefin", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Hareng", "Aldi"), 60);
        aldi.addProduct(getProductFromNameAndDesc("Limande et Sole", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Maquereau", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Merlan", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Perche", "Aldi"), 40);
        aldi.addProduct(getProductFromNameAndDesc("Raie", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Sardines", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Sardines (en conserve)", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Saumon", "Aldi"), 80);
        aldi.addProduct(getProductFromNameAndDesc("Saumon (en conserve)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Thon", "Aldi"), 30);
        aldi.addProduct(getProductFromNameAndDesc("Thon (en conserve)", "Aldi"), 10);
        aldi.addProduct(getProductFromNameAndDesc("Truite", "Aldi"), 20);
        aldi.addProduct(getProductFromNameAndDesc("Turbot", "Aldi"), 60);

        insert(delhaize);
        insert(carrefour);
        insert(colruyt);
        insert(aldi);

    }
}
