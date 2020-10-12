package cr.una.taskapp.backend.initialData;

import cr.una.taskapp.backend.model.User;
import cr.una.taskapp.backend.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to import initial data to user database
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql({
//        "/03-import-roles.sql",
//        "/05-import-users.sql"
//})
public class initialDataUserTest {
    @Autowired
    private IUserService userService;

    @Test
    public void loadUsers() {
        List<User> userList = userService.findAll();

        assertTrue(userList.size() == 3);
    }
}
