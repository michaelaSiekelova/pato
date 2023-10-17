package cz.upol.pato.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AttributeValueDto {
    @JsonProperty("stringValue")
    private String stringValue;

    @JsonProperty("ticketId")
    private Long ticketId;


    @JsonProperty("numberValue")
    private Float floatValue;

    @JsonProperty("dateValue")
    private Date dateValue;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributeId")
    private Long attributeId;

    @JsonProperty("attributeName")
    private String attributeName;

    @JsonProperty("id")
    private Long id;
}
