package com.JJ.helper;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

public class GeneralUtils {
	public static final String DELETED = "Y";
	public static final String NOT_DELETED = "N";
	public static final String IS_PARENT = "Y";
	public static final String IS_NOT_PARENT = "N";
	public static final String ALLOW_DISPLAY = "Y";
	public static final String NOT_ALLOW_DISPLAY = "N";
	public static final String MODE_BATCH = "BATCH";
	public static final String MODE_ADHOC = "ADHOC";
	public static final String STATUS_PENDING = "PENDING";
	public static final String BOUNCED = "Y";
	public static final String UNBOUNCED = "N";
	public static final String TYPE_SALARY = "Salary";
	public static final String TYPE_BONUS = "Bonus";
	
	private static final Logger logger = Logger.getLogger(GeneralUtils.class);	
	public static <T> String convertListToJSONString(List<T> list){
		return  convertListToJSONObject(list).toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> JSONObject convertListToJSONObject(List<T> list){
		Gson gson = new GsonBuilder().serializeNulls().create();
		JsonArray result = (JsonArray) gson.toJsonTree(list,
	            new TypeToken<List<T>>() {}.getType());
		JSONObject obj = new JSONObject();
		obj.put("data", result);
		return obj;
		
	}
	
	public static <T> Map<String, T> convertListToStringMap(Collection<T> list, String attribute) {
	   Map<String, T> map = new HashMap<String, T>();
	   for (T obj : list) {
		   Class<?> clazz = obj.getClass();
		   try{
			   Field field = clazz.getField(attribute);
			   String fieldValue = (String)field.get(obj);
			   map.put(fieldValue.toString(), obj);
		   }catch(Exception ex){
			   logger.error(ex.getStackTrace());
		   }
	       
	   }   
	   return map;
	}
	
	public static <T> Map<Integer, T> convertListToIntegerMap(List<T> list, String attribute) {
		   Map<Integer, T> map = new HashMap<Integer, T>();
		   for (T obj : list) {
			   Class<?> clazz = obj.getClass();
			   try{
				   Field field = clazz.getField(attribute);
				   Integer fieldValue = Integer.parseInt((String)field.get(obj));
				   map.put(fieldValue, obj);
			   }catch(Exception ex){
				   ex.printStackTrace();
				   logger.error(ex.getMessage());
			   }
		       
		   }   
		   return map;
		}
	
	public static String convertDateToString(Date date, String formatString){
		String dateString = "";
		try{
			dateString = new SimpleDateFormat(formatString).format(date);
		}catch(Exception e){
			logger.info("Error converting date to string.");
		}
		return dateString;
	}
	
}
