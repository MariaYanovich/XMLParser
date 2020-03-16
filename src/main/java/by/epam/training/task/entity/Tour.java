package by.epam.training.task.entity;

import by.epam.training.task.enums.Country;
import by.epam.training.task.enums.TourType;
import by.epam.training.task.enums.TransportType;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Tour complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tourName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tourType" type="{http://www.example.com/tours}TourType"/>
 *         &lt;element name="country" type="{http://www.example.com/tours}Country"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="days" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transport" type="{http://www.example.com/tours}Transport"/>
 *         &lt;element name="hotelCharacteristic" type="{http://www.example.com/tours}HotelCharacteristic"/>
 *         &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tour", namespace = "http://www.example.com/tours", propOrder = {
        "tourName",
        "tourType",
        "country",
        "startDate",
        "days",
        "transportType",
        "hotelCharacteristic",
        "cost"
})
public class Tour {

    @XmlElement(required = true, defaultValue = "defaultName")
    protected String tourName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TourType tourType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Country country;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(defaultValue = "1")
    protected int days;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransportType transportType;
    @XmlElement(required = true)
    protected HotelCharacteristic hotelCharacteristic;
    protected float cost;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the tourName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTourName() {
        return tourName;
    }

    /**
     * Sets the value of the tourName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTourName(String value) {
        this.tourName = value;
    }

    /**
     * Gets the value of the tourType property.
     *
     * @return possible object is
     * {@link TourType }
     */
    public TourType getTourType() {
        return tourType;
    }

    /**
     * Sets the value of the tourType property.
     *
     * @param value allowed object is
     *              {@link TourType }
     */
    public void setTourType(TourType value) {
        this.tourType = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     * {@link Country }
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link Country }
     */
    public void setCountry(Country value) {
        this.country = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the days property.
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the value of the days property.
     */
    public void setDays(int value) {
        this.days = value;
    }

    /**
     * Gets the value of the transport property.
     *
     * @return possible object is
     * {@link TransportType }
     */
    public TransportType getTransportType() {
        return transportType;
    }

    /**
     * Sets the value of the transport property.
     *
     * @param value allowed object is
     *              {@link TransportType }
     */
    public void setTransportType(TransportType value) {
        this.transportType = value;
    }

    /**
     * Gets the value of the hotelCharacteristic property.
     *
     * @return possible object is
     * {@link HotelCharacteristic }
     */
    public HotelCharacteristic getHotelCharacteristic() {
        return hotelCharacteristic;
    }

    /**
     * Sets the value of the hotelCharacteristic property.
     *
     * @param value allowed object is
     *              {@link HotelCharacteristic }
     */
    public void setHotelCharacteristic(HotelCharacteristic value) {
        this.hotelCharacteristic = value;
    }

    /**
     * Gets the value of the cost property.
     */
    public float getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     */
    public void setCost(float value) {
        this.cost = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    @Override
    public String toString() {
        return "\nid=" + id +
                ", tourName='" + tourName + '\'' +
                ", tourType=" + tourType +
                ", country=" + country +
                ", startDate=" + startDate +
                ", days=" + days +
                ", transport=" + transportType +
                "," + hotelCharacteristic +
                ", cost=" + cost;
    }
}
