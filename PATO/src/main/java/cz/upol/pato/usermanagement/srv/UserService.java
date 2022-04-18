package cz.upol.pato.usermanagement.srv;

import cz.upol.pato.mapstruct.dtos.UserPostDto;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity getUserByEmail(String email){
        return repository
                .findByEmail(email);
    }

    public UserEntity getUserById(long id){
        return repository
                .findById(id);
    }

    public void createUser(UserPostDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstname(userDto.getFirstname());
        userEntity.setLastname(userDto.getLastname());
        userEntity.setPassword(userDto.getPassword());
        repository.save(userEntity);
    }
}
