package be.ac.ulb.infof307.g10.utils;

import javafx.util.StringConverter;

/**
 * Convert a ToStringInterface into a StringConverter.
 * 
 * Can be used as a StringConverter to only implement toString method. This
 * enable lambda usage for a simpler code.
 * 
 * E.g.
 * <pre>{@code
 * 	new ToStringConverter<MyObject>((object) -> {
 * 		// return whatever you want
 * 		return object.toString();
 * 	});
 * }</pre>
 * 
 * @param <T> Object type to convert.
 */
public class ToStringConverter<T> extends StringConverter<T> {

	private ToStringInterface<T> converter;

	public ToStringConverter(ToStringInterface<T> converter) {
		if (converter == null) {
			throw new IllegalArgumentException("converter is null");
		}
		this.converter = converter;
	}

	/**
	 * Call the toString method of ToStringInterface
	 */
	@Override
	public String toString(T object) {
		return converter.toString(object);
	}

	/**
	 * Throws UnsupportedOperationException
	 */
	@Override
	public T fromString(String string) {
		throw new UnsupportedOperationException();
	}

	public interface ToStringInterface<T> {
		String toString(T object);
	}
}
