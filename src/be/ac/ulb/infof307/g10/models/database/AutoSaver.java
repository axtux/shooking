package be.ac.ulb.infof307.g10.models.database;

import java.util.Observable;
import java.util.Observer;

import be.ac.ulb.infof307.g10.models.AbstractObject;

/**
 * Automatically save {@link AbstractObject}s into database after each change.
 */
final public class AutoSaver implements Observer {

	/**
	 * Instance created at load time to avoid threads synchronization. Small
	 * performance impact because empty constructor.
	 */
	private static final AutoSaver instance = new AutoSaver();

	private AutoSaver() {
	}

	/**
	 * Automatically save {@link AbstractObject} into database after each
	 * change. Singleton instance of this class is used to allow multiple call
	 * to this function while keeping only one observer on object.
	 * 
	 * @param o
	 *            Object to save automatically.
	 */
	public static void autosave(AbstractObject o) {
		// save first
		instance.update(o, null);
		// save at each change
		o.addObserver(instance);
	}

	/**
	 * Same as {@link #autosave(AbstractObject)} for multiple objects.
	 * 
	 * @param ol
	 *            Objects to save automatically.
	 */
	public static void autosave(Iterable<? extends AbstractObject> ol) {
		for (AbstractObject o : ol) {
			autosave(o);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Database.save((AbstractObject) o);
	}

}
