package utility.reader.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import utility.reader.service.FileReaderService;

/***
 * This class will be the main function in accessing files for the input in
 * Advent Of Code.
 *
 * @author Hisoka
 *
 */
public class FileReaderServiceImpl implements FileReaderService {

	private static final Logger LOG = Logger.getLogger(FileReaderServiceImpl.class);

	@Override
	public Properties generateProperties(final File file) {
		Properties prop = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			prop.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}
		return prop;
	}

	@Override
	public List<String> parseLineWithDelimeter(String line, String delimeter) {
		String delimiter = "[" + delimeter + "]+";
		List<String> words = new ArrayList<String>();
		String[] dimensions = line.split(delimiter);

		for (String word : dimensions) {
			words.add(word);
		}

		return words;
	}

	@Override
	public List<String> readLines(final File file) {
		List<String> lines = new ArrayList<String>();
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			LOG.error("File not found!", e);
		} catch (IOException e) {
			LOG.error("Cannot perform I/O!", e);
		}

		return lines;
	}

	@Override
	public List<String> readWords(final File file) {
		BufferedReader bufferedReader = null;
		List<String> words = new ArrayList<String>();

		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				words.addAll(parseLineWithDelimeter(line, " "));
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			LOG.error("File not found!", e);
		} catch (IOException e) {
			LOG.error("Cannot perform I/O!", e);
		}

		return words;
	}
}
