package ro.teamnet.dao.interfaces;

import ro.teamnet.model.Job;

import java.util.List;


public interface JobRepository {

    List<Job> listAllJobs();

    void saveOrUpdate(Job job);

    Job findJobById(Long id);

    void deleteJob(Long id);

}
