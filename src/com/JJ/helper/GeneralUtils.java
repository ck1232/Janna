package com.JJ.helper;

import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

public class GeneralUtils {
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
}
