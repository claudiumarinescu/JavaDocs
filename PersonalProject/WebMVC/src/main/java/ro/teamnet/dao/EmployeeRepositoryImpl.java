package ro.teamnet.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.teamnet.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
        return  (Employee) getSession().get(Employee.class, id);
    }

    public void deleteEmployee(Long id) {
        Employee employee = (Employee) getSession().get(Employee.class, id);
        getSession().delete(employee);
    }
}
