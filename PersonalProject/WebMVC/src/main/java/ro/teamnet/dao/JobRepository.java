package ro.teamnet.dao;

import ro.teamnet.model.Job;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/24/2017.
 */
public interface JobRepository {

    List<Job> listAllJobs();

    void saveOrUpdate(Job job);

    Job findJobById(Long id);

    void deleteJob(Long id);

}
