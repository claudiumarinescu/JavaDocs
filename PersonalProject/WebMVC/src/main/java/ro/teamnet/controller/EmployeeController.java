package ro.teamnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.teamnet.model.Employee;
import ro.teamnet.model.Job;
import ro.teamnet.service.EmployeeService;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/actions")
    @ResponseBody
    public String getActions() {
        String buttons = "<button class=\"btn btn-success\" onclick=\"getAllEmployees()\">List all employees</button>\n" +
                "<button class=\"btn btn-success\" onclick=\"addEmployee()\">Add employee</button>\n";
        return buttons;
    }

    @RequestMapping("/list")
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView("listEmployees");
        List<Employee> list = employeeService.listAllEmployees();

        model.addObject("list", list);

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println(employee.getJob());
//        List<Job> jobs = employeeService.listAllJobs();
//        if (!jobs.isEmpty()) {
//            employee.setJob(jobs.get(0));
//        }
//        System.out.println(employee.getJob());
//        employeeService.saveOrUpdate(employee);
        return new ModelAndView("redirect:/employees/list");
    }

    @RequestMapping("/add")
    public ModelAndView addOneEmployee() {
        ModelAndView model = new ModelAndView("addEmployee");
        model.addObject("employee", new Employee());
        model.addObject("jobs", employeeService.listAllJobs());
        return model;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employees/list");
    }

}
