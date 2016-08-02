package utility.reader.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import utility.reader.FileReaderFacade;

/***
 * This class will be the main function in accessing files for the input in
 * Advent Of Code.
 *
 * @author Hisoka
 *
 */
public class FileReaderImpl implements FileReaderFacade {

	private static final Logger log = Logger.getLogger(FileReaderImpl.class);

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
	public List<String> readLines(File file) {
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
			log.error("File not found!", e);
		} catch (IOException e) {
			log.error("Cannot perform I/O!", e);
		}

		return lines;
	}

	@Override
	public List<String> readWords(File file) {
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
			log.error("File not found!", e);
		} catch (IOException e) {
			log.error("Cannot perform I/O!", e);
		}

		return words;
	}
}
