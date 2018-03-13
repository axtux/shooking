package be.ac.ulb.infof307.g10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.charset.Charset;

public class ConditionUtil {
	
	private String condiUtil= "En naviguant sur notre site, l’internaute reconnaît avoir pris connaissance et accepté nos conditions générales d’utilisation\r\n" +
            "\r\n" +
            "Données personnelles :\r\n" +
            "\r\n" +
            "Les données personnelles qui peuvent vous être demandées (exclusivement en vue de recevoir notre newsletter) sont vos nom prénom et adresse mails.\r\n" +
            "Le traitement de ces données dont le responsable est Mr J. Rolle  bénéficie d’une dispense de la CNIL (dispense n° 7)\r\n" +
            "Vous pouvez faire valoir vos droits de consultation et de rectification en le contactant à l’adresse suivante [e-mail]\r\n" +
            "Nous nous engageons à ne pas revendre ni donner ces informations qui ne sont pas conservées dès lors que vous demandez à ne plus recevoir notre newsletter.\r\n" +
            "\r\n" +
            "Cookies :\r\n" +
            "\r\n" +
            "En vue d’améliorer notre site, nous utilisons Google Analytics qui est un outil « d'analyse d'audience Internet permettant aux propriétaires de sites Web et\r\n" + "d'applications de mieux comprendre le comportement de leurs utilisateurs. Cet outil peut utiliser des cookies pour collecter des informations et générer des rapports sur les statistiques d'utilisation d'un site Web\r\n"+" sans que les utilisateurs individuels soient identifiés personnellement par Google. \r\n" +
            "Outre la génération de rapports sur les statistiques d'utilisation d'un site Web, Google Analytics permet également, en association \r\n"+" avec certains des cookies publicitaires décrits ci-dessus, d'afficher des annonces plus pertinentes sur les sites Google (tels que la recherche Google) et sur le Web. »\r\n" +
            "https://www.google.fr/intl/fr/policies/technologies/types/ \r\n" +
            "Nous utilisons également les cookies nécessaires à l’amélioration de votre navigation sur notre site tenant compte exclusivement de votre navigateur.\r\n" +
            "\r\n" +
            "Propriété intellectuelle :\r\n" +
            "\r\n" +
            "Le site web a été réalisé par notre webmaster, Mme Rose Fougère. \r\n" +
            "Il est la propriété de l’association et ne peut faire l’objet de reproduction.\r\n" +
            "\r\n" +
            "Photographies et contenu :\r\n" +
            "\r\n" +
            "Les photographies, vidéos,  textes et  illustrations  publiés sur le site sont propriété de l’association ou ont fait l’objet de cession de droits.\r\n" +
            "Ils  ne peuvent faire l’objet d’aucune réutilisation.\r\n" +
            "\r\n" +
            "Liens hypertextes :\r\n" +
            "\r\n" +
            "Le site www[site internet] peut contenir des liens hypertextes renvoyant à des pages ou des sites dont le contenu ne peut engager en rien l’association.\r\n" +
            "Les liens hypertextes renvoyant vers notre site sont les bienvenus lorsqu’ils émanent de sites respectant la législation en vigueur.".getBytes(Charset.defaultCharset());

	
	
public ConditionUtil() {
	Stage thirdStage = new Stage();
	Group root = new Group();
	thirdStage.setTitle("Conditions d'utilisation");
	
	
	Text t = new Text();
	t.setText(condiUtil);
	


	root.getChildren().add(t);
	
    Scene scene = new Scene(root);
	thirdStage.setScene(scene);
	

	
	 Button btnOk = new Button();
     btnOk.setText("I accept this conditions");
     btnOk.setDefaultButton(true);
     btnOk.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
        	 IntCreateAcount intCreateAcount = new IntCreateAcount();
        	 thirdStage.close();
         }
     });
     
 	VBox vbox = new VBox(t,btnOk);
     root.getChildren().add(vbox);
     vbox.setAlignment(Pos.CENTER);
     vbox.setSpacing(10);
     	
	thirdStage.show();
	
	}
	
	

}
