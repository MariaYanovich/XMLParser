package by.epam.training.task.builder.stax;


import by.epam.training.task.builder.AbstractToursBuilder;
import by.epam.training.task.entity.HotelCharacteristic;
import by.epam.training.task.enums.*;
import org.apache.log4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;

public class ToursStAXBuilder extends AbstractToursBuilder {
    private static final Logger LOGGER = Logger.getLogger(ToursStAXBuilder.class);

    private XMLInputFactory inputFactory;

    public ToursStAXBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildTours(InputStream source) {
        XMLStreamReader reader;
        String name;
        try {
            reader = inputFactory.createXMLStreamReader(source);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (Tour.valueOf(name.toUpperCase()) == Tour.TOUR) {
                        by.epam.training.task.entity.Tour tour = buildSetTours(reader);
                        tours.getTours().add(tour);
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("StAX parsing error! " + e.getMessage());
        } finally {
            try {
                if (source != null) {
                    source.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file " + source + " : " + e);
            }
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        if (text == null) {
            throw new XMLStreamException();
        } else {
            return text;
        }
    }

    private by.epam.training.task.entity.Tour buildSetTours(XMLStreamReader reader) throws XMLStreamException {
        by.epam.training.task.entity.Tour tour = new by.epam.training.task.entity.Tour();
        tour.setId(reader.getAttributeValue(null, Tour.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (Tour.valueOf(name.toUpperCase())) {
                        case TOURNAME:
                            tour.setTourName(getXMLText(reader));
                            break;
                        case TOURTYPE:
                            tour.setTourType(TourType.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case COUNTRY:
                            tour.setCountry(Country.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case STARTDATE:
                            try {
                                tour.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(getXMLText(reader)));
                            } catch (DatatypeConfigurationException e) {
                                LOGGER.error(e);
                            }
                            break;
                        case DAYS:
                            tour.setDays(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TRANSPORT:
                            tour.setTransport(Transport.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case HOTELCHARACTERISTIC:
                            tour.setHotelCharacteristic(new HotelCharacteristic());
                            setHotelCharacteristic(reader, tour.getHotelCharacteristic());
                            break;
                        case COST:
                            tour.setCost(Float.parseFloat(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (Tour.valueOf(name.toUpperCase()) == Tour.TOUR) {
                        return tour;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag tour");
    }

    private void setHotelCharacteristic(XMLStreamReader reader, HotelCharacteristic hotelCharacteristic) throws XMLStreamException {
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (Tour.valueOf(name.toUpperCase())) {
                        case STARS:
                            hotelCharacteristic.setStars(Integer.parseInt(getXMLText(reader)));
                            break;
                        case HOTELTYPE:
                            hotelCharacteristic.setHotelType(HotelType.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case ROOMS:
                            hotelCharacteristic.setRooms(Integer.parseInt(getXMLText(reader)));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (Tour.valueOf(name.toUpperCase()) == Tour.HOTELCHARACTERISTIC) {
                        return;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag hotelCharacteristic");

    }
}
