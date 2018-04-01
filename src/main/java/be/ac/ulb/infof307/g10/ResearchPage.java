/**
 * Page de login
 */
package be.ac.ulb.infof307.g10;


import be.ac.ulb.infof307.g10.Objects.Product;
import be.ac.ulb.infof307.g10.Objects.Shop;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Research page
 * @author Benjamin Nicodeme
 *
 */
public class ResearchPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Research Page");
		//Centrage horizontal des champs de texte et boutons
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //Création du champ "Product"
        TextField textFieldProd = new TextField();
        textFieldProd.setPrefSize(300, 20);
        textFieldProd.setPromptText("Product name");


        TextArea storesArea = new TextArea();


        //Création du bouton "Research"
        Button btnResearch = new Button();
        btnResearch.setText("Research");
        btnResearch.setDefaultButton(true);
        btnResearch.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//Récupération du champ "Login"

                List<Product> pl = DatabaseFacade.getProducts(textFieldProd.getText());
                Research r = new Research();
                List<Shop> sl = r.getStoreWithProducts(pl);
                for (Shop s: sl) {
                    storesArea.setText(storesArea.getText() + s.getName() +"\n");
                }
            }
        });




        //Welcome label
        Label titleLabel = new Label("Here is the research product page");
        titleLabel.setFont(new Font("Arial", 20));
        
        //Centrage des deux boutons
        HBox hbox2 = new HBox(20,textFieldProd, btnResearch);
        //Centrage vertical des champs de texte et boutons
        VBox vbox = new VBox(titleLabel, hbox2, storesArea);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.getChildren().addAll(vbox);
        
        //Création de la page principale
        Scene scene = new Scene(hbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
