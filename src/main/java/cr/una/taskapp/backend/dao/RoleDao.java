package cr.una.taskapp.backend.dao;

import com.google.common.base.Preconditions;
import cr.una.taskapp.backend.model.Department;
import cr.una.taskapp.backend.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDao extends AbstractHibernateDao implements IRoleDao{
    @Override
    public Role findById(long id) {
        return getCurrentSession().get(Role.class,id);
    }

    @Override
    public List<Role> findAll() {
        return getCurrentSession().createQuery("from Role ").getResultList();
    }

    /**
     * Method to find the entity by id
     *
     * @param name the name of the entity to find
     * @return the corresponding task
     */
    @Override
    public Role findByName(String name) {
        Query query = getCurrentSession().createQuery("from Role r where r.name = :name");
        query.setParameter("name", name);

        return (Role) query.getResultList().get(0);    }


    @Override
    public Role create(Role role) {
        Preconditions.checkNotNull(role);
        getCurrentSession().saveOrUpdate(role);

        return role;
    }

    @Override
    public Role update(Role role) {
        Preconditions.checkNotNull(role);
        return (Role) getCurrentSession().merge(role);
    }

    @Override
    public void delete(Role role) {
        Preconditions.checkNotNull(role);
        getCurrentSession().delete(role);
    }

    @Override
    public void deleteById(long id) {
        final Role role = findById(id);
        Preconditions.checkState(role != null);
        delete(role);
    }
}
