package cz.upol.pato.attributesmanagement.repository;

import cz.upol.pato.attributesmanagement.entity.Attribute;
import cz.upol.pato.projectmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    List<Attribute> findByProject(Project project);
}
