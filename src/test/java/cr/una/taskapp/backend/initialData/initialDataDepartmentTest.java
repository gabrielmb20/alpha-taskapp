package cr.una.taskapp.backend.initialData;

import cr.una.taskapp.backend.model.Department;
import cr.una.taskapp.backend.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to import initial data to department database
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql({
//        "/01-import-departments.sql"
//})
public class initialDataDepartmentTest {
    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void loadDepartments() {
        List<Department> departmentList = departmentService.findAll();

        assertTrue(departmentList.size() == 3);
    }
}
