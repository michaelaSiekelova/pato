package cz.upol.pato.usermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Basic
    @Column(name = "FIRST_NAME")
    private String firstname;

    @Basic
    @Column(name = "LAST_NAME")
    private String lastname;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "PASSWORD")
    private String password;
}
