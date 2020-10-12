package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IDepartmentDao;
import cr.una.taskapp.backend.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private IDepartmentDao departmentDao;

    @Test
    public void testFindById() {
        // given
        final Long id = 1l;
        Department department = new Department();
        Department departmentExpected;

        department.setId_department(id);
        department.setDepartment_name("Department 1");

        given(departmentDao.findById(id)).willReturn(department);

        // when
        departmentExpected = departmentService.findById(id);

        // then
        assertThat(departmentExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Department department = new Department();

        department.setId_department(id);

        List<Department> departmentList = Arrays.asList(department);

        given(departmentDao.findAll()).willReturn(departmentList);

        // when
        List<Department> departmentListExpected = departmentService.findAll();

        // then
        assertThat(departmentList).isEqualTo(departmentListExpected);
    }

    @Test
    public void testCreateDepartment() {
        // given
        final Long id = 1l;
        Department department = new Department();


        department.setId_department(id);

        given(departmentDao.create(department)).willReturn(department);

        // when
        Department departmentCreated = departmentService.create(department);

        // then
        assertThat(departmentCreated).isNotNull();
    }

    @Test
    public void testUpdateDepartment() {
        // given
        final Long id = 1l;
        Department department = new Department();

        department.setId_department(id);

        given(departmentDao.update(department)).willReturn(department);

        // when
        Department departmentUpdated = departmentService.update(department);

        // then
        assertThat(departmentUpdated).isNotNull();
    }
}
