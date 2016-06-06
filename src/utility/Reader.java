package utility;

import java.io.File;
import java.io.FileReader;

/**
 * File reader class used to read the contents of a file.
 * @author Hisoka
 *
 */
public class Reader {
	
	File file;	
	
	public void setFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}
}
