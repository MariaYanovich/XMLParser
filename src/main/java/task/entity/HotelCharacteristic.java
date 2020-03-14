package task.entity;

import task.enums.HotelType;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for HotelCharacteristic complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HotelCharacteristic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stars" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotelType" type="{http://www.example.com/tours}HotelType"/>
 *         &lt;element name="rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCharacteristic", namespace = "http://www.example.com/tours", propOrder = {
        "stars",
        "hotelType",
        "rooms"
})
public class HotelCharacteristic {

    protected int stars;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected HotelType hotelType;
    protected int rooms;

    /**
     * Gets the value of the stars property.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     */
    public void setStars(int value) {
        this.stars = value;
    }

    /**
     * Gets the value of the hotelType property.
     *
     * @return possible object is
     * {@link HotelType }
     */
    public HotelType getHotelType() {
        return hotelType;
    }

    /**
     * Sets the value of the hotelType property.
     *
     * @param value allowed object is
     *              {@link HotelType }
     */
    public void setHotelType(HotelType value) {
        this.hotelType = value;
    }

    /**
     * Gets the value of the rooms property.
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     */
    public void setRooms(int value) {
        this.rooms = value;
    }

    @Override
    public String toString() {
        return " stars=" + stars +
                ", hotelType=" + hotelType +
                ", rooms=" + rooms;
    }
}
