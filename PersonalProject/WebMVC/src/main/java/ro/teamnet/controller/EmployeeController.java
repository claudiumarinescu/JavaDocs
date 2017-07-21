package ro.teamnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.teamnet.model.Employee;
import ro.teamnet.service.EmployeeService;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/actions")
    @ResponseBody
    public String getActions() {
        String buttons = "<button class=\"btn btn-success\" onclick=\"getAllEmployees()\">List all employees</button>\n" +
                "<button class=\"btn btn-success\" onclick=\"addEmployee()\">Add employee</button>\n";
        return buttons;
    }

    @RequestMapping("/list")
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView("/WEB-INF/views/listEmployees.jsp");
        List<Employee> list = employeeService.listAllEmployees();

        model.addObject("list", list);

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employeeForm") Employee employee) {
        employeeService.saveOrUpdate(employee);
        return new ModelAndView("redirect:/employees/list");
    }

    @RequestMapping("/add")
    public ModelAndView addOneEmployee() {
        ModelAndView model = new ModelAndView("addEmployee");
        model.addObject("employeeForm", new Employee());
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employees/list");
    }

}
