package ro.teamnet.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.teamnet.model.Employee;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
@Repository("employeeRepository")
public class EmployeeRepository implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> listAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    public void saveOrUpdate(Employee employee) {
        getSession().saveOrUpdate(employee);
    }

    public Employee findEmployeeById(Long id) {
        Employee employee = (Employee) getSession().get(Employee.class, id);
        return employee;
    }

    public void deleteEmployee(Long id) {
        Employee employee = (Employee) getSession().get(Employee.class, id);
        getSession().delete(employee);
    }
}
