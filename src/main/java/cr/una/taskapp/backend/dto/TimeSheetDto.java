/*
 *
 *  *
 *  *
 *  * Universidad Nacional de Costa Rica  2020
 *  *
 *  * mike@guzmanalan.com
 *  *
 *  *
 *
 *
 */

package cr.una.taskapp.backend.dto;

import cr.una.taskapp.backend.model.Department;
import cr.una.taskapp.backend.model.User;
import lombok.Data;

import java.util.Date;


@Data
public class TimeSheetDto {
    private Long id;
    private Date timesheet_date;
    private Long monday;
    private Long tuesday;
    private Long wednesday;
    private Long thursday;
    private Long friday;
    private Long saturday;
    private Long sunday;
    private Integer pay;
    private Boolean approved;
    private Boolean payed;
    private DepartmentDto id_department;
    private UserDto id_user;

}
