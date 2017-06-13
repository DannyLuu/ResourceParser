import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import resources.Resource;
import utility.comparator.service.PropertyComparatorService;
import utility.reader.service.FileReaderService;

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
		Resource en_resource = (Resource) context.getBean("en_resource");
		Resource fr_resource = (Resource) context.getBean("fr_resource");

		FileReaderService fileReader = (FileReaderService) context.getBean("fileReaderService");
		PropertyComparatorService propertyComparatorService = (PropertyComparatorService) context
				.getBean("propertyComparatorService");

		Properties a = fileReader.generateProperties(en_resource.getFile());
		Properties b = fileReader.generateProperties(fr_resource.getFile());

		propertyComparatorService.comparePropertiesOf(a, b);
	}

}
