package cz.upol.pato.projectmanagement.repository;

import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findById(long id);
    List<Project> findByUsersIn(List<UserEntity> users);

}
