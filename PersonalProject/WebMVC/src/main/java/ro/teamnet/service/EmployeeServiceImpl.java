package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.dao.EmployeeRepository;
import ro.teamnet.dao.JobRepository;
import ro.teamnet.model.Employee;
import ro.teamnet.model.Job;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private JobRepository jobRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @Transactional
    public List<Job> listAllJobs() {
        return jobRepository.listAllJobs();
    }

    @Transactional
    public List<Employee> listAllEmployees() {
        return employeeRepository.listAllEmployees();
    }

    @Transactional
    public void saveOrUpdate(Employee employee) {
        employeeRepository.saveOrUpdate(employee);
    }

    @Transactional
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

}
