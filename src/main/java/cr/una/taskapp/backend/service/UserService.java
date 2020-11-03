package cr.una.taskapp.backend.service;


import cr.una.taskapp.backend.dao.IUserDao;
import cr.una.taskapp.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService implements IUserService{
    @Autowired
    private IUserDao dao;

    /**
     * Find user by id
     *
     * @param id_user identification of the user
     * @return the user found
     */
    @Override
    public User findById(long id_user) {
        return dao.findById(id_user);
    }

    @Override
    public User findByIdPost(long id_user) {
        return dao.findById(id_user);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of User
     */
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param user the entity to create in the database
     * @return the user created with the corresponding id
     */
    @Override
    public User create(User user) {
        return dao.create(user);
    }

    /**
     * Method to update the entity in the database
     *
     * @param user the entity with new information to update
     * @return the updated user
     */
    @Override
    public User update(User user) {
        return dao.update(user);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param user the entity to deleted
     */
    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
