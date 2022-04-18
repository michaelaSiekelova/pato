package cz.upol.pato.usermanagement.repository;

import cz.upol.pato.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findById(long id);
}

