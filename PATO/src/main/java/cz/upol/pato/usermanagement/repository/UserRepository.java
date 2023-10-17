package cz.upol.pato.usermanagement.repository;

import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findById(long id);
    UserEntity findByKeycloakId(String keycloakId);

    List<UserEntity> findAllByActiveIsTrue();

    List<UserEntity> findAllByActiveIsTrueAndIdIsNotIn(List<Long> ids);

    boolean existsByKeycloakId(String keycloakId);


}

