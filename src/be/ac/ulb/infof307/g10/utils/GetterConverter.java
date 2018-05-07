package be.ac.ulb.infof307.g10.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.util.StringConverter;

public class GetterConverter<T> extends StringConverter<T> {

	private Method getter;
	
	/**
	 * Use this method to get a String converter which toString method will invoke the getParameter
	 * on objects of class type.
	 * @param type Type of class to convert
	 * @param parameter Parameter to be get
	 * @return StringConverter
	 */
	public static <T> StringConverter<T> create(Class<T> type, String parameter) {
		return new GetterConverter<T>(type, parameter);
	}
	
	private GetterConverter(Class<T> type, String parameter) {
		// get camelCase getter name
		String getterName = "get"+parameter.substring(0, 1).toUpperCase()+parameter.substring(1);
		try {
			getter = type.getDeclaredMethod(getterName);
		} catch (NoSuchMethodException | SecurityException e) {
			// programmer should only use this method with known getters
			throw new RuntimeException("no such method "+getterName+" for object "+type.getName(), e);
		}
		if(getter.getReturnType() != String.class) {
			throw new RuntimeException("method "+getterName+" should return a String");
		}
	}
	@Override
	public String toString(T object) {
		try {
			return (String) getter.invoke(object);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// programmer should only use this method with known getters
			throw new RuntimeException("error invoking "+getter.getName()+" on object "+object, e);
		}
	}

	@Override
	public T fromString(String string) {
		throw new UnsupportedOperationException();
	}

}
