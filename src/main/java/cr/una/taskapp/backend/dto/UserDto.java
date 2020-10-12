package cr.una.taskapp.backend.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class UserDto {
    private Long id_user;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String username;
    private Date created;
    private boolean enabled;
    private boolean expired;
    //private RoleDto id_role;
    private List<RoleDto> roleList;

}
