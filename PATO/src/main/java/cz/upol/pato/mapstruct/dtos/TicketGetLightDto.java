package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TicketGetLightDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createDate")
    private Date createDate;
    @JsonProperty("deadline")
    private Date deadline;
    @JsonProperty("createUser")
    private String createUserName;
    @JsonProperty("assignee")
    private String currentUserName;
    @JsonProperty("projectShortcut")
    private String projectShortcut;
    @JsonProperty("projectId")
    private String projectId;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

    @JsonProperty("projectDeadline")
    private Date projectDeadline;

    @JsonProperty("progress")
    private Integer progress;

    @JsonProperty("duration")
    private long duration;
}
