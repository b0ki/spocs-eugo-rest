package si.gov.eugo.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 4:19 PM
 */
public class EugoServiceFactory {
    public static final String DEFAULT_API_ENDPOINT = "http://www.eugo.gov.si/";

    public static EugoService createEugoService() throws IOException {
        // TODO: Handle missing config.properties
        Properties properties = new Properties();
        properties.load(EugoServiceFactory.class.getResourceAsStream("/config.properties"));
        String apiEndpoint = properties.getProperty("api.endpoint", DEFAULT_API_ENDPOINT);

        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);

        return ProxyFactory.create(EugoService.class, apiEndpoint);
    }
}
