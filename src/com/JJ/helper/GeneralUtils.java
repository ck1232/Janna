package com.JJ.helper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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
	public static final String TYPE_SALARY_BONUS = "SalaryBonus";
	public static final String TYPE_BONUS = "Bonus";
	public static final String YES_IND = "Y";
	public static final String NO_IND = "N";
	public static final String NONE = "NONE";
	public static final String KEYWORD_STOCK_CHINA = "china";
	
	public static final String MODULE_SALARY_BONUS = "salarybonus";
	public static final String MODULE_SALARY = "salary";
	public static final String MODULE_BONUS = "bonus";
	public static final String MODULE_EXPENSE = "expense";
	public static final String MODULE_INVOICE = "invoice";
	public static final String MODULE_GRANT = "grant";
	
	public static final String STANDARD_DATE_FORMAT = "dd/MM/yyyy";
	public static final String SALARY_DATE_FORMAT = "MM-yyyy";
	public static final String BONUS_DATE_FORMAT = "yyyy";
	
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
	
	
	public static synchronized String getHtmlRows(ResultSet results) throws SQLException{
        StringBuffer htmlRows = new StringBuffer();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();

        htmlRows.append("<tr>");
        for (int i = 1; i <= columnCount; i++)
            htmlRows.append("<td><b>"
                + metaData.getColumnName(i) + "</td>");
        htmlRows.append("</tr>");

        while (results.next()){
            htmlRows.append("<tr>");
            for (int i = 1; i <= columnCount; i++)
                htmlRows.append("<td>"
                    + results.getString(i) + "</td>");
        }
        htmlRows.append("</tr>");
        return htmlRows.toString();
	}
	
	public static String convertDateToString(Date date, String formatString){
		String dateString = "";
		try{
			dateString = new SimpleDateFormat(formatString).format(date);
		}catch(Exception e){
			logger.info("Error converting date to string. Format:"+ formatString + ", Date : " + ((date == null) ? "null" : date.toString()) );
		}
		return dateString;
	}
	
	public static Date convertStringToDate(String dateString, String formatString){
		Date date = null;
		try{
			date = new SimpleDateFormat(formatString).parse(dateString);
		}catch(Exception e){
			logger.info("Error converting string to date.");
		}
		return date;
	}
	
	public static BindingResult validate(Object obj, String form, BindingResult result){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Object>> violations = validator.validate(obj);
		List<String> errorComponent = new ArrayList<String>();
		for (ConstraintViolation<Object> violation : violations) 
        {
			String propertyPath = violation.getPropertyPath().toString();
			if(errorComponent.contains(propertyPath)){
				continue;
			}
			errorComponent.add(propertyPath);
            String[] codes = new String[]{violation.getMessage()};
            Object[] argument = new Object[]{};
            Object rejectedValue = violation.getInvalidValue();
            result.addError(new FieldError(form,propertyPath,rejectedValue,false, codes, argument,new String()));
        }
		return result;
	}
	
	public static Date getCurrentDate(){
		return new Date();
	}
	
	public static Date getNewDate(Integer noOfYears){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, noOfYears); // to get previous year add -1
		return cal.getTime();
	}
	
	public static boolean isInteger(String id){
		try{
			Integer.valueOf(id);
			return true;
		}catch(Exception ex){
			
		}
		return false;
	}
}
