package by.epam.training.task.builder.sax;

import by.epam.training.task.entity.HotelCharacteristic;
import by.epam.training.task.entity.Tours;
import by.epam.training.task.enums.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.EnumSet;

public class TourHandler extends DefaultHandler {

    private static final Logger LOGGER = Logger.getLogger(TourHandler.class);

    private Tours tours;
    private by.epam.training.task.entity.Tour current = null;
    private Tour currentEnum = null;
    private EnumSet<Tour> withText;

    public TourHandler() {
        tours = new Tours();
        withText = EnumSet.range(Tour.TOURNAME, Tour.COST);
    }

    public Tours getTours() {
        return tours;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (Tour.TOUR.getValue().equals(localName)) {
            current = new by.epam.training.task.entity.Tour();
            current.setId(attributes.getValue(0));

        } else {
            Tour temp = Tour.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Tour.TOUR.getValue().equals(localName)) {
            tours.getTours().add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String currentField = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TOURNAME:
                    current.setTourName(currentField);
                    break;
                case TOURTYPE:
                    current.setTourType(TourType.valueOf(currentField.toUpperCase()));
                    break;
                case COUNTRY:
                    current.setCountry(Country.valueOf(currentField.toUpperCase()));
                    break;
                case STARTDATE:
                    try {
                        current.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(currentField));
                    } catch (DatatypeConfigurationException e) {
                        LOGGER.error(e);
                    }
                    break;
                case DAYS:
                    current.setDays(Integer.parseInt(currentField));
                    break;
                case TRANSPORT:
                    current.setTransportType(TransportType.valueOf(currentField.toUpperCase()));
                    break;
                case HOTELCHARACTERISTIC:
                    current.setHotelCharacteristic(new HotelCharacteristic());
                    break;
                case STARS:
                    current.getHotelCharacteristic().setStars(Integer.parseInt(currentField));
                    break;
                case HOTELTYPE:
                    current.getHotelCharacteristic().setHotelType(HotelType.valueOf(currentField.toUpperCase()));
                    break;
                case ROOMS:
                    current.getHotelCharacteristic().setRooms(Integer.parseInt(currentField));
                    break;
                case COST:
                    current.setCost(Float.parseFloat(currentField));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
