package be.ac.ulb.infof307.g10.views;

import be.ac.ulb.infof307.g10.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class correspond to the view of the Menu after the connection
 */
public class Menu {

    public Menu(Stage stage) {

        stage.setTitle("Menu");

        //Horizontal centering
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //Welcome label
        Label titleLabel = new Label("What do you want to do ?");
        titleLabel.setFont(new Font("Arial", 30));


        //creation of the product list button

        Button btnList = new Button();
        btnList.setText("See my list");
        btnList.setDefaultButton(true);
        btnList.setOnAction(new EventHandler<ActionEvent>() {
                              public void handle(ActionEvent event) {
                                  Main.getInstance().goToShoppingList();
                              }
        });

        //creation of the map button

        Button btnMap = new Button();
        btnMap.setText("See the map");
        btnMap.setDefaultButton(true);
        btnMap.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Main.getInstance().goToMenu();//change to map
            }
        });



        //buttons centering
        HBox hbox2 = new HBox(50,btnList,btnMap);
        //vetical centering
        VBox vbox = new VBox(titleLabel, hbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        hbox.getChildren().addAll(vbox);

        //Page creation
        Scene scene = new Scene(hbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
