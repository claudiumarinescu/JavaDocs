package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.teamnet.dao.EmployeeRepository;
import ro.teamnet.model.Employee;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
@Service("employeeService")
@Transactional
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmpRepository(EmployeeRepository empRepository) {
        this.employeeRepository = empRepository;
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
