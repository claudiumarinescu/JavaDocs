package ro.teamnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.teamnet.model.Job;
import ro.teamnet.service.interfaces.JobService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping({"", "/", "/list"})
    public ModelAndView getAllJobs() {
        ModelAndView model = new ModelAndView("listJobs");
        List<Job> list = jobService.listAllJobs();
        Collections.sort(list, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.getId().compareTo(j2.getId());
            }
        });
        model.addObject("jobs", list);
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveJob(@ModelAttribute("job") Job job) {
        jobService.saveOrUpdate(job);
        return new ModelAndView("redirect:/jobs/list");
    }

    @RequestMapping("/add")
    public ModelAndView addOneJob() {
        ModelAndView model = new ModelAndView("addJob");
        model.addObject("job", new Job());
        return model;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteJob(@PathVariable("id") Long id) {
        jobService.deleteJob(id);
        return new ModelAndView("redirect:/jobs/list");
    }


}
