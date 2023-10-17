package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TicketPostDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private long id;
    @JsonProperty("projectId")
    private long projectId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("deadline")
    private Date deadline;
}
