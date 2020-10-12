package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.exception.TimeSheetNotFoundException;
import cr.una.taskapp.backend.model.TimeSheet;

import java.util.List;

/**
 * TimeSheetService
 *
 * The Service for TimeSheet
 */
public interface ITimeSheetService {
    /**
     * Find timesheet by id
     * @param id identification of the timesheet
     * @return the timesheet found
     */
    public TimeSheet findById (final long id) throws TimeSheetNotFoundException;

    /**
     * Method to find all entities
     * @return the list of entities of TimeSheet
     */
    public List<TimeSheet> findAll();

    /**
     * Method to create a new entity
     * @param timesheet the entity to create in the database
     * @return the timesheet created with the corresponding id
     */
    public TimeSheet create (final TimeSheet timesheet);

    /**
     * Method to update the entity in the database
     * @param timesheet the entity with new information to update
     * @return the updated timesheet
     */
    public TimeSheet update (final TimeSheet timesheet);

    /**
     * Method to delete a entity in the database
     * @param timesheet the entity to deleted
     */
    public void delete (final TimeSheet timesheet);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id) throws TimeSheetNotFoundException;
}
