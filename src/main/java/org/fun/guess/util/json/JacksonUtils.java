package org.fun.guess.util.json;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;

import org.fun.guess.entity.UserEntity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class JacksonUtils {

	private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static ObjectMapper objectMapper = null;

	static {
		objectMapper = ObjectMapperUtil.getDefaultInstance();
		objectMapper.setTimeZone(TimeZone.getDefault());
		objectMapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
	}

	public static String entity2Json(Object bean) throws IOException {
		if (bean == null) {
			return null;
		}

		JsonGenerator gen = null;

		try {
			StringWriter writer = new StringWriter();
			gen = objectMapper.getFactory().createGenerator(writer);
			objectMapper.writeValue(gen, bean);
			String json = writer.toString();
			return json;
		} finally {
			if (gen != null) {
				gen.close();
			}
		}
	}

	public static <T> T json2Entity(String json, Class<T> classz) throws IOException {
		T t = objectMapper.readValue(json, classz);
		return t;
	}

	public static <T> T json2Entity(String json, TypeReference<T> type) {
		try {
			T t = objectMapper.readValue(json, type);
			return t;
		} catch (IOException e) {
			throw new IllegalArgumentException(json, e);
		}
	}

	public static Map<String, Object> json2Map(String json) {
		return JacksonUtils.json2Entity(json, new TypeReference<Map<String, Object>>() {
		});
	}

	@SuppressWarnings("unchecked")
	public static <T> T castNode(Class<?> jsonNode, Class<T> classz) throws Exception {
		if (classz.isAssignableFrom(jsonNode)) {
			return (T) classz;
		}
		throw new ClassCastException("can not cast " + classz + " to " + jsonNode);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getNode(JsonNode jsonNode, String fieldName) throws Exception {
		JsonNode rootNode = jsonNode.get(fieldName);
		return (T) rootNode;
	}

	public static String getAttributeToString(String content, String fieldName)
			throws JsonProcessingException, IOException {
		JsonNode root = objectMapper.readTree(content);
		JsonNode jsonNode = root.get(fieldName);
		if (jsonNode instanceof TextNode) {
			return jsonNode.asText();
		}
		return null;
	}

	public static int getAttributeToInt(String content, String fieldName) throws JsonProcessingException, IOException {
		JsonNode root = objectMapper.readTree(content);
		JsonNode jsonNode = root.get(fieldName);
		if (jsonNode instanceof IntNode) {
			return jsonNode.asInt();
		}
		return -1;
	}

	public static boolean getAttributeToBoolean(String content, String fieldName)
			throws JsonProcessingException, IOException {
		JsonNode root = objectMapper.readTree(content);
		return getAttributeToBoolean(root, fieldName);
	}

	public static boolean getAttributeToBoolean(JsonNode root, String fieldName)
			throws JsonProcessingException, IOException {
		JsonNode jsonNode = root.get(fieldName);
		if (jsonNode instanceof BooleanNode) {
			return jsonNode.booleanValue();
		}
		return false;
	}

	public static int getAttributeToInt(JsonNode root, String fieldName) {
		JsonNode jsonNode = root.get(fieldName);
		if (jsonNode == null || jsonNode.asText() == null) {
			return -1;
		} else if (jsonNode instanceof IntNode) {
			return jsonNode.asInt();
		}
		return -1;
	}

	public static JsonNode json2Node(String content) throws JsonProcessingException, IOException {
		return objectMapper.readTree(content);
	}

	public static String getAttribute(JsonNode root, String fieldName) {
		JsonNode jsonNode = root.get(fieldName);
		if (jsonNode == null || jsonNode instanceof TextNode) {
			return jsonNode.asText();
		}
		return null;
	}

	public static ObjectNode newObjectNode() {
		ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
		return objectNode;
	}

	public static String toString(Object object) {
		try {
			return entity2Json(object);
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		UserEntity user = new UserEntity();
		user.setId(1L);
		user.setUserName("aa");
		System.out.println(entity2Json(user));
	}
}