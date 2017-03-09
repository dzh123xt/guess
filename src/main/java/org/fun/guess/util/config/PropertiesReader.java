package org.fun.guess.util.config;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {

	private final static Logger logger = LoggerFactory.getLogger(PropertiesReader.class);

	private final static String prop_suffix = ".properties";

	public static Properties readPath(String filePath) throws Exception {
		Properties prop = new Properties();

		File root = new File(filePath);
		readFile(prop, root);

		return prop;
	}

	public static void readFile(Properties prop, String pathName) throws IOException {
		File file = new File(pathName);
		if (file.exists()) {
			readFile(prop, file);
		} else {
			logger.warn("{} is not exist.", pathName);
		}
	}

	public static void readFile(Properties prop, File file) throws IOException {
		if (file.isFile()) {
			if (file.getName().endsWith(prop_suffix)) {
				logger.debug("load file:{}", file.getName());
				InputStream in = null;
				try {
					in = new BufferedInputStream(new FileInputStream(file));
					prop.load(in);
				} finally {
					if (in != null) {
						in.close();
					}
				}
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				readFile(prop, f);
			}
		}
	}

	public static void readCurrentDirFile(Properties prop, String pathname) throws IOException {
		File rootFile = new File(pathname);
		logger.debug("load config file in {}", pathname);
		if (rootFile.isDirectory()) {
			File[] files = rootFile.listFiles();
			for (File file : files) {
				if (file.getName().endsWith(prop_suffix)) {
					logger.debug("load file :{}/{}", pathname, file.getName());
					InputStream in = null;
					try {
						in = new BufferedInputStream(new FileInputStream(file));
						prop.load(in);
					} finally {
						if (in != null) {
							in.close();
						}
					}
				}
			}
		}
	}

	/**
	 * 读取绝对路径
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static Properties read(String fileName) throws Exception {
		Properties prop = null;
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
			prop = new Properties();
			prop.load(in);
		} catch (FileNotFoundException e) {
			logger.error("file {} not exist", fileName);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return prop;
	}

	public static Properties read(InputStream in) throws IOException {
		Properties prop = new Properties();
		prop.load(in);
		return prop;
	}
}
