package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.dao.interfaces.EmployeeRepository;
import ro.teamnet.dao.interfaces.JobRepository;
import ro.teamnet.model.Employee;
import ro.teamnet.model.Job;
import ro.teamnet.service.interfaces.EmployeeService;

import java.util.List;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private JobRepository jobRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    public List<Job> listAllJobs() {
        return jobRepository.listAllJobs();
    }

    public List<Employee> listAllEmployees() {
        return employeeRepository.listAllEmployees();
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.saveOrUpdate(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

}
