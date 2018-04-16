/**
 * Page de login
 */
package be.ac.ulb.infof307.g10.views;


import be.ac.ulb.infof307.g10.models.Research;
import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import be.ac.ulb.infof307.g10.models.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;


/**
 * Research page
 * @author Benjamin Nicodeme
 *
 */
public class ResearchPage {

	public void start(Stage primaryStage){
		primaryStage.setTitle("Research Page");
        //Horizontal centering
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //"product name" text field
        TextField textFieldProd = new TextField();
        textFieldProd.setPrefSize(300, 20);
        textFieldProd.setPromptText("Product name");


        TextArea storesArea = new TextArea();


        //"Research" button creation
        Button btnResearch = new Button();
        btnResearch.setText("Research");
        btnResearch.setDefaultButton(true);
        btnResearch.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//"Login" Textfield creation

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
        
        //horizontal buttons centring
        HBox hbox2 = new HBox(20,textFieldProd, btnResearch);
        //vertical centring
        VBox vbox = new VBox(titleLabel, hbox2, storesArea);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.getChildren().addAll(vbox);
        
        //main page creation
        Scene scene = new Scene(hbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
