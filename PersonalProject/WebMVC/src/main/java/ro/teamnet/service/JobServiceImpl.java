package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.dao.JobRepository;
import ro.teamnet.model.Job;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Transactional
    public List<Job> listAllJobs() {
        return jobRepository.listAllJobs();
    }

    @Transactional
    public void saveOrUpdate(Job job) {
        jobRepository.saveOrUpdate(job);
    }

    @Transactional
    public Job findJobById(Long id) {
        return jobRepository.findJobById(id);
    }

    @Transactional
    public void deleteJob(Long id) {
        jobRepository.deleteJob(id);
    }

}
