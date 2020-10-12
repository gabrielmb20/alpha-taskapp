package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Role;

import java.util.List;

public interface IRoleDao {
    public Role findById (final long id);
    public Role findByName (final String name);
    public List<Role> findAll ();
    public Role create (final Role role);
    public Role update (final Role role);
    public void delete (final Role role);
    public void deleteById (final long id);
}
