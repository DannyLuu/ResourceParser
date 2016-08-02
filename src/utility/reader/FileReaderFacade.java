package utility.reader;

import java.io.File;
import java.util.List;

/**
 *
 * @author Hisoka
 *
 */
public interface FileReaderFacade {

	/**
	 * Parses the String to return an array of Strings separated by the
	 * delimiter.
	 *
	 * @param line
	 * @param delimiter
	 * @return List of Strings separated by the delimiter.
	 */
	List<String> parseLineWithDelimeter(String line, String delimiter);

	/**
	 * Reads a file line by line and returns an Array List of Strings.
	 *
	 * @param file
	 * @return
	 */
	List<String> readLines(File file);

	/**
	 * This class will return an Array List of Strings comprised of single
	 * words. Each word is determined to be a new word when at the beginning of
	 * the file and characters following a space.
	 *
	 * @param file
	 * @return
	 */
	List<String> readWords(File file);
}
