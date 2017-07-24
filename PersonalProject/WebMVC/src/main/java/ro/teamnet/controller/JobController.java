package ro.teamnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @RequestMapping("/actions")
    @ResponseBody
    public String getActions() {
        String buttons = "<button class=\"btn btn-success\" onclick=\"getAllJobs()\">List all jobs</button>\n" +
                "<button class=\"btn btn-success\" onclick=\"addJob()\">Add job</button>\n";
        return buttons;
    }

}
