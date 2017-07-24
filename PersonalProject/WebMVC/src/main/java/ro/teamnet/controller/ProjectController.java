package ro.teamnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @RequestMapping("/actions")
    @ResponseBody
    public String getActions() {
        String buttons = "<button class=\"btn btn-success\" onclick=\"getAllProjects()\">List all projects</button>\n" +
                "<button class=\"btn btn-success\" onclick=\"addProject()\">Add project</button>\n";
        return buttons;
    }

}
