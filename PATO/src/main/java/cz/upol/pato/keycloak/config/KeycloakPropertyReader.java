package cz.upol.pato.keycloak.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class KeycloakPropertyReader {

    @Autowired
    private KeycloakAdminClientConfig config;

    /*public String getProperty(String key){
        String returnValue = "No value";
        String keyValue = config.getProperty(key);

        if( keyValue!= null && !keyValue.isEmpty()) {
            returnValue = keyValue;
        }
        return returnValue;
    }*/
}
