package si.gov.eugo.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 4:19 PM
 */
public class EugoServiceFactory {

    public static EugoService createEugoService() throws IOException {
        Properties defaults = new Properties();
        defaults.load(EugoServiceFactory.class.getResourceAsStream("eugo-config-default.properties"));


        Properties properties = new Properties(defaults);
        InputStream propertiesSrc = EugoServiceFactory.class.getResourceAsStream("/eugo-config.properties");
        if (propertiesSrc != null) {
            properties.load(propertiesSrc);
        }
        String apiEndpoint = properties.getProperty("api.endpoint");

        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);

        return ProxyFactory.create(EugoService.class, apiEndpoint);
    }
}
