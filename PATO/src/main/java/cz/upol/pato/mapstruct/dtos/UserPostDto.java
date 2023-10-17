package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class UserPostDto{
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    private String keycloakId;

    @JsonProperty("ticketId")
    private Long ticketId;

    @JsonProperty("projectId")
    private Long projectId;

    private boolean admin = false;

    public String createRequestBody(){
        return "{" +
                "\"username\": \""+email+"\"," +
                "\"email\": \""+email+"\"," +
                "\"enabled\": true," +
                "\"emailVerified\": false," +
                "\"credentials\": [" +
                " {" +
                "\"type\": \"password\"," +
                "\"value\": \""+password+"\"," +
                "\"temporary\": true" +
                "}" +
                "]" +
                "}";
    }
}