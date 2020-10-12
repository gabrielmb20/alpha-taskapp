package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.exception.TimeSheetNotFoundException;
import cr.una.taskapp.backend.model.TimeSheet;

import java.util.List;

public interface ITimeSheetDao {
    public TimeSheet findById (final long id) throws TimeSheetNotFoundException;
    public List<TimeSheet> findAll ();
    public TimeSheet create (final TimeSheet timesheet);
    public TimeSheet update (final TimeSheet timesheet);
    public void delete (final TimeSheet timesheet);
    public void deleteById (final long id) throws TimeSheetNotFoundException;
}
