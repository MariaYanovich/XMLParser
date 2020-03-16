package by.epam.training.task.builder.dom;


import by.epam.training.task.builder.AbstractToursBuilder;
import by.epam.training.task.entity.HotelCharacteristic;
import by.epam.training.task.enums.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class ToursDOMBuilder extends AbstractToursBuilder {
    private static final Logger LOGGER = Logger.getLogger(ToursDOMBuilder.class);
    private DocumentBuilder documentBuilder;

    public ToursDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser configuration error: " + e);
        }
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

    public void buildTours(InputStream source) {
        Document document;
        try {
            document = documentBuilder.parse(source);
            Element root = document.getDocumentElement();
            NodeList toursList = root.getElementsByTagName(Tour.TOUR.getValue());
            for (int i = 0; i < toursList.getLength(); i++) {
                Element tourElement = (Element) toursList.item(i);
                by.epam.training.task.entity.Tour tour = buildTour(tourElement);
                tours.getTours().add(tour);
            }
        } catch (SAXException e) {
            LOGGER.error("File error or I/O error: " + e);
        } catch (IOException e) {
            LOGGER.error(("Parsing failure: " + e));
        }
    }

    private by.epam.training.task.entity.Tour buildTour(Element tourElement) {
        by.epam.training.task.entity.Tour tour = new by.epam.training.task.entity.Tour();
        tour.setId(tourElement.getAttribute(Tour.ID.getValue()));
        tour.setTourName(getElementTextContent(tourElement, Tour.TOURNAME.getValue()));
        String tourType = getElementTextContent(tourElement, Tour.TOURTYPE.getValue());
        tour.setTourType(TourType.valueOf(tourType.toUpperCase()));
        String country = getElementTextContent(tourElement, Tour.COUNTRY.getValue());
        tour.setCountry(Country.valueOf(country.toUpperCase()));
        try {
            tour.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(getElementTextContent(tourElement,
                    Tour.STARTDATE.getValue())));
        } catch (DatatypeConfigurationException e) {
            LOGGER.error(e);
        }
        tour.setDays(Integer.parseInt(getElementTextContent(tourElement, Tour.DAYS.getValue())));
        String transport = getElementTextContent(tourElement, Tour.TRANSPORT.getValue());
        tour.setTransportType(TransportType.valueOf(transport.toUpperCase()));
        tour.setHotelCharacteristic(new HotelCharacteristic());
        HotelCharacteristic characteristic = tour.getHotelCharacteristic();
        Element characteristicElement = (Element) tourElement.getElementsByTagName(Tour.HOTELCHARACTERISTIC.getValue()).item(0);
        characteristic.setStars(Integer.parseInt(getElementTextContent(characteristicElement, Tour.STARS.getValue())));
        String type = getElementTextContent(characteristicElement, Tour.HOTELTYPE.getValue());
        characteristic.setHotelType(HotelType.valueOf(type.toUpperCase()));
        characteristic.setRooms(Integer.parseInt(getElementTextContent(characteristicElement, Tour.ROOMS.getValue())));
        tour.setCost(Float.parseFloat(getElementTextContent(tourElement, Tour.COST.getValue())));
        return tour;
    }
}
