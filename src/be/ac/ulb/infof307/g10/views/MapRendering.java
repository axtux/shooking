package be.ac.ulb.infof307.g10.views;

import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import be.ac.ulb.infof307.g10.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class MapRendering implements MapComponentInitializedListener {
	ClusteredGoogleMapView mapView;
	ClusteredGoogleMap map;
	InfoWindow popup;

	public MapRendering(Stage stage) {
		// creation of the map
		mapView = new ClusteredGoogleMapView();
		mapView.addMapInializedListener(this);

		// creation button logout
		Button btnLogout = new Button();
		btnLogout.setText("Logout");
		btnLogout.setDefaultButton(true);
		btnLogout.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Main.getInstance().goToLogin();
			}
		});

		// creation button go back menu
		Button btnGoBack = new Button();
		btnGoBack.setText("Go back to the Menu");
		btnGoBack.setDefaultButton(true);
		btnGoBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Main.getInstance().goToMenu();
			}
		});

		// organization of the view
		VBox vbox = new VBox(btnGoBack, btnLogout);
		vbox.setAlignment(Pos.TOP_RIGHT);
		vbox.setSpacing(10);

		BorderPane bpane = new BorderPane();
		bpane.setCenter(mapView);
		bpane.setRight(vbox);

		// creation of the scene and configuration
		Scene scene = new Scene(bpane);
		stage.setTitle("Maps");
		stage.setScene(scene);
		stage.show();
	}

	public void markerHandler(GMapMouseEvent event) {
		LatLong latLong = event.getLatLong();
		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(latLong).visible(Boolean.TRUE).title("My Marker");

		Marker marker = new Marker(markerOptions);// need to be save on the database
		map.addClusterableMarker(marker);

		// popup
		popup.setContent("Hello world");
		popup.open(map, marker);
		map.addUIEventHandler(marker, UIEventType.click, (JSObject obj) -> {
			popup.open(map, marker);
		});
	}

	@Override
	public void mapInitialized() {
		// Set the initial properties of the map.
		MapOptions mapOptions = new MapOptions();
		LatLong latLong = new LatLong((double) 50.8504500, (double) 4.3487800);
		mapOptions.center(latLong)
			.mapType(MapTypeIdEnum.ROADMAP)
			.overviewMapControl(false)
			.panControl(false)
			.rotateControl(false)
			.scaleControl(false)
			.streetViewControl(false)
			.zoomControl(false)
			.zoom(12);

		map = mapView.createMap(mapOptions);
		popup = new InfoWindow();

		// Add a marker to the map on right clic
		map.addMouseEventHandler(UIEventType.rightclick, (GMapMouseEvent event) -> {
			markerHandler(event);
		});

	}

};
