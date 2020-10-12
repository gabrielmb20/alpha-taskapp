package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "timesheet")
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_time")
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Date timesheet_date;
    @Getter @Setter
    private Long monday;
    @Getter @Setter
    private Long tuesday;
    @Getter @Setter
    private Long wednesday;
    @Getter @Setter
    private Long thursday;
    @Getter @Setter
    private Long friday;
    @Getter @Setter
    private Long saturday;
    @Getter @Setter
    private Long sunday;
    @Getter @Setter
    private Integer pay;
    /*@Getter @Setter
    private Integer id_user;*/
    @Getter @Setter
    private Boolean approved;
    @Getter @Setter
    private Boolean payed;
   /* @Getter @Setter
    private Integer id_department;*/

    // Relationship definition
    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    @Getter @Setter
    private Department id_department;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @Getter @Setter
    private User id_user;
}
