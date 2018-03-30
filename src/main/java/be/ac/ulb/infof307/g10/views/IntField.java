package be.ac.ulb.infof307.g10.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class IntField extends TextField {
	private boolean signed;
	
	public boolean isSigned() {
		return signed;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	public IntField() {
		this(true);
	}
	
	public IntField(boolean signed) {
		this.signed = signed;
		// check each change
		textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.equals("") || valid(newValue)) {
					return;
				}
				setText(oldValue);
			}
		});
	}
	
	public int getInt() {
		String text = getText();
		if (text.equals("")) {
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
	
	private boolean valid(String s) {
		try {
			if (signed) {
				Integer.parseInt(s);
			} else {
				Integer.parseUnsignedInt(s);
			}
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}
