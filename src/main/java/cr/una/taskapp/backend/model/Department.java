package cr.una.taskapp.backend.model;
/*
 Entity for department
 */

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
//Properties

    @Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    @Getter @Setter
    private Long id_department;

    @Column(name = "department_name")
    @Getter @Setter
    private String department_name;


    // Relationship definition
    @OneToMany(mappedBy = "id_department")
    @Getter @Setter
    private List<TimeSheet> timeSheetList;
}
