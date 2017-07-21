package ro.teamnet.dao;

import ro.teamnet.model.Employee;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
public interface EmployeeDao {

    List<Employee> listAllEmployees();

    void saveOrUpdate(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);

}
