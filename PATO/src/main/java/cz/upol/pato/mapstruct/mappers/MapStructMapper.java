package cz.upol.pato.mapstruct.mappers;

import cz.upol.pato.mapstruct.dtos.ProjectGetLightDto;
import cz.upol.pato.mapstruct.dtos.TicketGetLightDto;
import cz.upol.pato.mapstruct.dtos.TicketPostDto;
import cz.upol.pato.mapstruct.dtos.UserGetDto;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.usermanagement.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    UserGetDto userToUserPostDto(UserEntity userEntity);
    UserGetDto userToUserGetDto(UserEntity userEntity);
    TicketGetLightDto ticketToTicketGetLightDto(Ticket ticket);
    TicketPostDto ticketToTicketPostDto (Ticket ticket);
    ProjectGetLightDto projectToProjectLightDto(Project project);
}