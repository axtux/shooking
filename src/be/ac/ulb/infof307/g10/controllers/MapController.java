package be.ac.ulb.infof307.g10.controllers;

import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Shop;
import javafx.fxml.FXML;

import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController extends MainController implements MapComponentInitializedListener {

    @FXML
    ClusteredGoogleMapView mapView;
    @FXML
    ClusteredGoogleMap map;
    @FXML
    InfoWindow popup;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
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

		for(Shop s: Database.getAllShops()) {
			addShopToMap(s);
		}

		// Add a marker to the map on right click
		map.addMouseEventHandler(UIEventType.rightclick, (GMapMouseEvent event) -> {
			createShop(event);
		});
    }

	@FXML
	public void createShop(GMapMouseEvent event) {
		LatLong latLong = event.getLatLong();
		//TODO create shop at position latLong
		System.out.println("TODO create shop");
		//addShopToMap(s);
	}

	private void addShopToMap(Shop s) {
		LatLong latLong = new LatLong(s.getLatitude(), s.getLongitude());
		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions.position(latLong).visible(Boolean.TRUE).title(s.getInfos());
		Marker marker = new Marker(markerOptions);
		map.addClusterableMarker(marker);
		
		map.addUIEventHandler(marker, UIEventType.click, (JSObject obj) -> {
			popup.setContent(marker.getTitle().replace("\n", "<br>"));
			popup.open(map, marker);
		});
	}
}
