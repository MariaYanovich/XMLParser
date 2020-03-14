package by.epam.training.task.validator;


import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {
    private static final Logger LOGGER = Logger.getLogger(Validator.class);

    public static boolean isValidResources() {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/main/resources/tour.xml";
        String schemaName = "src/main/resources/tour.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        boolean result = false;
        try {
            Schema schema = factory.newSchema(schemaLocation);
            javax.xml.validation.Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            LOGGER.debug(fileName + " is valid.");
            result = true;
        } catch (SAXException e) {
            LOGGER.error("validation " + fileName + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error(fileName + " is not valid because " + e.getMessage());
        }
        return result;
    }
}
