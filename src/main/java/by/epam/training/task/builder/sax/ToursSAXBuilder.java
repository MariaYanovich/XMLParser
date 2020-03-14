package by.epam.training.task.builder.sax;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import by.epam.training.task.builder.AbstractToursBuilder;

import javax.xml.XMLConstants;
import java.io.IOException;
import java.io.InputStream;

import static org.xml.sax.helpers.XMLReaderFactory.createXMLReader;

public class ToursSAXBuilder extends AbstractToursBuilder {

    private static final Logger LOGGER = Logger.getLogger(ToursSAXBuilder.class);
    private TourHandler tourHandler;
    private XMLReader reader;

    public ToursSAXBuilder() {
        super();
        tourHandler = new TourHandler();
        try {
            reader = createXMLReader();
            reader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            reader.setContentHandler(tourHandler);
        } catch (SAXException e) {
            LOGGER.error(e);
        }
    }

    public void buildTours(InputStream source) {
        try {
            reader.parse(new InputSource(source));
        } catch (SAXException e) {
            LOGGER.error("Error of SAX parser" + e);
        } catch (IOException e) {
            LOGGER.error("Error of I/O thread" + e);
        }
        tours = tourHandler.getTours();
    }
}
