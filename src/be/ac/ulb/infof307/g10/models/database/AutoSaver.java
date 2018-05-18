package be.ac.ulb.infof307.g10.models.database;

import java.util.Observable;
import java.util.Observer;

import be.ac.ulb.infof307.g10.models.AbstractModelObject;

/**
 * Automatically save {@link AbstractModelObject}s into database after each change.
 */
public class AutoSaver implements Observer {

	/**
	 * Instance created at load time to avoid threads synchronization. Small
	 * performance impact because empty constructor.
	 */
	private static AutoSaver instance = new AutoSaver();

	private AutoSaver() {
	}

	/**
	 * Automatically save {@link AbstractModelObject} into database after each change.
	 * @param o Object to save automatically.
	 */
	public static void autosave(AbstractModelObject o) {
		// save first
		instance.update(o, null);
		// save at each change
		o.addObserver(instance);
	}

	/**
	 * Automatically save {@link AbstractModelObject}s into database after each change.
	 * @param ol Objects to save automatically.
	 */
	public static void autosave(Iterable<? extends AbstractModelObject> ol) {
		for (AbstractModelObject o : ol) {
			autosave(o);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Database.save((AbstractModelObject) o);
	}

}
