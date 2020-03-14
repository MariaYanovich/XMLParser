package task.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tour" type="{http://www.example.com/tours}Tour" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tour"
})
@XmlRootElement(name = "tours", namespace = "http://www.example.com/tours")
public class Tours {

    protected Set<Tour> tour;

    /**
     * Gets the value of the tour property.
     *
     * <p>
     * This accessor method returns a reference to the live set,
     * not a snapshot. Therefore any modification you make to the
     * returned set will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tour property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTour().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the set
     * {@link Tour }
     */
    public Set<Tour> getTours() {
        if (tour == null) {
            tour = new HashSet<>();
        }
        return this.tour;
    }

    @Override
    public String toString() {
        return "Set of tours: " + tour;
    }
}
