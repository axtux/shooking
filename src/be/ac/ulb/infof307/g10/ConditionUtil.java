package be.ac.ulb.infof307.g10;

import java.awt.Checkbox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConditionUtil {
	
	private String condiUtil="En naviguant sur notre site, l�internaute reconna�t avoir pris connaissance et accept� nos conditions g�n�rales d�utilisation\r\n" + 
			"\r\n" + 
			"Donn�es personnelles :\r\n" + 
			"\r\n" + 
			"Les donn�es personnelles qui peuvent vous �tre demand�es (exclusivement en vue de recevoir notre newsletter) sont vos nom pr�nom et adresse mails.\r\n" + 
			"Le traitement de ces donn�es dont le responsable est Mr J. Rolle  b�n�ficie d�une dispense de la CNIL (dispense n� 7)\r\n" + 
			"Vous pouvez faire valoir vos droits de consultation et de rectification en le contactant � l�adresse suivante [e-mail]\r\n" + 
			"Nous nous engageons � ne pas revendre ni donner ces informations qui ne sont pas conserv�es d�s lors que vous demandez � ne plus recevoir notre newsletter.\r\n" + 
			"\r\n" + 
			"Cookies :\r\n" + 
			"\r\n" + 
			"En vue d�am�liorer notre site, nous utilisons Google Analytics qui est un outil � d'analyse d'audience Internet permettant aux propri�taires de sites Web et\r\n" + "d'applications de mieux comprendre le comportement de leurs utilisateurs. Cet outil peut utiliser des cookies pour collecter des informations et g�n�rer des rapports sur les statistiques d'utilisation d'un site Web\r\n"+" sans que les utilisateurs individuels soient identifi�s personnellement par Google. \r\n" + 
			"Outre la g�n�ration de rapports sur les statistiques d'utilisation d'un site Web, Google Analytics permet �galement, en association \r\n"+" avec certains des cookies publicitaires d�crits ci-dessus, d'afficher des annonces plus pertinentes sur les sites Google (tels que la recherche Google) et sur le Web. �\r\n" + 
			"https://www.google.fr/intl/fr/policies/technologies/types/ \r\n" + 
			"Nous utilisons �galement les cookies n�cessaires � l�am�lioration de votre navigation sur notre site tenant compte exclusivement de votre navigateur.\r\n" + 
			"\r\n" + 
			"Propri�t� intellectuelle :\r\n" + 
			"\r\n" + 
			"Le site web a �t� r�alis� par notre webmaster, Mme Rose Foug�re. \r\n" + 
			"Il est la propri�t� de l�association et ne peut faire l�objet de reproduction.\r\n" + 
			"\r\n" + 
			"Photographies et contenu :\r\n" + 
			"\r\n" + 
			"Les photographies, vid�os,  textes et  illustrations  publi�s sur le site sont propri�t� de l�association ou ont fait l�objet de cession de droits.\r\n" + 
			"Ils  ne peuvent faire l�objet d�aucune r�utilisation.\r\n" + 
			"\r\n" + 
			"Liens hypertextes :\r\n" + 
			"\r\n" + 
			"Le site www[site internet] peut contenir des liens hypertextes renvoyant � des pages ou des sites dont le contenu ne peut engager en rien l�association.\r\n" + 
			"Les liens hypertextes renvoyant vers notre site sont les bienvenus lorsqu�ils �manent de sites respectant la l�gislation en vigueur.";
	
	
public ConditionUtil() {
	Stage thirdStage = new Stage();
	Group root = new Group();
	thirdStage.setTitle("condition d'utilisation");
	
	
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
     
     
     root.getChildren().add(btnOk);
     	
	thirdStage.show();
	
	}
	
	

}
