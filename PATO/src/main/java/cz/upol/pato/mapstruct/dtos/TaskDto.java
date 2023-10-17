package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TaskDto {

    @JsonProperty("done")
    private boolean done;

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("ticketId")
    private Long ticketId;

}
