package cz.upol.pato.mapstruct.mappers;

import cz.upol.pato.attributesmanagement.entity.Attribute;
import cz.upol.pato.attributesmanagement.entity.AttributeValue;
import cz.upol.pato.mapstruct.dtos.*;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.ticketmanagement.entity.Task;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.usermanagement.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    //mappers for user entity -> dto
    UserGetDto userToUserPostDto(UserEntity userEntity);
    UserGetDto userToUserGetDto(UserEntity userEntity);

    //mappers for ticket entity -> dto
    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "project.shortcut", target = "projectShortcut")
    @Mapping(source = "currentUser.name", target = "currentUserName")
    @Mapping(source = "createUser.name", target = "createUserName")
    @Mapping(source = "project.deadline", target = "projectDeadline")
    TicketGetLightDto ticketToTicketGetLightDto(Ticket ticket);
    TicketPostDto ticketToTicketPostDto (Ticket ticket);
    //@Mapping(source = "currentUser.name", target = "assignee")
    TicketChartDto ticketToTicketChartDto (Ticket ticket);

    @Mapping(source = "ticket.id", target = "ticketId")
    TaskDto taskToTaskDto(Task task);

    //mappers for project entity -> dto
    ProjectGetLightDto projectToProjectLightDto(Project project);
    ProjectDto projectToProjectDto(Project project);
    ProjectForSelectDto projectToProjectForSelectDto(Project project);

    //mappers for Attributes entity -> dto
    AttributeDto attributeToAttributeDto(Attribute attribute);
    @Mapping(source = "attribute.name", target = "attributeName")
    @Mapping(source = "attribute.id", target = "attributeId")
    @Mapping(source = "string", target = "stringValue")
    @Mapping(source = "AFloat", target = "floatValue")
    @Mapping(source = "date", target = "dateValue")
    AttributeValueDto attributeValueToAttributeValueDto(AttributeValue attribute);
}