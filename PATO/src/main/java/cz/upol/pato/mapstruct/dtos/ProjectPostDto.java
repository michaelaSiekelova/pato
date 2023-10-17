package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectPostDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("shortcut")
    private String shortcut;
    @JsonProperty("deadline")
    private Date deadline;
}
