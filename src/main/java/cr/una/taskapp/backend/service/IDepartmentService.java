package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.model.Department;

import java.util.List;

public interface IDepartmentService {
    /**
     * Find department by id
     * @param id identification of the department
     * @return the user found
     */
    public Department findById (final long id);

    /**
     * Method to find all entities
     * @return the list of entities of department
     */
    public List<Department> findAll();

    /**
     * Method to create a new entity
     * @param department the entity to create in the database
     * @return the department created with the corresponding id
     */
    public Department create (final Department department);

    /**
     * Method to update the entity in the database
     * @param department the entity with new information to update
     * @return the updated department
     */
    public Department update (final Department department);

    /**
     * Method to delete a entity in the database
     * @param department the entity to deleted
     */
    public void delete (final Department department);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id);
}
