package cz.upol.pato.keycloak.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class KeycloakPropertyReader {

    @Autowired
    private Environment env;

    public String getProperty(String key){
        String returnValue = "No value";
        String keyValue = env.getProperty(key);

        if( keyValue!= null && !keyValue.isEmpty()) {
            returnValue = keyValue;
        }
        return returnValue;
    }
}
