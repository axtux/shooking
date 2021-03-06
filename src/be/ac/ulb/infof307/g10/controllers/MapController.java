package be.ac.ulb.infof307.g10.controllers;

import java.lang.Thread.UncaughtExceptionHandler;

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

import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.fxml.FXML;
import netscape.javascript.JSObject;

/**
 * Controller class of the Google Map view. It configures the map and manages the
 * markers on this map
 */
@SuppressWarnings("restriction")
public class MapController implements MapComponentInitializedListener, UncaughtExceptionHandler {

	@FXML
	ClusteredGoogleMapView mapView;
	@FXML
	private ClusteredGoogleMap map;
	@FXML
	private InfoWindow popup;

	public void initialize() {
		Thread.setDefaultUncaughtExceptionHandler(this);
		mapView.addMapInializedListener(this);
	}

	/**
	 * Catching the JavaScript Exceptions
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		if (e.getClass().getName().equals("netscape.javascript.JSException")) {
			DialogView.show(View.MAP_ERROR);
		} else {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Initialization of the map
	 */
	@Override
	public void mapInitialized() {
		// needed to debug Exception, see
		// https://gitlab.com/INFOF307-1718/Groupe10/issues/23
		try {
			// Set the initial properties of the map.
			MapOptions mapOptions = new MapOptions();
			//Centering the map on Brussels
			LatLong latLong = new LatLong(50.8504500, 4.3487800);
			mapOptions.center(latLong);
			mapOptions.mapType(MapTypeIdEnum.ROADMAP);
			mapOptions.overviewMapControl(false);
			mapOptions.panControl(false);
			mapOptions.rotateControl(false);
			mapOptions.scaleControl(false);
			mapOptions.streetViewControl(false);
			mapOptions.zoomControl(false);
			mapOptions.zoom(12);

			map = mapView.createMap(mapOptions);
			popup = new InfoWindow();

			updateInterface();

			// Add a marker to the map on right click
			map.addMouseEventHandler(UIEventType.rightclick, (GMapMouseEvent event) -> {
				// needed to debug Exception, see
				// https://gitlab.com/INFOF307-1718/Groupe10/issues/23
				try {
					createShop(event);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launching of the popup for the creation of a shop
	 * 
	 * @param event
	 *            the right click on the map
	 */
	@FXML
	private void createShop(GMapMouseEvent event) {
		CreateShopController.setPosition(event.getLatLong());
		DialogView.show(View.CREATE_SHOP, (e) -> updateInterface());
	}

	/**
	 * Adding a shop add a marker on the map
	 * 
	 * @param s
	 *            the shop to add
	 */
	private void addShopToMap(Shop s) {
		LatLong latLong = new LatLong(s.getLatitude(), s.getLongitude());
		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions.position(latLong).visible(Boolean.TRUE).title(s.getInfo());
		Marker marker = new Marker(markerOptions);
		map.addClusterableMarker(marker);
		map.addUIEventHandler(marker, UIEventType.click, (JSObject obj) -> {
			popup.setContent(marker.getTitle().replace("\n", "<br>"));
			popup.open(map, marker);
		});
	}

	/**
	 * Update of the interface removing of all the markers then query the
	 * database to obtain all the shops and render them
	 */
	private void updateInterface() {
		map.getMarkerClusterer().clearMarkers();
		for (Shop s : ShopDAO.getAll()) {
			addShopToMap(s);
		}
	}

}
