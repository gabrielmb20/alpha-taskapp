package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IRoleDao;
import cr.una.taskapp.backend.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService{

    @Autowired
    private IRoleDao dao;

    /**
     * Find department by id
     *
     * @param id_role identification of the role
     * @return the department found
     */
    @Override
    public Role findById(long id_role) {
        return dao.findById(id_role);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Roles
     */
    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param role the entity to create in the database
     * @return the role created with the corresponding id
     */
    @Override
    public Role create(Role role) {
        return dao.create(role);
    }

    /**
     * Method to update the entity in the database
     *
     * @param role the entity with new information to update
     * @return the updated role
     */
    @Override
    public Role update(Role role) {
        return dao.update(role);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param role the entity to deleted
     */
    @Override
    public void delete(Role role) {
        dao.delete(role);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id_role the id of the entity to delete
     */
    @Override
    public void deleteById(long id_role) {
        dao.deleteById(id_role);
    }
}
