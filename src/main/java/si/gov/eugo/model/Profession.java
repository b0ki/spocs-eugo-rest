package si.gov.eugo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Matija Mazi <br/>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Profession {

    @XmlAttribute
    private String id;

    private String title;

    private String description;

    public Profession(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Profession{id='%s', title='%s', description='%s'}", id, title, description);
    }
}
