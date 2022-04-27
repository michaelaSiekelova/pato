package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TicketGetLightDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createDate")
    private Date createDate;
    @JsonProperty("createUserName")
    private String createUserName;
    @JsonProperty("currentUserName")
    private String currentUserName;
    @JsonProperty("currentUserName")
    private String statusTitle;
}
