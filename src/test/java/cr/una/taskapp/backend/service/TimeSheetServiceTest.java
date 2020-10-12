package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.ITimeSheetDao;
import cr.una.taskapp.backend.model.TimeSheet;
import cr.una.taskapp.backend.service.TimeSheetService;
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
public class TimeSheetServiceTest {

    @InjectMocks
    private TimeSheetService timesheetService;

    @Mock
    private ITimeSheetDao timesheetDao;

    @Test
    public void testFindById() {
        // given
        final Long id = 1l;
        TimeSheet timesheet = new TimeSheet();
        TimeSheet timesheetExpected;

        timesheet.setId(id);
    //    timesheet.setId_department(1);

        given(timesheetDao.findById(id)).willReturn(timesheet);

        // when
        timesheetExpected = timesheetService.findById(id);

        // then
        assertThat(timesheetExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        TimeSheet timesheet = new TimeSheet();

        timesheet.setId(id);

        List<TimeSheet> timesheetList = Arrays.asList(timesheet);

        given(timesheetDao.findAll()).willReturn(timesheetList);

        // when
        List<TimeSheet> timesheetListExpected = timesheetService.findAll();

        // then
        assertThat(timesheetList).isEqualTo(timesheetListExpected);
    }

    @Test
    public void testCreateTimeSheet() {
        // given
        final Long id = 1l;
        TimeSheet timesheet = new TimeSheet();


        timesheet.setId(id);

        given(timesheetDao.create(timesheet)).willReturn(timesheet);

        // when
        TimeSheet timesheetCreated = timesheetService.create(timesheet);

        // then
        assertThat(timesheetCreated).isNotNull();
    }

    @Test
    public void testUpdateTimeSheet() {
        // given
        final Long id = 1l;
        TimeSheet timesheet = new TimeSheet();

        timesheet.setId(id);

        given(timesheetDao.update(timesheet)).willReturn(timesheet);

        // when
        TimeSheet timesheetUpdated = timesheetService.update(timesheet);

        // then
        assertThat(timesheetUpdated).isNotNull();
    }

}
