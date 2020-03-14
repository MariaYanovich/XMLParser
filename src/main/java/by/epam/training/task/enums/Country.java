package by.epam.training.task.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Country.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Country">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="egypt"/>
 *     &lt;enumeration value="italy"/>
 *     &lt;enumeration value="france"/>
 *     &lt;enumeration value="germany"/>
 *     &lt;enumeration value="austria"/>
 *     &lt;enumeration value="australia"/>
 *     &lt;enumeration value="greece"/>
 *     &lt;enumeration value="china"/>
 *     &lt;enumeration value="usa"/>
 *     &lt;enumeration value="canada"/>
 *     &lt;enumeration value="mexico"/>
 *     &lt;enumeration value="norway"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "Country", namespace = "http://www.example.com/tours")
@XmlEnum
public enum Country {

    @XmlEnumValue("egypt")
    EGYPT("egypt"),
    @XmlEnumValue("italy")
    ITALY("italy"),
    @XmlEnumValue("france")
    FRANCE("france"),
    @XmlEnumValue("germany")
    GERMANY("germany"),
    @XmlEnumValue("austria")
    AUSTRIA("austria"),
    @XmlEnumValue("australia")
    AUSTRALIA("australia"),
    @XmlEnumValue("greece")
    GREECE("greece"),
    @XmlEnumValue("china")
    CHINA("china"),
    @XmlEnumValue("usa")
    USA("usa"),
    @XmlEnumValue("canada")
    CANADA("canada"),
    @XmlEnumValue("mexico")
    MEXICO("mexico"),
    @XmlEnumValue("norway")
    NORWAY("norway");
    private final String value;

    Country(String v) {
        value = v;
    }

    public static Country fromValue(String v) {
        for (Country c : Country.values()) {
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
