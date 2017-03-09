package org.fun.guess.util.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GlobalConfigContainer {

	private static Properties globalConfig = null;

	private final static Logger logger = LoggerFactory.getLogger(GlobalConfigContainer.class);

	static {
		if (globalConfig == null) {
			synchronized (GlobalConfigContainer.class) {
				if (globalConfig == null) {
					globalConfig = new Properties();
					String configPath = null;
					try {
						PropertiesReader.readCurrentDirFile(globalConfig, GlobalDocConstant.CLASS_RESOURCES_PATH);
					} catch (Exception e) {
						logger.error(e.toString(), e);
					}
				}
			}
		}
	}

	public static String getConfig(String key) {
		if (globalConfig.containsKey(key)) {
			return globalConfig.getProperty(key).trim();
		} else {
			logger.error("config of {} is null. Please check", key);
			return null;
		}
	}

}
