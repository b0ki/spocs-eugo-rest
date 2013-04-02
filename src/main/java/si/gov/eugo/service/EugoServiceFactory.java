package si.gov.eugo.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Matija Mazi <br/>
 * @created 3/27/13 4:19 PM
 */
public class EugoServiceFactory {
    private static final Logger log = LoggerFactory.getLogger(EugoServiceFactory.class);

    private static final String apiEndpointUrl;
    private static final Properties properties;

    static {
        try {
            Properties defaults = new Properties();
            defaults.load(EugoServiceFactory.class.getResourceAsStream("eugo-config-default.properties"));

            Properties props = new Properties(defaults);
            InputStream propertiesSrc = EugoServiceFactory.class.getResourceAsStream("/eugo-config.properties");
            if (propertiesSrc != null) {
                props.load(propertiesSrc);
            }
            properties = props;
            apiEndpointUrl = properties.getProperty("api.endpoint");
            log.debug("Using properties: {}", properties);
        } catch (IOException e) {
            throw new RuntimeException("Error reading EUGO properties.", e);
        }

        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);
    }

    public static EugoService createEugoService() throws IOException {
        return ProxyFactory.create(EugoService.class, apiEndpointUrl);
    }
}
