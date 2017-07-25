package ro.teamnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.teamnet.model.Project;
import ro.teamnet.model.Task;
import ro.teamnet.service.interfaces.ProjectService;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping({"", "/", "/list"})
    public ModelAndView getAllProjects() {
        ModelAndView model = new ModelAndView("listProjects");
        List<Project> list = projectService.listAllProjects();
        Collections.sort(list, new Comparator<Project>() {
            public int compare(Project j1, Project j2) {
                return j1.getId().compareTo(j2.getId());
            }
        });
        model.addObject("projects", list);
        return model;
    }

    @RequestMapping("/{id}")
    public ModelAndView viewProject(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("viewProject");
        Project p = null;
        for (Project project : projectService.listAllProjects()) {
            if (project.getId().equals(id)) {
                p = project;
                break;
            }
        }
        List<Task> tasks = projectService.listAllTasks();
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            if (!it.next().getProject().getId().equals(id)) {
                it.remove();
            }
        }

        model.addObject("project", p);
        model.addObject("tasks", tasks);


        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveProject(@ModelAttribute("project") Project project) {
        projectService.saveOrUpdate(project);
        return new ModelAndView("redirect:/projects/list");
    }

    @RequestMapping("/add")
    public ModelAndView addOneProject() {
//        ModelAndView model = new ModelAndView("addProject");
//        model.addObject("project", new Project());
//        return model;
        return null;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return new ModelAndView("redirect:/projects/list");
    }

}
