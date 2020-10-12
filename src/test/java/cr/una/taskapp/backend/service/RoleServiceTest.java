package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IRoleDao;
import cr.una.taskapp.backend.model.Role;
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
public class RoleServiceTest {
    @InjectMocks
    private RoleService roleService;

    @Mock
    private IRoleDao roleDao;

    @Test
    public void testFindById() {
        // given
        final Long id = 1l;
        Role role = new Role();
        Role roleExpected;

        role.setId_role(id);
        role.setName("Role 1");

        given(roleDao.findById(id)).willReturn(role);

        // when
        roleExpected = roleService.findById(id);

        // then
        assertThat(roleExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Role role = new Role();

        role.setId_role(id);

        List<Role> roleList = Arrays.asList(role);

        given(roleDao.findAll()).willReturn(roleList);

        // when
        List<Role> roleListExpected = roleService.findAll();

        // then
        assertThat(roleList).isEqualTo(roleListExpected);
    }

    @Test
    public void testCreateDepartment() {
        // given
        final Long id = 1l;
        Role role = new Role();


        role.setId_role(id);

        given(roleDao.create(role)).willReturn(role);

        // when
        Role roleCreated = roleService.create(role);

        // then
        assertThat(roleCreated).isNotNull();
    }

    @Test
    public void testUpdateDepartment() {
        // given
        final Long id = 1l;
        Role role = new Role();

        role.setId_role(id);

        given(roleDao.update(role)).willReturn(role);

        // when
        Role roleUpdated = roleService.update(role);

        // then
        assertThat(roleUpdated).isNotNull();
    }
}
