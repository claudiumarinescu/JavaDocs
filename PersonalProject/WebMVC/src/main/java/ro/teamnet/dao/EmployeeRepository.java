package ro.teamnet.dao;

import ro.teamnet.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> listAllEmployees();

    void saveOrUpdate(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);

}
