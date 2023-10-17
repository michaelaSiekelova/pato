package cz.upol.pato.keycloak.config;

import org.apache.commons.lang3.StringUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeycloakAdminClientUtils {
    private static final Logger log = LoggerFactory.getLogger(KeycloakAdminClientUtils.class);

    /*public static KeycloakAdminClientConfig loadConfig(KeycloakPropertyReader keycloakPropertyReader){
        KeycloakAdminClientConfig.KeycloakAdminClientConfigBuilder builder = KeycloakAdminClientConfig.builder();

        try{
            String keycloakServer = System.getProperty("keycloak.url");
            if(!StringUtils.isBlank(keycloakServer)){
                builder = builder.serverUrl(keycloakServer);
            }else {
                builder = builder.serverUrl(keycloakPropertyReader.getProperty("keycloak.auth-server-url"));
            }

            String realm = System.getProperty("keycloak.realm");
            if(!StringUtils.isBlank(realm)){
                builder = builder.realm(realm);
            }else {
                builder = builder.realm(keycloakPropertyReader.getProperty("keycloak.realm"));
            }

            String clientId = System.getProperty("keycloak.clientId");
            if(!StringUtils.isBlank(clientId)){
                builder = builder.clientId(clientId);
            }else {
                builder = builder.clientId(keycloakPropertyReader.getProperty("keycloak.resource"));
            }

            String clientSecret = System.getProperty("keycloak.secret");
            if(!StringUtils.isBlank(clientSecret)){
                builder = builder.clientSecret(clientSecret);
            }else {
                builder = builder.clientSecret(keycloakPropertyReader.getProperty("keycloak.credentials.secret"));
            }

        } catch (Exception e) {
            log.error ("Error : Loading keycloak admin configuration => {}", e.getMessage());
        }

        KeycloakAdminClientConfig config  = builder.build();
        log.debug("found keycloak configuration: {}", config);

        return config;

    }*/

    public static Keycloak getKeycloakClient(RefreshableKeycloakSecurityContext session, KeycloakAdminClientConfig config) {

        return KeycloakBuilder.builder() //
                .serverUrl(config.getServerUrl()) //
                .realm(config.getRealm()) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(config.getClientId()) //
                .clientSecret(config.getClientSecret()) //
                .authorization(session.getTokenString())
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build())
                .build();
    }

}
