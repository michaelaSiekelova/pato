package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class UserPostDto{
    @JsonProperty("surname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}