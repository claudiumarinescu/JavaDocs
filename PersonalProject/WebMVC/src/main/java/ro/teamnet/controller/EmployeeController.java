package ro.teamnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.teamnet.model.Employee;
import ro.teamnet.model.Job;
import ro.teamnet.service.interfaces.EmployeeService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = {"", "/", "/list"}, produces = "text/html")
    @ResponseBody
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView("listEmployees");
        List<Employee> list = employeeService.listAllEmployees();
        Collections.sort(list, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getId().compareTo(e2.getId());
            }
        });
        model.addObject("list", list);
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee,
                                     @RequestParam("jobID") Long jobId,
                                     @RequestParam("managerID") Long managerId) {

        for (Job job : employeeService.listAllJobs()) {
            if (job.getId().equals(jobId)) {
                employee.setJob(job);
                break;
            }
        }
        for(Employee emp : employeeService.listAllEmployees()) {
            if (emp.getId().equals(managerId)) {
                employee.setManager(emp);
                break;
            }
        }
        employeeService.saveOrUpdate(employee);
        return new ModelAndView("redirect:/employees/list");
    }

    @RequestMapping("/add")
    public ModelAndView addOneEmployee() {
        ModelAndView model = new ModelAndView("addEmployee");
        model.addObject("employee", new Employee());
        model.addObject("jobID", (long) -1);
        model.addObject("managerID", (long) -1);
        model.addObject("jobs", employeeService.listAllJobs());
        model.addObject("employees", employeeService.listAllEmployees());
        return model;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employees/list");
    }

}
