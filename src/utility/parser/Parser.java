package utility.parser;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import resources.ResourceModel;
import utility.reader.FileReaderFacade;

/**
 * File reader class used to read the contents of a file.
 *
 * @author Hisoka
 *
 */
public class Parser {

	private static final Logger log = Logger.getLogger(Parser.class);

	private File file;

	private FileReaderFacade inputScanner;

	public ResourceModel generateResouceFile() {
		ResourceModel resourceModel = null;
		if (file != null && file.isFile()) {
			List<String> lines = inputScanner.readLines(file);
			if (!lines.isEmpty()) {

			}
		} else {
			log.error("Cannot read file, either empty or incorrect format.");
		}

		return resourceModel;
	}

	public File getFile() {
		return file;
	}

	public void parseResource(final ResourceModel resourceModel, final List<String> resources) {

	}

	public void setFile(File file) {
		this.file = file;
	}

}
