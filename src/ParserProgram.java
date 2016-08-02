import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import utility.parser.Parser;
import utility.parser.ResourceParserServiceFacade;
import utility.reader.FileReaderFacade;

/**
 * Main Parser Program
 *
 *
 * @author Hisoka
 *
 */
public class ParserProgram {

	private static final Logger log = Logger.getLogger(ParserProgram.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// Resource Files
		Parser en_resource = (Parser) context.getBean("en_resource");
		Parser fr_resource = (Parser) context.getBean("fr_resource");
		FileReaderFacade fileReader = (FileReaderFacade) context.getBean("fileReader");
		ResourceParserServiceFacade r = (ResourceParserServiceFacade) context.getBean("resourceParserService");
		r.generateResourceFromFile(en_resource.getFile());

	}

}
