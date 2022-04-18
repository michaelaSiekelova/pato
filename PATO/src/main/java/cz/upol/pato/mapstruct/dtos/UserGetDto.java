package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserGetDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("email")
    private String email;
}
