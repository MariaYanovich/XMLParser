package by.epam.training.task.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RO"/>
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="HB"/>
 *     &lt;enumeration value="FB"/>
 *     &lt;enumeration value="AL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "HotelType", namespace = "http://www.example.com/tours")
@XmlEnum
public enum HotelType {

    RO,
    BB,
    HB,
    FB,
    AL;

    public static HotelType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
