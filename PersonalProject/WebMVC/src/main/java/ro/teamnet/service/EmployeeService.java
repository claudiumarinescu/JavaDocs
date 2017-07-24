package ro.teamnet.service;

import ro.teamnet.model.Employee;
import ro.teamnet.model.Job;

import java.util.List;


public interface EmployeeService {

    List<Employee> listAllEmployees();

    List<Job> listAllJobs();

    void saveOrUpdate(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);

}
