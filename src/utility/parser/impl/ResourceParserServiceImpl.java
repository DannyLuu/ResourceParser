package utility.parser.impl;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import resources.ResourceModel;
import utility.parser.ResourceParserServiceFacade;
import utility.reader.FileReaderFacade;

public class ResourceParserServiceImpl implements ResourceParserServiceFacade {

	private static final Logger log = Logger.getLogger(ResourceParserServiceImpl.class);

	@Autowired
	private FileReaderFacade fileReader;

	private String header;

	@Override
	public ResourceModel generateResourceFromFile(File resourceFile) {
		// Use this... don't reinvent the wheel.
		// Properties property = new Properties();

		ResourceModel resource = new ResourceModel();
		List<String> lines = null;

		// Initialize the ResourceModel with file information.
		if (resourceFile.isFile()) {
			resource.setFileLocation(resourceFile.getPath());
			lines = fileReader.readLines(resourceFile);
		}

		return resource;
	}

	private void parseLines(final ResourceModel resource, final List<String> lines) {
		for (String line : lines) {

		}
	}

}
