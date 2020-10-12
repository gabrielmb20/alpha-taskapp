package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IDepartmentDao;
import cr.una.taskapp.backend.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentDao dao;

    /**
     * Find department by id
     *
     * @param id_department identification of the department
     * @return the department found
     */
    @Override
    public Department findById(long id_department) {
        return dao.findById(id_department);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Departments
     */
    @Override
    public List<Department> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param department the entity to create in the database
     * @return the department created with the corresponding id
     */
    @Override
    public Department create(Department department) {
        return dao.create(department);
    }
    /**
     * Method to update the entity in the database
     *
     * @param department the entity with new information to update
     * @return the updated department
     */
    @Override
    public Department update(Department department) {
        return dao.update(department);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param department the entity to deleted
     */
    @Override
    public void delete(Department department) {
        dao.delete(department);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id_department the id of the entity to delete
     */
    @Override
    public void deleteById(long id_department) {
        dao.deleteById(id_department);
    }
}
