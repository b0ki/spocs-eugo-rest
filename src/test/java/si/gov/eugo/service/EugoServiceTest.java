package si.gov.eugo.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import si.gov.eugo.model.Profession;

import java.util.Properties;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 1:15 PM
 */
@Test(groups = "integrationTests")
public class EugoServiceTest {
    private static final Logger log = LoggerFactory.getLogger(EugoServiceTest.class);
    public static final String DEFAULT_API_ENDPOINT = "http://www.eugo.gov.si/";

    @Test
    public void testGetProfession() throws Exception {
        // TODO: Handle missing config.properties
        Properties properties = new Properties();
        properties.load(EugoServiceTest.class.getResourceAsStream("/config.properties"));
        String apiEndpoint = properties.getProperty("api.endpoint", DEFAULT_API_ENDPOINT);

        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);
//        factory.registerProvider(XMLJAXBElementProvider.App.class);

        EugoService service = ProxyFactory.create(EugoService.class, apiEndpoint);

        Profession profession = service.getProfession("77");
        log.debug("result = {}", profession);

    }
}
