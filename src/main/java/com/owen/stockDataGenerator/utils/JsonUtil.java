package com.owen.stockDataGenerator.utils;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 描述：JSON工具类<br>
 * 作者：王欣逸 100992995@qq.com<br>
 * 创建时间：2013年11月16日 下午5:03:48<br>
 * 版本：v1.0<br>
 */
//@Controller
public final class JsonUtil {
	/** json工厂类 */
	private static JsonFactory jsonFactory = new JsonFactory();
	private static ObjectMapper mapper = null;

	static {
		jsonFactory.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		jsonFactory.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper = new ObjectMapper(jsonFactory);
		mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ;
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static JsonFactory getJsonFactory() {
		return jsonFactory;
	}

	public static <T> T toBean(String json, Class<T> clazz) {
		T rtv = null;
		try {
			//System.out.println(mapper);
			rtv = mapper.readValue(json, clazz);
		} catch (Exception ex) {
			throw new IllegalArgumentException("json将json字符串转化成对象出错", ex);
		}
		return rtv;
	}

	public static String toJson(Object bean) {
		String rtv = null;
		try {
			rtv = mapper.writeValueAsString(bean);
		} catch (Exception ex) {
			throw new IllegalArgumentException("java bean将bean转化成json字符串出错", ex);
		}
		return rtv;
	}
	
	public static void toJson(Object bean,OutputStream output){
		try {
			mapper.writeValue(output, bean);
		} catch (IOException e) {
			throw new IllegalArgumentException("java bean将bean转化成json字符串出错", e);
		}
	}
	
	public static String Obj2Json(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("将Object对象转化成json字符串出错", e);
		}  
	}
}