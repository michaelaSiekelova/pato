package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class UserPostDto{
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    private String keycloakId;

    public String createRequestBody(){
        return "{" +
                "\"username\": \""+email+"\"," +
                "\"email\": \""+email+"\"," +
                "\"enabled\": true," +
                "\"emailVerified\": false," +
                "\"firstName\": \""+firstname+"\"," +
                "\"lastName\": \""+lastname+"\"," +
                "\"credentials\": [" +
                " {" +
                "\"type\": \"password\"," +
                "\"value\": \""+password+"\"," +
                "\"temporary\": false" +
                "}" +
                "]" +
                "}";
    }
}