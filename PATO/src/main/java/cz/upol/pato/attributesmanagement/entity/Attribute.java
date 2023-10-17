package cz.upol.pato.attributesmanagement.entity;

import cz.upol.pato.attributesmanagement.enums.AttributeType;
import cz.upol.pato.projectmanagement.entity.Project;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Attribute {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Project project;

    private AttributeType type;

    private String name;
}
