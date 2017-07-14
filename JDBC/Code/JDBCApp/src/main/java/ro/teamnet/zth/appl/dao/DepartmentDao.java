package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/14/2017.
 */
public class DepartmentDao {

    private EntityManager manager;

    public DepartmentDao() {
        this.manager = new EntityManagerImpl();
    }

    public Department findById(Long id) {
        return manager.findById(Department.class, id);
    }

    public long getNextIdVal(String tableName, String columnIdName) {
        return manager.getNextIdVal(tableName, columnIdName);
    }

    public Department insert(Department department) {
        return (Department) manager.insert(department);
    }

    public List<Department> findAll() {
        return manager.findAll(Department.class);
    }

    public Department update(Department department) {
        return manager.update(department);
    }

    public void delete(Department department) {
        manager.delete(department);
    }

    public List<Department> findByParams(Map<String, Object> params) {
        return manager.findByParams(Department.class, params);
    }

}
