package cz.upol.pato.mapstruct.mappers;

import cz.upol.pato.mapstruct.dtos.UserGetDto;
import cz.upol.pato.usermanagement.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    UserGetDto userToUserPostDto(UserEntity userEntity);
    UserGetDto userToUserGetDto(UserEntity userEntity);
}