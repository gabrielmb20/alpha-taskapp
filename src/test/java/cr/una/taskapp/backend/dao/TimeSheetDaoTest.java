package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.TimeSheet;
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
//        "/01-import-departments.sql",
//        "/05-import-users.sql",
//        "/07-import-timesheets.sql"
//})
public class TimeSheetDaoTest {
    @Autowired
    private ITimeSheetDao timesheetDao;

    @Autowired
    private IDepartmentDao departmentDao;

    @Autowired
    private IUserDao userDao;

    @Test
    public void testFindById(){
        TimeSheet timesheet = timesheetDao.findById(1);

        assertEquals(timesheet.getId().longValue(), 1L);
    }

    @Test
    public void testFindAll() {
        List<TimeSheet> timesheetList = timesheetDao.findAll();

        assertTrue(timesheetList.size() == 3);
    }

    @Test
    public void testCreate(){
        TimeSheet timesheet = new TimeSheet();

        timesheet.setId(1L);
        timesheet.setMonday(4L);
        timesheet.setTuesday(6L);
        timesheet.setWednesday(3L);
        timesheet.setThursday(5L);
        timesheet.setFriday(8L);
        timesheet.setSaturday(2L);
        timesheet.setSunday(1L);
       // timesheet.setId_department(1);
        timesheet.setId_department(departmentDao.findById(1));
        timesheet.setId_user(userDao.findById(1));

        timesheetDao.create(timesheet);

        // Verifica que el ID sea 1
        assertEquals(timesheet.getId(), Long.valueOf(1));
    }

    @Test
    public void testUpdate() {
        TimeSheet timesheetUpdated = new TimeSheet();

        timesheetUpdated.setId(2L);
        timesheetUpdated.setFriday(2L);
        timesheetUpdated.setId_department(departmentDao.findById(1));
      //  timesheetUpdated.setId_department(2);

        timesheetDao.update(timesheetUpdated);

        TimeSheet timesheet = timesheetDao.findById(2);
        assertEquals(timesheet.getFriday().longValue(), 2L);
       // assertEquals(timesheet.getId().longValue(), 2L);
       // assertEquals(timesheet.getId_department().longValue(), 2);
    }

    @Test
    public void testDelete() {
        TimeSheet timesheetDeleted = new TimeSheet();
        timesheetDeleted.setId(1L);

        timesheetDao.delete(timesheetDeleted);

        TimeSheet timesheet = timesheetDao.findById(1);
        assertTrue(timesheet == null);
    }

    @Test
    public void testDeleteById() {
        timesheetDao.deleteById(1L);

        TimeSheet timesheet = timesheetDao.findById(1);
        assertTrue(timesheet == null);
    }
}
