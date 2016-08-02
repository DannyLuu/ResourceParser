package utility.parser;

import java.io.File;

import resources.ResourceModel;

public interface ResourceParserServiceFacade {

	/**
	 * Generates a Resource Model object from a given properties file.
	 *
	 * @param resourceFile
	 * @return
	 */
	ResourceModel generateResourceFromFile(File resourceFile);
}
