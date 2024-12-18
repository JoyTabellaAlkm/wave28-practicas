package com.mercadolibre.sprint1.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.Field;

public class CResourceUtils {

	public static final ObjectMapper MAPPER = new ObjectMapper()
			.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
			.registerModule(new JavaTimeModule())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public static boolean validateRequestBody(Object object){
		if(object == null) return false;

		Field[] fields = object.getClass().getDeclaredFields();

		for(Field field:fields){
			field.setAccessible(true);
			try{
				if (field.get(object) == null){
					return false;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return true;
	}
}
