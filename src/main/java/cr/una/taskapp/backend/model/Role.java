package cr.una.taskapp.backend.model;
/*
 Entity for role
 */

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
//Properties

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    @Getter @Setter
    private Long id_role;

    @Getter @Setter
    private String name;


    // Relationship definition
    @ManyToMany(mappedBy = "roleList")
    @Getter @Setter private List<User> usersList;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_privilege"))
    @Getter @Setter
    private List<Privilege> privilegeList;
}
