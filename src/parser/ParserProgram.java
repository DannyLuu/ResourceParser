package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import resources.constants.ResourceDelimeter;
import utility.InputScanner;
import utility.Reader;

/**
 * Main Parser Program
 * 
 * 
 * @author Hisoka
 *
 */
public class ParserProgram {

	public static void main(String[] args) {
		boolean debug = true;
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		// Java Beans
		InputScanner inputScanner = (InputScanner) context.getBean("inputScanner");
		Reader en_resource = (Reader) context.getBean("en_resource");
		
		
		// Read the file
		try {
			List<String> lines = inputScanner.readLines(en_resource.getFile());
			List<String> comments = new ArrayList<String>();
			List<String> assignment = new ArrayList<String>();
			
			for (String s : lines) {
				if (s.startsWith(ResourceDelimeter.COMMENT)) {
					comments.add(s);
				} else if (s.contains("=")) {
					assignment.add(s);
				}				
				
			}
			
			if (debug) {
				for (String s : assignment) {
					System.out.println(s);
				}
				System.out.println("Assignment Size: " + assignment.size());
			}
			
			// Printing file data
			if (debug) {
				System.out.println("Name: " + en_resource.getFile().getName());
				System.out.println("Last modified: " + en_resource.getFile().lastModified());
				System.out.println("Path: " + en_resource.getFile().getAbsolutePath());
				System.out.println("Lines: " + lines.size());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			e.printStackTrace();
		}
	}

}
