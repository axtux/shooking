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

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Shop;
import javafx.fxml.FXML;

import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class of the Google Map view
 * It configure the map and manage the markers on this map
 */
public class MapController extends MainController implements MapComponentInitializedListener {

    @FXML
    ClusteredGoogleMapView mapView;
    @FXML
    ClusteredGoogleMap map;
    @FXML
    InfoWindow popup;
    
    /**
     * Last LatLong clicked (Waiting for a smarter solution)
     */
    //TODO Make it smarter
    static LatLong latLong;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
    }
    

    /**
     * Initialization of the map
     */
    @Override
    public void mapInitialized() {
		// needed to debug Exception, see https://gitlab.com/INFOF307-1718/Groupe10/issues/23
        try {
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

			updateInterface();

			// Add a marker to the map on right click
			map.addMouseEventHandler(UIEventType.rightclick, (GMapMouseEvent event) -> {
				// needed to debug Exception, see https://gitlab.com/INFOF307-1718/Groupe10/issues/23
				try {
					createShop(event);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			Main.getInstance().showDialog("MapError", "Error loading map");
		}
    }

    /**
     * Launching of the popup for the creation of a shop
     * @param event the right clic on the map
     */
	@FXML
	public void createShop(GMapMouseEvent event) {
		latLong = event.getLatLong();
		Main.getInstance().showDialog("CreateShop", "Create shop");
		updateInterface();
	}

	/**
	 * Adding a shop add a marker on the map
	 * @param s the shop to add
	 */
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
	/**
	 * Update of the interface
	 * removing of all the markers then query the database to obtain all the shops and render them
	 */
	private void updateInterface(){
		map.getMarkerClusterer().clearMarkers();
		for(Shop s: Database.getAllShops()) {
			addShopToMap(s);
		}
	}
}
