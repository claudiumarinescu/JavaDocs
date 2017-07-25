package ro.teamnet.service.interfaces;

import ro.teamnet.model.Job;

import java.util.List;


public interface JobService {

    List<Job> listAllJobs();

    void saveOrUpdate(Job job);

    Job findJobById(Long id);

    void deleteJob(Long id);

}
