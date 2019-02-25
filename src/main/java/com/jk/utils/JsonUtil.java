package com.jk.utils;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class JsonUtil {
	
	/**
	 * 将字符串转成实体类，允许斜杠等字符串
	 */
	public static <T> T jsonToEntity(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 允许反斜杆等字符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
        return mapper.readValue(json, clazz);
    }
	
	/**
	 * 实体类转JSON字符串
	 */
	public static String entityToJson(Object entity){
		return JSON.toJSONString(entity);
	}
	
	/**
	 * 将字符串转成JsonNode，允许斜杠等字符串
	 */
	public static JsonNode jsonToJsonNode(String json) {
        ObjectMapper mapper = new ObjectMapper();
        // 允许反斜杆等字符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
        //允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);
        try {
			return mapper.readValue(json, JsonNode.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public static <T> String objectToJson(Object object, Class<T> cls)throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerSubtypes(cls);
		String reqJson = mapper.writeValueAsString(object);
		return reqJson;
	}
	
}
