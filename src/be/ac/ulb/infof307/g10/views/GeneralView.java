package be.ac.ulb.infof307.g10.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * This class is used to create different views with the same template (border
 * plane with a menu) It is useful to permit a uniformity of the different pages
 * of the application The menu used has a defined structure in the file
 * Menu.fxml (resources package) If it is modified, some method used here should
 * not work anymore. They have to be modified in this case
 */
public class GeneralView extends Parent {

	protected Parent centerPage;
	protected AnchorPane menu;

	public GeneralView(Stage stage, String centerPage, String menu) {

		this.centerPage = loadFXML(centerPage);
		this.menu = (AnchorPane) loadFXML(menu);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(this.centerPage);
		borderPane.setTop(this.menu);

		// creation of the scene and configuration
		Scene scene = new Scene(borderPane);
		stage.setTitle("Shooking (shopping and cooking)");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * This function is used to load the corresponding Parent class of the fxml
	 * representing a view
	 * 
	 * @param name
	 *            The String name of the fxml file located in the resource
	 *            package You should not put the .fxml extension, only the name
	 * @return A Parent node corresponding to the root node of the view
	 */
	private Parent loadFXML(String name) {
		try {

			return FXMLLoader.load(getClass().getResource("/FXML/" + name + ".fxml"));

		} catch (IOException e) {
			// never happens as resource is packed within application
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method is used to disable the buttons not wanted in the general menu
	 * (see Menu fxml) It really depends of the structure of the menu, if the
	 * menu view is modified, this function may not work anymore
	 * 
	 * @param btns
	 *            A list of String representing the id of the buttons we want to
	 *            disable
	 */
	public void disableButtons(List<String> btns) {
		// the container of menu buttons
		HBox menuBar = (HBox) menu.getChildren().get(0);

		for (Node btn : menuBar.getChildren()) {
			if (btns.contains(btn.getId())) {
				btn.setDisable(true);
			}
		}

	}

}
