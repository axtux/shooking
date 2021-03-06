package be.ac.ulb.infof307.g10.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * Integer field forces user to only enter valid integer values. If not signed,
 * only valid positive integer values are accepted.
 */
public class IntField extends TextField implements ChangeListener<String> {
	private boolean signed;

	public boolean isSigned() {
		return signed;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	public IntField() {
		this(false);
	}

	public IntField(boolean signed) {
		this.signed = signed;
		// check each change
		textProperty().addListener(this);
	}

	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		if (zeroValue(newValue) || valid(newValue)) {
			return;
		}
		setText(oldValue);
	}

	public int getInt() {
		String text = getText();
		if (zeroValue(text)) {
			return 0;
		}
		return Integer.parseInt(text);
	}

	public void setInt(int i) {
		if (!signed && i < 0) {
			i = 0;
		}
		setText(Integer.toString(i));
	}

	private boolean zeroValue(String s) {
		return (signed && "-".equals(s)) || "".equals(s);
	}

	/**
	 * Check the validity of the field
	 * @param s the text inside the field
	 * @return True if s can be parsed into a (Unsigned) Integer. False if not.
	 */
	private boolean valid(String s) {
		if (s.startsWith("+")) {
			return false;
		}
		try {
			if (signed) {
				Integer.parseInt(s);
			} else {
				Integer.parseUnsignedInt(s);
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
