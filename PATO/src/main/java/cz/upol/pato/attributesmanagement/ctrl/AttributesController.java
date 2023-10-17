package cz.upol.pato.attributesmanagement.ctrl;


import cz.upol.pato.attributesmanagement.entity.Attribute;
import cz.upol.pato.attributesmanagement.entity.AttributeValue;
import cz.upol.pato.attributesmanagement.enums.AttributeType;
import cz.upol.pato.attributesmanagement.srv.AttributesService;
import cz.upol.pato.mapstruct.dtos.AttributeDto;
import cz.upol.pato.mapstruct.dtos.AttributeValueDto;
import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/attributeManagement")
public class AttributesController {
    @Autowired
    private MapStructMapper mapstructMapper;

    @Autowired
    private AttributesService attributesService;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "attribute/create")
    public void createAttribute(@RequestBody AttributeDto dto){
        attributesService.createAttribute(dto);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "attribute/delete")
    public void deleteAttribute(@RequestBody Long attributeId){
        attributesService.deleteAttribute(attributeId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "attributeValue/create")
    public void createAttributeValue(@RequestBody AttributeValueDto dto){
        attributesService.createAttributeValue(dto);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "attributeValue/delete")
    public void deleteAttributeValue(@RequestBody Long attributeValueId){
        attributesService.deleteAttributeValue(attributeValueId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "attributeValue/getForTicket")
    public List<AttributeValueDto> getAttributeValuesForTicket(@RequestBody Long ticketId){
        List<AttributeValue> attributeValues= attributesService.getAttributeValuesForTicket(ticketId);
        List<AttributeValueDto> resultList = new ArrayList<>();
        for (AttributeValue attributeValue : attributeValues){
            resultList.add(mapstructMapper.attributeValueToAttributeValueDto(attributeValue));
        }
        return resultList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "attribute/getForProject")
    public List<AttributeDto> getAttributesForProject(@RequestBody Long projectId){
        List<Attribute> attributes = attributesService.getAttributeForProject(projectId);
        List<AttributeDto> resultList = new ArrayList<>();
        for (Attribute attribute : attributes){
            resultList.add(mapstructMapper.attributeToAttributeDto(attribute));
        }
        return resultList;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/attribute/types")
    public AttributeType[] getAttributeTypes(){
        return AttributeType.values();
    }
}
