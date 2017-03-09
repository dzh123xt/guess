package org.fun.guess.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

	private static ObjectMapper mapper;

	/**
	 * 给定参数createNew，如果是true，那就创建一个新的Mapper并返回。</br>
	 * 如果为false，那么久取默认的mapper，如果是第一次访问则mapper为null，那么new一个。否则直接返回。 </br>
	 * 通过synchronized保证默认mapper只有一份。
	 * 
	 * @param createNew
	 * @return
	 */
	public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
		if (createNew) {
			return new ObjectMapper();
		} else if (mapper == null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}

	public static synchronized ObjectMapper getDefaultInstance() {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}
}
