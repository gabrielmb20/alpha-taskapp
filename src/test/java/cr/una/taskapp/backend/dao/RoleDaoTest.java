package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Role;
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
//        "/03-import-roles.sql"
//})
public class RoleDaoTest {
    @Autowired
    private IRoleDao roleDao;

    @Test
    public void testFindById(){
        Role role = roleDao.findById(1);

        assertEquals(role.getName(), "ROLE_ADMIN");
        assertEquals(role.getId_role(), Long.valueOf(1));
        // assertEquals(department.getDepartment_name().longValue(), 2L);
    }

    @Test
    public void testFindAll() {
        List<Role> roleList = roleDao.findAll();

        assertTrue(roleList.size() == 2);
    }

    @Test
    public void testCreate() {
        Role role = new Role();

        role.setId_role(4L);
        role.setName("Role 4");

        roleDao.create(role);

        assertEquals(role.getId_role(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() {
        Role roleUpdated = new Role();

        roleUpdated.setId_role(2L);
        roleUpdated.setName("Role 2 - Updated");

        roleDao.update(roleUpdated);

        Role role = roleDao.findById(2);
        assertEquals(role.getName().toString(), "Role 2 - Updated");
    }

    @Test
    public void testDelete() {
        Role roleDeleted = new Role();
        roleDeleted.setId_role(1L);

        roleDao.delete(roleDeleted);

        Role role = roleDao.findById(1);
        assertTrue(role == null);
    }

    @Test
    public void testDeleteById() {
        roleDao.deleteById(1L);

        Role role = roleDao.findById(1);
        assertTrue(role == null);
    }
}
