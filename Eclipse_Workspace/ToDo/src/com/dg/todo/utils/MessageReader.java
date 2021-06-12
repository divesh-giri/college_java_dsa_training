package com.dg.todo.utils;

import java.util.ResourceBundle;
import static com.dg.todo.utils.Constants.CONFIG_BUNDLE_FILE_NAME;;

public interface MessageReader {
	ResourceBundle rb = ResourceBundle.getBundle(CONFIG_BUNDLE_FILE_NAME);
	
	public static String getValue(String key)
	{
		return rb.getString(key);
	}
}
