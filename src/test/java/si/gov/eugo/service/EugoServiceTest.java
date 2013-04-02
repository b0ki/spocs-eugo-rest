package si.gov.eugo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import si.gov.eugo.model.Profession;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 1:15 PM
 */
@Test(groups = "integrationTests")
public class EugoServiceTest {
    private static final Logger log = LoggerFactory.getLogger(EugoServiceTest.class);

    @Test
    public void testGetProfession() throws Exception {
        EugoService service = EugoServiceFactory.createEugoService();

        Profession profession = service.getProfession("77");
        log.debug("result = {}", profession);
        Assert.assertEquals(profession.getId(), "77");
    }
}
