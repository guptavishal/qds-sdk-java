package com.qubole.qds.sdk.java.client;

import com.google.common.base.Preconditions;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.concurrent.TimeUnit;

/**
 * Standard/default implementation of {@link QdsConfiguration}
 */
public class DefaultQdsConfiguration implements QdsConfiguration
{
    private final String apiEndpoint;
    private final String apiToken;
    private final ClientConfig jerseyConfiguration;

    public static final String API_ENDPOINT = "https://api.qubole.com/api";
    public static final String API_VERSION = "v1.2";

    private static final int DEFAULT_CONNECTION_TIMEOUT = (int)TimeUnit.SECONDS.toMillis(10);
    private static final int DEFAULT_READ_TIMEOUT = (int)TimeUnit.SECONDS.toMillis(10);

    /**
     * @param apiToken your API token
     */
    public DefaultQdsConfiguration(String apiToken)
    {
        this(API_ENDPOINT, apiToken, null);
    }

    /**
     * @param apiEndpoint endpoint
     * @param apiToken your API token
     */
    public DefaultQdsConfiguration(String apiEndpoint, String apiToken)
    {
        this(apiEndpoint, apiToken, null);
    }

    /**
     * @param apiEndpoint endpoint
     * @param apiToken your API token
     * @param jerseyConfiguration jersey client configuration or null for default
     */
    public DefaultQdsConfiguration(String apiEndpoint, String apiToken, ClientConfig jerseyConfiguration)
    {
        this.apiEndpoint = Preconditions.checkNotNull(apiEndpoint, "apiEndpoint cannot be null");
        this.apiToken = Preconditions.checkNotNull(apiToken, "apiToken cannot be null");

        if ( jerseyConfiguration == null )
        {
            jerseyConfiguration = new ClientConfig();
            jerseyConfiguration.property(ClientProperties.CONNECT_TIMEOUT, DEFAULT_CONNECTION_TIMEOUT);
            jerseyConfiguration.property(ClientProperties.READ_TIMEOUT, DEFAULT_READ_TIMEOUT);
        }
        this.jerseyConfiguration = jerseyConfiguration;
    }

    @Override
    public Client newClient()
    {
        return ClientBuilder
            .newClient(jerseyConfiguration)
            .register(JacksonFeature.class);
    }

    @Override
    public String getApiToken()
    {
        return apiToken;
    }

    @Override
    public String getApiEndpoint()
    {
        return apiEndpoint;
    }

    @Override
    public String getApiVersion()
    {
        return API_VERSION;
    }
}
