package ro.teamnet.zth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.teamnet.zth.services.EmployeeService;

/**
 * Created by Claudiu.Marinescu on 7/20/2017.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping("/count")
    public Object countEmployees() {
        return empService.getCount();

    }

}
