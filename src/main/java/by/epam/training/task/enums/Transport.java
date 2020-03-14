package by.epam.training.task.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transport.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Transport">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="air"/>
 *     &lt;enumeration value="liner"/>
 *     &lt;enumeration value="railway"/>
 *     &lt;enumeration value="car"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "Transport", namespace = "http://www.example.com/tours")
@XmlEnum
public enum Transport {

    @XmlEnumValue("air")
    AIR("air"),
    @XmlEnumValue("liner")
    LINER("liner"),
    @XmlEnumValue("railway")
    RAILWAY("railway"),
    @XmlEnumValue("car")
    CAR("car");
    private final String value;

    Transport(String v) {
        value = v;
    }

    public static Transport fromValue(String v) {
        for (Transport c : Transport.values()) {
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
