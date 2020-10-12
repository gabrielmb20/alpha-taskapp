package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.ITimeSheetDao;
import cr.una.taskapp.backend.exception.TimeSheetNotFoundException;
import cr.una.taskapp.backend.model.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TimeSheetService
 *
 * The Service for TimeSheet
 */
@Service
@Transactional
public class TimeSheetService implements ITimeSheetService {

    @Autowired
    private ITimeSheetDao dao;

    /**
     * Find timesheet by id
     *
     * @param id identification of the timesheet
     * @return the timesheet found
     */
    @Override
    public TimeSheet findById(long id) throws TimeSheetNotFoundException {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of TimeSheet
     */
    @Override
    public List<TimeSheet> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param timesheet the entity to create in the database
     * @return the timesheet created with the corresponding id
     */
    @Override
    public TimeSheet create(TimeSheet timesheet) {
        return dao.create(timesheet);
    }

    /**
     * Method to update the entity in the database
     *
     * @param timesheet the entity with new information to update
     * @return the updated timesheet
     */
    @Override
    public TimeSheet update(TimeSheet timesheet) {
        return dao.update(timesheet);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param timesheet the entity to deleted
     */
    @Override
    public void delete(TimeSheet timesheet) {
        dao.delete(timesheet);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) throws TimeSheetNotFoundException {
        dao.deleteById(id);
    }
}
