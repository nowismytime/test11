package test1.util;

import com.google.gson.Gson;



public class CommonUtils{
	
	private static Gson gson = new Gson(); //used for converting into json
	
	public static String toJson(Object obj){
		return gson.toJson(obj);           //converting object into json
	}
}


















/*import com.google.gson.Gson;

public class CommonUtils {

	private static Gson gson = new Gson();
	
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
}*/

