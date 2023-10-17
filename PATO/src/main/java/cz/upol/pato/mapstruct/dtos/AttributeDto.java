package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AttributeDto {
    @JsonProperty("type")
    private String type;

    @JsonProperty("projectId")
    private long projectId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;
}
