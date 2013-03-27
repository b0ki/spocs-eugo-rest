package si.gov.eugo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import si.gov.eugo.model.Profession;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 3:31 PM
 */
public class JaxbTest {
    private static final Logger log = LoggerFactory.getLogger(JaxbTest.class);

    @Test
    public void testParseProfession() throws Exception {
        InputStream input = JaxbTest.class.getResourceAsStream("professoin77.xml");
        Assert.assertNotNull(input);

        JAXBContext ctx = JAXBContext.newInstance(Profession.class);

        Profession profession = (Profession) ctx.createUnmarshaller().unmarshal(input);
        log.debug("profession = {}", profession);

        Assert.assertEquals(profession.getId(), "77");
        Assert.assertEquals(profession.getTitle(), "Responsible architectural designer (architect)");

    }
}
