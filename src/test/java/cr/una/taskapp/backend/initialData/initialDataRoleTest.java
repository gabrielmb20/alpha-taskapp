package cr.una.taskapp.backend.initialData;

import cr.una.taskapp.backend.model.Role;
import cr.una.taskapp.backend.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to import initial data to role database
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql({
//        "/03-import-roles.sql"
//})
public class initialDataRoleTest {
    @Autowired
    private IRoleService roleService;

    @Test
    public void loadRoles() {
        List<Role> roleList = roleService.findAll();

        assertTrue(roleList.size() == 2);
    }
}
