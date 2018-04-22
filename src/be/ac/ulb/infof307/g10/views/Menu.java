package be.ac.ulb.infof307.g10.views;

import be.ac.ulb.infof307.g10.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.geometry.Pos.TOP_CENTER;

/**
 * This class correspond to the view of the Menu after the connection
 */
public class Menu {

    public Menu(Stage stage) {

        stage.setTitle("Menu");


        BorderPane bpane = new BorderPane();

        //Welcome label
        Label titleLabel = new Label("Select your choice");
        titleLabel.setFont(new Font("Arial", 30));


        //Horizontal centering
        HBox hbox = new HBox(50,titleLabel);
        hbox.setAlignment(Pos.CENTER);

        //creation of the product list button
        Button btnList = new Button();
        btnList.setText("See the list");
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
                Main.getInstance().goToMap();
            }
        });


        //buttons centering

        //vetical centering of the choice buttons
        VBox vbox = new VBox(btnList,btnMap);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        //set the position of each part

        bpane.setTop(hbox);
        bpane.setCenter(vbox);

        //Page creation
        Scene scene = new Scene(bpane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
