/*
 *
 *  *
 *  *
 *  * Universidad Nacional de Costa Rica  2020
 *  *
 *  * mike@guzmanalan.com
 *  *
 *  *
 *
 *
 */

package cr.una.taskapp.backend.initialData;

import cr.una.taskapp.backend.model.TimeSheet;
import cr.una.taskapp.backend.service.ITimeSheetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to import initial data to database
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql({
//        "/03-import-roles.sql",
//        "/01-import-departments.sql",
//        "/05-import-users.sql",
//        "/07-import-timesheets.sql"
//})
public class InitialDataTimeSheetTest {

    @Autowired
    private ITimeSheetService timesheetService;

    @Test
    public void loadTimesheet() {
        List<TimeSheet> timesheetList = timesheetService.findAll();

        assertTrue(timesheetList.size() == 3);
    }
}
