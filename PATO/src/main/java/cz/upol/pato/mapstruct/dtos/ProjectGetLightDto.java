package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectGetLightDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
}
