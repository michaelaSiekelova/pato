package cz.upol.pato.mapstruct.mappers;

import cz.upol.pato.mapstruct.dtos.UserGetDto;
import cz.upol.pato.usermanagement.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T10:18:35+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public UserGetDto userToUserPostDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setId( userEntity.getId() );
        userGetDto.setLastname( userEntity.getLastname() );
        userGetDto.setEmail( userEntity.getEmail() );

        return userGetDto;
    }

    @Override
    public UserGetDto userToUserGetDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setId( userEntity.getId() );
        userGetDto.setLastname( userEntity.getLastname() );
        userGetDto.setEmail( userEntity.getEmail() );

        return userGetDto;
    }
}
