package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Department;

import java.util.List;

public interface IDepartmentDao {
    public Department findById (final long id);
    public List<Department> findAll ();
    public Department create (final Department department);
    public Department update (final Department department);
    public void delete (final Department department);
    public void deleteById (final long id);
}
