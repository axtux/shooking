package be.ac.ulb.infof307.g10.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * This class is used to create different views with the same template (border plane with a menu)
 * It is usefull to permit a uniformity of the different pages of the application
 */
public class GeneralView extends Parent {

    private Stage stage;
    protected AnchorPane centerPage;
    protected AnchorPane menu;

    public GeneralView(Stage stage, String centerPage, String menu){

        this.stage=stage;
        this.centerPage= (AnchorPane) loadFXML(centerPage);
        this.menu=(AnchorPane) loadFXML(menu);

        BorderPane borderPane= new BorderPane();
        borderPane.setCenter(this.centerPage);
        borderPane.setTop(this.menu);

        //creation of the scene and configuration
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
        update();
    }

    private Parent loadFXML(String name) {
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(name+".fxml"));

            return root;
            //Scene scene = new Scene(root);
            //stage.setScene(scene);
            //stage.show();

        } catch (IOException e) {
            // never happens as resource in packed with application
            e.printStackTrace();
        }
        return null;
    }

    private void update() {
        stage.centerOnScreen();
    }

    public void disableButtons(String[] btns ) {
        for (String b : btns) {
            //menu.getChildren();
            //System.out.println(hBox.);
            //btn.setDisable(true);
            //tu dois trover un moyen d'aller chercher les boutons que tu veux
        }
    }

    public void setTitle(String t) {
        Node title = menu.lookup("titlePage");
        Label modifiedTitle = (Label) title;
        modifiedTitle.setText(t);
    }
}
