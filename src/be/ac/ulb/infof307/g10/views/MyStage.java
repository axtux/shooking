package be.ac.ulb.infof307.g10.views;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyStage extends Stage {

	public MyStage() {
		super();
		// use dummy pane (root needed in scene)
		setScene(new Scene(new Pane()));
	}

	public static Point2D getScreenCenter() {
		Rectangle2D bounds = Screen.getPrimary().getBounds();
		double centerX = bounds.getMinX() + bounds.getWidth() / 2;
		double centerY = bounds.getMinY() + bounds.getHeight() / 2;
		return new Point2D(centerX, centerY);
	}

	public Point2D getCenter() {
		double centerX = getX() + getWidth() / 2;
		double centerY = getY() + getHeight() / 2;
		return new Point2D(centerX, centerY);
	}

	public void setCenter(Point2D center) {
		setX(center.getX() - getWidth() / 2);
		setY(center.getY() - getHeight() / 2);
		// force refresh, if removed, X and Y are not updated
		setHeight(getHeight() + 1);
	}

	@Override
	public void centerOnScreen() {
		setCenter(getScreenCenter());
	}

	public void setRoot(Parent value) {
		getScene().setRoot(value);
		sizeToScene();
	}

	public void hideOnEscape() {
		// hide on escape key
		Stage self = this;
		getScene().setOnKeyPressed((event) -> {
			if (event.getCode() == KeyCode.ESCAPE) {
				self.hide();
			}
		});
	}
}
