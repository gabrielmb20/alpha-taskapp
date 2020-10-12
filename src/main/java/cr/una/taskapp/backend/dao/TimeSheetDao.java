package cr.una.taskapp.backend.dao;

import com.google.common.base.Preconditions;
import cr.una.taskapp.backend.exception.TimeSheetNotFoundException;
import cr.una.taskapp.backend.model.TimeSheet;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TimeSheetDao extends AbstractHibernateDao implements ITimeSheetDao {

    @Override
    public TimeSheet findById(long id) throws TimeSheetNotFoundException {
        TimeSheet timesheet = getCurrentSession().get(TimeSheet.class,id);
        if (timesheet == null) {
            throw new TimeSheetNotFoundException("TimeSheet Not Found");
        } else {
            return timesheet;
        }
    }

    @Override
    public List<TimeSheet> findAll() {
        return getCurrentSession().createQuery("from TimeSheet ").getResultList();
    }

    @Override
    public TimeSheet create(TimeSheet timesheet) {
        Preconditions.checkNotNull(timesheet);
        getCurrentSession().saveOrUpdate(timesheet);

        return timesheet;
    }

    @Override
    public TimeSheet update(TimeSheet timesheet) {
        Preconditions.checkNotNull(timesheet);
        return (TimeSheet) getCurrentSession().merge(timesheet);
    }

    @Override
    public void delete(TimeSheet timesheet) {
        Preconditions.checkNotNull(timesheet);
        getCurrentSession().delete(timesheet);
    }

    @Override
    public void deleteById(long id) throws TimeSheetNotFoundException {
        final TimeSheet timesheet = findById(id);
        Preconditions.checkState(timesheet != null);
        delete(timesheet);
    }
}