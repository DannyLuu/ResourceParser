package resources;

import java.util.Map;

/**
 * Model for the resource files.
 *
 * @author Hisoka
 *
 */
public class ResourceModel {

	private String header;

	private String fileLocation;

	private Map<String, String> resources;

	public String getFileLocation() {
		return fileLocation;
	}

	public String getHeader() {
		return header;
	}

	public String getKey(String key) {
		return resources.get(key);
	}

	public Map<String, String> getResources() {
		return resources;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setResources(Map<String, String> resources) {
		this.resources = resources;
	}
}
