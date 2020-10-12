package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IUserDao;
import cr.una.taskapp.backend.model.User;
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
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private IUserDao userDao;

    @Test
    public void testFindById() {
        // given
        final Long id = 1l;
        User user = new User();
        User userExpected;

        user.setId_user(id);
        user.setFirstname("Admin");

        given(userDao.findById(id)).willReturn(user);

        // when
        userExpected = userService.findById(id);

        // then
        assertThat(userExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        User user = new User();

        user.setId_user(id);

        List<User> userList = Arrays.asList(user);

        given(userDao.findAll()).willReturn(userList);

        // when
        List<User> userListExpected = userService.findAll();

        // then
        assertThat(userList).isEqualTo(userListExpected);
    }

    @Test
    public void testCreateDepartment() {
        // given
        final Long id = 1l;
        User user = new User();


        user.setId_user(id);

        given(userDao.create(user)).willReturn(user);

        // when
        User userCreated = userService.create(user);

        // then
        assertThat(userCreated).isNotNull();
    }

    @Test
    public void testUpdateDepartment() {
        // given
        final Long id = 1l;
        User user = new User();

        user.setId_user(id);

        given(userDao.update(user)).willReturn(user);

        // when
        User userUpdated = userService.update(user);

        // then
        assertThat(userUpdated).isNotNull();
    }
}
