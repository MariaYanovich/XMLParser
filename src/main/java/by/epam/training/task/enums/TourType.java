package by.epam.training.task.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TourType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TourType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="weekend"/>
 *     &lt;enumeration value="sightseeing"/>
 *     &lt;enumeration value="vacation"/>
 *     &lt;enumeration value="pilgrimage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TourType", namespace = "http://www.example.com/tours")
@XmlEnum
public enum TourType {

    @XmlEnumValue("weekend")
    WEEKEND("weekend"),
    @XmlEnumValue("sightseeing")
    SIGHTSEEING("sightseeing"),
    @XmlEnumValue("vacation")
    VACATION("vacation"),
    @XmlEnumValue("pilgrimage")
    PILGRIMAGE("pilgrimage");
    private final String value;

    TourType(String v) {
        value = v;
    }

    public static TourType fromValue(String v) {
        for (TourType c : TourType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

}
