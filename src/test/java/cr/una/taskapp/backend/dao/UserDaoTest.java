package cr.una.taskapp.backend.dao;


import cr.una.taskapp.backend.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
//@Sql({
//        "/03-import-roles.sql",
//        "/05-import-users.sql"
//})
public class UserDaoTest {
    @Autowired
    private IUserDao userDao;



    @Test
    public void testDelete() {
        User userDelete = new User();
        userDelete.setId_user(1L);

        userDao.delete(userDelete);

        User user = userDao.findById(1);
        assertTrue(user == null);
        System.out.println("Exito");
    }
    @Test
    public void testCreate(){
        User user = new User();

        user.setId_user(1L);

        userDao.create(user);

        // Verifica que el ID sea 1
        assertEquals(user.getId_user(), Long.valueOf(1));
    }
    @Test
    public void testUpdate() {
        User userUpdate = new User();

        userUpdate.setId_user(2L);
        userUpdate.setFirstname("root");

        userDao.update(userUpdate);

        User user = userDao.findById(2L);


    }
    @Test
    public void testFindAll() {
        List<User> userList = userDao.findAll();

        assertTrue(userList.size() == 3);
    }


}
