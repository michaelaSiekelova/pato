package cz.upol.pato.attributesmanagement.srv;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.upol.pato.attributesmanagement.entity.Attribute;
import cz.upol.pato.attributesmanagement.entity.AttributeValue;
import cz.upol.pato.attributesmanagement.enums.AttributeType;
import cz.upol.pato.attributesmanagement.repository.AttributeRepository;
import cz.upol.pato.attributesmanagement.repository.AttributeValueRepository;
import cz.upol.pato.mapstruct.dtos.AttributeDto;
import cz.upol.pato.mapstruct.dtos.AttributeValueDto;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.repository.ProjectRepository;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.ticketmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributesService {

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AttributeValueRepository attributeValueRepository;

    public void createAttribute(AttributeDto dto){
        Attribute attr = new Attribute();
        attr.setType(AttributeType.valueOf(dto.getType()));
        attr.setName(dto.getName());
        attributeRepository.save(attr);
        Project project = projectRepository.getById(dto.getProjectId());
        attr.setProject(project);
        projectRepository.save(project);
    }

    public void createAttributeValue(AttributeValueDto dto){
        AttributeValue attrVal = new AttributeValue();
        Attribute attribute = attributeRepository.getById(dto.getAttributeId());
        AttributeType type = attribute.getType();
        attrVal.setType(type);
        switch(type){
            case STRING:
                attrVal.setString(dto.getStringValue());
            case DATE:
                attrVal.setDate(dto.getDateValue());
            case FLOAT:
                attrVal.setAFloat(dto.getFloatValue());
        }
        Ticket ticket = ticketRepository.getById(dto.getTicketId());
        attrVal.setTicket(ticket);
        attrVal.setAttribute(attribute);
        attributeValueRepository.save(attrVal);
    }

    public void deleteAttribute(Long id){
        attributeRepository.deleteById(id);
    }

    public void deleteAttributeValue(Long id){
        attributeValueRepository.deleteById(id);
    }

    public List<AttributeValue> getAttributeValuesForTicket (Long ticketId){
        Ticket ticket = ticketRepository.getById(ticketId);
        return attributeValueRepository.findByTicket(ticket);
    }

    public List<Attribute> getAttributeForProject(Long projectId){
        Project project = projectRepository.getById(projectId);
        return attributeRepository.findByProject(project);
    }
}
