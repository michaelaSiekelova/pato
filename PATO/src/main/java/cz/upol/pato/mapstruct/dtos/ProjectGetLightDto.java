package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectGetLightDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private long name;
}
