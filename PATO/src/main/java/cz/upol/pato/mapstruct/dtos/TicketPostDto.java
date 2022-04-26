package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TicketPostDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("projectId")
    private long projectId;
    @JsonProperty("description")
    private String description;
}
