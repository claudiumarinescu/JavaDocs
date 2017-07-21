package ro.teamnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
@Controller
@RequestMapping("/tasks")
public class TaskController {

    @RequestMapping("/actions")
    @ResponseBody
    public String getActions() {
        String buttons = "<button class=\"btn btn-success\" onclick=\"getAllTasks()\">List all tasks</button>\n" +
                "<button class=\"btn btn-success\" onclick=\"addTask()\">Add task</button>\n";
        return buttons;
    }
}
