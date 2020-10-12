package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Department;
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
//        "/01-import-departments.sql"
//})

public class DepartmentDaoTest {
    @Autowired
    private IDepartmentDao departmentDao;

    @Test
    public void testFindById(){
        Department department = departmentDao.findById(1);

        assertEquals(department.getDepartment_name(), "Department 1");
        assertEquals(department.getId_department(), Long.valueOf(1));
       // assertEquals(department.getDepartment_name().longValue(), 2L);
    }

    @Test
    public void testFindAll() {
        List<Department> departmentList = departmentDao.findAll();

        assertTrue(departmentList.size() == 3);
    }

    @Test
    public void testCreate() {
        Department department = new Department();

        department.setId_department(4L);
        department.setDepartment_name("Department 4");

        departmentDao.create(department);

        assertEquals(department.getId_department(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() {
        Department departmentUpdated = new Department();

        departmentUpdated.setId_department(2L);
        departmentUpdated.setDepartment_name("Department 2 - Updated");

        departmentDao.update(departmentUpdated);

        Department department = departmentDao.findById(2);
        assertEquals(department.getDepartment_name().toString(), "Department 2 - Updated");
    }

    @Test
    public void testDelete() {
        Department departmentDeleted = new Department();
        departmentDeleted.setId_department(1L);

        departmentDao.delete(departmentDeleted);

        Department department = departmentDao.findById(1);
        assertTrue(department == null);
    }

    @Test
    public void testDeleteById() {
        departmentDao.deleteById(1L);

        Department department = departmentDao.findById(1);
        assertTrue(department == null);
    }


}
